package io.github.jwdeveloper.descrabble.core;

import io.github.jwdeveloper.descrabble.api.DescriptionDecorator;
import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.api.DescriptionRenderer;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementData;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;
import io.github.jwdeveloper.descrabble.core.element.ElementImpl;
import io.github.jwdeveloper.descrabble.core.element.ElementsFactoryImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DescriptionGeneratorImpl implements DescriptionGenerator {
    private final List<DescriptionRenderer> renderers;
    private final List<DescriptionDecorator> decorators;
    private final Map<String, String> variables;

    public DescriptionGeneratorImpl(List<DescriptionRenderer> renderers,
                                    List<DescriptionDecorator> decorators,
                                    Map<String, String> variables) {
        this.renderers = renderers;
        this.decorators = decorators;
        this.variables = variables;
    }

    public Set<Path> generate(String outputPath) {
        var data = new ElementData();
        data.setElementType(ElementType.ROOT);
        var root = new ElementImpl(data);
        var factory = new ElementsFactoryImpl();
        for (var decorator : decorators) {
            decorator.decorate(root, factory);
        }
        var descriptions = new HashMap<Path, String>();
        for (var renderer : renderers) {
            var renderOutput = getRender(root, renderer);
            var output = resolveGlobalVariables(renderOutput);
            var descriptionPath = Paths.get(outputPath, renderer.getFileName());

            descriptions.put(descriptionPath, output);
        }
        try {
            Files.createDirectories(Paths.get(outputPath));
            for (var entrySet : descriptions.entrySet()) {
                Files.writeString(entrySet.getKey(), entrySet.getValue());
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to generate Descriptions", e);
        }
        return descriptions.keySet();
    }

    public String resolveGlobalVariables(String input)
    {
        for(var entry : variables.entrySet())
        {
            var key = "\\{\\{"+entry.getKey()+"}}";
            input =  input.replaceAll(key, entry.getValue());
        }
        return input;
    }

    public String getRender(Element root, DescriptionRenderer descriptionRenderer) {
        var builder = new TextBuilderImpl();
        for (var element : root.getElements()) {
            var out = getRenderOutput(element, descriptionRenderer);
            builder.text(out);
        }
        return builder.build();
    }


    public String getRenderOutput(Element element, DescriptionRenderer descriptionRenderer) {
        var elementRenderers = descriptionRenderer.getElementRenderers();

        if (!descriptionRenderer.onElementValidation(element)) {
            return "";
        }
        var openTextBuilder = new TextBuilderImpl();
        var beforeTextBuilder = new TextBuilderImpl();
        var afterChildren = new TextBuilderImpl();
        var closeTextBuilder = new TextBuilderImpl();
        var childContents = new ArrayList<String>();
        for (var renderer : elementRenderers) {
            if (!renderer.onElementValidation(element)) {
                continue;
            }
            renderer.onElementOpen(openTextBuilder, element);
            renderer.onBeforeEachChild(beforeTextBuilder, element);
            renderer.onAfterEachChild(afterChildren, element);
            renderer.onElementClose(closeTextBuilder, element);
        }

        for (var child : element.getElements()) {

            for (var props : element.getProperties().entrySet()) {
                if (child.hasProperty(props.getKey())) {
                    continue;
                }
                child.addProperty(props.getKey(), props.getValue());
            }
            for (var tag : element.getTags()) {
                if (child.hasTag(tag)) {
                    continue;
                }
                child.addTag(tag);
            }


            var childOutput = getRenderOutput(child, descriptionRenderer);
            if (childOutput.equals("")) {
                continue;
            }
            childContents.add(childOutput);
        }

        var result = new TextBuilderImpl();
        result.text(openTextBuilder.toString());
        for (var content : childContents) {
            result.text(beforeTextBuilder.toString());
            result.text(content);
            result.text(afterChildren.toString());
        }
        result.text(closeTextBuilder.toString());

        return result.toString();
    }
}

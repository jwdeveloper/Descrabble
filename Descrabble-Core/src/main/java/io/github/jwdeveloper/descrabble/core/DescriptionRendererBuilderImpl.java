package io.github.jwdeveloper.descrabble.core;

import io.github.jwdeveloper.descrabble.api.DescriptionRenderer;
import io.github.jwdeveloper.descrabble.api.DescriptionRendererBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementRendererBuilder;
import io.github.jwdeveloper.descrabble.core.element.ElementRendererBuilderImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class DescriptionRendererBuilderImpl implements DescriptionRendererBuilder {

    private final List<ElementRenderer> elementRenderers;
    private String name;
    private Function<Element, Boolean> onValidation;

    public DescriptionRendererBuilderImpl() {
        name = "output.txt";
        elementRenderers = new ArrayList<>();
        onValidation = (e) -> true;
    }


    @Override
    public DescriptionRendererBuilder withFileName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public DescriptionRendererBuilder withElementRenderer(ElementRenderer elementRenderer) {
        elementRenderers.add(elementRenderer);
        return this;
    }

    @Override
    public DescriptionRendererBuilder withElementRenderer(Consumer<ElementRendererBuilder> onRender) {

        var builder = new ElementRendererBuilderImpl();
        onRender.accept(builder);
        elementRenderers.add(builder.build());
        return this;
    }

    @Override
    public DescriptionRendererBuilder withOnValidationElement(Function<Element, Boolean> onValidation) {
        this.onValidation = onValidation;
        return this;
    }

    public DescriptionRenderer build() {
        return new DescriptionRendererImpl(name, elementRenderers, onValidation);
    }

}

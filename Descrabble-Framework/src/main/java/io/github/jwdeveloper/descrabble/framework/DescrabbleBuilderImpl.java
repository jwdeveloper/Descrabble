package io.github.jwdeveloper.descrabble.framework;

import io.github.jwdeveloper.descrabble.api.DescriptionDecorator;
import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.api.DescriptionRenderer;
import io.github.jwdeveloper.descrabble.api.DescriptionRendererBuilder;
import io.github.jwdeveloper.descrabble.core.DescriptionGeneratorBuilderImpl;
import io.github.jwdeveloper.descrabble.core.DescriptionRendererBuilderImpl;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleBuilder;
import io.github.jwdeveloper.descrabble.framework.api.DescrabblePlugin;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.function.Consumer;

public class DescrabbleBuilderImpl implements DescrabbleBuilder {
    private final DescriptionGeneratorBuilderImpl builder;
    private final ElementRendererWrapperFactory factory;


    public DescrabbleBuilderImpl() {
        builder = new DescriptionGeneratorBuilderImpl();
        factory = new ElementRendererWrapperFactory();
    }

    @Override
    public DescrabbleBuilder withPlugin(DescrabblePlugin plugin) {
        var renderer = new DescriptionRendererBuilderImpl();
        renderer.withFileName(plugin.getOutputFileName());
        renderer.withOnValidationElement(element -> !element.hasTag(plugin.getPluginName() + "-ignore"));
        renderer.withElementRenderer(factory.getTextElementInfo(plugin.getTextRenderer()));
        renderer.withElementRenderer(factory.getCodeRenderer(plugin.getCodeRenderer()));
        renderer.withElementRenderer(factory.getImageRenderer(plugin.getImageRenderer()));
        renderer.withElementRenderer(factory.getLinkRenderer(plugin.getLinkRenderer()));
        renderer.withElementRenderer(factory.getListRenderer(plugin.getListRenderer()));
        renderer.withElementRenderer(factory.getContainerElement(plugin.getContainerElement()));
        renderer.withElementRenderer(factory.getQuoteRenderer(plugin.getQuoteRenderer()));
        renderer.withElementRenderer(factory.getSpoilerRenderer(plugin.getSpoilerRenderer()));
        renderer.withElementRenderer(factory.getVideoRenderer(plugin.getVideoRenderer()));
        renderer.withElementRenderer(factory.getBreakLineRenderer(plugin.getBreakLineRenderer()));
        for (var customRenderer : plugin.getCustomRenderers()) {
            renderer.withElementRenderer(factory.getCustomElement(customRenderer));
        }
        return withRenderer(renderer.build());
    }

    @Override
    public DescrabbleBuilder withVariable(String name, String value) {
        builder.withVariable(name,value);
        return this;
    }

    @Override
    public DescrabbleBuilder withTemplate(URI path) {
        builder.withTemplate(path);
        return this;
    }

    @Override
    public DescrabbleBuilder withTemplate(Path path) {
        builder.withTemplate(path);
        return this;
    }

    @Override
    public DescrabbleBuilder withTemplate(File file) {
        builder.withTemplate(file);
        return this;
    }

    @Override
    public DescrabbleBuilder withDecorator(Consumer<DescriptionDecorator> onDecoration) {
        builder.withDecorator(onDecoration);
        return this;
    }

    @Override
    public DescrabbleBuilder withDecorator(DescriptionDecorator decorator) {
        builder.withDecorator(decorator);
        return this;
    }

    @Override
    public DescrabbleBuilder withRenderer(DescriptionRenderer renderer) {
        builder.withRenderer(renderer);
        return this;
    }

    @Override
    public DescrabbleBuilder withRenderer(Consumer<DescriptionRendererBuilder> onBuild) {
        builder.withRenderer(onBuild);
        return this;
    }

    public DescriptionGenerator build() {
        return builder.build();
    }
}

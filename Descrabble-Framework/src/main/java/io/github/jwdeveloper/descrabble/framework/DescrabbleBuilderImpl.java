/*
 * Copyright (c) 2012-2023 JW Developer https://github.com/jwdeveloper
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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

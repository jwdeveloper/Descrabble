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
package io.github.jwdeveloper.descrabble.core;

import io.github.jwdeveloper.descrabble.api.*;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementFactory;
import io.github.jwdeveloper.descrabble.core.decorators.TemplateParser;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class DescriptionGeneratorBuilderImpl implements DescriptionGeneratorBuilder {

    private final List<DescriptionRenderer> renderers;
    private final List<DescriptionDecorator> decorators;
    private final Map<String,String> variables;

    public DescriptionGeneratorBuilderImpl() {
        renderers = new ArrayList<>();
        decorators = new ArrayList<>();
        variables= new HashMap<>();
    }

    @Override
    public DescriptionGeneratorBuilder withTemplate(URI path) {
        return withTemplate(new File(path));
    }

    @Override
    public DescriptionGeneratorBuilder withTemplate(Path path) {
        return withTemplate(new File(path.toString()));
    }

    @Override
    public DescriptionGeneratorBuilder withTemplate(File file) {
        decorators.add(new TemplateParser(file));
        return this;
    }

    @Override
    public DescriptionGeneratorBuilder withDecorator(Consumer<DescriptionDecorator> onDecoration) {
        var proxy = new ProxyDecorator();
        onDecoration.accept(proxy);
        decorators.add(proxy);
        return this;
    }

    public DescriptionGeneratorBuilder withDecorator(DescriptionDecorator decorator) {
        decorators.add(decorator);
        return this;
    }

    public DescriptionGeneratorBuilder withRenderer(DescriptionRenderer renderer) {
        renderers.add(renderer);
        return this;
    }

    public DescriptionGeneratorBuilder withRenderer(Consumer<DescriptionRendererBuilder> onBuild) {
        var builder = new DescriptionRendererBuilderImpl();
        onBuild.accept(builder);
        renderers.add(builder.build());
        return this;
    }

    @Override
    public DescriptionGeneratorBuilder withVariable(String name, String value) {
        variables.put(name,value);
        return this;
    }

    public DescriptionGenerator build() {
        return new DescriptionGeneratorImpl(renderers, decorators, variables);
    }


    @Data
    @AllArgsConstructor
    private class ProxyDecorator implements DescriptionDecorator {
        @Override
        public void decorate(Element root, ElementFactory factory) {
        }
    }
}

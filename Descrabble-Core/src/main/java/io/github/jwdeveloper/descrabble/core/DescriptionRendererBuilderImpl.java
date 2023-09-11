/*
 * Copyright (c) 2023-2023 jwdeveloper  <jacekwoln@gmail.com>
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

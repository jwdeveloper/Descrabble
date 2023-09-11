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
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;

import java.util.List;
import java.util.function.Function;

public class DescriptionRendererImpl implements DescriptionRenderer {

    private final String name;
    private final List<ElementRenderer> elementRenderers;
    private final Function<Element, Boolean> onValidation;

    public DescriptionRendererImpl(String name,
                                   List<ElementRenderer> elementRenderers,
                                   Function<Element, Boolean> onValidation) {
        this.name = name;
        this.elementRenderers = elementRenderers;
        this.onValidation = onValidation;
    }

    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public List<ElementRenderer> getElementRenderers() {
        return elementRenderers;
    }

    @Override
    public boolean onElementValidation(Element element) {
        return onValidation.apply(element);
    }
}

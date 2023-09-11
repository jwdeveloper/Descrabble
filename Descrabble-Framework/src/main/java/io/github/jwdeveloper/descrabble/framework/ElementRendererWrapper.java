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


import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class ElementRendererWrapper implements ElementRenderer {
    private final DescrabbleElementRenderer renderer;
    private final ElementRendererModel model;

    public ElementRendererWrapper(DescrabbleElementRenderer renderer, ElementRendererModel model) {
        this.renderer = renderer;
        this.model = model;
    }

    public ElementRendererModel getModel()
    {
        return model;
    }


    @Override
    public boolean onElementValidation(Element element)
    {
        if(!element.getName().equals(model.getName()) && !element.getName().equals(model.getShortName()))
        {
            return false;
        }

        return renderer.onElementValidation(element);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        renderer.onElementOpen(textBuilder, elementData);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        renderer.onElementClose(textBuilder, elementData);
    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {
        renderer.onAfterEachChild(textBuilder, elementData);
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {
        renderer.onBeforeEachChild(textBuilder, elementData);
    }
}

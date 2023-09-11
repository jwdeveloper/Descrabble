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
package io.github.jwdeveloper.descrabble.core.element;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderEvent;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementRendererBuilder;

import java.util.function.Function;

public class ElementRendererBuilderImpl implements ElementRendererBuilder {

    private Function<Element, Boolean> onValidation;
    private ElementRenderEvent onOpen;
    private ElementRenderEvent onBeforeEachChild;
    private ElementRenderEvent onAfterEachChild;
    private ElementRenderEvent onElementClose;

    @Override
    public ElementRendererBuilder onElementValidation(Function<Element, Boolean> onValidation)
    {
        this.onValidation = onValidation;
        return this;
    }

    @Override
    public ElementRendererBuilder onElementOpen(ElementRenderEvent onOpen) {
         this.onOpen = onOpen;
         return this;
    }

    @Override
    public ElementRendererBuilder onBeforeEachChild(ElementRenderEvent onBeforeEachChild) {
        this.onBeforeEachChild = onBeforeEachChild;
        return this;
    }

    @Override
    public ElementRendererBuilder onAfterEachChild(ElementRenderEvent onAfterEachChild) {
        this.onAfterEachChild = onAfterEachChild;
        return this;
    }

    @Override
    public ElementRendererBuilder onElementClose(ElementRenderEvent onElementClose) {
        this.onElementClose = onElementClose;
        return this;
    }

    @Override
    public ElementRenderer build() {
        return new ElementRenderer() {
            @Override
            public boolean onElementValidation(Element element) {
                if(onValidation == null)
                {
                    return true;
                }
                return onValidation.apply(element);
            }

            @Override
            public void onElementOpen(TextBuilder textBuilder, Element elementData) {
                if(onOpen == null)
                {
                    return;
                }
                onOpen.onRenderEvent(textBuilder, elementData);
            }

            @Override
            public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {
                if(onBeforeEachChild == null)
                {
                    return;
                }
                onBeforeEachChild.onRenderEvent(textBuilder, elementData);
            }

            @Override
            public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {
                if(onAfterEachChild == null)
                {
                    return;
                }
                onAfterEachChild.onRenderEvent(textBuilder, elementData);
            }

            @Override
            public void onElementClose(TextBuilder textBuilder, Element elementData) {
                if(onElementClose == null)
                {
                    return;
                }
                onElementClose.onRenderEvent(textBuilder, elementData);
            }
        };
    }
}

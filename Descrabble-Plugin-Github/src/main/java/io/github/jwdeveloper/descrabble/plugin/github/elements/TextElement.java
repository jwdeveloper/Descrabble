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
package io.github.jwdeveloper.descrabble.plugin.github.elements;


import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class TextElement implements DescrabbleElementRenderer {
    @Override
    public void onRegistration(ElementRendererModel model) {

    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        if(elementData.hasTag("quote"))
        {
            textBuilder.text(">").space();
        }

        if(elementData.hasTag("bold"))
        {
            textBuilder.text("**");
        }
        if(elementData.hasTag("italic"))
        {
            textBuilder.text("* *");
        }
        if(elementData.hasTag("strikethrough"))
        {
            textBuilder.text("~~");
        }
        if(elementData.hasTag("checked"))
        {
            textBuilder.space().text("[x]");
        }
        if(elementData.hasTag("not-checked"))
        {
            textBuilder.space().text("[x]");
        }
        if(elementData.hasTag("emoji"))
        {
            textBuilder.text(":");
        }

        String text = elementData.getProperty("text");
        textBuilder.text(text);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

        if(elementData.hasTag("italic"))
        {
            textBuilder.text("* *");
        }

        if(elementData.hasTag("emoji"))
        {
            textBuilder.text(":");
        }

        if(elementData.hasTag("strikethrough"))
        {
            textBuilder.text("~~");
        }

        if(elementData.hasTag("bold"))
        {
            textBuilder.text("**");
        }
    }
}

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
package io.github.jwdeveloper.descrabble.plugin.github.elements;


import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

import java.util.Objects;

public class TitleElement implements DescrabbleElementRenderer {
    @Override
    public void onRegistration(ElementRendererModel model) {
        model.setName("title");
        model.setShortName("title");
    }
    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        textBuilder.newLine();
        var size= getSize(elementData);
        textBuilder.text("<h").text(size);

        if(elementData.hasProperty("align"))
        {
            textBuilder.space().textBetween("align=\"",elementData.getProperty("align"),"\"").space();
        }
        textBuilder.text(">");

        if (elementData.hasProperty("title")) {
            textBuilder.text(elementData.getProperty("title"));
        }
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

        textBuilder.textBetween("</h", getSize(elementData), ">");
        textBuilder.newLine();
    }


    private String getSize(Element elementData) {
        if (elementData.hasProperty("size")) {
            return elementData.getProperty("size");
        }
        return "1";
    }


}

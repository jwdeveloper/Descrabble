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
package io.github.jwdeveloper.descrabble.plugin.github.elements.html;


import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

import java.util.Map;

public class HtmlElement implements DescrabbleElementRenderer {
    @Override
    public void onRegistration(ElementRendererModel model) {

    }
    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        renderOpenTag(textBuilder, elementData.getName(), elementData, elementData.getProperties());
    }


    public void renderOpenTag(TextBuilder textBuilder,String name, Element elementData,  Map<String, Object> properties)
    {
        var align = "";
        if(elementData.hasTag("left"))
        {
            align = "left";
        }
        if(elementData.hasTag("right"))
        {
            align = "right";
        }
        if(elementData.hasTag("center"))
        {
            align = "right";
        }

        if(!align.equals(""))
        {
            properties.put("align", align);
        }


        textBuilder.newLine();
        textBuilder.text("<").text(name).space();

        for(var property : properties.entrySet())
        {
            textBuilder.text(property.getKey()).text("=\"").text(property.getValue()).text("\"").space();
        }
        textBuilder.text(">").newLine();
    }

    public void renderCloseTag(TextBuilder textBuilder, String name)
    {
        textBuilder.textBetween("</",name , ">");
        textBuilder.newLine();
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        renderCloseTag(textBuilder, elementData.getName());
    }


}

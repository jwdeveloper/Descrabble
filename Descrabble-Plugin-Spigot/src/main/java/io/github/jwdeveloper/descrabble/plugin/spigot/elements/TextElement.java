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
package io.github.jwdeveloper.descrabble.plugin.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.plugin.spigot.SpigotElement;


public class TextElement extends SpigotElement {

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {


        if (elementData.hasProperty("color")) {
            openTag(textBuilder, "COLOR", elementData.getProperty("color"));
        }
        if (elementData.hasProperty("font")) {
            openTag(textBuilder, "FONT", elementData.getProperty("font"));
        }
        if (elementData.hasProperty("size")) {
            openTag(textBuilder, "SIZE", elementData.getProperty("size"));
        }
        if(elementData.hasTag("strike"))
        {
            openTag(textBuilder, "S");
        }

        if (elementData.hasTag("bold")) {
            openTag(textBuilder, "B");
        }
        if (elementData.hasTag("italic")) {
            openTag(textBuilder, "I");
        }
        if (elementData.hasTag("under-line")) {
            openTag(textBuilder, "U");
        }
        String text = elementData.getProperty("text");
        textBuilder.text(text);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {


        if (elementData.hasTag("under-line")) {
            closeTag(textBuilder, "U");
        }
        if (elementData.hasTag("italic")) {
            closeTag(textBuilder, "I");
        }
        if (elementData.hasTag("bold")) {
            closeTag(textBuilder, "B");
        }
        if(elementData.hasTag("strike"))
        {
            openTag(textBuilder, "S");
        }
        if (elementData.hasProperty("size")) {
            closeTag(textBuilder, "SIZE");
        }
        if (elementData.hasProperty("font")) {
            closeTag(textBuilder, "FONT");
        }
        if (elementData.hasProperty("color")) {
            closeTag(textBuilder, "COLOR");
        }
    }



}

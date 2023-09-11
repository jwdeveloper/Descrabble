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
package io.github.jwdeveloper.descrabble.plugin.spigot;


import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class SpigotElement implements DescrabbleElementRenderer
{

    @Override
    public void onRegistration(ElementRendererModel model) {

    }
    protected void openTag(TextBuilder textBuilder, String name) {
        openTag(textBuilder, name, null);
    }

    protected void openTag(TextBuilder textBuilder, String name, String value) {
        if (value == null || value.equals("")) {
            textBuilder.textBetween("[", name.toUpperCase(), "]");
            return;
        }
        textBuilder.textBetween("[", name.toUpperCase(), "=" + value + "]");
    }

    protected void closeTag(TextBuilder textBuilder, String name) {
        textBuilder.textBetween("[/", name.toUpperCase(), "]");
    }
    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
    }


}

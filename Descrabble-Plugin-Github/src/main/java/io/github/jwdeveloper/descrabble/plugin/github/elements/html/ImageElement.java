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

import java.util.HashMap;

public class ImageElement extends HtmlElement {
    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        var props = new HashMap<String,Object>();
        props.put("target","blank");
        if(elementData.hasProperty("open"))
        {
            props.put("href",elementData.getProperty("open"));
        }

        var imgProps = new HashMap<String,Object>();
        if(elementData.hasProperty("image"))
        {
            imgProps.put("src",elementData.getProperty("image"));
        }
        if(elementData.hasProperty("size"))
        {
            imgProps.put("size",elementData.getProperty("size"));
        }
        if(elementData.hasProperty("height"))
        {
            imgProps.put("height",elementData.getProperty("height"));
        }
        if(elementData.hasProperty("width"))
        {
            imgProps.put("width",elementData.getProperty("width"));
        }
        textBuilder.newLine();
        renderOpenTag(textBuilder,"a",props);
        renderOpenTag(textBuilder,"img",imgProps);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        renderCloseTag(textBuilder,"img");
        renderCloseTag(textBuilder,"a");
        textBuilder.newLine();
    }
}

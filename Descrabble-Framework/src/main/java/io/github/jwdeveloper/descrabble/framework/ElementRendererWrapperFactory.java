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
package io.github.jwdeveloper.descrabble.framework;


import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class ElementRendererWrapperFactory
{
    public ElementRenderer getTextElementInfo(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("text");
        info.setElementType(ElementType.TEXT);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getCodeRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("code");
        info.setElementType(ElementType.CODE);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getImageRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("image");
        info.setShortName("img");
        info.setElementType(ElementType.IMAGE);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getLinkRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("link");
        info.setElementType(ElementType.LINK);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getListRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("list");
        info.setElementType(ElementType.LIST);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getContainerElement(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("container");
        info.setShortName("con");
        info.setElementType(ElementType.POSITION);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getQuoteRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("quote");
        info.setElementType(ElementType.QUOTE);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getSpoilerRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("spoiler");
        info.setElementType(ElementType.SPOILER);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getVideoRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("video");
        info.setElementType(ElementType.VIDEO);

        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getBreakLineRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("break");
        info.setShortName("br");
        info.setElementType(ElementType.BREAK);

        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }


    public ElementRenderer getCustomElement(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setElementType(ElementType.CUSTOM);

        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }
}

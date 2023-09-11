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
package io.github.jwdeveloper.descrabble.plugin.spigot;


import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.DescrabblePlugin;
import io.github.jwdeveloper.descrabble.plugin.spigot.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Plugin implements DescrabblePlugin {
    @Override
    public String getPluginName() {
        return "spigot";
    }

    @Override
    public String getOutputFileName() {
        return "spigot.txt";
    }

    @Override
    public DescrabbleElementRenderer getContainerElement() {
        return new ContainerElement();
    }

    @Override
    public DescrabbleElementRenderer getImageRenderer() {
        return new ImageElement();
    }

    @Override
    public DescrabbleElementRenderer getVideoRenderer() {
        return new VideoElement();
    }

    @Override
    public DescrabbleElementRenderer getBreakLineRenderer() {
        return new BreakLineElement();
    }

    @Override
    public DescrabbleElementRenderer getCodeRenderer() {
        return new CodeElement();
    }

    @Override
    public DescrabbleElementRenderer getLinkRenderer() {
        return new LinkElement();
    }

    @Override
    public DescrabbleElementRenderer getListRenderer() {
        return new ListElement();
    }

    @Override
    public DescrabbleElementRenderer getQuoteRenderer() {
        return new QuoteElement();
    }

    @Override
    public DescrabbleElementRenderer getSpoilerRenderer() {
        return new SpoilerElement();
    }

    @Override
    public DescrabbleElementRenderer getTextRenderer() {
        return new TextElement();
    }

    @Override
    public List<DescrabbleElementRenderer> getCustomRenderers() {
        return List.of(new TitleElement());
    }
}

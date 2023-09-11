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
import io.github.jwdeveloper.descrabble.api.elements.ElementType;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodeElement implements DescrabbleElementRenderer {
    @Override
    public boolean onElementValidation(Element element) {
        return element.hasElementType(ElementType.CODE);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        String language = elementData.getProperty("language");

        textBuilder.newLine();
        textBuilder.newLine().text("```").textNewLine(language);

        if (elementData.hasProperty("code")) {
            String code = elementData.getProperty("code");
            textBuilder.text(code);
        }

        if (elementData.hasProperty("file")) {
            var path = elementData.<String>getProperty("file");
            try {
                var fullPath = System.getProperty("user.dir")+ File.separator+path;
                textBuilder.text(Files.readString(Paths.get(fullPath)));
            } catch (Exception e)
            {
                textBuilder.text(e.getMessage());
            }
        }
    }


    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.space().newLine().textNewLine("```");
    }

    @Override
    public void onRegistration(ElementRendererModel model) {

    }
}

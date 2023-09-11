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
package io.github.jwdeveloper.descrabble.core.decorators;

import io.github.jwdeveloper.descrabble.api.DescriptionDecorator;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementFactory;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;

public class TemplateParser implements DescriptionDecorator {
    private final File file;
    public TemplateParser(File file)  {
      this.file = file;
    }

    @Override
    public void decorate(Element root, ElementFactory factory) {
        try
        {
            var doc = Jsoup.parse(file, "UTF-8");
            var htmlBody = doc.getElementsByTag("body").get(0);
            decorate(htmlBody, root, factory);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Unable to load template file",e);
        }
    }

    public void decorate(org.jsoup.nodes.Element htmlRoot, Element root, ElementFactory factory) {
        for (var htmlElement : htmlRoot.children()) {

            var builder = factory.getBuilder();
            var name = htmlElement.tagName();
            if(name.equals("img"))
            {
                name = "image";
            }
            var elementType = ElementType.byName(name);
            builder.withName(name);
            builder.withType(elementType);


            for (var htmlAttribute : htmlElement.attributes()) {
                var key = htmlAttribute.getKey();
                if (key.contains("#")) {
                    key = key.substring(1);
                    builder.withTag(key);
                    continue;
                }
                var value = htmlAttribute.getValue();
                builder.withProperty(key, value);
            }

            var newRoot = builder.build();
            if (htmlElement.hasText()) {
                var text = htmlElement.ownText();
                if (elementType != ElementType.TEXT) {
                    var textElement = factory.textElement(text);
                    newRoot.addElement(textElement);
                }
                newRoot.addProperty("text", text);
            }
            System.out.println(htmlElement.tagName());
            if(htmlElement.tagName().equals("html-content"))
            {
                var text = factory.textElement(htmlElement.html());
                newRoot.addElement(text);
                root.addElement(newRoot);
                continue;
            }
            decorate(htmlElement, newRoot, factory);
            root.addElement(newRoot);
        }
    }
}

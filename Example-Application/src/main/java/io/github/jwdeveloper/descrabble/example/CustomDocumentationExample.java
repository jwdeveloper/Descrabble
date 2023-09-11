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
package io.github.jwdeveloper.descrabble.example;



import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.api.DescriptionRenderer;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;
import io.github.jwdeveloper.descrabble.core.DescriptionRendererBuilderImpl;
import io.github.jwdeveloper.descrabble.framework.Descrabble;

import java.io.IOException;

public class CustomDocumentationExample {
    public static void main(String[] args) throws IOException {

        DescriptionRenderer githubRenderer = new DescriptionRendererBuilderImpl()
                .withFileName("CUSTOM_README.md")
                .withElementRenderer(elementRenderer ->
                {
                    elementRenderer.onElementValidation(element -> element.hasElementType(ElementType.LINK));
                    elementRenderer.onElementOpen((textBuilder, element) ->
                    {
                        textBuilder.textBetween("[",element.getProperty("title"),"]");
                        textBuilder.textBetween("(",element.getProperty("link"),")");
                    });
                })
                .build();

        DescriptionRenderer redditRenderer = new DescriptionRendererBuilderImpl()
                .withFileName("CUSTOM_README.md")
                .withElementRenderer(elementRenderer ->
                {
                    elementRenderer.onElementValidation(element -> element.hasElementType(ElementType.LINK));
                    elementRenderer.onElementOpen((textBuilder, element) ->
                    {
                        textBuilder.textBetween("[",element.getProperty("title"),"]");
                        textBuilder.textBetween("(",element.getProperty("link"),")");
                    });
                })
                .build();

        DescriptionGenerator descriptionGenerator = Descrabble.create()
                .withDecorator((root, factory) ->
                {
                    String link = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley";
                    Element linkElement = factory.linkElement("DO NOT CLICK THIS LINK", link);
                    root.addElement(linkElement);
                })
                .withRenderer(redditRenderer)
                .withRenderer(githubRenderer)
                .build();

        String outputPath = "D:\\Git\\DescriptionGenerator\\example";
        descriptionGenerator.generate(outputPath);
    }
}

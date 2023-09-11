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
package io.github.jwdeveloper.descrabble.example;


import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.Descrabble;
import io.github.jwdeveloper.descrabble.plugin.github.DescrabbleGithub;


import java.util.ArrayList;

public class GithubDocumentationExample {
    public static void main(String[] args) {
        DescriptionGenerator descriptionGenerator = Descrabble.create()
                .withDecorator((root, factory) ->
                {
                    String link = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley";
                    Element linkElement = factory.linkElement("DO NOT CLICK THIS LINK", link);
                    Element titleElement = factory.titleElement("Hello world");
                    titleElement.addProperty("size",6);

                    Element videoElement = factory.videoElement("example video",link);
                    Element codeElement = factory.codeElement("""
                            public static void main(String[] args) {
                                System.out.printLine("hello world");
                            }
                            ""","java");

                    Element listElement = factory.listElement(new ArrayList<>());
                    for(int i =0;i<5;i++)
                    {
                        Element listContent = factory.textElement("List content "+i);
                        listContent.addTag("quote");
                        listElement.addElement(listContent);
                    }

                    root.addElement(titleElement);
                    root.addElement(listElement);
                    root.addElement(linkElement);
                    root.addElement(videoElement);
                    root.addElement(codeElement);

                })
                .withPlugin(DescrabbleGithub.plugin())
                .build();

        String outputPath = "D:\\Git\\DescriptionGenerator\\example";
        descriptionGenerator.generate(outputPath);

    }
}

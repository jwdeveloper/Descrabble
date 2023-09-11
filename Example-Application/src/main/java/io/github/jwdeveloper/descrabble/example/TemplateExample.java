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
import io.github.jwdeveloper.descrabble.framework.Descrabble;
import io.github.jwdeveloper.descrabble.plugin.github.DescrabbleGithub;
import io.github.jwdeveloper.descrabble.plugin.spigot.DescrabbleSpigot;


import java.io.File;

public class TemplateExample {
    public static void main(String[] args) {
        ClassLoader classLoader = TemplateExample.class.getClassLoader();
        File file = new File(classLoader.getResource("template.html").getFile());

        DescriptionGenerator generator = Descrabble.create()
                .withTemplate(file)
                .withPlugin(DescrabbleGithub.plugin())
                .withPlugin(DescrabbleSpigot.plugin())
                .build();

        String output = "C:\\Users\\ja\\IdeaProjects\\DescriptionGenerator\\examples\\src\\main\\resources\\output";
        generator.generate(output);
    }
}

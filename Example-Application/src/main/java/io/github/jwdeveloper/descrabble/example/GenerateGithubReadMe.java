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
import io.github.jwdeveloper.descrabble.framework.Descrabble;
import io.github.jwdeveloper.descrabble.plugin.github.DescrabbleGithub;
import io.github.jwdeveloper.descrabble.plugin.spigot.DescrabbleSpigot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class GenerateGithubReadMe
{

    public static void main(String[] args) throws IOException {
        var version = System.getenv("VERSION");
        if(version == null || version.equals(""))
        {
            version = "[Replace with current version]";
        }

        var inputStream =GenerateGithubReadMe.class.getResourceAsStream("/readme-template.html");
        var targetFile = new File("temp.tmp");
        FileUtils.copyInputStreamToFile(inputStream, targetFile);

        DescriptionGenerator generator = Descrabble.create()
                .withTemplate(targetFile)
                .withVariable("version",version)
                .withPlugin(DescrabbleGithub.plugin("README.MD"))
                .withPlugin(DescrabbleSpigot.plugin())
                .build();

        var output = System.getProperty("user.dir");
        generator.generate(output);
        targetFile.delete();
        inputStream.close();

    }
}

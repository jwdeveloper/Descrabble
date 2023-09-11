package io.github.jwdeveloper.descrabble.example;

import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.framework.Descrabble;
import io.github.jwdeveloper.descrabble.plugin.github.DescrabbleGithub;
import java.io.File;

public class GenerateGithubReadMe
{

    public static void main(String[] args)
    {
        var classLoader = GenerateGithubReadMe.class.getClassLoader();
        var file = new File(classLoader.getResource("readme-template.html").getFile());


        DescriptionGenerator generator = Descrabble.create()
                .withTemplate(file)
                .withVariable("version","1.0.0")
                .withPlugin(DescrabbleGithub.plugin("README.MD"))
                .build();

        var output = System.getProperty("user.dir");
        generator.generate(output);

    }
}

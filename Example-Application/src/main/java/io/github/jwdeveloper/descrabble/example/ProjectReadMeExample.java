package io.github.jwdeveloper.descrabble.example;

import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.framework.Descrabble;
import io.github.jwdeveloper.descrabble.plugin.github.DescrabbleGithub;


import java.nio.file.Path;

public class ProjectReadMeExample
{
    public static void main(String[] args)
    {
        DescriptionGenerator generator = Descrabble.create()
                .withTemplate(Path.of("C:\\Users\\ja\\IdeaProjects\\DescriptionGenerator\\readme-template.html"))
                .withPlugin(DescrabbleGithub.plugin())
                .build();

        String output = "C:\\Users\\ja\\IdeaProjects\\DescriptionGenerator\\";
        generator.generate(output);
    }
}

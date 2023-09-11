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

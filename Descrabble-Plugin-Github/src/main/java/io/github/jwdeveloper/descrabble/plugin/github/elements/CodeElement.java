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

package io.github.jwdeveloper.descrabble.plugin.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.plugin.spigot.SpigotElement;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodeElement extends SpigotElement {
    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        if(elementData.hasProperty("language"))
        {
            openTag(textBuilder,"code",elementData.getProperty("language"));
        }
        else
        {
            openTag(textBuilder,"code");
        }
        textBuilder.newLine();
        if (elementData.hasProperty("file")) {
            var path = elementData.<String>getProperty("file");
            try {
                var fullPath = System.getProperty("user.dir")+ File.separator+path;
                textBuilder.text(Files.readString(Paths.get(fullPath)));
            } catch (Exception e) {
                textBuilder.text(e.getMessage());
            }
        }

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
        closeTag(textBuilder,"CODE");

    }

}

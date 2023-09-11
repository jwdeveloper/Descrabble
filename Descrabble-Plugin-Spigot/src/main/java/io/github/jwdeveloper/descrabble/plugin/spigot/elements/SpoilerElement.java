package io.github.jwdeveloper.descrabble.plugin.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.plugin.spigot.SpigotElement;

public class SpoilerElement extends SpigotElement {

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        if(elementData.hasProperty("title"))
        {
            openTag(textBuilder,"SPOILER",elementData.getProperty("title"));
            textBuilder.newLine();
            return;
        }
        openTag(textBuilder,"SPOILER");
        textBuilder.newLine();
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
        closeTag(textBuilder,"SPOILER");

    }
}

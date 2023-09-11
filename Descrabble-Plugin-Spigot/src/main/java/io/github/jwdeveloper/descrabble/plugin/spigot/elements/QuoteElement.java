package io.github.jwdeveloper.descrabble.plugin.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.plugin.spigot.SpigotElement;

public class QuoteElement extends SpigotElement
{



    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        textBuilder.newLine();
        openTag(textBuilder,"quote");
        textBuilder.newLine();
    }


    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
        closeTag(textBuilder,"quote");
        textBuilder.newLine();
    }
}

package io.github.jwdeveloper.descrabble.plugin.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.plugin.spigot.SpigotElement;


public class LinkElement extends SpigotElement {


    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {


        if(elementData.hasProperty("link"))
        {
            String link = elementData.getProperty("link");
            openTag(textBuilder,"URL","'"+link+"'");
        }
        if(elementData.hasProperty("title"))
        {
            String title = elementData.getProperty("title");
            textBuilder.text(title);
        }
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        closeTag(textBuilder,"URL");
    }
}

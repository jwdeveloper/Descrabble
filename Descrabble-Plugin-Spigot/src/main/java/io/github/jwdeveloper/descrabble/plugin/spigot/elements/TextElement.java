package io.github.jwdeveloper.descrabble.plugin.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.plugin.spigot.SpigotElement;


public class TextElement extends SpigotElement {

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {




        if (elementData.hasProperty("color")) {
            openTag(textBuilder, "COLOR", elementData.getProperty("color"));
        }
        if (elementData.hasProperty("font")) {
            openTag(textBuilder, "FONT", elementData.getProperty("font"));
        }
        if (elementData.hasProperty("size")) {
            openTag(textBuilder, "SIZE", elementData.getProperty("size"));
        }
        if(elementData.hasTag("strike"))
        {
            openTag(textBuilder, "S");
        }

        if (elementData.hasTag("bold")) {
            openTag(textBuilder, "B");
        }
        if (elementData.hasTag("italic")) {
            openTag(textBuilder, "I");
        }
        if (elementData.hasTag("under-line")) {
            openTag(textBuilder, "U");
        }
        String text = elementData.getProperty("text");
        textBuilder.text(text);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {


        if (elementData.hasTag("under-line")) {
            closeTag(textBuilder, "U");
        }
        if (elementData.hasTag("italic")) {
            closeTag(textBuilder, "I");
        }
        if (elementData.hasTag("bold")) {
            closeTag(textBuilder, "B");
        }
        if(elementData.hasTag("strike"))
        {
            openTag(textBuilder, "S");
        }
        if (elementData.hasProperty("size")) {
            closeTag(textBuilder, "SIZE");
        }
        if (elementData.hasProperty("font")) {
            closeTag(textBuilder, "FONT");
        }
        if (elementData.hasProperty("color")) {
            closeTag(textBuilder, "COLOR");
        }
    }



}

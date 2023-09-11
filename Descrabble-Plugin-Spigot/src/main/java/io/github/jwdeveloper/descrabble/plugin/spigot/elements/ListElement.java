package io.github.jwdeveloper.descrabble.plugin.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.plugin.spigot.SpigotElement;

public class ListElement extends SpigotElement {

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
        openTag(textBuilder,"LIST");
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine().text("[*]");
    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
        closeTag(textBuilder,"LIST");
        textBuilder.newLine();
    }
}

package io.github.jwdeveloper.descrabble.plugin.spigot;


import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class SpigotElement implements DescrabbleElementRenderer
{

    @Override
    public void onRegistration(ElementRendererModel model) {

    }
    protected void openTag(TextBuilder textBuilder, String name) {
        openTag(textBuilder, name, null);
    }

    protected void openTag(TextBuilder textBuilder, String name, String value) {
        if (value == null || value.equals("")) {
            textBuilder.textBetween("[", name.toUpperCase(), "]");
            return;
        }
        textBuilder.textBetween("[", name.toUpperCase(), "=" + value + "]");
    }

    protected void closeTag(TextBuilder textBuilder, String name) {
        textBuilder.textBetween("[/", name.toUpperCase(), "]");
    }
    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine();
    }


}

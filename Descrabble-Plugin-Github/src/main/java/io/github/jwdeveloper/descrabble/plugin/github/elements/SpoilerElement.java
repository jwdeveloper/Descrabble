package io.github.jwdeveloper.descrabble.plugin.github.elements;


import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class SpoilerElement implements DescrabbleElementRenderer {


    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine()
                .textNewLine("<details>");
        if (elementData.hasProperty("title")) {
            textBuilder.textBetween("<summary>", elementData.getProperty("title"), "</summary>").newLine();
        }
    }



    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        textBuilder.newLine().textNewLine("</details>");
        textBuilder.newLine();

    }

    @Override
    public void onRegistration(ElementRendererModel model) {

    }
}

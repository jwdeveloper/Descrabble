package io.github.jwdeveloper.descrabble.plugin.github.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class QuoteElement implements DescrabbleElementRenderer {

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        textBuilder.text(">").space();
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {

        textBuilder.newLine();
    }

    @Override
    public void onRegistration(ElementRendererModel model) {

    }
}

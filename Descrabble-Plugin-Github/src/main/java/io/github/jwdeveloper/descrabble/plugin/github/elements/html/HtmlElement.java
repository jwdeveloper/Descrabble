package io.github.jwdeveloper.descrabble.plugin.github.elements.html;


import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

import java.util.Map;

public class HtmlElement implements DescrabbleElementRenderer {
    @Override
    public void onRegistration(ElementRendererModel model) {

    }
    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        renderOpenTag(textBuilder, elementData.getName(), elementData.getProperties());
    }


    public void renderOpenTag(TextBuilder textBuilder,String name, Map<String, Object> properties)
    {
        textBuilder.newLine();
        textBuilder.text("<").text(name).space();

        for(var property : properties.entrySet())
        {
            textBuilder.text(property.getKey()).text("=\"").text(property.getValue()).text("\"").space();
        }
        textBuilder.text(">").newLine();
    }

    public void renderCloseTag(TextBuilder textBuilder, String name)
    {
        textBuilder.textBetween("</",name , ">");
        textBuilder.newLine();
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {

    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        renderCloseTag(textBuilder, elementData.getName());
    }


}

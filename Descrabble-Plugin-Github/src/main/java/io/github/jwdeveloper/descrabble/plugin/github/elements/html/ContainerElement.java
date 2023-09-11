package io.github.jwdeveloper.descrabble.plugin.github.elements.html;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;

import java.util.HashMap;

public class ContainerElement extends HtmlElement {
    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
         var properties = new HashMap<String, Object>();

        var position = "center";
        if(elementData.hasTag("left"))
        {
            position = "left";
        }
        if(elementData.hasTag("right"))
        {
            position = "right";
        }

        properties.put("align", position);
        renderOpenTag(textBuilder, "div", properties);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        renderCloseTag(textBuilder, "div");
        textBuilder.newLine();
    }



}

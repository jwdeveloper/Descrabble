package io.github.jwdeveloper.descrabble.plugin.spigot.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class TitleElement extends TextElement
{
    @Override
    public void onRegistration(ElementRendererModel model) {
        model.setName("title");
        model.setShortName("title");
    }
    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData)
    {
        if (!elementData.hasProperty("size"))
        {
            elementData.setProperty("size","8");
        }
        super.onElementOpen(textBuilder, elementData);
    }
}

package io.github.jwdeveloper.descrabble.framework;


import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class ElementRendererWrapper implements ElementRenderer {
    private final DescrabbleElementRenderer renderer;
    private final ElementRendererModel model;

    public ElementRendererWrapper(DescrabbleElementRenderer renderer, ElementRendererModel model) {
        this.renderer = renderer;
        this.model = model;
    }

    public ElementRendererModel getModel()
    {
        return model;
    }


    @Override
    public boolean onElementValidation(Element element)
    {
        if(!element.getName().equals(model.getName()) && !element.getName().equals(model.getShortName()))
        {
            return false;
        }

        return renderer.onElementValidation(element);
    }

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {
        renderer.onElementOpen(textBuilder, elementData);
    }

    @Override
    public void onElementClose(TextBuilder textBuilder, Element elementData) {
        renderer.onElementClose(textBuilder, elementData);
    }

    @Override
    public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {
        renderer.onAfterEachChild(textBuilder, elementData);
    }

    @Override
    public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {
        renderer.onBeforeEachChild(textBuilder, elementData);
    }
}

package io.github.jwdeveloper.descrabble.framework;


import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;
import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.ElementRendererModel;

public class ElementRendererWrapperFactory
{
    public ElementRenderer getTextElementInfo(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("text");
        info.setElementType(ElementType.TEXT);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getCodeRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("code");
        info.setElementType(ElementType.CODE);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getImageRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("image");
        info.setShortName("img");
        info.setElementType(ElementType.IMAGE);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getLinkRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("link");
        info.setElementType(ElementType.LINK);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getListRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("list");
        info.setElementType(ElementType.LIST);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getContainerElement(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("container");
        info.setShortName("con");
        info.setElementType(ElementType.POSITION);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getQuoteRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("quote");
        info.setElementType(ElementType.QUOTE);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getSpoilerRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("spoiler");
        info.setElementType(ElementType.SPOILER);
        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getVideoRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("video");
        info.setElementType(ElementType.VIDEO);

        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }

    public ElementRenderer getBreakLineRenderer(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setName("break");
        info.setShortName("br");
        info.setElementType(ElementType.BREAK);

        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }


    public ElementRenderer getCustomElement(DescrabbleElementRenderer renderer)
    {
        var info = new ElementRendererModel();
        info.setElementType(ElementType.CUSTOM);

        renderer.onRegistration(info);
        return new ElementRendererWrapper(renderer, info);
    }
}

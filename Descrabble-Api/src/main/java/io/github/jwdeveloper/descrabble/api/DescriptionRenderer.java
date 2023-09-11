package io.github.jwdeveloper.descrabble.api;

import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;

import java.util.List;

public interface DescriptionRenderer
{
    String getFileName();

    List<ElementRenderer> getElementRenderers();

    boolean onElementValidation(Element element);
}

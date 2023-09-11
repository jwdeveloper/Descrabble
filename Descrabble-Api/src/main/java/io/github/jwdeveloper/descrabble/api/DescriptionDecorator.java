package io.github.jwdeveloper.descrabble.api;

import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementFactory;

public interface DescriptionDecorator
{
    void decorate(Element root, ElementFactory factory);
}

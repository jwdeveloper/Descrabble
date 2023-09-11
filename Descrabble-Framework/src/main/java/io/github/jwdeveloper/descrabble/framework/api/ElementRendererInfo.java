package io.github.jwdeveloper.descrabble.framework.api;

import io.github.jwdeveloper.descrabble.api.elements.ElementType;

import java.util.List;

public interface ElementRendererInfo
{
    String getSource();

    String getDescription();

    String getName();

    String getShortName();

    List<HandledValue> getSupportedTags();

    List<HandledValue> getSupportedProperties();

    ElementType getElementType();
}

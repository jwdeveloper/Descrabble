package io.github.jwdeveloper.descrabble.api.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;


public interface ElementRenderer {

    default boolean onElementValidation(Element element)
    {
        return true;
    }

    void onElementOpen(TextBuilder textBuilder, Element elementData);

    default void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {
    }

    default void onAfterEachChild(TextBuilder textBuilder, Element elementData) {
    }

    void onElementClose(TextBuilder textBuilder, Element elementData);
}

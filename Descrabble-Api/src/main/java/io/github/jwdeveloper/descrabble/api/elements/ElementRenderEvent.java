package io.github.jwdeveloper.descrabble.api.elements;

import io.github.jwdeveloper.descrabble.api.TextBuilder;

@FunctionalInterface
public interface ElementRenderEvent
{
    public void onRenderEvent(TextBuilder textBuilder, Element element);
}

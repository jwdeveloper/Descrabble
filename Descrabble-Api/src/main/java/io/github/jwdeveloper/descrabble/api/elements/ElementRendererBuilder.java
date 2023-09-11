package io.github.jwdeveloper.descrabble.api.elements;

import java.util.function.Function;

public interface ElementRendererBuilder {
    ElementRendererBuilder onElementValidation(Function<Element, Boolean> onValidation);

    ElementRendererBuilder onElementOpen(ElementRenderEvent onOpen);

    ElementRendererBuilder onBeforeEachChild(ElementRenderEvent onBeforeEachChild);

    ElementRendererBuilder onAfterEachChild(ElementRenderEvent onAfterEachChild);

    ElementRendererBuilder onElementClose(ElementRenderEvent onElementClose);

    ElementRenderer build();
}

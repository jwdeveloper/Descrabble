package io.github.jwdeveloper.descrabble.core.element;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderEvent;
import io.github.jwdeveloper.descrabble.api.elements.ElementRenderer;
import io.github.jwdeveloper.descrabble.api.elements.ElementRendererBuilder;

import java.util.function.Function;

public class ElementRendererBuilderImpl implements ElementRendererBuilder {

    private Function<Element, Boolean> onValidation;
    private ElementRenderEvent onOpen;
    private ElementRenderEvent onBeforeEachChild;
    private ElementRenderEvent onAfterEachChild;
    private ElementRenderEvent onElementClose;

    @Override
    public ElementRendererBuilder onElementValidation(Function<Element, Boolean> onValidation)
    {
        this.onValidation = onValidation;
        return this;
    }

    @Override
    public ElementRendererBuilder onElementOpen(ElementRenderEvent onOpen) {
         this.onOpen = onOpen;
         return this;
    }

    @Override
    public ElementRendererBuilder onBeforeEachChild(ElementRenderEvent onBeforeEachChild) {
        this.onBeforeEachChild = onBeforeEachChild;
        return this;
    }

    @Override
    public ElementRendererBuilder onAfterEachChild(ElementRenderEvent onAfterEachChild) {
        this.onAfterEachChild = onAfterEachChild;
        return this;
    }

    @Override
    public ElementRendererBuilder onElementClose(ElementRenderEvent onElementClose) {
        this.onElementClose = onElementClose;
        return this;
    }

    @Override
    public ElementRenderer build() {
        return new ElementRenderer() {
            @Override
            public boolean onElementValidation(Element element) {
                if(onValidation == null)
                {
                    return true;
                }
                return onValidation.apply(element);
            }

            @Override
            public void onElementOpen(TextBuilder textBuilder, Element elementData) {
                if(onOpen == null)
                {
                    return;
                }
                onOpen.onRenderEvent(textBuilder, elementData);
            }

            @Override
            public void onBeforeEachChild(TextBuilder textBuilder, Element elementData) {
                if(onBeforeEachChild == null)
                {
                    return;
                }
                onBeforeEachChild.onRenderEvent(textBuilder, elementData);
            }

            @Override
            public void onAfterEachChild(TextBuilder textBuilder, Element elementData) {
                if(onAfterEachChild == null)
                {
                    return;
                }
                onAfterEachChild.onRenderEvent(textBuilder, elementData);
            }

            @Override
            public void onElementClose(TextBuilder textBuilder, Element elementData) {
                if(onElementClose == null)
                {
                    return;
                }
                onElementClose.onRenderEvent(textBuilder, elementData);
            }
        };
    }
}

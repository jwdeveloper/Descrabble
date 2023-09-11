package io.github.jwdeveloper.descrabble.core.element;

import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementBuilder;
import io.github.jwdeveloper.descrabble.api.elements.ElementData;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

public class ElementBuilderImpl implements ElementBuilder {

    private final ElementData elementData;

    public ElementBuilderImpl()
    {
        elementData = new ElementData();
    }

    @Override
    public ElementBuilder withType(ElementType type) {
        elementData.setElementType(type);
        return this;
    }

    @Override
    public ElementBuilder withName(String name) {
        elementData.setName(name);
        return this;
    }

    @Override
    public ElementBuilder withTag(String tag) {
        elementData.getTags().add(tag);
        return this;
    }

    @Override
    public ElementBuilder withProperty(String key, Object value) {
        elementData.getProperties().put(key, value);
        return this;
    }

    @Override
    public Element build() {
        return new ElementImpl(elementData);
    }


}

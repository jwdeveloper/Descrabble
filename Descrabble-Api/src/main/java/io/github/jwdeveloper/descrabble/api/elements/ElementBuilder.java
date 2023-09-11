package io.github.jwdeveloper.descrabble.api.elements;

public interface ElementBuilder
{
    ElementBuilder withType(ElementType type);

    ElementBuilder withName(String name);

    ElementBuilder withTag(String tag);

    ElementBuilder withProperty(String key, Object value);

    Element build();
}

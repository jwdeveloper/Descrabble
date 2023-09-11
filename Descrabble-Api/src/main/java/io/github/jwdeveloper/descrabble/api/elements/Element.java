package io.github.jwdeveloper.descrabble.api.elements;


import java.util.List;
import java.util.Map;

public interface Element {
    String getName();

    List<String> getTags();

    void addTag(String tag);

    Map<String, Object> getProperties();

    <T> T getProperty(String property);

    void addProperty(String property, Object value);

    List<Element> getElements();

    void addElement(Element... elements);

    List<Element> findElements(String elementName, boolean deep);

    List<Element> findElements(String elementName);

    Element findElement(String elementName, boolean deep);

    Element findElement(String elementName);

    boolean hasName();

    boolean hasProperty(String property);

    boolean hasTag(String tag);
    boolean hasElements();

    boolean hasElementType(ElementType elementType);
}
/*
 * Copyright (c) 2012-2023 JW Developer https://github.com/jwdeveloper
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.jwdeveloper.descrabble.core.element;

import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementData;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ElementImpl implements Element {

    private final ElementData data;
    private final List<Element> elements;
    private final ElementsFinder elementsFinder;

    public ElementImpl() {
        this(new ElementData());
    }

    public ElementImpl(ElementData data) {
        this.data = data;
        this.elements = new ArrayList<>();
        this.elementsFinder = new ElementsFinder();
    }

    @Override
    public String getName() {
        return data.getName();
    }

    @Override
    public List<String> getTags() {
        return Collections.unmodifiableList(data.getTags());
    }

    @Override
    public void addTag(String tag) {
        data.getTags().add(tag);
    }

    @Override
    public Map<String, Object> getProperties() {
        return Collections.unmodifiableMap(data.getProperties());
    }

    @Override
    public <T> T getProperty(String property) {
        if (!data.getProperties().containsKey(property)) {
            throw new RuntimeException("element " + getName() + " not contains property: " + property);
        }
        return (T) data.getProperties().get(property);
    }

    @Override
    public void addProperty(String property, Object value) {
        data.getProperties().put(property, value);
    }

    @Override
    public List<Element> getElements() {
        return Collections.unmodifiableList(elements);
    }

    @Override
    public void addElement(Element... elements) {
        for (var element : elements) {
            if (element == this) {
                throw new RuntimeException("Element can not be added to itself");
            }
            this.elements.add(element);
        }
    }

    @Override
    public List<Element> findElements(String elementName, boolean deep) {
        return elementsFinder.findByName(getElements(), elementName, deep);
    }

    @Override
    public List<Element> findElements(String elementName) {
        return findElements(elementName, false);
    }

    @Override
    public Element findElement(String elementName, boolean deep) {
        var elements = findElements(elementName, deep);
        if (elements.size() == 0) {
            throw new RuntimeException("Element " + elementName + " not found in " + getName());
        }
        return elements.get(0);
    }

    @Override
    public Element findElement(String elementName) {
        return findElement(elementName, false);
    }

    @Override
    public boolean hasName() {
        return getName() != null;
    }

    @Override
    public boolean hasProperty(String key) {
        return data.getProperties().containsKey(key);
    }

    @Override
    public boolean hasTag(String tag) {
        for (var tagg : getTags()) {
            if (tagg.equals(tag)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasElements() {
        return elements.size() != 0;
    }

    @Override
    public boolean hasElementType(ElementType elementType) {
        return data.getElementType().equals(elementType);
    }
}

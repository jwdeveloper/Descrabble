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

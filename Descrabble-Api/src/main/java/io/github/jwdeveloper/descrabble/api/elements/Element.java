/*
 * Copyright (c) 2023-2023 jwdeveloper  <jacekwoln@gmail.com>
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

    void setProperty(String name, String value);

    boolean hasTag(String tag);
    boolean hasElements();

    boolean hasElementType(ElementType elementType);
}
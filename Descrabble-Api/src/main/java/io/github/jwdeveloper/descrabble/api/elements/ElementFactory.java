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
package io.github.jwdeveloper.descrabble.api.elements;

import java.util.List;
import java.util.Map;

public interface ElementFactory {
    ElementBuilder getBuilder();

    Element textElement(String text);

    Element titleElement(String title);

    Element linkElement(String title, String link);

    Element videoElement(String open);

    Element videoElement(String open, String size);

    Element imageElement(String image);

    Element imageElement(String image, String open);

    Element imageElement(String image, String open, String size);

    Element htmlElement(String tagName, Map<String, Object> properties);

    Element htmlElement(String tagName);

    Element codeElement(String code, String language);

    Element codeElementFromFile(String codeSourcePathString, String language);

    Element listElement(List<String> values);

    Element spoilerElement(String title);
    Element containerElement();
    Element containerElement(String tag);
    Element quoteElement();
    Element breakElement();
    Element customElement();

}

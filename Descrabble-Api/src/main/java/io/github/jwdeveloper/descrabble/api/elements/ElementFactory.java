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

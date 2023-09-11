package io.github.jwdeveloper.descrabble.core.element;

import io.github.jwdeveloper.descrabble.api.elements.Element;
import io.github.jwdeveloper.descrabble.api.elements.ElementBuilder;
import io.github.jwdeveloper.descrabble.api.elements.ElementFactory;
import io.github.jwdeveloper.descrabble.api.elements.ElementType;

import java.util.List;
import java.util.Map;

public class ElementsFactoryImpl implements ElementFactory {

    public ElementBuilder getBuilder() {
        return new ElementBuilderImpl();
    }

    @Override
    public Element titleElement(String title) {
        return getBuilder()
                .withType(ElementType.TITLE)
                .withName("title")
                .withProperty("title", title)
                .build();
    }

    @Override
    public Element linkElement(String title, String link) {
        return getBuilder()
                .withType(ElementType.LINK)
                .withName("link")
                .withProperty("title", title)
                .withProperty("link", link)
                .build();
    }

    @Override
    public Element textElement(String text) {
        return getBuilder()
                .withType(ElementType.TEXT)
                .withName("text")
                .withProperty("text", text)
                .build();
    }

    @Override
    public Element videoElement(String open) {
        return videoElement(open,"100");
    }

    @Override
    public Element videoElement(String open, String height) {
        return getBuilder()
                .withType(ElementType.VIDEO)
                .withName("video")
                .withProperty("open", open)
                .withProperty("height", height)
                .build();
    }

    @Override
    public Element imageElement(String image, String open, String size) {
        return getBuilder().withName("image")
                .withType(ElementType.IMAGE)
                .withProperty("image", image)
                .withProperty("open", open)
                .withProperty("height",size)
                .build();
    }

    @Override
    public Element imageElement(String link, String redirectLink) {
        return imageElement(link,redirectLink,"100");
    }

    @Override
    public Element imageElement(String link) {
        return imageElement(link,"");
    }

    @Override
    public Element htmlElement(String tagName, Map<String, Object> properties) {
        var builder = getBuilder()
                .withType(ElementType.HTML)
                .withName(tagName)
                .withProperty("tag-name", tagName);
        for (var prop : properties.entrySet()) {
            builder.withProperty(prop.getKey(), prop.getValue());
        }
        return builder.build();
    }

    @Override
    public Element htmlElement(String tagName) {
        return getBuilder()
                .withType(ElementType.HTML)
                .withName(tagName)
                .withProperty("tag-name", tagName)
                .build();
    }

    @Override
    public Element customElement() {
        return getBuilder()
                .withType(ElementType.CUSTOM)
                .build();
    }

    @Override
    public Element codeElement(String code, String language) {
        return getBuilder()
                .withType(ElementType.CODE)
                .withProperty("code", code)
                .withProperty("language", language)
                .build();
    }

    @Override
    public Element codeElementFromFile(String codeSourcePath, String language) {
        return getBuilder()
                .withType(ElementType.CODE)
                .withProperty("code-source-path", codeSourcePath)
                .withProperty("language", language)
                .build();
    }

    @Override
    public Element listElement(List<String> values) {
        return getBuilder()
                .withType(ElementType.LIST)
                .withName("list")
                .withProperty("values", values)
                .build();
    }

    @Override
    public Element spoilerElement(String title) {
        return getBuilder()
                .withType(ElementType.SPOILER)
                .withName("spoiler")
                .withProperty("title", title)
                .build();
    }

    @Override
    public Element containerElement() {
        return getBuilder()
                .withType(ElementType.CUSTOM)
                .withName("container")
                .build();
    }

    @Override
    public Element containerElement(String tag) {
        return getBuilder()
                .withType(ElementType.CUSTOM)
                .withName("container")
                .withTag(tag)
                .build();
    }

    @Override
    public Element quoteElement() {
        return getBuilder()
                .withType(ElementType.QUOTE)
                .withName("quote")
                .build();
    }

    @Override
    public Element breakElement() {
        return getBuilder()
                .withType(ElementType.BREAK)
                .withName("break")
                .build();
    }
}

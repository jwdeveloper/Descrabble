package io.github.jwdeveloper.descrabble.core;

import io.github.jwdeveloper.descrabble.api.TextBuilder;

public class TextBuilderImpl implements TextBuilder {
    private final StringBuilder builder;

    public TextBuilderImpl() {
        builder = new StringBuilder();
    }

    @Override
    public TextBuilder text(Object... texts) {
        for (var text : texts) {
            var value = text == null ? "NULL" : text.toString();
            text(value).space();
        }
        return this;
    }

    @Override
    public TextBuilder text(Object text) {
        builder.append(text);
        return this;
    }

    @Override
    public TextBuilder textBetween(Object open, Object text, Object close) {
        text(open).text(text).text(close);
        return this;
    }

    @Override
    public TextBuilder space() {
        builder.append(" ");
        return this;
    }

    @Override
    public TextBuilder space(int count) {
        for (; count > 0; count--) {
            space();
        }
        return this;
    }


    @Override
    public TextBuilder textNewLine(String text) {
        return text(text).newLine();
    }

    @Override
    public TextBuilder textFormat(String pattern, Object... args) {
        return text(String.format(pattern, args));
    }


    @Override
    public TextBuilder newLine() {
        builder.append(System.lineSeparator());
        return this;
    }

    @Override
    public TextBuilder repeat(String text, int length)
    {
        text(text.repeat(length));
        return this;
    }

    @Override
    public String build() {
        return toString();
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
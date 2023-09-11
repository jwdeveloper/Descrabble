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
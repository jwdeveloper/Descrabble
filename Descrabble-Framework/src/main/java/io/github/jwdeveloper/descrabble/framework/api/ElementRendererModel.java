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
package io.github.jwdeveloper.descrabble.framework.api;

import io.github.jwdeveloper.descrabble.api.elements.ElementType;
import io.github.jwdeveloper.descrabble.core.TextBuilderImpl;
import lombok.Data;

import java.util.List;

@Data
public class ElementRendererModel
{
    private String source = "default";

    private String name;

    private String description;
    private String shortName;

    private ElementType elementType;

    private List<HandledValue> supportedTags;

    private List<HandledValue> supportedProperties;

    public String getShortName() {
        if(shortName != null)
        {
            return shortName;
        }
        return String.valueOf(name.charAt(0));
    }

    @Override
    public String toString()
    {
        var builder = new TextBuilderImpl();

        builder.text("Source: ", getSource()).newLine();
        builder.text("Name: ", getName()).newLine();
        builder.text("ShortName: ", getShortName()).newLine();
        builder.text("Type: ", getElementType().name()).newLine();
        builder.repeat("=", 10).newLine();
        builder.text("Tags: ").newLine();
        for(var tag : supportedTags)
        {
            builder.text("Source: ", tag.getSource()).newLine();
            builder.text("Name: ", tag.getName()).newLine();
            builder.text("Description: ", tag.getDescription()).newLine();
        }

        builder.repeat("=", 10).newLine();
        builder.text("Properties: ").newLine();
        for(var tag : supportedProperties)
        {
            builder.text("Source: ", tag.getSource()).newLine();
            builder.text("Name: ", tag.getName()).newLine();
            builder.text("Description: ", tag.getDescription()).newLine();
        }

        return builder.toString();
    }
}




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




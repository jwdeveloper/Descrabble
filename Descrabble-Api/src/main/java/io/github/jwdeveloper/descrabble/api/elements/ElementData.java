package io.github.jwdeveloper.descrabble.api.elements;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ElementData {
    private ElementType elementType = ElementType.TEXT;
    private String name = "";
    private List<String> tags = new ArrayList<>();
    private Map<String, Object> properties = new HashMap<>();
}
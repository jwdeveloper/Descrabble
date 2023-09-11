package io.github.jwdeveloper.descrabble.core.element;

import io.github.jwdeveloper.descrabble.api.elements.Element;

import java.util.ArrayList;
import java.util.List;

public class ElementsFinder
{
    public List<Element> findByName(List<Element> elements, String name, boolean deep)
    {
        var result = new ArrayList<Element>();
        for(var element : elements)
        {
            if(element.getName().equals(name))
            {
               result.add(element);
               continue;
            }
            if(!deep)
            {
                continue;
            }
            var childResult = findByName(element.getElements(), name, deep);
            result.addAll(childResult);
        }
        return result;
    }
}

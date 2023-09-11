package io.github.jwdeveloper.descrabble.framework;


import io.github.jwdeveloper.descrabble.framework.api.DescrabbleBuilder;

public class Descrabble
{
    public static DescrabbleBuilder create() {
        return new DescrabbleBuilderImpl();
    }

}

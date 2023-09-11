package io.github.jwdeveloper.descrabble.framework.api;

import java.util.List;

public interface DescrabblePlugin
{
    String getPluginName();
    String getOutputFileName();
    DescrabbleElementRenderer getContainerElement();

    DescrabbleElementRenderer getImageRenderer();

    DescrabbleElementRenderer getVideoRenderer();

    DescrabbleElementRenderer getBreakLineRenderer();

    DescrabbleElementRenderer getCodeRenderer();

    DescrabbleElementRenderer getLinkRenderer();

    DescrabbleElementRenderer getListRenderer();

    DescrabbleElementRenderer getQuoteRenderer();

    DescrabbleElementRenderer getSpoilerRenderer();

    DescrabbleElementRenderer getTextRenderer();

    List<DescrabbleElementRenderer> getCustomRenderers();
}

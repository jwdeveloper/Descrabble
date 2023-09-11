package io.github.jwdeveloper.descrabble.plugin.spigot;


import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.DescrabblePlugin;
import io.github.jwdeveloper.descrabble.plugin.spigot.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Plugin implements DescrabblePlugin {
    @Override
    public String getPluginName() {
        return "spigot";
    }

    @Override
    public String getOutputFileName() {
        return "spigot.txt";
    }

    @Override
    public DescrabbleElementRenderer getContainerElement() {
        return new ContainerElement();
    }

    @Override
    public DescrabbleElementRenderer getImageRenderer() {
        return new ImageElement();
    }

    @Override
    public DescrabbleElementRenderer getVideoRenderer() {
        return new VideoElement();
    }

    @Override
    public DescrabbleElementRenderer getBreakLineRenderer() {
        return new BreakLineElement();
    }

    @Override
    public DescrabbleElementRenderer getCodeRenderer() {
        return new CodeElement();
    }

    @Override
    public DescrabbleElementRenderer getLinkRenderer() {
        return new LinkElement();
    }

    @Override
    public DescrabbleElementRenderer getListRenderer() {
        return new ListElement();
    }

    @Override
    public DescrabbleElementRenderer getQuoteRenderer() {
        return new QuoteElement();
    }

    @Override
    public DescrabbleElementRenderer getSpoilerRenderer() {
        return new SpoilerElement();
    }

    @Override
    public DescrabbleElementRenderer getTextRenderer() {
        return new TextElement();
    }

    @Override
    public List<DescrabbleElementRenderer> getCustomRenderers() {
        return new ArrayList<>();
    }
}

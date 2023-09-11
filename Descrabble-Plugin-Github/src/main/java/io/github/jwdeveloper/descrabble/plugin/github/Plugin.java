package io.github.jwdeveloper.descrabble.plugin.github;


import io.github.jwdeveloper.descrabble.framework.api.DescrabbleElementRenderer;
import io.github.jwdeveloper.descrabble.framework.api.DescrabblePlugin;
import io.github.jwdeveloper.descrabble.plugin.github.elements.*;
import io.github.jwdeveloper.descrabble.plugin.github.elements.html.ContainerElement;
import io.github.jwdeveloper.descrabble.plugin.github.elements.html.ImageElement;
import io.github.jwdeveloper.descrabble.plugin.github.elements.html.VideoElement;

import java.util.List;

public class Plugin implements DescrabblePlugin {
    @Override
    public String getPluginName() {
        return "github";
    }

    @Override
    public String getOutputFileName() {
        return "github.md";
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
        return List.of(new TitleElement());
    }


}

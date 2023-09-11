package io.github.jwdeveloper.descrabble.framework.api;

import io.github.jwdeveloper.descrabble.api.DescriptionDecorator;
import io.github.jwdeveloper.descrabble.api.DescriptionGenerator;
import io.github.jwdeveloper.descrabble.api.DescriptionRenderer;
import io.github.jwdeveloper.descrabble.api.DescriptionRendererBuilder;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.function.Consumer;

public interface DescrabbleBuilder {
    DescrabbleBuilder withTemplate(URI path);

    DescrabbleBuilder withTemplate(Path path);

    DescrabbleBuilder withTemplate(File file);

    DescrabbleBuilder withPlugin(DescrabblePlugin plugin);

    DescrabbleBuilder withDecorator(Consumer<DescriptionDecorator> onDecoration);

    DescrabbleBuilder withDecorator(DescriptionDecorator decorator);

    DescrabbleBuilder withRenderer(DescriptionRenderer renderer);

    DescrabbleBuilder withRenderer(Consumer<DescriptionRendererBuilder> onBuild);

    DescrabbleBuilder withVariable(String name, String value);

    DescriptionGenerator build();
}

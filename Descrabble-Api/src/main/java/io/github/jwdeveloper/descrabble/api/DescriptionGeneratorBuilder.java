package io.github.jwdeveloper.descrabble.api;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.function.Consumer;

public interface DescriptionGeneratorBuilder {
    DescriptionGeneratorBuilder withTemplate(URI path);
    DescriptionGeneratorBuilder withTemplate(Path path);
    DescriptionGeneratorBuilder withTemplate(File file);
    DescriptionGeneratorBuilder withDecorator(Consumer<DescriptionDecorator> onDecoration);
    DescriptionGeneratorBuilder withDecorator(DescriptionDecorator decorator);

    DescriptionGeneratorBuilder withRenderer(DescriptionRenderer renderer);

    DescriptionGeneratorBuilder withRenderer(Consumer<DescriptionRendererBuilder> onBuild);
    DescriptionGeneratorBuilder withVariable(String name, String value);
    DescriptionGenerator build();
}

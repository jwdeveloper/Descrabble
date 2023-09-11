package io.github.jwdeveloper.descrabble.api;

import java.nio.file.Path;
import java.util.Set;

public interface DescriptionGenerator
{
    Set<Path> generate(String outputPath);
}

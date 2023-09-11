package io.github.jwdeveloper.descrabble.plugin.github.elements.html;

import io.github.jwdeveloper.descrabble.api.TextBuilder;
import io.github.jwdeveloper.descrabble.api.elements.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoElement extends ImageElement {

    @Override
    public void onElementOpen(TextBuilder textBuilder, Element elementData) {

        if(elementData.hasProperty("image"))
        {
            super.onElementOpen(textBuilder, elementData);
            return;
        }

        String link = elementData.getProperty("open");
        if (!link.contains("youtube")) {
            textBuilder.text("Only youtube videos currently supported");
            return;
        }
        var id = getYouTubeId(link);
        var imageUrl = "https://img.youtube.com/vi/" + id + "/0.jpg";
        elementData.addProperty("image", imageUrl);
        super.onElementOpen(textBuilder, elementData);
    }

    private String getYouTubeId(String youTubeUrl) {
        String pattern = "(?<=youtu.be/|watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(youTubeUrl);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }
}

package io.github.jwdeveloper.descrabble.core.decorators;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;

public class FileFinder {
    public static Map<String, FileDto> listHtmlFiles(File file) {
        Map<String, FileDto> htmlFilesMap = new HashMap<>();


        if(file.getParent() == null)
        {
            return htmlFilesMap;
        }

        var directory = new File(file.getParent());
        if (directory == null || !directory.isDirectory()) {
            return htmlFilesMap;
        }

        // Create a FilenameFilter to filter out .html files
        FilenameFilter htmlFileFilter = (dir, name) -> {
            if (!name.toLowerCase().contains("template")) {
                return false;
            }
            return name.endsWith(".html");
        };

        // List all the .html files in the directory
        File[] htmlFiles = directory.listFiles(htmlFileFilter);

        if (htmlFiles == null || htmlFiles.length == 0) {
            return htmlFilesMap;
        }

        // Populate the map with file paths and File objects
        for (File htmlFile : htmlFiles) {
            if (htmlFile.getAbsolutePath().equals(file.getAbsolutePath())) {
                continue;
            }
            var dto = createFileDto(htmlFile);
            htmlFilesMap.put(dto.getName(), dto);
        }

        return htmlFilesMap;
    }


    private static FileDto createFileDto(File file) {
        var fileName = file.getName().replace(".html","");
        var path  = file.getAbsolutePath();
        return new FileDto(fileName, path, file);
    }

    @Data
    @AllArgsConstructor
    public static class FileDto {
        private String name;

        private String filePath;

        private File file;
    }
}

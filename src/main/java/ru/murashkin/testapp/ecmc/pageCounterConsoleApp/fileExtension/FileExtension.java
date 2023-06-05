package ru.murashkin.testapp.ecmc.pageCounterConsoleApp.fileExtension;

import java.util.HashMap;
import java.util.Map;

public enum FileExtension {

    DOC("doc"),
    DOCX("docx"),
    PDF("pdf"),
    RTF("rtf"),
    XML("xml");

    private final String extension;

    private static final Map<String, FileExtension> map;

    static {
        map = new HashMap<>();
        for (FileExtension fileExtension : FileExtension.values()) {
            map.put(fileExtension.extension, fileExtension);
        }
    }

    public static FileExtension findByExtension(String extension) {
        return map.get(extension);
    }

    FileExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}

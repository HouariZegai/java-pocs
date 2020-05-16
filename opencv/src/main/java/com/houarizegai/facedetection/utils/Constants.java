package main.java.com.houarizegai.facedetection.utils;

import java.nio.file.Paths;

public class Constants {
    public static final String RESOURCES_FOLDER;

    static {
        // Get relative path
        RESOURCES_FOLDER = new StringBuilder().append(Paths.get("").toAbsolutePath())
                .append("\\src\\main\\resources\\").toString();;
    }
}

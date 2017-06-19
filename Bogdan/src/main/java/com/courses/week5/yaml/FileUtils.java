package com.courses.week5.yaml;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class FileUtils {

    private static final ClassLoader CONTEXT_CLASS_LOADER = Thread.currentThread().getContextClassLoader();

    public static File readFileFromResources(String fileName) {
        if (StringUtils.isEmpty(fileName)) throw new IllegalArgumentException("fileName is not valid");
        URL resource = CONTEXT_CLASS_LOADER.getResource(fileName);
        Objects.requireNonNull(resource);
        return new File(resource.getFile());
    }
}
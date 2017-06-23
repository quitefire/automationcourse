package com.courses.week5.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlReader {

    private ObjectMapper mapper;

    public YamlReader() {
        this.mapper = new ObjectMapper(new YAMLFactory());
    }

    public <T> T toObject(final String fileName, Class<T> clazz) {
        File file = FileUtils.readFileFromResources(fileName);
        try {
            return mapper.readValue(file, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.courses.week5.yaml;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlReader {

    private ObjectMapper mapper;

    public YamlReader() {
        this.mapper = new ObjectMapper(new YAMLFactory());
        mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, false);
    }


    public <T> T toObject(final String fileName, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = FileUtils.readFileFromResources(fileName);
        try {
            return mapper.readValue(file, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

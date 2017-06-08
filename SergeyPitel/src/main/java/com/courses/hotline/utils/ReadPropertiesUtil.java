package com.courses.hotline.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertiesUtil {

    public static String getProperty(String key, String path) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(path)) {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}

package com.courses.week3.conciseapi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;

    static {
        try {
            ClassLoader classLoader = ConfigLoader.class.getClassLoader();
            URL resourceURL = classLoader.getResource("application.properties");
            if (resourceURL == null) {
                throw new RuntimeException("Can't find properties file in classpath tests suite may work wrong!!!");
            }
            File file = new File(resourceURL.getFile());
            properties = new Properties();
            properties.load(new FileInputStream(file));
            overrideWithSystemProperties();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void overrideWithSystemProperties() {
        Properties systemProperties = System.getProperties();

        for (Map.Entry entry : properties.entrySet()) {
            String key = String.valueOf(entry.getKey());
            if (systemProperties.containsKey(key)) {
                String value = systemProperties.getProperty(key);

                if (!value.isEmpty()) {
                    properties.setProperty(key, value);
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
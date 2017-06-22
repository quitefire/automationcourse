package com.demo.utils;

import ru.qatools.properties.PropertyLoader;

public class PropertiesLoader {
    private PropertiesLoader() {
    }

    private static final Configuration config = init();

    public static Configuration getConfig() {
        if (config != null) {
            return config;
        }
        return init();
    }

    private static Configuration init() {
        return PropertyLoader.newInstance()
                .populate(Configuration.class);
    }
}

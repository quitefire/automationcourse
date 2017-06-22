package com.courses.week5;

import com.courses.week3.conciseapi.utils.ConfigLoader;
import org.junit.Test;

import java.io.IOException;

public class PropertyProfilesTests {

    @Test
    public void testCanReadPropertiesFromCorrectFile() throws IOException {
        String appURL = ConfigLoader.getProperty("app.url");
        String browser = ConfigLoader.getProperty("browser");
        String env = ConfigLoader.getProperty("env");
        String myProperty = System.getProperty("my.property");
        String ciProperty = System.getProperty("ci.property");
        System.out.println("app.url = " + appURL);
        System.out.println("browser = " + browser);
        System.out.println("env = " + env);
        System.out.println("my.property = " + myProperty);
        System.out.println("ci.property = " + ciProperty);
    }
}

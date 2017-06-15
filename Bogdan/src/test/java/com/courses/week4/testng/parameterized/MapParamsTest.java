package com.courses.week4.testng.parameterized;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class MapParamsTest {

    @Test(dataProvider = "dbconfig")
    public void testConnection(Map<String, String> config) {
        config.forEach((k, v) -> System.out.println("key:" + k + " value:" + v));
    }

    @DataProvider(name = "dbconfig")
    public static Object[][] provideDbConfig() {
        Map<String, String> config1 = ImmutableMap.of("url", "http://192.168.2.100", "connectionPoolSize", "10");
        Map<String, String> config2 = ImmutableMap.of("url", "http://192.168.2.111", "connectionPoolSize", "3");
        return new Object[][]{
                {config1}, {config2}
        };
    }
}


package com.demo.fixtures;

import com.demo.utils.Configuration;
import com.demo.utils.PropertiesLoader;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;

import static com.demo.utils.WeatherAPIConstants.APPID;
import static com.demo.utils.WeatherAPIConstants.CURRENT_WEATHER_BASE_PATH;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

public class BaseTest {

    private static final Configuration config = PropertiesLoader.getConfig();

    @BeforeClass
    public static void setUp() throws Exception {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(config.getBaseURI())
                .setBasePath(CURRENT_WEATHER_BASE_PATH)
                .setContentType(JSON)
                .addParam(APPID, config.getApiKey())
                .log(ALL).build();
    }
}

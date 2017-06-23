package com.demo.api;

import com.demo.utils.Configuration;
import com.demo.utils.PropertiesLoader;
import com.google.common.collect.ImmutableMap;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static com.demo.utils.WeatherAPIConstants.*;
import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class WeatherApi {

    private static final Configuration config = PropertiesLoader.getConfig();
    private RequestSpecification spec;

    public WeatherApi() {
        spec = new RequestSpecBuilder()
                .setBaseUri(config.getRestEndpoint())
                .setBasePath(BASE_PATH)
                .setContentType(ContentType.JSON)
                .build();
    }


    private <T> T getWeatherBy(Class<T> type, Map<String, Object> params) {
        return given(spec).
                params(params).
                param(APPID, config.getApiKey()).
                when().
                get(EMPTY).
                then().
                extract().
                response().
                as(type);
    }

    public <T> T getWeatherByCity(String city, Class<T> type) {
        Map<String, Object> params = ImmutableMap.of(CITY, city);
        return getWeatherBy(type, params);
    }

    public <T> T getWeatherByZip(int code, Class<T> type) {
        Map<String, Object> params = ImmutableMap.of(ZIP_CODE, code);
        return getWeatherBy(type, params);
    }

    public <T> T getWeatherByCoordinates(int lat, int lon, Class<T> type) {
        Map<String, Object> params = ImmutableMap.of(LAT, lat, LON, lon);
        return getWeatherBy(type, params);
    }

    public <T> T getWeatherByCityAndCountryCode(String city, String countryCode, Class<T> type) {
        Map<String, Object> params = ImmutableMap.of(CITY, String.join(",", city, countryCode));
        return getWeatherBy(type, params);
    }
}

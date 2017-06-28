package com.demo;

import com.demo.api.WeatherApi;
import com.demo.fixtures.BaseTest;
import com.demo.listeners.LogListener;
import com.demo.model.ErrorResponse;
import com.demo.model.WeatherResponse;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.demo.enums.City.LDN;
import static com.demo.matchers.ErrorResponseAssert.assertThat;
import static com.demo.matchers.WeatherResponseAssert.assertThat;

@Listeners(LogListener.class)
public class WeatherTest extends BaseTest{

    private WeatherApi api = new WeatherApi();

    // tag::shouldGetWeatherByCity[]
    @Test
    public void shouldGetWeatherByCity() {
        String cityName = LDN.getCity();
        WeatherResponse weatherResponse = api.getWeatherByCity(cityName, WeatherResponse.class);
        assertThat(weatherResponse).hasName(cityName).hasCod(200);
        Assertions.assertThat(weatherResponse.getSys().getCountry()).isEqualTo(LDN.getCoutryCode());
    }
    // end::shouldGetWeatherByCity[]

    @Test
    // tag::shouldGetWeatherByCityAndCountryCode[]
    public void shouldGetWeatherByCityAndCountryCode() {
        String cityName = LDN.getCity();
        String code = LDN.getCoutryCode();
        WeatherResponse weatherResponse = api.getWeatherByCityAndCountryCode(cityName, code, WeatherResponse.class);
        assertThat(weatherResponse).hasName(cityName).hasCod(200);
        Assertions.assertThat(weatherResponse.getSys().getCountry()).isEqualTo(code);
    }
    // end::shouldGetWeatherByCityAndCountryCode[]

    // tag::shouldGetWeatherByZipCode[]
    @Test
    public void shouldGetWeatherByZipCode() {
        WeatherResponse weatherResponse = api.getWeatherByZip(94040, WeatherResponse.class);
        assertThat(weatherResponse).hasName("Mountain View")
                .hasCod(200);
    }
    // end::shouldGetWeatherByZipCode[]

    @Test
    public void shouldGetWeatherByCoordinates() {
        WeatherResponse weatherResponse = api.getWeatherByCoordinates(35, 139, WeatherResponse.class);
        assertThat(weatherResponse).hasName("Shuzenji")
                .hasCod(200);
    }

    @Test
    public void shouldNotGetNonExistingCity() {
        ErrorResponse errorResponse = api.getWeatherByCity("/", ErrorResponse.class);
        assertThat(errorResponse).hasMessage("city not found")
                .hasCod(404);
    }
}

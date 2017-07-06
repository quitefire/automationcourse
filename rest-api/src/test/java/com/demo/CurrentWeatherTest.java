package com.demo;

import com.demo.api.CurrentWeatherApi;
import com.demo.fixtures.BaseTest;
import com.demo.listeners.LogListener;
import com.demo.model.ErrorResponse;
import com.demo.model.WeatherResponse;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.demo.enums.City.LDN;
import static com.demo.matchers.ErrorResponseAssert.assertThat;
import static com.demo.matchers.WeatherResponseAssert.assertThat;
import static org.apache.http.HttpStatus.*;

@Features("Get current weather")
@Stories("story-1")
@Listeners(LogListener.class)
public class CurrentWeatherTest extends BaseTest {

    private CurrentWeatherApi api = new CurrentWeatherApi();

    // tag::shouldGetWeatherByCity[]
    @Test
    public void shouldGetWeatherByCity() {
        String cityName = LDN.getCity();
        WeatherResponse weatherResponse = api.getWeatherByCity(cityName, WeatherResponse.class);
        assertThat(weatherResponse).hasName(cityName).hasCod(SC_OK);
        Assertions.assertThat(weatherResponse.getSys().getCountry()).isEqualTo(LDN.getCoutryCode());
    }
    // end::shouldGetWeatherByCity[]

    @Test
    // tag::shouldGetWeatherByCityAndCountryCode[]
    public void shouldGetWeatherByCityAndCountryCode() {
        String cityName = LDN.getCity();
        String code = LDN.getCoutryCode();
        WeatherResponse weatherResponse = api.getWeatherByCityAndCountryCode(cityName, code, WeatherResponse.class);
        assertThat(weatherResponse).hasName(cityName).hasCod(SC_OK);
        Assertions.assertThat(weatherResponse.getSys().getCountry()).isEqualTo(code);
    }
    // end::shouldGetWeatherByCityAndCountryCode[]

    // tag::shouldGetWeatherByZipCode[]
    @Test
    public void shouldGetWeatherByZipCode() {
        WeatherResponse weatherResponse = api.getWeatherByZip(94040, WeatherResponse.class);
        assertThat(weatherResponse).hasName("Mountain View")
                .hasCod(SC_OK);
    }
    // end::shouldGetWeatherByZipCode[]

    @Test
    public void shouldGetWeatherByCoordinates() {
        WeatherResponse weatherResponse = api.getWeatherByCoordinates(35, 139, WeatherResponse.class);
        assertThat(weatherResponse).hasName("Shuzenji")
                .hasCod(SC_OK);
    }

    @Test
    public void shouldNotGetNonExistingCity() {
        ErrorResponse errorResponse = api.getWeatherByCity("/", ErrorResponse.class);
        assertThat(errorResponse).hasMessage("city not found")
                .hasCod(SC_NOT_FOUND);
    }
}

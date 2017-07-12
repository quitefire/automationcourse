package weather

import com.demo.model.WeatherResponse

import static com.demo.enums.City.LDN
import static org.apache.http.HttpStatus.SC_OK

class CurrentWeatherSpec extends BaseSpec {

    def "should get weather by city name"() {
        given:
        "city name is ${LDN.city}"
        def cityName = LDN.city
        when: "the request is sent"
        def weatherResponse = api.getWeatherByCity(cityName, WeatherResponse.class)
        then: "the response should contain correct city name , status code and country code"
        weatherResponse.name == cityName
        weatherResponse.cod == SC_OK
        weatherResponse.sys.country == LDN.coutryCode
    }
}

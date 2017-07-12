package weather

import com.demo.api.CurrentWeatherApi
import com.demo.utils.PropertiesLoader
import groovy.util.logging.Slf4j
import io.restassured.builder.RequestSpecBuilder
import spock.lang.Specification

import static com.demo.utils.WeatherAPIConstants.APPID
import static com.demo.utils.WeatherAPIConstants.CURRENT_WEATHER_BASE_PATH
import static io.restassured.RestAssured.requestSpecification
import static io.restassured.filter.log.LogDetail.ALL
import static io.restassured.http.ContentType.JSON

@Slf4j
class BaseSpec extends Specification {

    static def config = PropertiesLoader.getConfig();
    static def api

    def setupSpec() {
        api = new CurrentWeatherApi()
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(config.getBaseURI())
                .setBasePath(CURRENT_WEATHER_BASE_PATH)
                .setContentType(JSON)
                .addParam(APPID, config.getApiKey())
                .log(ALL).build()
    }
}

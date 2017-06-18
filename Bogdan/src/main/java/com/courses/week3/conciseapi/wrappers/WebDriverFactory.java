package com.courses.week3.conciseapi.wrappers;

import com.courses.week3.conciseapi.utils.ConfigLoader;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.courses.week3.conciseapi.utils.CoreConstants.CHROME;
import static com.courses.week3.conciseapi.utils.CoreConstants.FIREFOX;


public class WebDriverFactory {

    public static WebDriver getDriver() {
        final String browser = ConfigLoader.getProperty("browser");
        //  final String browser = System.getProperty("browser");

        if (StringUtils.isEmpty(browser)) {
            throw new IllegalStateException("'browser' property is missing!");
        }

        switch (browser) {
            //BrowserType.CHROME
            case CHROME:
                // ChromeDriverManager.getInstance().setup();
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                return new ChromeDriver(createChromeOptions());
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException(browser + " browser is not supported!");
        }
    }

    private static ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        return options;
    }


    public static WebDriver getDriverUsingIf(DesiredCapabilities desiredCapabilities) {
        if (desiredCapabilities == null) {
            throw new IllegalStateException("DesiredCapabilities are missing!");
        }

        final String browser = desiredCapabilities.getBrowserName();

        if (CHROME.equalsIgnoreCase(browser)) {
            return new ChromeDriver(desiredCapabilities);
        } else if (FIREFOX.equalsIgnoreCase(browser)) {
            return new FirefoxDriver(desiredCapabilities);
        } else if (browser.isEmpty()) {
            throw new IllegalStateException("'browser' capability is missing!");
        }

        throw new IllegalArgumentException(desiredCapabilities.getBrowserName() + " browser is not supported!");
    }
}

package com.courses.week3.conciseapi.wrappers;

import org.openqa.selenium.WebDriver;

import static com.courses.week3.conciseapi.utils.ScreenshotUtils.takeScreenshot;


public abstract class WebDriverProvider {

    private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return DRIVER_CONTAINER.get();
    }


    public static void setupDriver() {
        DRIVER_CONTAINER.set(WebDriverFactory.getDriver());
    }

    public static void cleanUp() {
        if (getDriver() != null) {
         //   takeScreenshot(getDriver());
            getDriver().quit();
            DRIVER_CONTAINER.remove();
        }
    }
}


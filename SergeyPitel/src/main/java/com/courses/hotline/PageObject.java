package com.courses.hotline;


import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


/**
 * Base class for all page objects
 */
public abstract class PageObject {

    private WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }
}

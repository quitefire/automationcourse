package com.courses.seleniumyahoo.pages;


import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Base class for all Page Objects
 */

public abstract class PageObject {

    private WebDriver driver;

    public PageObject(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}

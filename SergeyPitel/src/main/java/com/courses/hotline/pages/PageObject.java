package com.courses.hotline.pages;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


/**
 * Base class for all page objects
 */
public abstract class PageObject {

    protected Logger logger;

    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass().getSimpleName());
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void scrollPage(int px) {
        ((JavascriptExecutor) driver).executeScript("scroll(0," + px + ")");
    }
}

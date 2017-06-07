package com.courses.hotline.pages;


import static com.courses.hotline.utils.ProjectConstants.DEFAULT_DRIVER_WAIT_TIMEOUT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Base class for all page objects
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, DEFAULT_DRIVER_WAIT_TIMEOUT);
        PageFactory.initElements(driver, this);
    }
}

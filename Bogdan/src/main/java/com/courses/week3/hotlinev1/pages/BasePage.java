package com.courses.week3.hotlinev1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.courses.week3.hotlinev1.utils.CoreConstants.WAIT_TIMEOUT;

public abstract class BasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }
}

package com.courses.globalmoney.pagefactory.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static com.courses.globalmoney.utils.SiteConstants.WAIT_TIMEOUT;


public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIMEOUT), this);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}

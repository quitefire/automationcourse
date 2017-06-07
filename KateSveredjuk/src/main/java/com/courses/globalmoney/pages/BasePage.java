package com.courses.globalmoney.pages;


import com.courses.globalmoney.utils.SiteConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Катюша on 06.06.2017
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, SiteConstants.WAIT_TIMEOUT);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}

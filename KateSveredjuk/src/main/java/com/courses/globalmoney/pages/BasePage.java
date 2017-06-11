package com.courses.globalmoney.pages;


import com.courses.globalmoney.utils.SiteConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.courses.globalmoney.utils.SiteConstants.WAIT_TIMEOUT;

/**
 * Created by Катюша on 06.06.2017
 */
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

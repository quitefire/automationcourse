package automation.hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static automation.hotline.utils.Configuration.WAIT_TIMEOUT;

/**
 * Created by dtv on 05.06.2017.
 */

// class
//state - locators
// behaviour - methods

public abstract class BasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }
}


package automation.hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static automation.hotline.constants.CoreConstants.WAIT_TIMEOUT;


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
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        wait = new WebDriverWait(driver, 10);
    }
}


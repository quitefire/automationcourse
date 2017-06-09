package automation.hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by dtv on 05.06.2017.
 */
    public abstract class BasePage {

        protected WebDriver driver;
        protected Wait<WebDriver> wait;

        public BasePage(WebDriver driver) {
            this.driver = driver;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 20);
        }


        public Wait<WebDriver> getWait(){
            return wait;
        }

    }


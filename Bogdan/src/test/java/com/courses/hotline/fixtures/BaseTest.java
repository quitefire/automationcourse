package com.courses.hotline.fixtures;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.courses.week3.hotlinev1.utils.CoreConstants.WAIT_TIMEOUT;

public class BaseTest {

    protected static WebDriver driver;
    protected static Wait<WebDriver> wait;

    @Before
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }


    @After
    public void tearDownAll() throws Exception {
      //  driver.quit();
    }

}

package com.courses.hotline.fixtures;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.courses.week3.hotlinev1.utils.CoreConstants.WAIT_TIMEOUT;

public class BaseTest {

    protected static WebDriver driver;
    protected static Wait<WebDriver> wait;

    @BeforeClass
    public static void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }


    @AfterClass
    public static void tearDownAll() throws Exception {
        driver.quit();
    }

}

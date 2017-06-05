package com.courses.hotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Base class for all test suits
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}

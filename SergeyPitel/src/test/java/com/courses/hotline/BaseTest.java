package com.courses.hotline;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * Base class for all test suits
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    protected void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}

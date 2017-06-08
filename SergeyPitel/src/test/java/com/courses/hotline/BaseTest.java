package com.courses.hotline;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;


import static com.courses.hotline.utils.ProjectConstants.DEFAULT_DRIVER_WAIT_TIMEOUT;

/**
 * Base class for all test suits
 */
public class BaseTest {

    protected WebDriver driver;
    protected static Wait<WebDriver> wait;

    @BeforeClass
    protected void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, DEFAULT_DRIVER_WAIT_TIMEOUT);
        driver.manage().window().maximize();
    }

//    @AfterClass
//    protected void tearDown() {
//        driver.quit();
//    }
}

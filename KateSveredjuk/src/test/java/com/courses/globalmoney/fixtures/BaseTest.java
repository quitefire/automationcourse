package com.courses.globalmoney.fixtures;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setAll() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }


    @AfterClass
    public static void tearDown() {
       driver.quit();
    }
}

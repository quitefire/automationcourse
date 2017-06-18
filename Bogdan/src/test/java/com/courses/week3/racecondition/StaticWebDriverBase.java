package com.courses.week3.racecondition;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebDriverBase {

    private static WebDriver driver;

    @Before
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        // driver.quit();
    }

    static WebDriver getDriver() {
        return driver;
    }
}
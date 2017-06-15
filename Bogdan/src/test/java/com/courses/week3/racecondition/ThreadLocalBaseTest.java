package com.courses.week3.racecondition;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadLocalBaseTest {

    private static ThreadLocal<WebDriver> container = new ThreadLocal<>();

    @Before
    public void setDriver() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        container.set(driver);
    }

    protected WebDriver getDriver() {
        return container.get();
    }

    @After
    public void tearDownAll() throws Exception {
      //  getDriver().quit();
    }

}

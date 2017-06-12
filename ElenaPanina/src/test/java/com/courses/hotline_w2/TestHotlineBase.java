package com.courses.hotline_w2;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by elena on 07.06.17.
 */
public abstract class TestHotlineBase {

    public static WebDriver browser;
    public static WebDriverWait wait;
    String baseURL = "https://www.hotline.ua/";



    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/home/elena/courses/automationcourse/ElenaPanina/drivers/chromedriver");
        browser = new ChromeDriver();
        wait = new WebDriverWait(browser, 10);
        browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        browser.quit();
    }
}

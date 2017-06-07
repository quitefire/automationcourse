package com.courses.hotline.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Катюша on 06.06.2017
 */
public abstract class BasePage {

    private static WebDriver driver;
    private static Wait<WebDriver> wait;

    protected static final String URL = "http://62.149.16.47:8080/";

    public BasePage() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Катюша.Кот\\automationcourse\\KateSveredjuk\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


    }

    public static WebDriver getDriver() {
        return driver;
    }

}

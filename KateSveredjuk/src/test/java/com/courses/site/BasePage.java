package com.courses.site;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Катюша on 06.06.2017
 */
public abstract class BasePage {
    private static WebDriver browser;
    private static Wait<WebDriver> wait;
    String url = "http://62.149.16.47:8080/";
    public String getUrl() {
        return url;
    }
    public BasePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Катюша.Кот\\automationcourse\\KateSveredjuk\\drivers\\chromedriver.exe");
        browser = new ChromeDriver();
        wait = new WebDriverWait(browser, 10);
        browser.manage().window().maximize();
        browser.manage().deleteAllCookies();

    }

//      public WebDriver getBrowser() {
//        return browser;

//    }
}

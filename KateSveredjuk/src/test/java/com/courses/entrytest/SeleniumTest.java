package com.courses.entrytest;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumTest {

    private static WebDriver browser;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Катюша.Кот\\automationcourse\\KateSveredjuk\\drivers\\chromedriver.exe");
       // WebDriver browser = new ChromeDriver();
        browser = new ChromeDriver();
        wait = new WebDriverWait(browser, 10);
        browser.manage().window().maximize();
    }

    @Test
    public void testSearch() {
        String expected = "samsung galaxy s8 plus case";
        browser.get("https://www.amazon.com/");

        WebElement element = browser.findElement(By.cssSelector("#twotabsearchtextbox"));
        element.sendKeys("Samsung");
        By locator = By.cssSelector("#issDiv0");
        String firstSug = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        //      = browser.findElement(By.cssSelector("#issDiv0")).getText();
        Assert.assertEquals(expected, firstSug);

    }

    @AfterClass
    public static void tearDown() {
        browser.quit();
    }
}

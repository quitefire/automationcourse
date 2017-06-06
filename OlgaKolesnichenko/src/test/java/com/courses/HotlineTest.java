package com.courses;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 02/06/2017.
 */
public class HotlineTest {

    private static WebDriver browser;
    private static Wait<WebDriver> wait;

    //global precondition
    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/admin/automationcourse/OlgaKolesnichenko/src/test/java/com/courses/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-fullscreen");
        browser = new ChromeDriver(chromeOptions);
        browser.manage().deleteAllCookies();
        wait = new WebDriverWait(browser, 20);
    }

    @Test
    public void searchIphoneTest() throws Exception {
        int lowPrice = 3500;
        int highPrice = 5000;
        String searchRequest = "iphone";
        //go to hotline web site
        browser.get("http://hotline.ua/");
        //wait for search bar to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchbox")));
        //search bar element
        WebElement searchBar = browser.findElement(By.cssSelector("#searchbox"));
        //search for 'iphone'
        searchBar.sendKeys(searchRequest + Keys.ENTER);
        //wait for price range filter to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".group-gr-185")));
        //close statistic bar
        browser.findElement(By.cssSelector(".link-turn")).click();
        //price filter element
        WebElement priceFilter = browser.findElement(By.xpath("//a[.='3500-5000 грн.']"));
        //save number of results
        String numberOfResults = browser.findElement(By.xpath("//a[.='3500-5000 грн.']/parent::div")).getText().substring(15);
        //click on price filter '2500-3500 грн.'
        priceFilter.click();
        //wait for filter appears in "Вы выбрали" section
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-filters-selected-block]//a[.='3500-5000 грн.']")));
        //get all prices from the search result
        List<WebElement> prices = browser.findElements(By.cssSelector(".gd-price-sum div:nth-of-type(2) b"));
        //get low price and convert string to int
        List<Integer> values = new ArrayList<>();
        for (WebElement element : prices) {
            String[] priceRange = element.getText().split("-");
            int length = priceRange[0].length();
            values.add(Integer.parseInt(priceRange[0].replaceAll("\\s","").substring(0, length-2)));
        }
        //check that all the filtered results' prices are within the price range 3500-5000 грн.
        for (Integer el : values) {
            Assert.assertTrue(el >= lowPrice && el <= highPrice);
        }
        //check that number of results are the same as numbers shown next to price range
        Assert.assertEquals(numberOfResults, "(" + prices.size() + ")");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        browser.quit();
    }
}
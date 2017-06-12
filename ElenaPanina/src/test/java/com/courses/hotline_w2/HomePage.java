package com.courses.hotline_w2;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by elena on 07.06.17.
 */
public class HomePage extends TestHotlineBase {

    public static By searchFieldLocator = By.cssSelector("#searchbox");


    public HomePage(WebDriver browser) {
        browser.manage().window().maximize();
        browser.get(baseURL);
    }

    public static SearchResultsPage searchBy(String searchPhrase){
        WebElement element = browser.findElement(searchFieldLocator);
        element.sendKeys(searchPhrase + Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("tabs-link g_statistic")));


        return new SearchResultsPage(browser);

    }

}

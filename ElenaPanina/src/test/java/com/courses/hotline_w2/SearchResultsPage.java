package com.courses.hotline_w2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by elena on 07.06.17.
 */
public class SearchResultsPage extends TestHotlineBase {

    public SearchResultsPage(WebDriver browser) {
        this.browser = browser;
    }

    public static SearchResultsPage priceRange(int filterNum){
        WebElement element = browser.findElement(By.cssSelector(String.format("#filters > div.cell.group-gr-185.full-list div: nth-child(%filterNum)>a", filterNum)));
        ((JavascriptExecutor)browser).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return new SearchResultsPage(browser);
    }
}

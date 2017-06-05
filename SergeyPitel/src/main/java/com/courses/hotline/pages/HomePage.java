package com.courses.hotline.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represents Finance Home Page
 *
 * @see <a href="http://hotline.ua/"></a>
 */

public class HomePage extends PageObject {

    private static final String HOME_PAGE_URL = "http://hotline.ua/";

    @FindBy(id = "searchbox")
    private WebElement searchField;

    @FindBy(css = "div#live-search ul li a")
    private WebElement firstSearchResultItem;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(HOME_PAGE_URL);
        logger.info("Open Home Page");
        return this;
    }

    public SearchResultPage search(String query) {
        searchField.sendKeys(query);
        logger.info("Search for " + query);
        firstSearchResultItem.click();
        return new SearchResultPage(driver);
    }
}

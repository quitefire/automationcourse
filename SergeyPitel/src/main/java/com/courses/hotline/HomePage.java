package com.courses.hotline;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(css = "span.close-x")
    private WebElement btnClose;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.get(HOME_PAGE_URL);
    }

    public HomePage disablePopUp() {
        btnClose.click();
        return this;
    }

    public SearchResultPage search(String query) {
        searchField.sendKeys(query);
        firstSearchResultItem.click();
        return new SearchResultPage(getDriver());
    }
}

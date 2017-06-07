package com.courses.hotline.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.courses.hotline.utils.ProjectConstants.HOME_PAGE_URL;

/**
 * This class represents Finance Home Page
 *
 * @see <a href="http://hotline.ua/"></a>
 */

public class HomePage extends BasePage {

    @FindBy(id = "searchbox")
    private WebElement searchField;

    @FindBy(css = ".reg")
    private WebElement register;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public SearchResultPage searchFor(String query) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(query, Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public HomePage removeBottomToolbar() {
        WebElement toolbar = driver.findElement(By.cssSelector("a.hide"));
        if (toolbar.isDisplayed()) toolbar.click();
        return this;
    }

    public RegistrationPage register() {
        register.click();
        return new RegistrationPage(driver);
    }
}

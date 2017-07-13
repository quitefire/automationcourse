package com.courses.seleniumyahoo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents Finance Home Page
 *
 * @see <a href="https://finance.yahoo.com/"></a>
 */
public class FinanceHomePage extends PageObject {

    private static final String FINANCE_HOME_PAGE_URL = "https://finance.yahoo.com";

    @FindBy(name = "p")
    private WebElement search;

    public FinanceHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        getDriver().get(FINANCE_HOME_PAGE_URL);
    }

    public CompanySummaryPage search(String query) {
        search.sendKeys(query);
        search.submit();
        return new CompanySummaryPage(getDriver());
    }
}

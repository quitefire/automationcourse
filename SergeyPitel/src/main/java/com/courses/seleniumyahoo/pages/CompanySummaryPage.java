package com.courses.seleniumyahoo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents selected company summary page
 * for page example
 *
 * @see <a href="https://finance.yahoo.com/quote/MMM?p=MMM"></a>
 */
public class CompanySummaryPage extends PageObject {

    @FindBy(xpath = "//span[contains(text(), 'Financials')]")
    WebElement financialsTab;

    public CompanySummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CompanyFinancialsPage navigateToFinancialsTab() {
        financialsTab.click();
        return new CompanyFinancialsPage(getDriver());
    }
}

package com.courses.seleniumyahoo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents selected company financials page
 * for page example
 *
 * @see <a href="https://finance.yahoo.com/quote/MMM/financials?p=MMM></a>
 */
public class CompanyFinancialsPage extends PageObject {

    @FindBy(xpath = "//section[@id='quote-leaf-comp']//table/tbody//tr[2]/td[2]")
    private WebElement totalRevenue;

    public CompanyFinancialsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public double getTotalRevenue() throws NumberFormatException {
        String totalRevenueStr = totalRevenue.getText().replaceAll(",", "");
        return Double.parseDouble(totalRevenueStr);
    }
}

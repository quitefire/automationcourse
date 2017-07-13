package com.courses.seleniumyahoo;


import com.courses.seleniumyahoo.pages.CompanyFinancialsPage;
import com.courses.seleniumyahoo.pages.CompanySummaryPage;
import com.courses.seleniumyahoo.pages.FinanceHomePage;
import com.courses.seleniumyahoo.utils.TestDataUtil;
import org.junit.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class CompanyRevenueTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider
    public Object[][] testData() throws IOException {
        String str;
        str = TestDataUtil.readFromCvsFile("src/main/resources/company_stock_symbols.csv");
        return TestDataUtil.parseCompanyStockSymbols(str);
    }

    @Test(dataProvider = "testData")
    public void testTotalRevenue(String company, String revenue) {
        // Navigate to home page
        FinanceHomePage financeHomePage = new FinanceHomePage(driver);
        // Search for the company by company name
        CompanySummaryPage companySummaryPage = financeHomePage.search(company);
        // Navigate to financials tab
        CompanyFinancialsPage companyFinancialsPage = companySummaryPage.navigateToFinancialsTab();
        double currentNumber = Double.parseDouble(revenue);
        // Verify if expected company revenue is within 20% of total revenue from Yahoo finance
        Assert.assertTrue(currentNumber <= (companyFinancialsPage.getTotalRevenue() * 0.2));
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}

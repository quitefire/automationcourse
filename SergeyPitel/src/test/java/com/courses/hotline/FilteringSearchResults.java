package com.courses.hotline;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilteringSearchResults {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testFilterByPrice() {
        HomePage homePage = new HomePage(driver);
        homePage.disablePopUp();
        SearchResultPage searchResultPage = homePage.search("iphone");
        searchResultPage.selectPriceFilter(2);
    }

//    @AfterTest
//    public void tearDown() {
//        driver.close();
//    }
}

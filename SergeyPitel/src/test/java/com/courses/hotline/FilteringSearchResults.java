package com.courses.hotline;


import com.courses.hotline.pages.HomePage;
import com.courses.hotline.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


public class FilteringSearchResults {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFilterByPriceResultsAreInPriceRange() {
        // Navigate to home page
        HomePage homePage = new HomePage(driver);
        // Search for products
        SearchResultPage searchResultPage = homePage.search("iphone");
        searchResultPage.getAllPrices();
        List<Integer> lis = searchResultPage.getPanel(5).getCurrentPageProductPrices();
        System.out.println(lis.size());
        for (Integer i : lis){
            System.out.println(i);
        }
//        searchResultPage.print();



        // Select price filter
//        searchResultPage.selectPriceFilter(7);
//        List<WebElement> products = searchResultPage.getAllSearchResultProducts();


//        // Get all result list item prices
//        List<Integer> prices = searchResultPage.getResultListPrices();
        // Get selected filer price range
//        int[] priceRange = searchResultPage.getSelectedFilterPriceRange();
//        // Verify that all prices are in range of selected price range
//        assertThat(prices, everyItem(both(
//                greaterThanOrEqualTo(priceRange[0]))
//                .and(lessThanOrEqualTo(priceRange[1])))
//        );
    }

    @Test
    public void testFilterByPriceCorrectResultsAmount() {

    }

//    @AfterTest
//    public void tearDown() {
//        driver.close();
//    }
}

package com.courses.hotline;


import com.courses.hotline.pages.HomePage;
import com.courses.hotline.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;


public class FilteringSearchResults {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testFilterByPriceResultsAreInPriceRange() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        SearchResultPage searchResultPage = homePage.search("iphone");
        searchResultPage.priceFiltersPanel.clickFilter(6);
        int[] priceRange = searchResultPage.priceFiltersPanel.getSelectedFilterPriceRange();
        searchResultPage.fetchAllProducts();
        List<Integer> prices = searchResultPage.getAllProductsPrices();
        // Verify that all getAllProductsPrices are in range of selected price range
        assertThat(prices, everyItem(both(
                greaterThanOrEqualTo(priceRange[0]))
                .and(lessThanOrEqualTo(priceRange[1])))
        );
    }

    @Test
    public void testFilterByPriceCorrectResultsAmount() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        SearchResultPage searchResultPage = homePage.search("iphone");
        searchResultPage.priceFiltersPanel.clickFilter(6);
        int amount = searchResultPage.priceFiltersPanel.getSelectedFilterResultsAmount();
        searchResultPage.fetchAllProducts();
        Assert.assertEquals(searchResultPage.getSearchResultAmount(), amount);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}

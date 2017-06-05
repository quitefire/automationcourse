package com.courses.hotline;


import com.courses.hotline.pages.HomePage;
import com.courses.hotline.pages.SearchResultPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;


public class FilteringSearchResults extends BaseTest {

    @DataProvider
    public Object[][] getFiltersAmount() {
        return new Object[][]{
                new Object[]{0},
                new Object[]{1},
                new Object[]{2},
                new Object[]{3},
                new Object[]{4},
                new Object[]{5},
                new Object[]{6}
        };
    }

    @Test(dataProvider = "getFiltersAmount")
    public void testFilterByPriceResultsAreInPriceRange(int filter) {
        HomePage homePage = new HomePage(driver).open();

        SearchResultPage searchResultPage = homePage.search("iphone");

        searchResultPage.priceFiltersPanel.clickFilter(filter);

        int[] priceRange = searchResultPage.priceFiltersPanel.getSelectedFilterPriceRange();

        searchResultPage.fetchAllProducts();

        List<Integer> prices = searchResultPage.getAllProductsPrices();

        // Verify that all getAllProductsPrices are in range of selected price range
        assertThat(prices, everyItem(both(
                greaterThanOrEqualTo(priceRange[0]))
                .and(lessThanOrEqualTo(priceRange[1])))
        );
    }

    @Test(dataProvider = "getFiltersAmount")
    public void testFilterByPriceCorrectResultsAmount(int filter) {

        HomePage homePage = new HomePage(driver).open();

        SearchResultPage searchResultPage = homePage.search("iphone");

        searchResultPage.priceFiltersPanel.clickFilter(filter);

        int amount = searchResultPage.priceFiltersPanel.getSelectedFilterResultsAmount();

        searchResultPage.fetchAllProducts();

        Assert.assertEquals(searchResultPage.getSearchResultAmount(), amount);
    }
}

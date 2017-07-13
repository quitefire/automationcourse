package com.courses.hotline;


import com.courses.hotline.pages.HomePage;
import com.courses.hotline.utils.PriceRange;
import com.courses.hotline.pages.SearchResultPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;


public class FilterByPriceTest extends BaseTest {

    @DataProvider
    public Object[][] getFiltersAmount() {
        return new Object[][]{new Object[]{0}, new Object[]{5}};
    }

    @Test(dataProvider = "getFiltersAmount")
    public void testFilterByPriceResultsAreInPriceRange(int priceFilterIndex) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.removeBottomToolbar();
        SearchResultPage searchResultPage = homePage.searchFor("iphone");

        PriceRange priceRange = searchResultPage.selectPriceFilter(priceFilterIndex);
        List<Integer> prices = searchResultPage.getAllSearchResultsPrices();
        // Verify that all getAllProductsPrices are in range of selected price range
        assertThat(prices, everyItem(both(greaterThanOrEqualTo(priceRange.getMinPrice()))
                .and(lessThanOrEqualTo(priceRange.getMaxPrice())))
        );
    }

}

package com.courses.hotline_w2;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by elena on 07.06.17.
 */
public class TestHotlineMain extends TestHotlineBase {


    @Test
    public void testSearch() throws Exception {
        HomePage homePage = new HomePage(browser);
        String request = "iPhone";
        homePage.searchBy(request);
        assert browser.getTitle().contains(request);
    }

    @Test
    public void testPriceRange() throws Exception {
        testSearch();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.className("data-filter-item")));
        SearchResultsPage.priceRange(2);
    }

    @Test
    public void priceCounter() throws Exception {

    }
}

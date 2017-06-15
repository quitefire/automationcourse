package com.courses.week3;

import com.courses.week3.conciseapi.pages.HotlineMainPage;
import com.courses.week3.conciseapi.wrappers.WebDriverProvider;
import com.courses.week3.hotlinev1.enums.PriceRange;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HotLineTestWithWrapper {

    @Before
    public void setUp() {
        WebDriverProvider.setupDriver();
    }

    @Test
    public void checkIphonePricesWithinTheRange() throws Exception {

        PriceRange range = PriceRange.$2500_3500;

        HotlineMainPage hotlineMainPage = new HotlineMainPage();
        hotlineMainPage.openPage();
        List<Integer> prices = hotlineMainPage.
                searchFor("iphone").
                selectPriceRange(range).
                selectAllPrices();
        prices.forEach(System.out::println);
        prices.forEach(price -> assertTrue("Price is out of the range", price >= range.getMinPrice() && price <= range.getMaxPrice()));
    }

    @Test
    public void checkIphonePricesWithinTheRange1() throws Exception {

        PriceRange range = PriceRange.$2500_3500;

        HotlineMainPage hotlineMainPage = new HotlineMainPage();
        hotlineMainPage.openPage();
        List<Integer> prices = hotlineMainPage.
                searchFor("iphone").
                selectPriceRange(range).
                selectAllPrices();
        prices.forEach(System.out::println);
        prices.forEach(price -> assertTrue("Price is out of the range", price >= range.getMinPrice() && price <= range.getMaxPrice()));
    }

    @After
    public void tearDown() throws Exception {
        WebDriverProvider.cleanUp();
    }
}

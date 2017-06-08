package com.courses.hotline;

import com.courses.hotline.fixtures.BaseTest;
import com.courses.week3.hotlinev1.enums.PriceRange;
import com.courses.week3.hotlinev1.pages.HotlineMainPage;
import com.courses.week3.conciseapi.utils.ScreenshotUtils;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HotLineTest extends BaseTest {

    @Test
    public void checkIphonePricesWithinTheRange() throws Exception {

        PriceRange range = PriceRange.$2500_3500;

        List<Integer> prices = new HotlineMainPage(driver).
                openPage().
                searchFor("iphone").
                selectPriceRange(range).
                selectAllPrices();
        prices.forEach(System.out::println);
        prices.forEach(price -> assertTrue("Price is out of the range", price >= range.getMinPrice() && price <= range.getMaxPrice()));
    }

    @After
    public void tearDown() throws Exception {
        ScreenshotUtils.takeScreenshot(driver);
    }
}

package com.courses.week4.testng.parallel;

import com.courses.week3.conciseapi.pages.HotlineMainPage;
import com.courses.week3.hotlinev1.enums.PriceRange;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FirstTest {

  /*  @BeforeMethod
    public void setUp() {
        WebDriverProvider.setupDriver();
    }*/

    @Test
    public void test1(Method method) throws Exception {

        System.out.printf("Running test method : %s in test class=%s using thread = %s\n", method.getName(), getClass().getSimpleName(), Thread.currentThread().getId());

        PriceRange range = PriceRange.$2500_3500;

        HotlineMainPage hotlineMainPage = new HotlineMainPage();
        hotlineMainPage.openPage();
        List<Integer> prices = hotlineMainPage.
                searchFor("iphone").
                selectPriceRange(range).
                selectAllPrices();
        prices.forEach(System.out::println);
        prices.forEach(price -> assertTrue("Price is out of the range", price >= range.getMinPrice() && price <= 10_000));
    }


    @Test
    public void test2(Method method) throws Exception {

        System.out.printf("Running test method : %s in test class=%s using thread = %s\n", method.getName(), getClass().getSimpleName(), Thread.currentThread().getId());

        PriceRange range = PriceRange.$2500_3500;

        HotlineMainPage hotlineMainPage = new HotlineMainPage();
        hotlineMainPage.openPage();
        List<Integer> prices = hotlineMainPage.
                searchFor("iphone").
                selectPriceRange(range).
                selectAllPrices();
        prices.forEach(System.out::println);
        prices.forEach(price -> assertTrue("Price is out of the range", price >= range.getMinPrice() && price <= 10_000));
    }

/*    @AfterMethod
    public void tearDown() throws Exception {
        WebDriverProvider.cleanUp();
    }*/
}

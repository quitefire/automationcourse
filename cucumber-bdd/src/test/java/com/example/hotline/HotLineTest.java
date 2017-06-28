package com.example.hotline;

import com.example.enums.PriceRange;
import com.example.pages.HotLineMainPage;
import com.example.pages.HotLineResultPage;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.util.List;

import static com.example.Gherkin.*;
import static org.junit.Assert.assertTrue;

@Features("search feature")
@RunWith(DataProviderRunner.class)
public class HotLineTest extends BaseTest {

    @DataProvider
    public static Object[][] resultsPerProduct() {
        return new Object[][]
                {{"холодильник", 24},
                        {"смартфон", 25}};
    }


    @Test
    @Title("title")
    @Severity(value = SeverityLevel.CRITICAL)
    public void checkIphonePricesWithinTheRange() throws Exception {

        PriceRange range = PriceRange.$2500_3500;

        GIVEN("user is open hotline  ");

        HotLineMainPage.openPage();

        WHEN("user searches for iphones");

        HotLineMainPage.searchFor("iphone");
        HotLineResultPage.selectPriceRange(range);

        THEN("ASSERTION");

        List<Integer> prices = HotLineResultPage.selectAllPrices();
        System.out.println(prices.size());

        prices.forEach(price -> assertTrue("Price is out of the range",
                price >= range.getMinPrice() && price <= range.getMaxPrice()));
    }

    @Test
    @UseDataProvider("resultsPerProduct")
    public void checkNumberOfSearchResultsIsCorrect(String product, int resultsNum) throws Exception {

        HotLineMainPage.openPage();
        HotLineMainPage.searchFor(product);
        List<Integer> results = HotLineResultPage.selectAllPrices();
        System.out.println(results.size());
        System.out.println(resultsNum);
        assertTrue(results.size() == resultsNum);

    }
}
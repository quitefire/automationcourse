package automation.hotline;


import automation.hotline.enums.PriceRange;
import automation.hotline.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static automation.hotline.enums.PriceRange.*;


/**
 * Created by dtv on 05.06.2017.
 */
public class HotlinePriceRangeTest extends BaseTest {

    @DataProvider
    public Object[][] getPriceRangeData() {
        return new Object[][]{{$2500_3500}, {$3500_5000}};
    }

    @Test(dataProvider = "getPriceRangeData")
    public void testAllPricesWithinPriceRange(PriceRange priceRange) throws Exception {
        //   PriceRange priceRange = PriceRange.$2500_3500;

        HomePage homePage = new HomePage(driver);
        homePage.openPage();

        List<Integer> actualPrices = homePage.searchFor("iPhone")
                .selectPriceFilter(priceRange)
                .findPrices();

//        for (int price : actualPrices) {
//            Assert.assertTrue(priceRange.getMinPrice() <= price && price <= priceRange.getMaxPrice(),
//                    String.format("Price %s is out of range", price));
//        }
        actualPrices.forEach(price -> Assert.assertTrue(priceRange.getMinPrice() <= price && price <= priceRange.getMaxPrice(),
                String.format("Price %s is out of range", price)));

        //  boolean isAllMatch = actualPrices.stream().allMatch(price -> priceRange.getMinPrice() <= price && price <= priceRange.getMaxPrice());
    }
}

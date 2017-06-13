package automation.hotline;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


/**
 * Created by dtv on 05.06.2017.
 */
public class TestHotline {
    private WebDriver driver;
    private static Wait<WebDriver> wait;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "G:\\automationcourse\\PavelSeredyuk\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testHotline() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.fillSearchField("iPhone");
        SearchResultPage resultPage = homePage.getSearchResult();
        resultPage.closeBar();
        resultPage.selectPriceFilter(0);
        List<Integer> actualPrices = resultPage.findPrices();

        int[] priceRange = resultPage.getPriceRange();
        for (Integer price : actualPrices) {

            Assert.assertTrue(priceRange[0] <= price && price <= priceRange[1], "Test was failed on " + price.toString());

        }

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }
}

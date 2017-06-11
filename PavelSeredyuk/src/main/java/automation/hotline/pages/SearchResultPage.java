package automation.hotline.pages;

import automation.hotline.enums.PriceRange;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dtv on 05.06.2017.
 */
public class SearchResultPage extends BasePage {

//    private By priceId = By.cssSelector(".text-14.text-13-480.orng>b");
//    By modelId = By.cssSelector(".m_r-10>a");
//    By rangeId = By.cssSelector(".cell.group-gr-185.full-list  div.f-item>a");

    //private By products = By.cssSelector("cell gd-promo-brdr");

//
//    private List<Product> products = new ArrayList<>();
//
//    private String priceRange;

    public SearchResultPage(WebDriver driver) {
        super(driver);

    }

    //method for searching price range
    public SearchResultPage selectPriceFilter(PriceRange priceRange) {
        String formattedLocator = String.format("#filters > div.cell.group-gr-185.full-list > div > div:nth-child(%d) > a", priceRange.getIndex());
        By priceFilterLocator = By.cssSelector(formattedLocator);
        closeBar();
        driver.findElement(priceFilterLocator).click();
        return this;
    }

    //method for closing bottom bar
    private SearchResultPage closeBar() {
        WebElement bottorBar = driver.findElement(By.cssSelector(".link-turn.hide.g_statistic"));
        if (bottorBar.isDisplayed()) bottorBar.click();
        return this;
    }

    public List<Integer> findPrices() {

        List<Integer> prices = new ArrayList<>();

        List<WebElement> productElements = driver.findElements(
                By.cssSelector("div.gd-price-sum.inl-bot > div.text-14.text-13-480.orng"));

        for (WebElement item : productElements) {
            prices.add(NumberUtils.toInt(item.getText().replaceAll("[^0-9]", ""), 0));
        }
        return prices;
    }

}

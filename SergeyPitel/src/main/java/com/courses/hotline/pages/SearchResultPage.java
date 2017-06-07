package com.courses.hotline.pages;

import static com.courses.hotline.utils.TextUtils.parseInt;
import static com.courses.hotline.utils.TextUtils.parsePriceRange;

import com.courses.hotline.utils.PriceRange;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents Search Result Page
 *
 * @see <a href="http://hotline.ua/mobile/mobilnye-telefony-i-smartfony/294245/"></a>
 */
public class SearchResultPage extends BasePage {

    @FindBy(css = ".gd-price-sum div:nth-child(1)")
    private List<WebElement> productsPrices;

    @FindBy(css = ".cell.group-gr-185 .f-item a")
    private List<WebElement> priceFilters;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public PriceRange selectPriceFilter(int filterIndex) {
        wait.until(ExpectedConditions.visibilityOfAllElements(priceFilters));
        priceFilters.get(filterIndex).click();
        int[] priceRange = parsePriceRange(priceFilters.get(filterIndex).getText());
        return new PriceRange(priceRange[0], priceRange[1]);
    }

    public List<Integer> getAllSearchResultsPrices() {
        List<Integer> prices = new ArrayList<>();
        for (WebElement element : productsPrices) {
            prices.add(parseInt(element.getText()));
        }
        return prices;
    }
}

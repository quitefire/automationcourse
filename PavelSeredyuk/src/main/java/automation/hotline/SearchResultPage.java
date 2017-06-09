package automation.hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dtv on 05.06.2017.
 */
public class SearchResultPage extends BasePage {

    By priceId = By.cssSelector(".text-14.text-13-480.orng>b");
    By modelId = By.cssSelector(".m_r-10>a");
    By rangeId = By.cssSelector(".cell.group-gr-185.full-list  div.f-item>a");

    private List<Integer> prices = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    private String priceRange;

    public SearchResultPage(WebDriver driver) {
        super(driver);

    }

    //method for searching price range
    public SearchResultPage selectPriceFilter(int priceRangeIndex) {
        List<WebElement> rangeList = driver.findElements(rangeId);
        priceRange = rangeList.get(priceRangeIndex).getText();
        rangeList.get(priceRangeIndex).click();
        return this;
    }

    //method for parsing ranges and determining MAX and MIN value for comparing
    public int[] getPriceRange() {
        String[] maxMin = priceRange.replace(" грн.", "").split("-");
        int min = Integer.valueOf(maxMin[0]);
        int max = Integer.valueOf(maxMin[1]);
        return new int[]{min, max};

    }


    //method for closing bottom bar
    public SearchResultPage closeBar() {
        driver.findElement(By.cssSelector(".link-turn.hide.g_statistic")).click();
        return this;
    }

    public List<Integer> findPrices() {
        List<WebElement> iPhonePrice = driver.findElements(priceId);
        List<WebElement> iPhoneModel = driver.findElements(modelId);


        for (WebElement item : iPhonePrice) {
            prices.add(Integer.valueOf(item.getText().replaceAll("[^0-9]", "")));
        }

        return prices;
    }

}

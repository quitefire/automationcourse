package com.courses.hotline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents Finance Home Page
 *
 * @see <a href="http://hotline.ua/mobile/mobilnye-telefony-i-smartfony/294245/"></a>
 */
public class SearchResultPage extends PageObject {

    @FindBy(css = "div.cell.group-gr-185.full-list div a")
    private List<WebElement> priceFilters;

    @FindBy(xpath = "//div[@class='cell pager p_t-10 p_b-20']//span//a")
    private List<WebElement> nextResultsPageButtons;

    private List<SearchResultCenterPanel> resultsPages = new ArrayList<>();

    private List<Integer> allPrices = new ArrayList<>();

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage selectPriceFilter(int priceFilterPosition) {
        scrollPage(3150);
//        selectedPriceRange = TextUtils.parsePriceRange(priceFilters.get(priceFilterPosition).getText());
        if (priceFilterPosition <= priceFilters.size()) {
            priceFilters.get(priceFilterPosition).click();
        }
        return this;
    }

    public void getAllPrices() {
        SearchResultCenterPanel searchResultPanel = new SearchResultCenterPanel(driver);
        resultsPages.add(searchResultPanel);
        allPrices.addAll(searchResultPanel.getCurrentPageProductPrices());

        for (int i = 0; i < nextResultsPageButtons.size(); i++) {
            Actions actions = new Actions(driver);
            actions.moveToElement(nextResultsPageButtons.get(i)).build().perform();
//            scrollPage(4250);
            nextResultsPageButtons.get(i).click();
            searchResultPanel = new SearchResultCenterPanel(driver);
            resultsPages.add(searchResultPanel);

            allPrices.addAll(searchResultPanel.getCurrentPageProductPrices());
        }
    }

    public SearchResultCenterPanel getPanel(int num) {
        return resultsPages.get(num);
    }

    public void print() {
        for (Integer e : allPrices) {
            System.out.println(e);
        }
    }
}

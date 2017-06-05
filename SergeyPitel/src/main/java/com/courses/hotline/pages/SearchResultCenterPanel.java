package com.courses.hotline.pages;

import com.courses.hotline.utils.TextUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 6/5/17.
 */
public class SearchResultCenterPanel extends PageObject {

    @FindBy(xpath = "//div[@class='cell pager p_t-10 p_b-20']//span//a")
    private List<WebElement> nextResultsPageButtons;

    @FindBy(xpath = "//div[@class='gd-price-sum inl-bot']//div[1]/b")
    private List<WebElement> prices;

    public SearchResultCenterPanel(WebDriver driver) {
        super(driver);
    }

    public SearchResultCenterPanel getSearchResultPanel(int pageNum) {
        scrollPage(4150);
        nextResultsPageButtons.get(pageNum).click();
        return this;
    }

    public List<Integer> getCurrentPageProductPrices() {
        List<Integer> pr = new ArrayList<>();
        for(WebElement element : prices){
            pr.add(TextUtils.parseInt(element.getText()));
        }
        return pr;
    }
}

package com.courses.hotline;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * This class represents Finance Home Page
 *
 * @see <a href="http://hotline.ua/mobile/mobilnye-telefony-i-smartfony/294245/"></a>
 */
public class SearchResultPage extends PageObject {

    @FindBy(css = "div.cell.group-gr-185.full-list div")
    private List<WebElement> priceFilters;
    @FindBy(css = "div.cell.group-gr-185.full-list div div:first-child")
    private WebElement priceFilters1;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        ((JavascriptExecutor) driver).executeScript("scroll(0,2950);");
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage selectPriceFilter(int filterPosition) {
        priceFilters1.click();
////        System.out.println(priceFilters.get(filterPosition).getText());
//        if (filterPosition <= priceFilters.size()) {
//            priceFilters.get(filterPosition).click();
//        }
        return this;
    }
}

package com.courses.hotline.elements;


import com.courses.hotline.utils.TextUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PriceFiltersPanel {

    @FindBy(css = ".cell.group-gr-185.full-list div div a")
    private List<WebElement> priceFilters;

    @FindBy(css = ".cell.group-gr-185.full-list div div")
    private List<WebElement> filtersResultAmount;

    private int selectedFilter;
    private int[] selectedPriceRange;

    private WebDriver driver;

    public PriceFiltersPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getFiltersAmount() {
        return priceFilters.size();
    }

    public int getSelectedFilterResultsAmount() {
        return selectedFilter;
    }

    public int[] getSelectedFilterPriceRange() {
        return selectedPriceRange;
    }

    public void clickFilter(int filterIndex) {
        scrollPage(3250);
        selectedFilter = TextUtils.parseResultAmount(filtersResultAmount.get(filterIndex).getText());
        selectedPriceRange = TextUtils.parsePriceRange(priceFilters.get(filterIndex).getText());
        priceFilters.get(filterIndex).click();
    }

    public void scrollPage(int px) {
        ((JavascriptExecutor) driver).executeScript("scroll(0," + px + ")");
    }
}

package com.courses.hotline.elements;

import com.courses.hotline.utils.TextUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductsSearchResultPanel {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='cell pager p_t-10 p_b-20']//span//a")
    private List<WebElement> nextResultsPageButtons;

    @FindBy(xpath = "//div[@class='gd-price-sum inl-bot']//div[1]/b")
    private List<WebElement> prices;

    @FindBy(css = ".m_r-10")
    private List<WebElement> names;

    public ProductsSearchResultPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        scrollPage(4250);
        for (WebElement price : prices) {
            Product current = new Product(TextUtils.parseInt(price.getText()));
            products.add(current);
        }
        return products;
    }

    public void getNextSearchResultPage(int pageNumber) {
        scrollPage(4250);
        nextResultsPageButtons.get(pageNumber).click();
    }

    public void scrollPage(int px) {
        ((JavascriptExecutor) driver).executeScript("scroll(0," + px + ")");
    }

    public int getSearchResultPagesAmount() {
        return nextResultsPageButtons.size();
    }
}

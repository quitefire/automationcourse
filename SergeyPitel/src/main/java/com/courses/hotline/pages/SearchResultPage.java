package com.courses.hotline.pages;

import com.courses.hotline.elements.PriceFiltersPanel;
import com.courses.hotline.elements.Product;
import com.courses.hotline.elements.ProductsSearchResultPanel;
import com.courses.hotline.utils.TextUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents Search Result Page
 *
 * @see <a href="http://hotline.ua/mobile/mobilnye-telefony-i-smartfony/294245/"></a>
 */
public class SearchResultPage extends PageObject {

    public PriceFiltersPanel priceFiltersPanel;
    private List<Product> products = new ArrayList<>();

    public SearchResultPage(WebDriver driver) {
        super(driver);
        priceFiltersPanel = new PriceFiltersPanel(driver);
    }

    public List<Product> fetchAllProducts() {
        ProductsSearchResultPanel searchResultPanel = new ProductsSearchResultPanel(driver);
        products.addAll(searchResultPanel.getProducts());
        for (int i = 0; i < searchResultPanel.getSearchResultPagesAmount(); i++) {
            searchResultPanel.getNextSearchResultPage(i);
            products.addAll(searchResultPanel.getProducts());
        }
        return products;
    }

    public List<Integer> getAllProductsPrices() {
        List<Integer> prices = new ArrayList<>();
        for (Product product : products) {
            prices.add(product.getPrice());
        }
        return prices;
    }

    public int getSearchResultAmount() {
        return products.size();
    }
}

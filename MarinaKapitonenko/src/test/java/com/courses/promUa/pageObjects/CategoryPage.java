package com.courses.promUa.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;
import java.util.Comparator;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryPage {
	ElementsCollection products = $$("[data-qaid=product_block]");
	String categoryName;

	public CategoryPage(String categoryName) {
		this.categoryName = categoryName;
	}

	public void filterByPrice(PriceFilter price) {
		ElementsCollection options = $$(".x-filters").filterBy(text("Диапазон цен")).first().findAll(".x-filters-checkbox__text");

		switch (price){
			case MAX:
				options.last().click();
				break;
			case MIN:
				options.first().click();
		}
	}

	public void sortBy(SortOrder order) {
		switch (order){
			case PRICE_ASC:
				$("a[data-qaid=\"price\"]").click();
				break;
			case PRICE_DESC:
				$("a[data-qaid=\"-price\"]").click();
				break;
			case POPULARITY:
				throw new NotImplementedException();
		}
	}

	public void bookProduct(SelenideElement product){
		product.find(".x-gallery-tile__content").hover();
		product.find(".x-gallery-tile__extra").find("[data-qaid=\"buy-button\"]").click();
	}

	public void bookCheapProduct() {
		filterByPrice(CategoryPage.PriceFilter.MIN);
		sortBy(CategoryPage.SortOrder.PRICE_ASC);
		bookProduct(products.first());
	}

	public void bookExpensiveProduct() {
		filterByPrice(PriceFilter.MAX);
		sortBy(SortOrder.PRICE_DESC);

		SelenideElement product = products.stream()
				.filter(
						p -> p.find("span[itemprop=\"name\"]").getText().startsWith(categoryName)
				)
				.max(Comparator.comparing(p -> new BigDecimal(
						p.find(("div[data-qaid=\"price\"] > span")).getText().replace(",", ".")
				))).get();
		bookProduct(product);
	}

	public void resetFilters() {
		$(".x-filters-selected__delete").click();
	}


	public enum PriceFilter {
		MIN, MAX
	}

	public enum SortOrder {
		PRICE_ASC, PRICE_DESC, POPULARITY
	}
}

package com.courses.promUa.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Menu {

	private SelenideElement menuElement = $("[data-qaid=\"categories_menu\"]"),
			categoryElement = menuElement.find(".x-categories-menu__wrapper"),
			selectedCategory;

	public Menu category(String category) {
		menuElement.hover();
		categoryElement.find("[data-qaid=\"scroll_button\"]").click();
		selectedCategory = categoryElement.find(byText(category)).hover();
		return this;
	}

	public Menu subCategory(String subCategory) {
		selectedCategory = categoryElement.find(byText(subCategory)).hover();
		return this;
	}

	public void select() {
		selectedCategory.click();
	}
}

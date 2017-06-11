package com.courses.hotlineV2.pages;

import com.courses.hotlineV2.application.NavigationHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBox extends BasePage {

	@FindBy(id = "searchbox")
	private WebElement searchBox;

	public SearchBox(WebDriver driver, NavigationHelper helper) {
		super(driver, helper);
	}

	public SearchResultsPage search(String queryString) {
		searchBox.sendKeys(queryString, Keys.ENTER);
		return this.navigationHelper.getSearchResultsPage();

	}
}

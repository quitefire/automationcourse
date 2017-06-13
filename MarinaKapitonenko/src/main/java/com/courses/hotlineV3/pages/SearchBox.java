package com.courses.hotlineV3.pages;

import com.courses.hotlineV3.application.NavigationHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {

	private By searchBox = By.id("searchbox");

	public SearchBox(WebDriver driver, NavigationHelper helper) {
		super(driver, helper);
	}

	public SearchResultsPage search(String queryString) {
		findOne(searchBox).sendKeys(queryString, Keys.ENTER);
		return this.navigationHelper.getSearchResultsPage();

	}
}

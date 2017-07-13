package com.courses.hotlineV3.pages.pageElements;

import com.courses.hotlineV3.application.NavigationHelper;
import com.courses.hotlineV3.pages.BasePageObject;
import com.courses.hotlineV3.pages.SearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePageObject {

	private By searchBox = By.id("searchbox");

	public SearchBox(WebDriver driver, NavigationHelper helper) {
		super(driver, helper);
	}

	public SearchResultsPage search(String queryString) {
		findOne(searchBox).sendKeys(queryString, Keys.ENTER);
		return this.navigationHelper.getSearchResultsPage();

	}
}

package com.courses.hotlineFinal.pages.elements;

import com.courses.hotlineFinal.pages.BasePageObject;
import com.courses.hotlineFinal.pages.SearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePageObject {
	public SearchBox(WebDriver driver) {
		super(driver);
	}
	private By searchBox = By.id("searchbox");


	public SearchResultsPage search(String queryString) {
		findOne(searchBox).sendKeys(queryString, Keys.ENTER);
		return new SearchResultsPage(driver);

	}
}

package com.courses.hotlineV3.pages;

import com.courses.hotlineV3.application.NavigationHelper;
import org.openqa.selenium.WebDriver;

public class AnyPage extends BasePage {

	private String url;

	public AnyPage(String url, WebDriver driver, NavigationHelper helper) {
		super(driver, helper);
		this.url = url;
	}

	public AnyPage open() {
		driver.get(this.url);
		return this;
	}

	public SearchResultsPage searchFor(String queryString) {
		SearchBox searchBox = new SearchBox(driver, navigationHelper);
		return searchBox.search(queryString);
	}

	public SignUpPage signUpWith(String email, String username, String password) {
		LoginBox loginBox = new LoginBox(driver, navigationHelper);
		return loginBox.signUp(email, username, password);
	}
}

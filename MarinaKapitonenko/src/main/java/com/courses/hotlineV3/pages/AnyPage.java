package com.courses.hotlineV3.pages;

import com.courses.hotlineV3.application.NavigationHelper;
import com.courses.hotlineV3.pages.pageElements.LoginForm;
import com.courses.hotlineV3.pages.pageElements.LoginLinksBox;
import com.courses.hotlineV3.pages.pageElements.SearchBox;
import org.openqa.selenium.WebDriver;

public abstract class AnyPage extends BasePageObject {

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
		LoginLinksBox loginBox = new LoginLinksBox(driver, navigationHelper);
		return loginBox.signUp(email, username, password);
	}


	public LoginForm openLoginForm() {
		LoginLinksBox loginBox = new LoginLinksBox(driver, navigationHelper);
		return loginBox.openLoginForm();
	}

	public AnyPage seeUserIsLoggedIn(String username) {
		LoginLinksBox loginBox = new LoginLinksBox(driver, navigationHelper);
		return loginBox.seeUserIsLoggedIn(username, this);
	}
}

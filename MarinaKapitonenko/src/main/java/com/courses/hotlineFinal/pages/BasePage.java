package com.courses.hotlineFinal.pages;

import com.courses.hotlineFinal.pages.elements.LoginForm;
import com.courses.hotlineFinal.pages.elements.SearchBox;
import com.courses.hotlineFinal.pages.elements.UserBox;
import junitx.util.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends BasePageObject {

	public static String baseUrl = PropertyManager.getProperty("URL");

	protected String url;

	public BasePage(WebDriver driver) {
		super(driver);
	}


	public SearchResultsPage searchFor(String queryString) {
		SearchBox searchBox = new SearchBox(driver);
		return searchBox.search(queryString);
	}

	public LoginForm openLoginForm() {
		UserBox loginBox = new UserBox(driver);
		return loginBox.openLoginForm();
	}

	public boolean isUserLoggedInAs(String username) {
		UserBox loginBox = new UserBox(driver);
		return loginBox.getUsername().equals(username);

	}

	public SignUpPage openSignUpPage() {
		UserBox loginBox = new UserBox(driver);
		return loginBox.openSignUpPage();
	}

	public static String urlTo(String route){
		return baseUrl + route;
	}

	public String getUrl() {
		return urlTo(this.url);
	}

	public boolean isAt(){
		return driver.getCurrentUrl().equals(getUrl());
	}

	public void navigateTo(String linkText) {
		closeBottomBar();
		findOne(By.linkText(linkText)).click();
	}

	public void closeBottomBar(){
		try {
			findOne("a.hide").click();
		} catch (TimeoutException ignored){}
	}

	public BasePage open() {
		driver.get(getUrl());
		return this;
	}
}

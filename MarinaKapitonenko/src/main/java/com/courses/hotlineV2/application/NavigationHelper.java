package com.courses.hotlineV2.application;

import com.courses.hotlineV2.pages.AnyPage;
import com.courses.hotlineV2.pages.SearchResultsPage;
import com.courses.hotlineV2.pages.SignUpPage;

public class NavigationHelper {

	private String baseUrl;
	private ApplicationManager app;

	public NavigationHelper(ApplicationManager app) {
		this.app = app;
		this.baseUrl = "http://hotline.ua/";
	}

	public AnyPage openHomePage() {
		AnyPage home = new AnyPage(baseUrl, app.getDriver(), this);
		return home.open();
	}

	public SearchResultsPage getSearchResultsPage() {
		return new SearchResultsPage("sr", app.getDriver(),this);
	}

	public SignUpPage getSignUpPage() {
		return new SignUpPage("user/register", app.getDriver(),this);
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public ApplicationManager getApp() {
		return app;
	}
}

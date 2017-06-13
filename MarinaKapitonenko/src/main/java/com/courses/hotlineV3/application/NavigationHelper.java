package com.courses.hotlineV3.application;

import com.courses.hotlineV3.pages.AnyPage;
import com.courses.hotlineV3.pages.SearchResultsPage;
import com.courses.hotlineV3.pages.SignUpPage;
import junitx.util.PropertyManager;

public class NavigationHelper {

	private String baseUrl;
	private ApplicationManager app;

	public NavigationHelper(ApplicationManager app) {
		this.app = app;
		this.baseUrl = PropertyManager.getProperty("URL");
	}

	public AnyPage openHomePage() {
		AnyPage home = new AnyPage(baseUrl, app.getDriver(), this);
		return home.open();
	}

	public SearchResultsPage getSearchResultsPage() {
		return new SearchResultsPage(urlTo("sr"), app.getDriver(),this);
	}

	public SignUpPage getSignUpPage() {
		return new SignUpPage(urlTo("user/register"), app.getDriver(),this);
	}

	private String urlTo(String route){
		return this.baseUrl + "/" + route;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public ApplicationManager getApp() {
		return app;
	}
}

package com.courses.hotlineV3.pages;

import com.courses.hotlineV3.application.Base;
import com.courses.hotlineV3.application.NavigationHelper;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends Base {

	protected WebDriver driver;
	protected NavigationHelper navigationHelper;

	public BasePage(WebDriver driver, NavigationHelper helper) {
		this.driver = driver;
		this.navigationHelper = helper;
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

}

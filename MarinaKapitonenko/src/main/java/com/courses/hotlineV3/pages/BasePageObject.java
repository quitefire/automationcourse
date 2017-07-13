package com.courses.hotlineV3.pages;

import com.courses.hotlineV3.application.Base;
import com.courses.hotlineV3.application.NavigationHelper;
import org.openqa.selenium.WebDriver;

public abstract class BasePageObject extends Base {

	protected WebDriver driver;
	protected NavigationHelper navigationHelper;

	public BasePageObject(WebDriver driver, NavigationHelper helper) {
		this.driver = driver;
		this.navigationHelper = helper;
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

}

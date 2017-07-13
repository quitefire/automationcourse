package com.courses.hotlineV3.application;

import com.courses.hotlineV3.pages.AnyPage;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;


public class ApplicationManager {

	NavigationHelper navigationHelper;
	WebDriver driver;

	public ApplicationManager() {
		driver = DriverFactory.getDriver();
		this.navigationHelper = new NavigationHelper(this);
	}

	public AnyPage openHomePage() {
		return this.navigationHelper.openHomePage();
	}

	public NavigationHelper getNavigationHelper() {
		return navigationHelper;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void close() {
		WebDriverPool.DEFAULT.dismissAll();
	}
}

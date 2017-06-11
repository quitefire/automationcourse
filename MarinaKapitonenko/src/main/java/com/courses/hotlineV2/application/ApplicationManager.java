package com.courses.hotlineV2.application;

import com.courses.hotlineV2.pages.AnyPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ApplicationManager {

	NavigationHelper navigationHelper;
	WebDriver driver;

	public ApplicationManager() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
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

	public void close() {
		driver.quit();
	}
}

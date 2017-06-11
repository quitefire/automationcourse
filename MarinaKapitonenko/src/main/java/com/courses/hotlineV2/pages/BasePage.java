package com.courses.hotlineV2.pages;

import com.courses.hotlineV2.application.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;
	protected NavigationHelper navigationHelper;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver, NavigationHelper helper) {
		this.driver = driver;
		this.navigationHelper = helper;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);

	}

}

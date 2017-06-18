package com.courses.hotlineFinal.pages;

import com.courses.hotlineFinal.core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePageObject extends ConciseAPI{

	protected WebDriver driver;

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

	public BasePageObject(WebDriver driver){
		this.driver = driver;
	}


	protected boolean fieldHasError(By selector){
		return checkThat(ExpectedConditions.attributeContains(selector, "class", "errors"));
	}
}

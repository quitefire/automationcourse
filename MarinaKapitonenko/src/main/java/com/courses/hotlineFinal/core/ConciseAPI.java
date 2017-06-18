package com.courses.hotlineFinal.core;


import junitx.util.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

public abstract class ConciseAPI {

	public abstract WebDriver getWebDriver();

	protected WebElement findOne(By locator){
		return checkThat(Conditions.visible(locator));
	}

	protected WebElement findOne(String cssSelector){
		return findOne(By.cssSelector(cssSelector));
	}

	protected List<WebElement> findAll(By locator){
		return getWebDriver().findElements(locator);
	}

	protected List<WebElement> findAll(String cssSelector){
		return findAll(By.cssSelector(cssSelector));
	}

	protected <V> V waitUntil(Function<? super WebDriver, V> condition, int timeout){
		return (new WebDriverWait(getWebDriver(), timeout)).until(condition);
	}

	protected <V> V checkThat(Function<? super WebDriver, V> condition){
		int timeout = Integer.valueOf(PropertyManager.getProperty("TIMEOUT"));
		return waitUntil(condition, timeout);
	}
}

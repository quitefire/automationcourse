package com.courses.hotlineV3.application;

import com.google.common.base.Function;
import junitx.util.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class Base {

	public abstract WebDriver getWebDriver();

	protected WebElement findOne(By locator){
		return assertThat(Conditions.visible(locator));
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

	protected <V> V assertThat(Function<? super WebDriver, V> condition){
		int timeout = Integer.valueOf(PropertyManager.getProperty("TIMEOUT"));
		return waitUntil(condition, timeout);
	}
}

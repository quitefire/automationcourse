package com.courses.hotlineV3.pages;

import com.courses.hotlineV3.application.Conditions;
import com.courses.hotlineV3.application.NavigationHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class HomePage extends AnyPage {

	public HomePage(String url, WebDriver driver, NavigationHelper helper) {
		super(url, driver, helper);
	}
}

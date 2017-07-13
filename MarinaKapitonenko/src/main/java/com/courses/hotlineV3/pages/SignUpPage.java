package com.courses.hotlineV3.pages;

import com.courses.hotlineV3.application.Conditions;
import com.courses.hotlineV3.application.NavigationHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends AnyPage {

	private By emailInput = By.cssSelector("input[name='email']");
	private By usernameInput = By.cssSelector("input[name='nick']");
	private By passwordInput = By.cssSelector("input[name='password']");
	private By submitBtn = By.id("submit-button");
	private By confirmation = By.cssSelector(".page-final-reg");


	public SignUpPage(String url, WebDriver driver, NavigationHelper helper) {
		super(url, driver, helper);
	}

	public SignUpPage signUp(String email, String username, String password) {
		findOne(emailInput).sendKeys(email);
		findOne(usernameInput).sendKeys(username);
		findOne(passwordInput).sendKeys(password);
		findOne(submitBtn).click();
		return this;
	}

	public SignUpPage seeValidationErrors() {
		try {
			assertThat(Conditions.containsText(emailInput,"errors"));
			assertThat(Conditions.containsText(passwordInput,"errors"));
			assertThat(Conditions.containsText(usernameInput,"errors"));
			throw new NotFoundException("Can't find validation errors.");
		} catch (TimeoutException ignored){}
		return this;

	}

	public SignUpPage seeConfirmationMessage() {
		findOne(confirmation);
		return this;
	}
}

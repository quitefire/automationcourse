package com.courses.hotlineV2.pages;

import com.courses.hotlineV2.application.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends AnyPage {

	@FindBy(css = "input[name='email']")
	private WebElement emailInput;

	@FindBy(css = "input[name='nick']")
	private WebElement usernameInput;

	@FindBy(css = "input[name='password']")
	private WebElement passwordInput;

	@FindBy(id = "submit-button")
	private WebElement submitBtn;

	@FindBy(css = ".page-final-reg")
	private WebElement confirmation;

	public SignUpPage(String url, WebDriver driver, NavigationHelper helper) {
		super(url, driver, helper);
	}

	public SignUpPage signUp(String email, String username, String password) {
		emailInput.sendKeys(email);
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		submitBtn.click();
		return this;
	}

	public boolean hasValidationErrors() {
		String emailClass = emailInput.getAttribute("class");
		String usernameClass = usernameInput.getAttribute("class");
		String passwordClass = passwordInput.getAttribute("class");

		return
			emailClass.contains("errors") ||
			usernameClass.contains("errors") ||
			passwordClass.contains("errors");
	}

	public boolean hasConfirmationMessage() {
		return confirmation.isDisplayed();
	}
}

package com.courses.hotlineFinal.pages;

import org.openqa.selenium.*;

public class SignUpPage extends BasePage {

	private By emailInput = By.cssSelector("input[name='email']");
	private By usernameInput = By.cssSelector("input[name='nick']");
	private By passwordInput = By.cssSelector("input[name='password']");
	private By submitBtn = By.id("submit-button");
	private By confirmation = By.cssSelector(".page-final-reg");


	public SignUpPage(WebDriver driver) {
		super(driver);
		this.url = "/user/register/";
	}

	public SignUpPage signUpWith(String email, String username, String password) {
		findOne(emailInput).sendKeys(email);
		findOne(usernameInput).sendKeys(username);
		findOne(passwordInput).sendKeys(password);
		findOne(submitBtn).click();
		return this;
	}

	public boolean hasValidationErrors(){
		if (!driver.getCurrentUrl().equals(urlTo(this.url))){
			return false;
		}

		try {
			return fieldHasError(emailInput) || fieldHasError(passwordInput) || fieldHasError(usernameInput);
		} catch (TimeoutException ignored){}

		return false;
	}


	public WebElement getConfirmationMessage() {
		return findOne(confirmation);
	}

}

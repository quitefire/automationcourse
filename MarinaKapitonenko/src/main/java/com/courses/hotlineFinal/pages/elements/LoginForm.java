package com.courses.hotlineFinal.pages.elements;

import com.courses.hotlineFinal.core.WindowSwitcher;
import com.courses.hotlineFinal.pages.BasePageObject;
import org.openqa.selenium.*;

public class LoginForm extends BasePageObject {

	private By form = By.id("lightbox-form");
	private By googleLink = By.cssSelector("#lightbox-form a.gp img");
	private By emailField = By.cssSelector(".user-login-form input[name='login']");
	private By passField = By.cssSelector(".user-login-form input[name='password']");
	private By submitBtn = By.cssSelector(".user-login-form input[type='submit']");


	public LoginForm(WebDriver driver) {
		super(driver);
	}

	public LoginForm loginWith(AccountType type, String email, String pass){

		switch (type){
			case GOOGLE:
				fillOutGoogleForm(email, pass);
				break;
			case EMAIL:
				fillOutEmailForm(email, pass);
		}
		return this;
	}

	private void fillOutEmailForm(String email, String pass){
		findOne(emailField).sendKeys(email);
		findOne(passField).sendKeys(pass);
		findOne(submitBtn).click();
	}


	private void fillOutGoogleForm(String email, String pass){
		WebElement link = findOne(googleLink);
		link.click();

		String preTitle = driver.getTitle();
		WindowSwitcher.getHandleToWindow("Вход&nbsp;– Google Аккаунты", driver);

		WebElement emailField = findOne("#identifierId");
		emailField.sendKeys(email, Keys.ENTER);

		WebElement passField = findOne("#password input");
		passField.sendKeys(pass, Keys.ENTER);

		WindowSwitcher.getHandleToWindow(preTitle, driver);
	}

	public boolean hasValidationErrors(){
		try {
			findOne(form);
			return fieldHasError(emailField) || fieldHasError(passField);
		} catch (TimeoutException ignored){}
		return false;

	}

	public enum AccountType {
		GOOGLE,
		EMAIL
	}
}

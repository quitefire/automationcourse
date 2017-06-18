package com.courses.hotlineV3.pages.pageElements;

import com.courses.hotlineV3.application.Conditions;
import com.courses.hotlineV3.application.NavigationHelper;
import com.courses.hotlineV3.application.WindowSwitcher;
import com.courses.hotlineV3.pages.AnyPage;
import com.courses.hotlineV3.pages.BasePageObject;
import com.courses.hotlineV3.pages.SignUpPage;
import org.openqa.selenium.*;

public class LoginForm extends BasePageObject {

	private By googleLink = By.cssSelector("#lightbox-form a.gp img");
	private By emailField = By.cssSelector(".user-login-form input[name='login']");
	private By passField = By.cssSelector(".user-login-form input[name='password']");
	private By submitBtn = By.cssSelector(".user-login-form input[type='submit']");


	public LoginForm(WebDriver driver, NavigationHelper helper) {
		super(driver, helper);
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

	public AnyPage seeUserIsLoggedIn(String username) {
		return navigationHelper.getHomePage().seeUserIsLoggedIn(username);
	}

	public LoginForm seeValidationErrors() {
		try {
			assertThat(Conditions.containsText(emailField,"errors"));
			assertThat(Conditions.containsText(passField,"errors"));
			throw new NotFoundException("Can't find validation errors.");
		} catch (TimeoutException ignored){}
		return this;
	}


	public enum AccountType {
		GOOGLE,
		EMAIL
	}
}

package com.courses.hotlineV3.pages;

import com.courses.hotlineV3.application.NavigationHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBox extends BasePage {

	private By signUpLink = By.cssSelector(".reg");

	public LoginBox(WebDriver driver, NavigationHelper navigationHelper) {
		super(driver, navigationHelper);
	}

	public SignUpPage signUp(String email, String username, String password) {
		findOne(signUpLink).click();
		SignUpPage page = navigationHelper.getSignUpPage();
		return page.signUp(email, username, password);

	}
}

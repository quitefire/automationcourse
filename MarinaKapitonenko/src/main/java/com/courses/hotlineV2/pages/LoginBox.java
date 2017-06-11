package com.courses.hotlineV2.pages;

import com.courses.hotlineV2.application.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginBox extends BasePage{

	@FindBy(css = ".login")
	private WebElement box;

	@FindBy(css = ".reg")
	private WebElement signUpLink;

	@FindBy(css = ".open-lightbox")
	private WebElement loginLink;

	public LoginBox(WebDriver driver, NavigationHelper navigationHelper) {
		super(driver, navigationHelper);
	}

	public SignUpPage signUp(String email, String username, String password) {
		signUpLink.click();
		SignUpPage page = navigationHelper.getSignUpPage();
		return page.signUp(email, username, password);

	}
}

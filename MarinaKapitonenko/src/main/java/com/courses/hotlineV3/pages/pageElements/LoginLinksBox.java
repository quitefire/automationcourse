package com.courses.hotlineV3.pages.pageElements;

import com.courses.hotlineV3.application.Conditions;
import com.courses.hotlineV3.application.NavigationHelper;
import com.courses.hotlineV3.pages.AnyPage;
import com.courses.hotlineV3.pages.BasePageObject;
import com.courses.hotlineV3.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLinksBox extends BasePageObject {

	private By signUpLink = By.cssSelector(".reg");
	private By loginLink = By.cssSelector(".open-lightbox>b");
	private By userMenuLink = By.cssSelector("#open-user-menu > span");


	public LoginLinksBox(WebDriver driver, NavigationHelper navigationHelper) {
		super(driver, navigationHelper);
	}

	public SignUpPage signUp(String email, String username, String password) {
		findOne(signUpLink).click();
		SignUpPage page = navigationHelper.getSignUpPage();
		return page.signUp(email, username, password);
	}

	public LoginForm openLoginForm() {
		findOne(loginLink).click();
		return new LoginForm(driver, navigationHelper);
	}

	public AnyPage seeUserIsLoggedIn(String username, AnyPage page) {
		assertThat(Conditions.containsText(userMenuLink, username));
		return page;
	}
}

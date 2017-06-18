package com.courses.hotlineFinal.pages.elements;


import com.courses.hotlineFinal.pages.BasePageObject;
import com.courses.hotlineFinal.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserBox extends BasePageObject {

	private By signUpLink = By.cssSelector(".reg");
	private By loginLink = By.cssSelector(".open-lightbox>b");
	private By userMenuLink = By.cssSelector("#open-user-menu > span");


	public UserBox(WebDriver driver) {
		super(driver);
	}

	public LoginForm openLoginForm() {
		findOne(loginLink).click();
		return new LoginForm(driver);
	}

	public String getUsername(){
		return findOne(userMenuLink).getText();
	}

	public SignUpPage openSignUpPage() {
		findOne(signUpLink).click();
		return new SignUpPage(driver);
	}
}

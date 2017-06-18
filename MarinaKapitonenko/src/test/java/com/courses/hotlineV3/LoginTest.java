package com.courses.hotlineV3;

import com.courses.hotlineV3.pages.pageElements.LoginForm;
import org.junit.Test;

public class LoginTest extends BaseTest{

	@Test
	public void loginWithGoogleAccountSuccessfully() {

		app.openHomePage()
				.openLoginForm()
				.loginWith(LoginForm.AccountType.GOOGLE, "juchka.sirko@gmail.com", "juchka.sirko@")
				.seeUserIsLoggedIn("Juchka Sirko");
	}

	@Test
	public void loginWithEmailSuccessfully() {

		app.openHomePage()
				.openLoginForm()
				.loginWith(LoginForm.AccountType.EMAIL, "juchka.sirko@gmail.com", "juchka.sirko@")
				.seeUserIsLoggedIn("Juchka Sirko");
	}

	@Test
	public void loginWithInvalidEmail() {

		app.openHomePage()
				.openLoginForm()
				.loginWith(LoginForm.AccountType.EMAIL, faker.internet().emailAddress(), faker.internet().password())
				.seeValidationErrors();
	}
}

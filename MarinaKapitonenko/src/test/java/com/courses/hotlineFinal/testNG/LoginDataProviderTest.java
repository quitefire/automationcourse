package com.courses.hotlineFinal.testNG;

import com.courses.hotlineFinal.pages.HomePage;
import com.courses.hotlineFinal.pages.elements.LoginForm;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginDataProviderTest extends BaseTest {


	@DataProvider(name = "userInfoDataProvider")
	public Object[][] createData() {
		return new Object[][] {
				{ "juchka.sirko@gmail.com", "juchka.sirko@", "Juchka Sirko"}
		};
	}

	@Test(dataProvider = "userInfoDataProvider")
	public void loginWithGoogleAccountSuccessfully(String email, String pass, String fullName) {

		HomePage home = new HomePage(driver);
		home.open()
				.openLoginForm()
				.loginWith(LoginForm.AccountType.GOOGLE, email, pass);
		assertThat(home.isUserLoggedInAs(fullName), is(true));

	}

	@Test(dataProvider = "userInfoDataProvider")
	public void loginWithEmailSuccessfully(String email, String pass, String fullName) {

		// preconditions: add user to DB

		HomePage home = new HomePage(driver);
		LoginForm form = home.open()
				.openLoginForm()
				.loginWith(LoginForm.AccountType.EMAIL, email, pass);
		assertThat(form.hasValidationErrors(), is(false));
		assertThat(home.isUserLoggedInAs(fullName), is(true));

	}

	@Test
	public void loginWithInvalidEmail() {

		HomePage home = new HomePage(driver);
		LoginForm form = home.open()
				.openLoginForm()
				.loginWith(LoginForm.AccountType.EMAIL, faker.internet().emailAddress(), faker.internet().emailAddress());
		assertThat(form.hasValidationErrors(), is(true));
	}
}

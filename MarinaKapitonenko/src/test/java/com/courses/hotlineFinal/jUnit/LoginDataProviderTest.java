package com.courses.hotlineFinal.jUnit;


import com.courses.hotlineFinal.pages.HomePage;
import com.courses.hotlineFinal.pages.elements.LoginForm;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(DataProviderRunner.class)
public class LoginDataProviderTest extends BaseTest {

	@DataProvider
	public static Object[][] userInfoDataProvider() {
		return new Object[][]{
				{ "juchka.sirko@gmail.com", "juchka.sirko@", "Juchka Sirko"}
		};
	}


	@Test
	@UseDataProvider("userInfoDataProvider")
	public void loginWithGoogleAccountSuccessfully(String email, String pass, String fullName) {

		HomePage home = new HomePage(driver);
		home.open()
				.openLoginForm()
				.loginWith(LoginForm.AccountType.GOOGLE, email, pass);
		assertThat(home.isUserLoggedInAs(fullName), is(true));

	}


	@Test
	@UseDataProvider("userInfoDataProvider")
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

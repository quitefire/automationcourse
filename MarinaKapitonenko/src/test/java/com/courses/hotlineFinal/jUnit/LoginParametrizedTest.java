package com.courses.hotlineFinal.jUnit;


import com.courses.hotlineFinal.pages.HomePage;
import com.courses.hotlineFinal.pages.elements.LoginForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class LoginParametrizedTest extends BaseTest {

	@Parameterized.Parameters(name = "{index}: user({2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ "juchka.sirko@gmail.com", "juchka.sirko@", "Juchka Sirko"}
		});
	}

	@Parameterized.Parameter
	public String email;

	@Parameterized.Parameter(1)
	public String pass;

	@Parameterized.Parameter(2)
	public String fullName;


	@Test
	public void loginWithGoogleAccountSuccessfully() {

		HomePage home = new HomePage(driver);
		home.open()
				.openLoginForm()
				.loginWith(LoginForm.AccountType.GOOGLE, email, pass);
		assertThat(home.isUserLoggedInAs(fullName), is(true));

	}


	@Test
	public void loginWithEmailSuccessfully() {

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

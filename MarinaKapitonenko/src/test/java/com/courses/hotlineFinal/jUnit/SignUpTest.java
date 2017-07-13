package com.courses.hotlineFinal.jUnit;


import com.courses.hotlineFinal.pages.HomePage;
import com.courses.hotlineFinal.pages.SignUpPage;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SignUpTest extends BaseTest {

	@Category(TestTypes.SanityTests.class)
	@Test
	public void signUpWithInvalidEmail() {

		HomePage home = new HomePage(driver);
		SignUpPage signUpPage = home.open()
				.openSignUpPage()
				.signUpWith(faker.internet().domainName(), faker.name().username(), faker.internet().password());

		assertThat(signUpPage.hasValidationErrors(), is(true));
	}

	@Category({TestTypes.RegressionTests.class, TestTypes.SanityTests.class})
	@Test
	public void signUpSuccessfully() {

		HomePage home = new HomePage(driver);
		SignUpPage signUpPage = home.open()
				.openSignUpPage()
				.signUpWith(faker.internet().emailAddress(), faker.name().username(), faker.internet().password());

		assertThat(signUpPage.getConfirmationMessage(), is(notNullValue()));

	}

	@Category(TestTypes.RegressionTests.class)
	@Test
	public void signUpAlreadyRegisteredUser() {

		// preconditions: add user to DB

		HomePage home = new HomePage(driver);
		SignUpPage signUpPage = home.open()
				.openSignUpPage()
				.signUpWith("juchka.sirko@gmail.com", "Juchka Sirko","juchka.sirko@");

		assertThat(signUpPage.hasValidationErrors(), is(true));

	}
}

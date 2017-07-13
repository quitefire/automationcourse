package com.courses.hotlineV2;

import com.courses.hotlineV2.pages.SignUpPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignUpTest extends BaseTest{

	@Test
	public void signUpWithInvalidEmail() {

		SignUpPage result = app.openHomePage()
				.signUpWith(faker.internet().domainName(), faker.name().username(), faker.internet().password());

		assertTrue(result.hasValidationErrors());
	}

	@Test
	public void signUpSuccessfully() {

		SignUpPage result = app.openHomePage()
				.signUpWith(faker.internet().emailAddress(), faker.name().username(), faker.internet().password());

		assertTrue(result.hasConfirmationMessage());
	}

	@Test
	public void signUpAlreadyRegisteredUser() {

		String email = faker.internet().emailAddress();

		String username = faker.name().username();
		String password = faker.internet().password();
		SignUpPage result = app.openHomePage()
				.signUpWith(email, username, password);

		assertTrue(result.hasConfirmationMessage());

		result = app.openHomePage()
				.signUpWith(email, username, password);

		assertTrue(result.hasValidationErrors());


	}
}

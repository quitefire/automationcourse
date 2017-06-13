package com.courses.hotlineV3;

import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

	@Test
	public void signUpWithInvalidEmail() {

		app.openHomePage()
				.signUpWith(faker.internet().domainName(), faker.name().username(), faker.internet().password())
				.seeValidationErrors();
	}

	@Test
	public void signUpSuccessfully() {

		app.openHomePage()
				.signUpWith(faker.internet().emailAddress(), faker.name().username(), faker.internet().password())
				.seeConfirmationMessage();
	}

	@Test
	public void signUpAlreadyRegisteredUser() {

		String email = faker.internet().emailAddress();
		String username = faker.name().username();
		String password = faker.internet().password();

		app.openHomePage()
				.signUpWith(email, username, password)
				.seeConfirmationMessage();

		app.openHomePage()
				.signUpWith(email, username, password)
				.seeValidationErrors();
	}
}

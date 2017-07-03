package com.courses.promUa.pageObjects;

import com.courses.promUa.models.User;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

	public void registerAs(User user) {
		$("[data-qaid=\"name\"]").setValue(user.getUsername());
		$("[data-qaid=\"email\"]").setValue(user.getEmail());
		$("[data-qaid=\"password\"]").setValue(user.getPassword());
		$("[data-qaid=\"submit\"]").click();
	}

	public enum UserType{
		CUSTOMER, COMPANY
	}
}

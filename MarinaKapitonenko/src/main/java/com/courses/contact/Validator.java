package com.courses.contact;

import sun.security.validator.ValidatorException;

public class Validator {

	public static boolean isPhoneNumberValid(String phoneNumber) throws ValidatorException {
		String regex = "\\(\\d{3}\\) \\d{3}-\\d{2}-\\d{2}";
		if (!phoneNumber.matches(regex)) {
			throw new ValidatorException("Phone Number must be in format (###) ###-##-##");
		}
		return true;
	}
}

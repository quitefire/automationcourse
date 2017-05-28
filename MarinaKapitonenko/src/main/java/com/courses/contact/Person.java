package com.courses.contact;

import sun.security.validator.ValidatorException;

import java.util.List;

public class Person {
	private String mFirstName;
	private String mLastName;
	private String mPhoneNumber;

	public Person(String firstName, String lastName, String phoneNumber) {
		mFirstName = firstName;
		mLastName = lastName;
		mPhoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public String getPhoneNumber() {
		return mPhoneNumber;
	}

	public String getFullName(){
		return mFirstName + " " + mLastName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber){
		mPhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return  getFullName() + ": " + mPhoneNumber;
	}

	public static String getInfo(List<Person> list){
		StringBuilder sb = new StringBuilder();
		for (Person person : list) {
			sb.append(person);
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}


	public static boolean isPhoneNumberValid(String phoneNumber) throws ValidatorException {
		String regex = "\\(\\d{3}\\) \\d{3}-\\d{2}-\\d{2}";
		if (!phoneNumber.matches(regex)) {
			throw new ValidatorException("Phone Number must be in format (###) ###-##-##");
		}
		return true;
	}


}

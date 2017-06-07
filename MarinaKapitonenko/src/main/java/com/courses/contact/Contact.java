package com.courses.contact;

import java.util.Objects;

public class Contact implements Comparable<Contact>{
	private String mFirstName;
	private String mLastName;
	private String mPhoneNumber;

	public Contact(String firstName, String lastName, String phoneNumber) {
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

	public boolean hasOperatorNumber(Operator operator){
		if (mPhoneNumber == null) return false;

		String[] codes = operator.getCodes();
		for (String code : codes){
			if (mPhoneNumber.startsWith("(" + code)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) return true;
		if (!(o instanceof Contact)) {
			return false;
		}
		Contact contact = (Contact) o;
		return  this.mPhoneNumber.equals(contact.mPhoneNumber) &&
				this.mFirstName.equals(contact.mFirstName) &&
				this.mLastName.equals(contact.mLastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mFirstName, mLastName, mPhoneNumber);
	}

	@Override
	public int compareTo(Contact o) {
		return getFullName().compareTo(o.getFullName());
	}
}

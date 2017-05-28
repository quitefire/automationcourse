package com.courses.contact;

import java.util.*;

class ContactController {

	private List<Person> mContacts;

	public ContactController() {
		mContacts = new ArrayList<>();
	}

	public ContactController(List<Person> personList) {
		mContacts = personList;
	}

	public List<Person> getContacts() {
		return mContacts;
	}

	public List<Person> getContacts(int length, int start){
		List<Person> contacts = new ArrayList<>();
		if (start < 0){
			for (int i = (mContacts.size() + start); i > (length + start); i--){
				contacts.add(mContacts.get(i));
			}
		} else {
			for (int i = start; i < length; i++){
				contacts.add(mContacts.get(i));
			}
		}

		return contacts;
	}

	public int addContact(Person person) {
		mContacts.add(person);
		return mContacts.size() - 1;
	}


	public boolean removeLast() {
		if (mContacts != null && !mContacts.isEmpty()) {
			mContacts.remove(mContacts.size()-1);
			return true;
		}
		return false;
	}

	public boolean removeContact(Person contact) {
		return mContacts.remove(contact);
	}


	public List<Person> findContact(String name) {
		List<Person> wanted = new ArrayList<>();
		for (Person c : mContacts) {
			if (c.getFullName() != null && c.getFullName().contains(name)){
				wanted.add(c);
			}
		}
		return wanted;
	}


	public void updateContactInfo(Person contact, Map<String, String> personInfo) {
		contact.setFirstName(personInfo.get("firstName"));
		contact.setLastName(personInfo.get("lastName"));
		contact.setPhoneNumber(personInfo.get("phoneNumber"));
	}

	public String showAllContacts() {
		return Person.getInfo(mContacts);
	}


	public String showContacts(int length, int start) {
		return Person.getInfo(getContacts(length, start));
	}


	public String showLifeContacts() {
		return Person.getInfo(getContactsByOperator(Operator.LIFE));
	}

	public String showKiyvstarContacts() {
		return Person.getInfo(getContactsByOperator(Operator.KIEVSTAR));
	}

	public List<Person> getContactsByOperator(Operator operator){
		List<Person> contacts = new ArrayList<>();
		for (Person c : mContacts) {
			String[] codes = operator.getCodes();
			for (String code : codes){
				if (c.getPhoneNumber() != null && c.getPhoneNumber().contains(code)){
					contacts.add(c);
				}
			}
		}
		return contacts;
	}


}

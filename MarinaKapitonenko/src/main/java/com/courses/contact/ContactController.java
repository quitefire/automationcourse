package com.courses.contact;

import java.util.*;

class ContactController {

	public static final int FILTER_LIFE = 1;
	public static final int FILTER_KIEVSTAR = 2;

	public static final int SORT_FIRST_NEW = 1;
	public static final int SORT_FIRST_OLD = 2;

	private List<Contact> mContacts;

	public ContactController() {
		mContacts = new ArrayList<>();
	}

	public ContactController(List<Contact> contactList) {
		mContacts = contactList;
	}

	public List<Contact> getContacts() {
		return mContacts;
	}

	public boolean addContact(Contact contact) {
		return contact != null && mContacts.add(contact);

	}

	public boolean removeLast() {
		if (mContacts != null && !mContacts.isEmpty()) {
			mContacts.remove(mContacts.size()-1);
			return true;
		}
		return false;
	}

	public boolean removeContact(Contact contact) {
		return mContacts.remove(contact);
	}

	public List<Contact> findContact(String name) {
		List<Contact> wanted = new ArrayList<>();
		for (Contact c : mContacts) {
			if (c.getFullName() != null && c.getFullName().contains(name)){
				wanted.add(c);
			}
		}
		return wanted;
	}

	public void updateContactInfo(int index, Contact info) {
		Contact contact = mContacts.get(index);

		contact.setFirstName(info.getFirstName());
		contact.setLastName(info.getLastName());
		contact.setPhoneNumber(info.getPhoneNumber());
	}

	public String showList(){
		return showList(0,0,0);
	}

	public String showList(int sortOrder, int listSize, int filter){
		List<Contact> list = sortContacts(sortOrder);
		return ContactView.listView(filterContacts(filter, list, listSize));
	}

	private List<Contact> sortContacts(int sortOrder) {
		if (sortOrder == SORT_FIRST_NEW) Collections.reverse(mContacts);
		return mContacts;

/*		List<Contact> list = mContacts;
		if (sortOrder == SORT_FIRST_NEW) {
			list = new ArrayList<>(mContacts);
			Collections.reverse(list);
		}
		return list;*/
	}

	private List<Contact> filterContacts(int filter, List<Contact> list, int listSize) {
		List<Contact> filtered;
		switch (filter){
			case FILTER_LIFE:
				filtered = getContactsByOperator(Operator.LIFE, list);
				break;
			case FILTER_KIEVSTAR:
				filtered = getContactsByOperator(Operator.KIEVSTAR, list);
				break;
			default:
				filtered = mContacts;
		}
		if (listSize > filtered.size() || listSize == 0){
			listSize = filtered.size();
		}
		return filtered.subList(0, listSize);
	}

	private List<Contact> getContactsByOperator(Operator operator, List<Contact> list){
		List<Contact> contacts = new ArrayList<>();
		for (Contact c : list) {
			if (c.hasOperatorNumber(operator)){
				contacts.add(c);
			}
		}
		return contacts;
	}
}

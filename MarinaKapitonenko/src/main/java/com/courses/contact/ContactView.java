package com.courses.contact;

import java.util.List;

public class ContactView {

	public static String listView(List<Contact> list){

		StringBuilder sb = new StringBuilder();
		sb.append("Contacts:");
		sb.append(System.getProperty("line.separator"));

		for (Contact contact : list) {
			sb.append(contact);
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
}

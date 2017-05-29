package com.courses.contact;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.security.validator.ValidatorException;

import java.util.*;

public class ContactControllerTest {

	private Faker mFaker;
	private ContactController mController;

	@Before
	public void setUp() throws Exception {
		mFaker = new Faker(new Locale("uk"));
		mController = new ContactController();
	}

	@Test
	public void addContact(){

		String firstName = mFaker.name().firstName();
		String lastName = mFaker.name().lastName();
		String phoneNumber = mFaker.phoneNumber().cellPhone();

		Contact contact = new Contact(firstName, lastName, phoneNumber);
		mController.addContact(contact);

		List contacts = mController.getContacts();

		Assert.assertTrue(contacts.contains(contact));
		Assert.assertEquals(1, contacts.size());
	}

	@Test
	public void removeLastContact(){
		Contact contact1 = getFixture();
		Contact contact2 = getFixture();

		mController.addContact(contact1);
		mController.addContact(contact2);
		List contacts = mController.getContacts();
		Assert.assertEquals(2, contacts.size());

		Assert.assertTrue(mController.removeLast());
		Assert.assertEquals(1, contacts.size());
		Assert.assertTrue(contacts.contains(contact1));
		Assert.assertFalse(contacts.contains(contact2));
	}

	@Test
	public void findByFirstName(){

		Contact contact = getFixture();
		mController.addContact(contact);

		List<Contact> wanted =  mController.findContact(contact.getFirstName());
		Assert.assertEquals(1, wanted.size());
	}

	@Test
	public void findByLastName(){

		Contact contact = getFixture();
		mController.addContact(contact);

		List<Contact> wanted =  mController.findContact(contact.getLastName());
		Assert.assertFalse(wanted.isEmpty());
		Assert.assertEquals(1, wanted.size());
	}

	@Test
	public void findByFullName(){

		Contact contact = getFixture();
		mController.addContact(contact);

		List<Contact> wanted =  mController.findContact(contact.getFullName());
		Assert.assertFalse(wanted.isEmpty());
		Assert.assertEquals(1, wanted.size());
	}

	@Test
	public void findByNotExistingName(){
		Contact contact = getFixture();
		mController.addContact(contact);

		List<Contact> wanted =  mController.findContact(mFaker.name().firstName());
		Assert.assertTrue(wanted.isEmpty());
	}

	@Test
	public void removeContact(){
		Contact contact = getFixture();
		mController.addContact(contact);

		List contacts = mController.getContacts();
		Assert.assertTrue(contacts.contains(contact));

		Assert.assertTrue(mController.removeContact(contact));
		Assert.assertFalse(contacts.contains(contact));
	}

	@Test
	public void updateContact(){
		Contact contact = getFixture();
		mController.addContact(contact);

		int index = mController.getContacts().indexOf(contact);

		String firstName = contact.getFirstName();
		String lastName = mFaker.name().lastName();
		String phoneNumber = mFaker.phoneNumber().cellPhone();

		Contact updated = new Contact(firstName, lastName, phoneNumber);

		mController.updateContactInfo(index, updated);
		Assert.assertEquals(firstName, contact.getFirstName());
		Assert.assertEquals(lastName, contact.getLastName());
		Assert.assertEquals(phoneNumber, contact.getPhoneNumber());
	}

	@Test
	public void showAllContacts(){
		List<Contact> contactList = getFixtures(3);
		ContactController controller = new ContactController(contactList);

		List contacts = controller.getContacts();
		Assert.assertEquals(3, contacts.size());

		String personsInfo = ContactView.listView(contactList);
		Assert.assertEquals(personsInfo, controller.showList());
	}

	@Test
	public void showFirstFiveContacts(){
		int size = 10;
		List<Contact> contactList = getFixtures(size);
		ContactController controller = new ContactController(contactList);

		List contacts = controller.getContacts();
		Assert.assertEquals(10, contacts.size());

		int length = 5;
		List<Contact> five = new ArrayList<>();
		for (int i = 0; i < length; i++){
			five.add(contactList.get(i));
		}
		String personsInfo = ContactView.listView(five);
		Assert.assertEquals(personsInfo, controller.showList(ContactController.SORT_FIRST_OLD, 5,0));
	}

	@Test
	public void showLastFiveContacts(){
		int size = 10;
		List<Contact> contactList = getFixtures(size);
		ContactController controller = new ContactController(contactList);

		List contacts = controller.getContacts();
		Assert.assertEquals(10, contacts.size());

		int length = 5;
		List<Contact> five = new ArrayList<>();
		for (int i = size - 1; i > length - 1; i--){
			five.add(contactList.get(i));
		}
		String personsInfo = ContactView.listView(five);
		Assert.assertEquals(personsInfo, controller.showList(ContactController.SORT_FIRST_NEW, 5,0));
	}

	@Test
	public void showLifeContacts(){
		Contact lifeContact1 = getFixture();
		lifeContact1.setPhoneNumber("(063) 555-55-55");

		Contact lifeContact2 = getFixture();
		lifeContact2.setPhoneNumber("(073) 555-55-55");

		Contact kievstarContact = getFixture();
		kievstarContact.setPhoneNumber("(067) 063-55-55");

		mController.addContact(lifeContact1);
		mController.addContact(lifeContact2);
		mController.addContact(kievstarContact);


		List<Contact> contactList = new ArrayList<>();
		contactList.add(lifeContact1);
		contactList.add(lifeContact2);

		String personsInfo = ContactView.listView(contactList);
		Assert.assertEquals(personsInfo, mController.showList(0,0, ContactController.FILTER_LIFE));
	}

	@Test
	public void showKiyvstarContacts(){
		Contact lifeContact1 = getFixture();
		lifeContact1.setPhoneNumber("(063) 555-55-55");

		Contact lifeContact2 = getFixture();
		lifeContact2.setPhoneNumber("(073) 555-55-55");

		Contact kievstarContact = getFixture();
		kievstarContact.setPhoneNumber("(067) 555-55-55");

		mController.addContact(lifeContact1);
		mController.addContact(lifeContact2);
		mController.addContact(kievstarContact);

		List<Contact> contactList = new ArrayList<>();
		contactList.add(kievstarContact);

		String personsInfo = ContactView.listView(contactList);
		Assert.assertEquals(personsInfo, mController.showList(0,0, ContactController.FILTER_KIEVSTAR));
	}

	@Test
	public void phoneNumberValidationValidNumber() throws ValidatorException {
		String number = "(055) 555-55-55";
		Validator.isPhoneNumberValid(number);
	}

	@Test(expected = ValidatorException.class)
	public void phoneNumberValidationInvalidNumber() throws ValidatorException {

		String number = "555-555-55-55";
		Validator.isPhoneNumberValid(number);
	}

	private Contact getFixture(){
		String firstName = mFaker.name().firstName();
		String lastName = mFaker.name().lastName();
		String phoneNumber = mFaker.phoneNumber().cellPhone();

		return new Contact(firstName, lastName, phoneNumber);
	}


	private List<Contact> getFixtures(int size){
		List<Contact> fixtures = new ArrayList<>();
		for (int i = 0; i < size; i++){
			fixtures.add(new Contact(mFaker.name().firstName(), mFaker.name().lastName(), mFaker.phoneNumber().cellPhone()));
		}
		return fixtures;
	}

}
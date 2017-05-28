package com.courses.contact;

import com.github.javafaker.Faker;
import org.junit.After;
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

		Person contact = new Person(firstName, lastName, phoneNumber);
		mController.addContact(contact);

		List contacts = mController.getContacts();

		Assert.assertTrue(contacts.contains(contact));

	}

	@Test
	public void removeLastContact(){
		Person contact1 = getPersonFixture();
		Person contact2 = getPersonFixture();

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

		Person contact = getPersonFixture();
		mController.addContact(contact);

		List<Person> wanted =  mController.findContact(contact.getFirstName());
		Assert.assertEquals(1, wanted.size());
	}

	@Test
	public void findByLastName(){

		Person contact = getPersonFixture();
		mController.addContact(contact);

		List<Person> wanted =  mController.findContact(contact.getLastName());
		Assert.assertFalse(wanted.isEmpty());
		Assert.assertEquals(1, wanted.size());
	}

	@Test
	public void findByFullName(){

		Person contact = getPersonFixture();
		mController.addContact(contact);

		List<Person> wanted =  mController.findContact(contact.getFullName());
		Assert.assertFalse(wanted.isEmpty());
		Assert.assertEquals(1, wanted.size());
	}

	@Test
	public void findByNotExistingName(){
		Person contact = getPersonFixture();
		mController.addContact(contact);

		List<Person> wanted =  mController.findContact(mFaker.name().firstName());
		Assert.assertTrue(wanted.isEmpty());
	}

	@Test
	public void removeContact(){
		Person contact = getPersonFixture();
		mController.addContact(contact);

		List contacts = mController.getContacts();
		Assert.assertTrue(contacts.contains(contact));

		Assert.assertTrue(mController.removeContact(contact));
		Assert.assertFalse(contacts.contains(contact));
	}

	@Test
	public void updateContact(){
		Person contact = getPersonFixture();
		mController.addContact(contact);

		Map<String,String> info = getPersonInfo();

		mController.updateContactInfo(contact, info);
		Assert.assertEquals(info.get("firstName"), contact.getFirstName());
		Assert.assertEquals(info.get("lastName"), contact.getLastName());
		Assert.assertEquals(info.get("phoneNumber"), contact.getPhoneNumber());
	}

	@Test
	public void showAllContacts(){
		List<Person> personList = getPersonFixtures(3);
		ContactController controller = new ContactController(personList);

		List contacts = controller.getContacts();
		Assert.assertEquals(3, contacts.size());

		String personsInfo = Person.getInfo(personList);
		Assert.assertEquals(personsInfo, controller.showAllContacts());


	}
	@Test
	public void showFirstFiveContacts(){
		int size = 10;
		List<Person> personList = getPersonFixtures(size);
		ContactController controller = new ContactController(personList);

		List contacts = controller.getContacts();
		Assert.assertEquals(10, contacts.size());

		int length = 5;
		List<Person> five = new ArrayList<>();
		for (int i = 0; i < length; i++){
			five.add(personList.get(i));
		}
		String personsInfo = Person.getInfo(five);
		Assert.assertEquals(personsInfo, controller.showContacts(length, 0));
	}

	@Test
	public void showLastFiveContacts(){
		int size = 10;
		List<Person> personList = getPersonFixtures(size);
		ContactController controller = new ContactController(personList);

		List contacts = controller.getContacts();
		Assert.assertEquals(10, contacts.size());

		int length = 5;
		List<Person> five = new ArrayList<>();
		for (int i = size - 1; i > length - 1; i--){
			five.add(personList.get(i));
		}
		String personsInfo = Person.getInfo(five);
		Assert.assertEquals(personsInfo, controller.showContacts(length, -1));
	}

	@Test
	public void showLifeContacts(){
		Person lifeContact1 = getPersonFixture();
		lifeContact1.setPhoneNumber("(063) 555-55-55");

		Person lifeContact2 = getPersonFixture();
		lifeContact2.setPhoneNumber("(073) 555-55-55");

		Person kievstarContact = getPersonFixture();
		kievstarContact.setPhoneNumber("(067) 555-55-55");

		mController.addContact(lifeContact1);
		mController.addContact(lifeContact2);
		mController.addContact(kievstarContact);

		Assert.assertEquals(2, mController.getContactsByOperator(Operator.LIFE).size());

		List<Person> personList = new ArrayList<>();
		personList.add(lifeContact1);
		personList.add(lifeContact2);

		String personsInfo = Person.getInfo(personList);
		Assert.assertEquals(personsInfo, mController.showLifeContacts());
	}

	@Test
	public void showKiyvstarContacts(){
		Person lifeContact1 = getPersonFixture();
		lifeContact1.setPhoneNumber("(063) 555-55-55");

		Person lifeContact2 = getPersonFixture();
		lifeContact2.setPhoneNumber("(073) 555-55-55");

		Person kievstarContact = getPersonFixture();
		kievstarContact.setPhoneNumber("(067) 555-55-55");

		mController.addContact(lifeContact1);
		mController.addContact(lifeContact2);
		mController.addContact(kievstarContact);

		List<Person> personList = new ArrayList<>();
		personList.add(kievstarContact);

		String personsInfo = Person.getInfo(personList);
		Assert.assertEquals(personsInfo, mController.showKiyvstarContacts());
	}

	@Test
	public void phoneNumberValidationValidNumber(){
		String number = "(055) 555-55-55";
		Throwable e = null;

		try {
			Person.isPhoneNumberValid(number);
		} catch (Throwable ex) {
			e = ex;
		}

		Assert.assertNull(e);
	}

	@Test
	public void phoneNumberValidationInvalidNumber(){
		String number = "555-555-55-55";
		Throwable e = null;

		try {
			Person.isPhoneNumberValid(number);
		} catch (Throwable ex) {
			e = ex;
		}

		Assert.assertTrue(e instanceof ValidatorException);
	}




	private Person getPersonFixture(){
		String firstName = mFaker.name().firstName();
		String lastName = mFaker.name().lastName();
		String phoneNumber = mFaker.phoneNumber().cellPhone();

		return new Person(firstName, lastName, phoneNumber);
	}

	private Map<String,String> getPersonInfo(){
		String firstName = mFaker.name().firstName();
		String lastName = mFaker.name().lastName();
		String phoneNumber = mFaker.phoneNumber().cellPhone();

		Map<String,String> info = new HashMap<>();
		info.put("firstName", firstName);
		info.put("lastName", lastName);
		info.put("phoneNumber", phoneNumber);

		return info;
	}

	private List<Person> getPersonFixtures(int size){
		List<Person> fixtures = new ArrayList<>();
		for (int i = 0; i < size; i++){
			fixtures.add(new Person(mFaker.name().firstName(), mFaker.name().lastName(), mFaker.phoneNumber().cellPhone()));
		}
		return fixtures;
	}

	@After
	public void tearDown() throws Exception {
		mController = null;
	}

}
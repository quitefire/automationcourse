package com.courses.contactlist;


import com.courses.contactlist.exceptions.InvalidPhoneNumberException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class ContactListTest {

    private ContactList contactList;

    @Before
    public void setUp() {
        contactList = new ContactList();
        contactList.addNewContact(new Contact("Jack Black", "0636345237"));
        contactList.addNewContact(new Contact("Robert Gigs", "0686345337"));
        contactList.addNewContact(new Contact("Jack Richer", "0936325333"));
        contactList.addNewContact(new Contact("Jenny Clark", "0736325333"));
        contactList.addNewContact(new Contact("Sam Ray", "0986325339"));
    }

    @Test
    public void testAddNewContact() {
        Assert.assertTrue(contactList.addNewContact(new Contact("Jack Black", "0636345237")));
    }

    @Test(expected = InvalidPhoneNumberException.class)
    public void testAddNewContactWithInvalidPhoneNumber() {
        contactList.addNewContact(new Contact("Jack Black", "0636ad21345237"));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullContact() {
        contactList.addNewContact(null);
    }

    @Test
    public void testRemoveContact() {
        Contact toRemove = new Contact("Sam Ray", "0986325339");
        Assert.assertTrue(contactList.removeContact(toRemove));
    }

    @Test
    public void testFindContact() {
        Contact toFind = new Contact("Sam Ray", "0986325339");
        Assert.assertTrue(toFind.equals(contactList.findContact(toFind)));
    }

    @Test
    public void testFindContactByName() {
        List<Contact> expected = new ArrayList<>();
        expected.add(new Contact("Jack Black", "0636345237"));
        expected.add(new Contact("Jack Richer", "0936325333"));
        Assert.assertThat(contactList.findContactsByName("Ja"), is(expected));
    }

    @Test
    public void testFindContactByPhoneNumber() {
        List<Contact> expected = new ArrayList<>();
        expected.add(new Contact("Jack Richer", "0936325333"));
        expected.add(new Contact("Jenny Clark", "0736325333"));
        expected.add(new Contact("Sam Ray", "0986325339"));
        Assert.assertThat(contactList.findContactsByPhoneNumber("2533"), is(expected));
    }

    @Test
    public void testGetLifeContacts() {
        List<Contact> expected = new ArrayList<>();
        expected.add(new Contact("Jack Black", "0636345237"));
        expected.add(new Contact("Jack Richer", "0936325333"));
        expected.add(new Contact("Jenny Clark", "0736325333"));
        Assert.assertThat(contactList.getLifeContacts(), is(expected));
    }

    @Test
    public void testGetKiyvstarContacts() {
        List<Contact> expected = new ArrayList<>();
        expected.add(new Contact("Robert Gigs", "0686345337"));
        expected.add(new Contact("Sam Ray", "0986325339"));
        Assert.assertThat(contactList.getKiyvstarContacts(), is(expected));
    }

    @Test
    public void testUpdateContactName() {
        Contact test = new Contact("Test", "0634555467");
        test.setName("New name");
        Assert.assertEquals("New name", test.getName());
    }

    @Test
    public void testUpdateContactNumber() {
        Contact test = new Contact("Test", "0634555467");
        test.setPhoneNumber("096 3456 891");
        Assert.assertEquals("0963456891", test.getPhoneNumber());
    }

}

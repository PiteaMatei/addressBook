package com.addressBook.pitea.dao;

import java.util.List;

import com.addressBook.pitea.entity.Contact;

public interface ContactDAO {

	public List<Contact> getContacts();

	public List<Contact> searchContacts(String name);

	public void saveContact(Contact theContact);

	public Contact getContact(int theId);

	public void deleteContact(int theId);

}

package com.addressBook.pitea.service;

import java.util.List;

import com.addressBook.pitea.entity.Contact;

public interface ContactService {

	public List<Contact> getContacts();
	
	public List<Contact> searchContacts(String name);
	
	public void saveContact(Contact theContact);

	public Contact getContact(int theId);

	public void deleteContact(int theId);
	
}

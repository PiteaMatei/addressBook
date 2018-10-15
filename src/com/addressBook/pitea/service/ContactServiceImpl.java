package com.addressBook.pitea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.addressBook.pitea.dao.ContactDAO;
import com.addressBook.pitea.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	// inject customer dao
	@Autowired
	private ContactDAO contactDAO;

	@Override
	@Transactional
	public List<Contact> getContacts() {
		// TODO Auto-generated method stub
		return contactDAO.getContacts();
	}

	@Override
	@Transactional
	public List<Contact> searchContacts(String name) {
		// TODO Auto-generated method stub
		return contactDAO.searchContacts(name);
	}

	@Override
	@Transactional
	public void saveContact(Contact theContact) {
		contactDAO.saveContact(theContact);

	}

	@Override
	@Transactional
	public Contact getContact(int theId) {
		// TODO Auto-generated method stub
		return contactDAO.getContact(theId);
	}

	@Override
	@Transactional
	public void deleteContact(int theId) {
		contactDAO.deleteContact(theId);

	}

}

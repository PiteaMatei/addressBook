package com.addressBook.pitea.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.addressBook.pitea.entity.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Contact> getContacts() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Contact> theQuery = currentSession.createQuery("from Contact order by name", Contact.class);

		try {
			List<Contact> contacts = theQuery.getResultList();
			// return results
			return contacts;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Contact> searchContacts(String name) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		try {
			// search the database
			Query theQuery = currentSession.createQuery("from Contacts where name=:name");

			// execute query and get the result list
			List<Contact> contacts = theQuery.getResultList();

			// get results
			return contacts;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void saveContact(Contact theContact) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		try {
			// save or update the contact
			currentSession.saveOrUpdate(theContact);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Contact getContact(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		try {
			// read from the database using the primary key
			Contact theContact = currentSession.get(Contact.class, theId);

			// get the contact by id
			return theContact;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void deleteContact(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		try {
			// delete from the database using the primary key
			Query theQuery = currentSession.createQuery("delete from Contact where id=:contactId");
			theQuery.setParameter("contactId", theId);

			// delete contact by id
			theQuery.executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}

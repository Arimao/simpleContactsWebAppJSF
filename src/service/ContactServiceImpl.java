package service;

import java.util.List;

import model.Contact;
import dao.ContactDAOImpl;

public class ContactServiceImpl {

	private static ContactDAOImpl contactDAOImpl;

	public ContactServiceImpl() {
		contactDAOImpl = new ContactDAOImpl();
	}

	private ContactDAOImpl getContactDAOImpl() {
		return contactDAOImpl;
	}

	public Contact createContact(String name, String email, String address, String phone) {
		return getContactDAOImpl().createContact(name, email, address, phone);
	}

	public Contact findContact(int id) {
		return getContactDAOImpl().findContact(id);
	}

	public List<Contact> findAllContacts() {
		return getContactDAOImpl().findAllContacts();
	}
	
	public List<Contact> findContactsByQuery(String search){
		return getContactDAOImpl().findContactsByQuery(search);
	}

	public void removeContact(int id) {
		getContactDAOImpl().removeContact(id);
	}
	
	public Contact editContact(int id, String name, String email, String address, String phone) {
		return getContactDAOImpl().editContact(id, name, email, address, phone);
	}
}

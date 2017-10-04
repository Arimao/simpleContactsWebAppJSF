package dao;

import java.util.List;

import model.Contact;

public interface ContactDAO {

	public Contact createContact(String name, String email, String address, String phone);

	public Contact findContact(int id);

	public List<Contact> findAllContacts();
	
	public List<Contact> findContactsByQuery(String search);

	public void removeContact(int id);
	
	public Contact editContact(int id, String name, String email, String address, String phone);
}

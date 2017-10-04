package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import utility.EntityManagerUtility;
import model.Contact;

public class ContactDAOImpl implements ContactDAO {

	private EntityManager entityManager;

	public ContactDAOImpl() {
		EntityManagerFactory entityManagerFactory = EntityManagerUtility.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Contact createContact(String name, String email, String address, String phone) {
		Contact contact = new Contact(name, email, address, phone);
		entityManager.getTransaction().begin();
		entityManager.persist(contact);
		entityManager.getTransaction().commit();
		return contact;
	}

	@Override
	public Contact findContact(int id) {
		return entityManager.find(Contact.class, id);
	}

	@Override
	public List<Contact> findAllContacts() {
		TypedQuery<Contact> query = entityManager.createQuery("Select c from Contact c", Contact.class);
		return query.getResultList();
	}
	
	@Override
	public List<Contact> findContactsByQuery(String search) {
		TypedQuery<Contact> query = entityManager.createQuery("from Contact c where (c.name like '%" + search + "%' OR c.address like '%"+ search +"%' OR c.phone like '%"+ search +"%' OR c.email like '%"+ search +"%')", Contact.class);
		return query.getResultList();
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContact(id);
		if (contact != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(contact);
			entityManager.getTransaction().commit();
		}
	}
	
	@Override
	public Contact editContact(int id, String name, String email, String address, String phone) {
		Contact contact = findContact(id);
		entityManager.getTransaction().begin();
		contact.setName(name);
		contact.setEmail(email);
		contact.setAddress(address);
		contact.setPhone(phone);
		entityManager.getTransaction().commit();
		return contact;
	}
}

package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import service.ContactServiceImpl;
import model.Contact;

@ManagedBean
@SessionScoped
public class ContactController {

	private int id;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String search;
	private List<Contact> contacts = new ArrayList<Contact>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public String saveContact() {

		ContactServiceImpl contactService = new ContactServiceImpl();
		
		if(id == 0) {
			contactService.createContact(name, email, address, phone);
		}
		else {
			contactService.editContact(id, name, email, address, phone);
		}

		contacts = contactService.findAllContacts();
		return "home";

	}

	public void deleteContact(int id) {
		ContactServiceImpl contactService = new ContactServiceImpl();
		contactService.removeContact(id);

		contacts = contactService.findAllContacts();

	}
	
	public String editContact(int id, String name, String email, String address, String phone) {
		setId(id);
		setName(name);
		setEmail(email);
		setAddress(address);
		setPhone(phone);
		return "addContact";
	}
	
	public String addContact() {
		setId(0);
		setName("");
		setEmail("");
		setAddress("");
		setPhone("");
		return "addContact";
	}
	
	public void searchContacts() {
		ContactServiceImpl contactService = new ContactServiceImpl();
		contacts = contactService.findContactsByQuery(search);
	}
	
	public void checkName(FacesContext context, UIComponent component, Object value) {
		String cName = (String) value;
		if (cName.isEmpty()) {
			((UIInput) component).setValid(false);
			FacesMessage message = new FacesMessage("Name cannot be empty.");
			context.addMessage(component.getClientId(context), message);
		}
		else if (cName.matches(".*\\d+.*")) {
			((UIInput) component).setValid(false);
			FacesMessage message = new FacesMessage("Name cannot contain numbers.");
			context.addMessage(component.getClientId(context), message);
		}
	}
	
	public void checkEmail(FacesContext context, UIComponent component, Object value) {
		String cMail = (String) value;
		if (cMail.matches(".*@.*") == false) {
			((UIInput) component).setValid(false);
			FacesMessage message = new FacesMessage("E-mail must contain @.");
			context.addMessage(component.getClientId(context), message);
		}
	}
	
	public void checkPhone(FacesContext context, UIComponent component, Object value) {
		String cPhone = (String) value;
		if (cPhone.isEmpty()) {
			((UIInput) component).setValid(false);
			FacesMessage message = new FacesMessage("Telephone cannot be empty.");
			context.addMessage(component.getClientId(context), message);
		}
		else if (cPhone.matches(".*[a-zA-Z].*")) {
			((UIInput) component).setValid(false);
			FacesMessage message = new FacesMessage("Telephone cannot contain letters.");
			context.addMessage(component.getClientId(context), message);
		}
	}
}

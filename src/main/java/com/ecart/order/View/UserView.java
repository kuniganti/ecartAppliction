package com.ecart.order.View;

import java.util.List;

import com.ecart.order.entity.Address;
import com.ecart.order.entity.Contact;
import com.ecart.order.entity.LoginEntity;

public class UserView {
	private String name;
	private char gender;
	private Contact primaryContact;
	private Contact secondaryContact;
	private List<Contact> userContacts;
	private Address shippingAddress;
	private LoginEntity login;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Contact getPrimaryContact() {
		return primaryContact;
	}
	public void setPrimaryContact(Contact primaryContact) {
		this.primaryContact = primaryContact;
	}
	public Contact getSecondaryContact() {
		return secondaryContact;
	}
	public void setSecondaryContact(Contact secondaryContact) {
		this.secondaryContact = secondaryContact;
	}
	public List<Contact> getUserContacts() {
		return userContacts;
	}
	public void setUserContacts(List<Contact> userContacts) {
		this.userContacts = userContacts;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public LoginEntity getLogin() {
		return login;
	}
	public void setLogin(LoginEntity login) {
		this.login = login;
	}
	
	
	
	
}

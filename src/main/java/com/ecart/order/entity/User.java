package com.ecart.order.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class User {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userID;
	private String name;
	private char gender;
	@ElementCollection
	@JoinTable(name="contact",joinColumns=@JoinColumn(name="userID"))
	private List<Contact> contacts;
	@OneToOne(mappedBy="user",cascade=CascadeType.PERSIST)
	@PrimaryKeyJoinColumn
	private Address shippingaddress;
	
	public User(long userID, String name, List<Contact> contacts) {
		this.userID = userID;
		this.name = name;
		this.contacts = contacts;
	}
	public User() {
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContact(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public Address getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(Address shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "\n User [userID=" + userID + ", name=" + name + ", contacts=" + contacts +", shippingaddress=" + shippingaddress + "]";
	}
	
	
}

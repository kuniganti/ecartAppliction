package com.ecart.order.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {
	
	private String emailID;
	private String contactNumber;
	public Contact( String emailID, String contactNumber) {
		this.emailID = emailID;
		this.contactNumber = contactNumber;
	}
	public Contact() {
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "\n Contact [emailID=" + emailID + ", contactNumber="
				+ contactNumber + "]";
	}
	
	
}

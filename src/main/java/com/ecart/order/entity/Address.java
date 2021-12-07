package com.ecart.order.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
//@Embeddable
public class Address {
	@Id@GeneratedValue(generator="addressKeyGenerator")
	@GenericGenerator(name="addressKeyGenerator",strategy="foreign",parameters=@Parameter(name="property", value = "user"))
	private long addressID;
	private String flatName;
	private String streetName;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	@Embedded
	private Locality locality;
	
	public Address(long addressID, String flatName, String streetName, User user, Locality locality) {
		this.addressID = addressID;
		this.flatName = flatName;
		this.streetName = streetName;
		this.user = user;
		this.locality = locality;
	}
	public Address() {
	}
	public long getAddressID() {
		return addressID;
	}
	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}
	public String getFlatName() {
		return flatName;
	}
	public void setFlatName(String flatName) {
		this.flatName = flatName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Locality getLocality() {
		return locality;
	}
	public void setLocality(Locality locality) {
		this.locality = locality;
	}
	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", flatName=" + flatName + ", streetName=" + streetName
				+ ", locality=" + locality + "]";
	}
	
}

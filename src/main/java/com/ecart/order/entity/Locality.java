package com.ecart.order.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Locality {
	
	private String city;
	private int zipCode;
	private String country;
	public Locality(String city, int zipCode, String country) {
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}
	public Locality() {
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Locality [city=" + city + ", zipCode=" + zipCode + ", country=" + country + "]";
	}
	
	
}

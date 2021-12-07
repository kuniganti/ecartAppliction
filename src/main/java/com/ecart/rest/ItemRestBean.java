package com.ecart.rest;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.ecart.order.entity.Category;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemRestBean {

	private Long ItemID;
	private String name;
	private String price;
	private String seller;
	private Category category;
	
	public Long getItemID() {
		return ItemID;
	}

	public void setItemID(Long itemID) {
		ItemID = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}

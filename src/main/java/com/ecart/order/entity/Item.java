package com.ecart.order.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

@Entity
public class Item {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long itemID;
	private String name;
	//private String category;
	private double price;
	private String seller;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryID",nullable=false)
	private Category category;
	
	@ElementCollection
	@CollectionTable(name = "ItemImage",joinColumns=@JoinColumn(name="itemID"))
	//@OrderColumn (name="ItemImage_Order")
	@Column(name="imagePath")
	Set<String> imagePaths = new HashSet<>();
	//List<String> imagePaths = new ArrayList<>();
	/*Set<Image> images = new HashSet<>();*/
	public Item(long itemID, String name, Category category, double price, String seller, Set<String> imagePaths) {
		this.itemID = itemID;
		this.name = name;
		this.category = category;
		this.price = price;
		this.seller = seller;
		this.imagePaths = imagePaths;
	}
	/*public Item(long itemID, String name, String category, double price, String seller, List<String> imagePaths) {
		this.itemID = itemID;
		this.name = name;
		this.category = category;
		this.price = price;
		this.seller = seller;
		this.imagePaths = imagePaths;
	}*/
	
	
	public Item() {
	}
	/*public Item(long itemID, String name, String category, double price, String seller, Set<Image> images) {
		this.itemID = itemID;
		this.name = name;
		this.category = category;
		this.price = price;
		this.seller = seller;
		//this.images = images;
	}*/
	public long getItemID() {
		return itemID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}*/
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	/*public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}*/
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", name=" + name + /*", category=" + category + ", price="*/ + price + ", seller="
				+ seller + /*", imagePaths=" + imagePaths +*/ "]";
	}
	
}

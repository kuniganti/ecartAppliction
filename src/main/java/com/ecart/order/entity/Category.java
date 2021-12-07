package com.ecart.order.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
public class Category {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long categoryID;
	
	@Column(name="categoryname")
	private String name;
	
	@OneToMany(mappedBy = "category",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Item> items =new ArrayList<>();
	
	public Category(long categoryID, String name) {
		this.categoryID = categoryID;
		this.name = name;
	}
	public Category() {
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "\n Category [categoryID=" + categoryID + ", name=" + name + ", items=" + items + "]";
	}
	
	
}

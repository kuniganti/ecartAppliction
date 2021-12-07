package com.ecart.order.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bookID;
	private String iSBN;
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Author> authors;
	private Date publishedDate;
	
	public Book(long bookID, String iSBN, Date publishedDate) {
		this.bookID = bookID;
		this.iSBN = iSBN;
		this.publishedDate = publishedDate;
	}

	public Book() {
	}

	public long getBookID() {
		return bookID;
	}

	public void setBookID(long bookID) {
		this.bookID = bookID;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", iSBN=" + iSBN + ", publishedDate=" + publishedDate + "]";
	}
	
	
}

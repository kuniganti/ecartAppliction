package com.ecart.order.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Author {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long authorID;
	private String authorName;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name = "AUTHOR_BOOK",
			joinColumns = @JoinColumn(name = "AUTHOR_ID"),
			inverseJoinColumns = @JoinColumn(name = "BOOK_ID")
			)
	private Set<Book> books;
	public Author(long authorID, String authorName) {
		this.authorID = authorID;
		this.authorName = authorName;
	}
	public Author() {
	}
	public long getAuthorID() {
		return authorID;
	}
	public void setAuthorID(long authorID) {
		this.authorID = authorID;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", authorName=" + authorName + "]";
	}
	
	
}

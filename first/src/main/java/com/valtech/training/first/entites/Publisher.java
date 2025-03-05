package com.valtech.training.first.entites;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pubseq")
	@SequenceGenerator(name = "pubseq", sequenceName = "pub_seq",allocationSize = 1)
	private long id;
	private String name;
	
	@OneToMany(targetEntity = Book.class, mappedBy = "publisher",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Book> books;
	
	
	public Publisher() {}
	public Publisher(String name) {
		super();
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		if(books==null) books=new HashSet<Book>();
		books.add(book);
		book.setPublisher(this);
	}
	
	
}



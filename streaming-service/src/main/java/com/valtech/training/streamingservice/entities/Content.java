package com.valtech.training.streamingservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;

@MappedSuperclass
public class Content {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cont_seq")
	@SequenceGenerator(name = "cont_seq", sequenceName = "cont_seq", allocationSize = 1)
	private long id;
	private String name;

	private String genre;
	private String language;
	
	
	public Content() {
	}
	
	
	public Content(String name, String genre, String language) {
		super();

		this.name=name;
		this.genre = genre;
		this.language = language;
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
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	

}

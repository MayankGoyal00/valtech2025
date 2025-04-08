package com.valtech.training.quiz.entities;

public class Response {
	private long id;
	private String response;
	
	public Response() {
		// TODO Auto-generated constructor stub
	}

	public Response(long id, String response) {
		super();
		this.id = id;
		this.response = response;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	

}

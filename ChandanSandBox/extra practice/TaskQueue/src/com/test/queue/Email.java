package com.test.queue;

import java.io.Serializable;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class Email implements Serializable {
	@Id
	Long id;
	String email;
	
	public Email(String email) {
		super();
		this.email = email;
	}
	public Email() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}

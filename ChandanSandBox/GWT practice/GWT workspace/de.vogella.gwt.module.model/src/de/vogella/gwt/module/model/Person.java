package de.vogella.gwt.module.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
	String firstName;
	String LastName;

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		LastName = lastName;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

}

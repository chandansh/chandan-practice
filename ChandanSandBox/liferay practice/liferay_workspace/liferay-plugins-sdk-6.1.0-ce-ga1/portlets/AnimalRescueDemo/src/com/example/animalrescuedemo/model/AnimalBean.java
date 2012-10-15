package com.example.animalrescuedemo.model;

public class AnimalBean {

	private String id;
	private String name;
	private String state;
	private String location;
	private String description;
	private boolean isVoteComplete;

	public AnimalBean() {
	}

	public AnimalBean(String id, String name, String state, String location,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.location = location;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isVoteComplete() {
		return isVoteComplete;
	}

	public void setVoteComplete(boolean isVoteComplete) {
		this.isVoteComplete = isVoteComplete;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package com.test;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DispatchAction extends ActionSupport {
	
	String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() {
		System.out.println("execute method called.");
		message = "inside execute method";
		return SUCCESS;
	}
	
	public String add() {
		System.out.println("add method called.");
		message = "inside add method";
		return SUCCESS;
	}
	
	public String update() {
		System.out.println("update method called.");
		message = "inside update method";
		return SUCCESS;
	}
	
	public String remove() {
		System.out.println("remove method called.");
		message = "inside remove method";
		return SUCCESS;
	}
}

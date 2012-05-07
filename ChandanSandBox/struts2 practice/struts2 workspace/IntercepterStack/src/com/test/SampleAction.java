package com.test;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SampleAction extends ActionSupport {

	public String populate() {
		System.out.println("Populate Action called");
		return "populate";
	}

	public String execute() {
		System.out.println("Sample Action called");
		return "success";
	}

	// validate method always called Since we extend our class from
	// ActionSupport which inturn implements the Validateable interface, the
	// validate() method of the action class will be called by the workflow
	// interceptor. By default the validate() method will be called during the
	// execution of both populate() and execute() methods but we need to
	// validate only when the execute() method is invoked.
	
	public void validate() {
		System.out.println("validate() method called");
	}
}

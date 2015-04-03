package com.test;

import java.util.List;

public class HelloWorldImpl implements HelloWorld {
	private String message;
	private TestBean testBean;
	private List<String> names;

	public HelloWorldImpl() {

	}

	public HelloWorldImpl(String message, TestBean testBean, List<String> names) {
		this.message = message;
		this.testBean = testBean;
		this.names = names;
	}

	public String sayHello() {
		return message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TestBean getTestBean() {
		return testBean;
	}

	public void setTestBean(TestBean testBean) {
		this.testBean = testBean;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}

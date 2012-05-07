package com.springinaction.test;

public class GreetingServiceImpl implements GreetingService {
	
	String greeting;


	@Override
	public void sayGreeting() {
		System.out.println(greeting);
	}

	public GreetingServiceImpl() {
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public GreetingServiceImpl(String greeting) {
		super();
		this.greeting = greeting;
	}

}

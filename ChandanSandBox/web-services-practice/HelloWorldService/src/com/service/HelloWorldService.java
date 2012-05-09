package com.service;

public class HelloWorldService {
	public String sayHello(String name) {
		System.out.println("Hello World Hello Service called");
		return "Hello " + name;
	}

	public String sayBye(String name) {
		System.out.println("Hello World Bye Service called");
		return "Bye " + name;
	}
}

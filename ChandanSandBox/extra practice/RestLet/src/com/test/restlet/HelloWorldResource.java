package com.test.restlet;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorldResource extends ServerResource {
	@Get("/hello-world")
	public String represent() {
		return "hello, world";
	}

	@Get("/hello-user")
	public String sayHelloWorld(String name) {
		return "Hello, " + name + "!";
	}
}

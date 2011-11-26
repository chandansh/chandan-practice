package com.edujini.ws.test;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class WSAppliction extends Application {

	// @Override
	// public Set<Class<?>> getClasses() {
	//
	// }

	@Override
	public Set<Object> getSingletons() {
		Set<Object> rv = new HashSet<Object>();
		rv.add(new HelloWorldService());

		return rv;
	}
}

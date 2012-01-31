package com.test.chat;

import java.util.HashSet;
import java.util.Set;

public class Users {
	private static Set<String> users = new HashSet<String>();

	private Users() {

	}

	public static Set<String> get() {
		return users;
	}

}

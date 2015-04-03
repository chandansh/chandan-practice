package com.test;

public class EscapeChar {

	
	public static void main(String[] args) {
		String message = "'chadnan'";
		message = message.replace("'", "\\'");
		System.out.println("\\hello \\"+ message);

	}

}

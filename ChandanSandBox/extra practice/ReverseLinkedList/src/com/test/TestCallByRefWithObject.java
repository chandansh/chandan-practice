package com.test;

import java.util.ArrayList;

public class TestCallByRefWithObject {
	ArrayList list = new ArrayList(5);

	public void remove(int index) {
		list.remove(index);
	}

	public void add(Object obj) {
		list.add(obj);
	}

	public void display() {
		System.out.println(list);
	}

	public static void main(String[] args) {
		TestCallByRefWithObject test = new TestCallByRefWithObject();

		test.add("1");
		test.add("2");
		test.add("3");
		test.add("4");
		test.add("5");

		test.remove(4);
		test.display();
	}
}
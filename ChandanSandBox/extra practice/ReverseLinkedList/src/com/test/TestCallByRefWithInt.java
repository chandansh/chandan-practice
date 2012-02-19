package com.test;

public class TestCallByRefWithInt {
	int i = 5;

	public void decrement(int i) {
		i--;
	}

	public void increment(int i) {
		i++;
	}

	public void display() {
		System.out.println("\nValue of i is : " + i);
	}

	public static void main(String[] args) {
		TestCallByRefWithInt test = new TestCallByRefWithInt();

		test.increment(test.i);

		test.display();
	}
}
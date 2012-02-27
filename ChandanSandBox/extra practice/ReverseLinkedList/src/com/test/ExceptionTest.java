package com.test;

import java.util.Arrays;

public class ExceptionTest {
	public static void main(String[] args) {

		try {
			printAverage(100, 0);
		} catch (ArithmeticException ae) {
			ae.printStackTrace();
			System.out.println("Exception handled in " + "main().");
		} finally {
			System.out.println("Finally in main().");
		}
		System.out.println("Exit main().");
		Object o = new Object();

	}

	public static void printAverage(int totalSum, int totalNumber) {
		// int average = computeAverage(totalSum, totalNumber);
		// System.out.println("Average = " + totalSum + " / " + totalNumber
		// + " = " + average);
		try {
			int average = computeAverage(totalSum, totalNumber);
			System.out.println("Average = " + totalSum + " / " + totalNumber
					+ " = " + average);
		} catch (IllegalArgumentException iae) {
			System.out.println("Exception handled in " + "printAverage().");
			iae.printStackTrace();

		} finally {
			System.out.println("Finally in printAverage().");
		}

		System.out.println("Exit printAverage().");
	}

	public static int computeAverage(int sum, int number) {
		System.out.println("Computing average.");
		if (number == 0)
			throw new MyException("Integer division by 0 message ");
		return sum / number;
	}
}

@SuppressWarnings("serial")
class MyException extends ArithmeticException {

	public MyException() {
		super();
	}

	public MyException(String s) {
		super(s);
	}

}

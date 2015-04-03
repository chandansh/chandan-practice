package com.test;

class BaseClass {

	int a = 10;

	public static void method1() {
		System.out.println("inside BaseClass method1.");
	}

	public void method2() {
		System.out.println("inside BaseClass method2.");
	}

	public void method3() {
		System.out.println("inside BaseClass method3");
		method1();
		method2();
	}
}

public class InheritenceTest1 extends BaseClass {
	int a = 20;

	public static void method1() {
		System.out.println("inside InheritenceTest1 method1.");
	}

	public void method2() {
		System.out.println("inside InheritenceTest1 method2.");
	}

	public static void main(String[] args) {
		new InheritenceTest1().method3();
		BaseClass a= new InheritenceTest1();
		InheritenceTest1 b= new InheritenceTest1();
		a.method1();
		System.out.println(a.a);

	}

}

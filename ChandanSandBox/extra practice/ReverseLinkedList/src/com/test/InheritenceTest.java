package com.test;

class A{
	public void hello(){
		System.out.println("hello A");
	}
	
	public void helloa(){
		System.out.println("helloA  A method");
	}
}

class B extends A{
	public void hello(){
		System.out.println("hello B");
	}
	
	public int hello1(int a, int b){
		System.out.println("Hello 1 of B");
		return 0;
	}
	
	public float hello1(int a, float b){
		return 0;
	}
}

public class InheritenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new B();
		a.hello();
		a.helloa();
		
		//a.hello1();
		

	}

}

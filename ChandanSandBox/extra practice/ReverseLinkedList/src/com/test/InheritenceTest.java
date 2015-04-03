package com.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

abstract interface AA {
	int a = 10;

	public void hello();

	public static class AAInner {
		int a = 10;
		AAInner inObj = new AAInner();

		AAInner() {
			System.out.println("AAInner is created");
		}
	}

	class AAInner1 {
		private int a = 10;

		AAInner1() {
			System.out.println("AAInner1 is created");
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

	}
}

interface BB {
	int a = 20;

	public void hello1();

	public void hello();
}

class A implements AA, BB {
	Calendar cal = Calendar.getInstance();

	@Override
	public void hello() {
		System.out.println("hello AA and BB is implemented");
	}

	public void helloa() {
		System.out.println("helloA  A method");
	}

	@Override
	public void hello1() {
		System.out.println("Hello1 AA implemented.");

	}

	public static class AAInner {
		int a = 10;
		A inObj = new A();

		AAInner() {
			System.out.println("AAInner is created");
		}
	}
}

class B extends A {
	@Override
	public void hello() {
		System.out.println("hello AA and BB is implemented");
	}

	public void helloa() {
		System.out.println("helloA  A method");
	}

	@Override
	public void hello1() {
		System.out.println("Hello1 AA implemented.");

	}
}

class C extends B {
	public void hello() {
		System.out.println("hello B");
	}

	public int hello1(int a, int b) {
		System.out.println("Hello 1 of B");
		return 0;
	}

	public float hello1(int a, float b) {
		return 0;
	}
}

public abstract class InheritenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA aa = new B();

		BB b = new B();
		System.out.println(aa.a);
		System.out.println(b.a);

		A a = new B();
		a.hello();

		A a1 = new A();
		a1.hello();
		// System.out.println(a.a);
		// a.helloa();

		// a.hello1();
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		// ht.put(null, "");

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(4);
		list.add(5);
		list.add(3);
		list.add(1);
		list.add(7);
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(2);
		printList(list);
		Collections.sort(list);
		System.out.println("After sorting.");
		printList(list);

		System.out.println("After removing duplicates.");
		for (int i = 0; i < list.size(); i++) {
			int item = list.get(i);

			if (i < list.size() - 1 && item == list.get(i + 1)) {
				list.remove(i + 1);
				i--;
			}
		}

		for (int i : list) {
			// list.remove(i); // this will make ConcurrentModificationException
			// at runtime
			// list.add(i);
		}
		printList(list);

		String s1 = "hello";
		String s2 = "hello";
		System.out.println("Both Strings are equal using equals:"
				+ s1.equals(s2));
		System.out.println("Both Strings are equal using == :" + (s1 == s2));
		System.out.println("String1 Hashcode :" + s1.hashCode()
				+ "  String2 HashCode :" + s2.hashCode());

		AA.AAInner inner = new AA.AAInner();
		System.out.println(inner.a);

		AA.AAInner1 inner1 = new AA.AAInner1();
		System.out.println(inner1.getA());

		List<B> list1 = new ArrayList<B>();
		// list1.add(new A()); //this will compile tie error the method is not
		// applicable for A
		list1.add(new B());
		list1.add(new C());
		int x = 1, y = 2, a11 = 5, b11 = 6, p = 2, q = 4;
		boolean bb = (x > y ? a11 : b11) == p * q;
		Runtime.getRuntime().gc();
		System.gc();
	}

	private static void printList(List<Integer> list) {
		for (int i : list) {
			System.out.println("List =>" + i);
		}
	}

}

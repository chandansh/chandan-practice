package com.test.linkedlist;

public class DeckTest {
	public static void main(String s[]) {
		Deck d = new Deck();
		System.out.println("before shuffle:" + d);
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		// System.out.println(d.deal());
		d.shuffle();
		System.out.println("After shuffle:" + d);
		d.shuffle();
		System.out.println("After shuffle:" + d);
		d.shuffle();
		System.out.println("After shuffle:" + d);
		d.shuffle();
		System.out.println("After shuffle:" + d);
		d.shuffle();
		System.out.println("After shuffle:" + d);
		for (int i = 0; i < Deck.size; i++)
			System.out.println(d.deal());
	}
}

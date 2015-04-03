package com.test.linkedlist;

import java.util.Random;

public class Deck {
	public static final int size = 52;
	private int[] cards = new int[size];
	private int top = -1;

	public Deck() {
		for (int i = 0; i < 52; i++) {
			cards[i] = i + 1;
		}
	}

	public int deal() {
		top++;
		if (top < 52) {
			return cards[top];
		}
		return 0;
	}

	public void shuffle() {
		Random r = new Random();
		for (int i = size; i > 1; i--)
			swap(cards, i - 1, r.nextInt(i));
	}

	private static void swap(int[] arr, int i, int j) {
		System.out.println("random no:" + j);
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	@Override
	public String toString() {
		String rv = "";
		for (int i = 0; i < size; i++) {
			rv += "," + cards[i];
		}
		return rv;
	}

}

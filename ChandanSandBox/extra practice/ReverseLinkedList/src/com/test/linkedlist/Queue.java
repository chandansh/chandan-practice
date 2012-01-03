package com.test.linkedlist;

import java.util.Iterator;
import java.util.Stack;

public class Queue {
	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<Integer>();

	public void inQueue(int num) {
		s1.push(num);
	}

	public int deQueue() {
		if (s2.empty()) {
			while (!s1.empty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}

	@Override
	public String toString() {
		String rv = "";
		Iterator<Integer> it = s2.iterator();
		while (it.hasNext()) {
			rv = it.next() + "," + rv;
		}
		it = s1.iterator();
		while (it.hasNext()) {
			rv += "," + it.next();
		}
		if (rv.startsWith(","))
			rv = rv.substring(1);
		return rv;
	}

}

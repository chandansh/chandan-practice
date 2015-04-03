package com.test.linkedlist;

import java.util.Iterator;
import java.util.Stack;

public class Queue1 {
	private Stack<Integer> s = new Stack<Integer>();
	
	public void enqueue(int num) {
		if(s.empty())
		{
			s.push(num);
		}else
		{
			int temp=s.pop();
			enqueue(num);
			s.push(temp);
		}
	}

	public int dequeue() {
		return s.pop();
	}

	@Override
	public String toString() {
		String rv = "";
		Iterator<Integer> it = s.iterator();
		while (it.hasNext()) {
			rv += "," + it.next();
		}
		if (rv.startsWith(","))
			rv = rv.substring(1);
		return rv;
	}

}

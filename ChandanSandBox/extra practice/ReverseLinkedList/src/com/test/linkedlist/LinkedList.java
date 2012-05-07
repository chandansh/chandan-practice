package com.test.linkedlist;

import com.test.node.Node;

public class LinkedList {
	public static void main(String s[]) {

		Node head = new Node("A", new Node("B", new Node("C", new Node("D",
				new Node("E", new Node("F", new Node("G")))))));

		head.printList();
		Node rev = reverse(head);
		System.out.println("rev: ");
		rev.printList();
	}

	private static Node reverse(Node head) {
		Node pivot = head;
		Node previous = null;
		Node temp = null;
		while (pivot.getNext() != null) {
			temp = pivot.getNext();
			pivot.setNext(previous);
			previous = pivot;
			pivot = temp;

		}
		pivot.setNext(previous);
		
		return pivot;

	}
}

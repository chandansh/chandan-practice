package com.test.node;

public class Node {
	private String value;
	private Node next;

	public Node() {

	}

	public Node(String value) {
		this.value = value;
	}

	public Node(String value, Node next) {
		this.value = value;
		this.next = next;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public void printList()
	{
		System.out.print(value+">>");
		if(next!=null)
		{
			next.printList();
		}
	}
}

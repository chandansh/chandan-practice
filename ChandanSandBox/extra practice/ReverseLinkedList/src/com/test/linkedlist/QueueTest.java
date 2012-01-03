package com.test.linkedlist;

public class QueueTest {
	public static void main(String args[]) {
		Queue q = new Queue();
		q.inQueue(10);
		q.inQueue(15);
		q.inQueue(22);
		q.inQueue(65);
		q.inQueue(35);
		q.inQueue(25);
		System.out.println(q);
		System.out.println(q.deQueue() + " deleted");
		System.out.println(q);
		System.out.println(q.deQueue() + " deleted");
		System.out.println(q);
		q.inQueue(27);
		q.inQueue(68);
		System.out.println(q);
		
		System.out.println("another Queue");
		Queue1 q1 = new Queue1();
		q1.enqueue(10);
		q1.enqueue(15);
		q1.enqueue(22);
		q1.enqueue(65);
		q1.enqueue(35);
		q1.enqueue(25);
		System.out.println(q1);
		System.out.println(q1.dequeue() + " deleted");
		System.out.println(q1);
		System.out.println(q1.dequeue() + " deleted");
		System.out.println(q1);
		q1.enqueue(27);
		q1.enqueue(68);
		System.out.println(q1);
		
		
		
		
		
	}
}

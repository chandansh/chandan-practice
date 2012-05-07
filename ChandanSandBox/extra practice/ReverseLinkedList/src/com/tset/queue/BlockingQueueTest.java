package com.tset.queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
		ArrayList myList =new ArrayList();
		System.out.println();
		main();
		
	}
	
	public static void main()
	{
		System.out.println("hello");
	}

}

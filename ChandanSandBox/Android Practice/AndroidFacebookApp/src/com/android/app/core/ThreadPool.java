package com.android.app.core;

import com.android.app.ICommand;

public class ThreadPool implements Runnable {

	private static ThreadPool instance = new ThreadPool();
	private static Thread t1 = new Thread(new ThreadPool());
	private static Thread t2 = new Thread(new ThreadPool());

	private ThreadPool() {

	}

	public static ThreadPool get() {
		return instance;
	}

	@Override
	public void run() {
		try {
			while (true) {
				ICommand command = QueueManager.get().dQueue();
				command.exec();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void init() {
		if (!t1.isAlive())
			t1.start();
		if (!t2.isAlive())
			t2.start();
	}

}

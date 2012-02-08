package com.android.app.core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.android.app.ICommand;

public class QueueManager {
	private static QueueManager instance = new QueueManager();

	private BlockingQueue<ICommand> queue = new LinkedBlockingQueue<ICommand>();

	private QueueManager() {

	}

	public static QueueManager get() {
		return instance;
	}

	public void addQueue(ICommand command) throws InterruptedException {
		queue.put(command);
	}

	public ICommand dQueue() throws InterruptedException {
		return queue.take();
	}

	public void clear() {
		while (true) {
			if (queue.poll() == null) {
				break;
			}
		}
	}
}

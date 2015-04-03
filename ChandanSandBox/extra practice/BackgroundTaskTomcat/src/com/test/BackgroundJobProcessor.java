package com.test;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BackgroundJobProcessor implements Runnable {
	private static final Logger logger = Logger.getLogger("com.test");

	@Override
	public void run() {

		long id = Thread.currentThread().getId();
		String threadName = Thread.currentThread().getName();
		if (null == threadName || threadName.length() == 0)
			threadName = "";
		String threadId = id + ":" + threadName;

		String result = longRunningProcess(threadId);

	}

	public String longRunningProcess(String threadId) {

		logger.info("BackgroundJobProcessor: Begin long run process (on thread: "
				+ threadId + "[" + new Date() + "]");

		for (int i = 0; i <= 25; i++) {
			try {
				Thread.sleep(1000);
				logger.log(Level.INFO, "background job is running job no :"+threadId+ " and "+i+"times");
			} catch (InterruptedException ie) {
				logger.log(Level.WARNING, ie.getMessage(), ie);
			}
		}

		logger.info("BackgroundJobProcessor: Done processing request: "
				+ ". on thread: " + threadId + "[" + new Date() + "]");
		return new Date().toString();
	}

}

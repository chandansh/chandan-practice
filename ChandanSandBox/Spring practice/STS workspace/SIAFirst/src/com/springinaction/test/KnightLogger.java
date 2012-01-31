package com.springinaction.test;

import org.apache.log4j.Logger;

public class KnightLogger {
	private static final Logger SONG = Logger.getLogger(KnightLogger.class);

	public void singBefore(Knight knight) {
		SONG.info("Fa la la; Sir " + knight.getName() + " is so brave!");
		System.out.println("Fa la la; Sir " + knight.getName() + " is so brave!");
	}

	public void singAfter(Knight knight) {
		SONG.info("Tee-hee-he; Sir " + knight.getName() + " did embark on a quest!");
		System.out.println("Tee-hee-he; Sir " + knight.getName() + " did embark on a quest!");
	}
	
	

}

package com.springinaction.test;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
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
	
	@Before("execution(* *.embarkOnQuest(..))" )
	public void singBefore() {
		SONG.info("Fa la la; Sir is so brave!");
		System.out.println("Fa la la; Sir  is so brave!");
	}

	@After("execution(* *.embarkOnQuest(..))" )
	public void singAfter() {
		SONG.info("Tee-hee-he; Sir did embark on a quest!");
		System.out.println("Tee-hee-he; Sir  did embark on a quest!");
	}
	
	

}

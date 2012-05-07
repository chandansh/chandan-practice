package com.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.client.model.Picture;
import com.googlecode.objectify.ObjectifyService;

public class GAEInitializer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(Picture.class);
		
	}

	

}

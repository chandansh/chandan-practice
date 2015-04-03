package com.incoleg.fb.server.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.incoleg.fb.server.model.FacebookUser;
import com.incoleg.fb.server.model.RawEntity;

public class FacebookEngine implements ServletContextListener
{
	@Override
	public void contextInitialized(ServletContextEvent event)
	{
		ObjectifyService.register(FacebookUser.class);
		ObjectifyService.register(RawEntity.class);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event)
	{
	}

}

/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package mypack;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ognl.OgnlRuntime;

/**
 * This is a brief description of OgnlListener.
 * <br/>
 * gvaish must provide more details about the type.
 *
 * @author gvaish
 *
 */
public class OgnlListener implements ServletContextListener
{
	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		OgnlRuntime.setSecurityManager(null);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
	}

}

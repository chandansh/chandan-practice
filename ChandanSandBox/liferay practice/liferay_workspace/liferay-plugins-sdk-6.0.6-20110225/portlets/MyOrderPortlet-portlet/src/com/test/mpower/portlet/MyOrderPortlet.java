package com.test.mpower.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class MyOrderPortlet implements Portlet {

	PortletContext context;

	public void destroy() {
		System.out.println("Destroy is called by MyOrderPortlet.");
	}

	public void init(PortletConfig config) throws PortletException {
		System.out.println("Init is called by MyOrderPortlet");
		context = config.getPortletContext();
	}

	public void processAction(ActionRequest arg0, ActionResponse arg1)
			throws PortletException, IOException {
		System.out.println("Process action is called by MyOrderPortlet");
		System.out.println("user name is :" + arg0.getParameter("name")
				+ "in process action");
	}

	public void render(RenderRequest arg0, RenderResponse arg1)
			throws PortletException, IOException {
		System.out.println("render action is called by MyOrderPortlet");
		PortletRequestDispatcher dispatcher = context
				.getRequestDispatcher("/view.jsp");
		dispatcher.include(arg0, arg1);
		System.out.println("user name is :" + arg0.getParameter("name"));
	}

}

package com.edujini.incoleg.mentor.forms;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Registration
 */
public class Registration extends MVCPortlet {
 
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException
	{
	

		System.out.println("Hello**************************************");
		super.processAction(actionRequest, actionResponse);
	}
	
	@Override
	public void doAbout(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException,
			PortletException
	{
	
		System.out.println("Hello___________________________________");
		super.doAbout(renderRequest, renderResponse);
	}

}

package com.test;

import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EventLstenerPortlet
 */
public class EventLstenerPortlet extends MVCPortlet {

	@Override
	public void processEvent(EventRequest request, EventResponse response)
			throws PortletException, IOException {
		Event event = request.getEvent();
		String value = (String) event.getValue();
		System.out.print("value in process event>>>>>>>>>" + value);

		response.setRenderParameter("myInfo", value);
		super.processEvent(request, response);
	}
}

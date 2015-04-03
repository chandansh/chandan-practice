package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.xml.namespace.QName;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EventPublisherPortlet
 */
public class EventPublisherPortlet extends MVCPortlet {
	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("inside process action..");
		QName qName = new QName("http://mytest.com", "myinfo", "x");
		actionResponse.setEvent(qName,
				"Hai You have received Event Data sent from Sender Portlet");
		
//		actionResponse.setEvent("myInfo",
//				"Hai You have received Event Data sent from Sender Portlet");
		System.out.println("event fired..");
		super.processAction(actionRequest, actionResponse);
	}

}

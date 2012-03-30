
package com.mpower.training;

import java.io.IOException;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class MyPortlet2 extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		String action = ParamUtil.getString(renderRequest, "action");
		System.out.println("action :"+action);

		if ("showCustomerDetails".equalsIgnoreCase(action)) {

			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/customer_details.jsp");
			dispatcher.include(renderRequest, renderResponse);
		}
		
		System.out.println("My Portlet 2");
		super.doView(renderRequest, renderResponse);
	}

}

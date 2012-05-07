package com.mpower.training.ipc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class Portlet1 extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		long customerId = ParamUtil.getLong(renderRequest, "customerId");
		PrintWriter out = renderResponse.getWriter();
		System.out.print("<h1>Customer Id :" + customerId + "</h1>");
		super.doView(renderRequest, renderResponse);

	}
}

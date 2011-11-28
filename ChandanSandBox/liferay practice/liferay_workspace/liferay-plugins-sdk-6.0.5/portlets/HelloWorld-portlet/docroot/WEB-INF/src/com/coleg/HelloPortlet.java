package com.coleg;

import java.io.IOException;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.coleg.model.Employee;
import com.coleg.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class HelloPortlet
 */
public class HelloPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		System.out.println("[do-view]of HelloPortlet Called...... ");
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("[processAction] of HelloPortlet called...");
		// String name = actionRequest.getParameter("name");
		String name = ParamUtil.getString(actionRequest, "name");
		String address = ParamUtil.getString(actionRequest, "add");
		actionResponse.setRenderParameter("username", name);
		System.out.println("Name: " + name + "\nAddress: " + address);
		Random r = new Random();
		int i = r.nextInt(500);
		try {
			if (name.startsWith("a")) {
				SessionErrors.add(actionRequest, "error");
			} else {
				Employee emp = EmployeeLocalServiceUtil.createEmployee("emp"
						+ i);
				emp.setName(name);
				emp.setAddress(address);
				EmployeeLocalServiceUtil.addEmployee(emp);
				System.out
						.println("New Employee added by HelloWorld Portlet...  ");
				SessionMessages.add(actionRequest, "success");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		super.processAction(actionRequest, actionResponse);
	}

}

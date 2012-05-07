
package com.mpower.training.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mpower.training.customer.model.MyCustomer;
import com.mpower.training.customer.service.MyCustomerLocalServiceUtil;

public class MyCustomerPortlet extends MVCPortlet {

	PortletContext context;

	@Override
	public void init(PortletConfig config)
		throws PortletException {

		super.init(config);
		context = config.getPortletContext();
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		System.out.println("inside doView method");
		String action = ParamUtil.getString(renderRequest, "action");
		System.out.println("Action :" + action);
		if (action.equals("newCustomer")) {
			System.out.println("request for new customer page");
			PortletRequestDispatcher dispatcher = context.getRequestDispatcher("/new_cust.jsp");
			dispatcher.include(renderRequest, renderResponse);
		}
		else if (action.equals("editCustomer")) {
			System.out.println("request for Edit customer page");
			long id = ParamUtil.getLong(renderRequest, "id");
			renderRequest.setAttribute("id", id);
			System.out.println("Id :" + id);
			PortletRequestDispatcher dispatcher = context.getRequestDispatcher("/edit_cust.jsp");
			dispatcher.include(renderRequest, renderResponse);
		}
		else {
			super.doView(renderRequest, renderResponse);

		}
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		System.out.println("inside processAction method");
		String action = ParamUtil.getString(actionRequest, "action");
		if (action.equals("newCustomer")) {
			// long id = ParamUtil.getLong(actionRequest, "id");
			String name = ParamUtil.getString(actionRequest, "name");
			String address = ParamUtil.getString(actionRequest, "address");
			MyCustomer customer = MyCustomerLocalServiceUtil.createMyCustomer(0);
			customer.setName(name);
			customer.setAddress(address);
			try {
				MyCustomerLocalServiceUtil.updateMyCustomer(customer);

			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SessionMessages.add(actionRequest, "success");

		}
		else if (action.equals("deleteCustomer")) {
			long id = ParamUtil.getLong(actionRequest, "id");
			try {
				MyCustomerLocalServiceUtil.deleteMyCustomer(id);

			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			SessionMessages.add(actionRequest, "delete-success");
		}
		else if (action.equals("updateCustomer")) {
			System.out.println("update customer action");
			long id = ParamUtil.getLong(actionRequest, "custId");
			System.out.println("Id :" + id);
			String name = ParamUtil.getString(actionRequest, "name");
			String address = ParamUtil.getString(actionRequest, "address");
			MyCustomer customer;
			try {
				customer = MyCustomerLocalServiceUtil.getMyCustomer(id);
				customer.setName(name);
				customer.setAddress(address);
				MyCustomerLocalServiceUtil.updateMyCustomer(customer, true);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			SessionMessages.add(actionRequest, "update-success");

		}
		super.processAction(actionRequest, actionResponse);
	}

}

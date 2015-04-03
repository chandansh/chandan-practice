package com.coleg;

import java.io.IOException;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.coleg.model.Customer;
import com.coleg.service.CustomerLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CustomerPortlet
 */
public class CustomerPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		System.out.println("[do View] of customerPortlet is called..");
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("[process Action] of customerPortlet is called...");
		String name = ParamUtil.getString(actionRequest, "cname");
		String company = ParamUtil.getString(actionRequest, "company");
		String address = ParamUtil.getString(actionRequest, "caddress");
		System.out.println(name + "\t" + company + "\t" + address);
		Random r = new Random();
		int id = r.nextInt(1000);
		try {
			Customer cust = CustomerLocalServiceUtil
					.createCustomer("cust" + id);
			cust.setName(name);
			cust.setAddress(address);
			cust.setCompany(company);
			CustomerLocalServiceUtil.addCustomer(cust);
			System.out.println("new customer added.. with id: cust" + id);
		} catch (Exception e) {

		}
		super.processAction(actionRequest, actionResponse);
	}
}

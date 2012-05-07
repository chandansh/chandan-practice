
package com.mpower.training.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mpoer.training.customer.model.Customer;
import com.mpoer.training.customer.service.CustomerLocalServiceUtil;

public class CustomerPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		System.out.println("inside do view");
		CustomerLocalServiceUtil.deactivateCustomer(1234);
		Customer cust;
		try {
			// cust = CustomerLocalServiceUtil.findByName("HP");
			//
			// if (cust != null) {
			// System.out.print("\nCustomer found Id :" + cust.getId() +
			// " Name :" + cust.getName() + " Address :" +
			// cust.getAddress());
			// }
			//
			// Customer cust1 =
			// CustomerLocalServiceUtil.findByNameAndAddress("HP", "Bangalore");
			// if (cust1 != null) {
			// System.out.print("\nCustomer found Id :" + cust1.getId() +
			// " Name :" + cust1.getName() + " Address :" +
			// cust1.getAddress());
			// System.out.println("\n" + cust1.getDetails());
			// }
			// else {
			// System.out.print("customer not found");
			//
			// }
			List<Customer> customers = CustomerLocalServiceUtil.getCustomers(0, 100);
			renderRequest.setAttribute("customers", customers);
		}
		// catch (NoSuchCustomerException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		System.out.println("inside process action");

		String action = ParamUtil.getString(actionRequest, "action");
		if (action.equals("create")) {
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			long id = ParamUtil.getLong(actionRequest, "id");
			String name = ParamUtil.getString(actionRequest, "name");
			String address = ParamUtil.getString(actionRequest, "address");
			Date inductionDate = ParamUtil.getDate(actionRequest, "inductionDate", s);
			System.out.println("InductionDate: " + inductionDate);
			Customer customer = CustomerLocalServiceUtil.createCustomer(id);
			customer.setName(name);
			customer.setAddress(address);
			customer.setInductionDate(inductionDate);
			try {
				CustomerLocalServiceUtil.updateCustomer(customer);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			SessionMessages.add(actionRequest, "success");
		}
		else if (action.equals("delete")) {
			long id = ParamUtil.getLong(actionRequest, "id");
			try {
				CustomerLocalServiceUtil.deleteCustomer(id);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			SessionMessages.add(actionRequest, "delete-success");
		}
		else if (action.equals("update")) {
			long id = ParamUtil.getLong(actionRequest, "id");
			String name = ParamUtil.getString(actionRequest, "name");
			String address = ParamUtil.getString(actionRequest, "address");
			try {
				Customer customer = CustomerLocalServiceUtil.getCustomer(id);
				customer.setName(name);
				customer.setAddress(address);
				CustomerLocalServiceUtil.updateCustomer(customer);
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

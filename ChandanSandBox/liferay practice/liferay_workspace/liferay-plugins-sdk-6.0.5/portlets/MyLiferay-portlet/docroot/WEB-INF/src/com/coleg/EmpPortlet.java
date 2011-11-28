package com.coleg;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.coleg.model.Employee;
import com.coleg.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EmpPortlet
 */
public class EmpPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		System.out.println("[doView] called.");
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println("[processAction] called...");
		String name = actionRequest.getParameter("name");
		String address = ParamUtil.getString(actionRequest, "address");
		String id = getRandomID(5);
		System.out.println("Emp Name :" + name);
		System.out.println("Emp Address :" + address);
		try {

			Employee e = EmployeeLocalServiceUtil.createEmployee(id);
			e.setName(name);
			e.setAddress(address);

			EmployeeLocalServiceUtil.addEmployee(e);

			// EmployeeLocalServiceUtil.updateEmployee(e);
			System.out.println("Employee added...");
			actionResponse.setRenderParameter("empid", id);

			List<Employee> emp = EmployeeLocalServiceUtil.getEmployees(
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			System.out.println("List: " + emp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		super.processAction(actionRequest, actionResponse);
	}

	private String getRandomID(int length) {
		final String GUID_CHARS = "0123456789abcdef";
		final int GUID_NUM_CHARS = GUID_CHARS.length();

		Random r = new Random();
		char[] v = new char[length];

		int idx;
		for (int i = 0; i < length; i++) {

			idx = r.nextInt(GUID_NUM_CHARS);
			v[i] = GUID_CHARS.charAt(idx);
		}

		return new String(v);

	}

}

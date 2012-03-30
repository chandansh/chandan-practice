
package com.mpower.training.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.mpower.training.dbutil.SalesOrderUtil;
import com.mpower.training.model.SalesOrder;

public class OrderPortlet implements Portlet {

	private PortletContext context;
	private boolean salesOrderSaved = false;

	@Override
	public void destroy() {

		System.out.println("destroy is executed.");

	}

	@Override
	public void init(PortletConfig config)
		throws PortletException {

		System.out.println("init is executed");
		context = config.getPortletContext();
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException, IOException {

		System.out.println("process action is executed.");

		if (actionRequest.getPortletMode() == PortletMode.EDIT) {
			savePreferences(actionRequest, actionResponse);
		}
		else {
			// System.out.println("company name is :" +
			// actionRequest.getParameter("companyName") +
			// " using process action");
			saveSalesOrder(actionRequest, actionResponse);

		}

	}

	private void saveSalesOrder(ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException, IOException {

		String orderId = actionRequest.getParameter("orderId");
		String customer = actionRequest.getParameter("customer");
		int amount = Integer.parseInt(actionRequest.getParameter("amount"));
		SalesOrder order = new SalesOrder(orderId, customer, amount);
		salesOrderSaved = SalesOrderUtil.save(order);
		if (salesOrderSaved)
			System.out.println("Sales order saved successfully salesOrder id: " + orderId);

	}

	private void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException, IOException {

		String displayStyle = actionRequest.getParameter("displayStyle");
		System.out.println("Your display mode is: " + displayStyle);

		PortletPreferences preferences = actionRequest.getPreferences();
		// String preDisplayStyle=preferences.getValue(arg0, arg1)

		preferences.setValue("displayStyle", displayStyle);
		preferences.store();

	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, IOException {

		System.out.println("render is executed.");
		System.out.println("Window state :" + renderRequest.getWindowState());

		// System.out.println("company name is :"
		// + renderRequest.getParameter("companyName"));
		PortletMode curMode = renderRequest.getPortletMode();
		if (curMode == PortletMode.EDIT) {
			PortletRequestDispatcher dispatcher = context.getRequestDispatcher("/edit.jsp");
			dispatcher.include(renderRequest, renderResponse);
		}
		else if (curMode == PortletMode.HELP) {
			PortletRequestDispatcher dispatcher = context.getRequestDispatcher("/help.jsp");
			dispatcher.include(renderRequest, renderResponse);
		}
		else {
			PrintWriter out = renderResponse.getWriter();
			out.print("Chandan Sharma");
			
			if (salesOrderSaved) {
				out.print("<h3>Successfully saved</h3>");
			}
			List<SalesOrder> list = SalesOrderUtil.getAll();
			for(SalesOrder item:list)
			{
			//out.print(item.getOrderId()+" "+item.getCustomer()+" "+item.getAmount()+"<br>");	
			}

			renderRequest.setAttribute("orderList", list);
			PortletRequestDispatcher dispatcher = context.getRequestDispatcher("/view.jsp");
			dispatcher.include(renderRequest, renderResponse);

		}

	}
}

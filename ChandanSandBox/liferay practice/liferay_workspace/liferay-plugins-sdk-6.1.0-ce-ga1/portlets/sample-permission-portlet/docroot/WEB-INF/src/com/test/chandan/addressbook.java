package com.test.chandan;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.test.slayer.model.Address;
import com.test.slayer.service.AddressLocalServiceUtil;

/**
 * Portlet implementation class addressbook
 */
public class addressbook extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// Address
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			long addId = ParamUtil.getLong(actionRequest, "addId");
			String address = ParamUtil.getString(actionRequest, "address");
			String city = ParamUtil.getString(actionRequest, "city");
			Address add = AddressLocalServiceUtil.createAddress(addId);
			add.setAddress(address);
			add.setCity(city);

			AddressLocalServiceUtil.updateAddress(add);

			String redirect = ParamUtil.getString(actionRequest, "redirectURL");
			actionResponse.sendRedirect(redirect);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

}

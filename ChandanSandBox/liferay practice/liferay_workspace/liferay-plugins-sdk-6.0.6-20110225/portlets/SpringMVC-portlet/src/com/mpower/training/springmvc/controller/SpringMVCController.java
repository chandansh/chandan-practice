package com.mpower.training.springmvc.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

@Controller
@RequestMapping("VIEW")
public class SpringMVCController {

	@RequestMapping
	public String theViewMethod(RenderRequest request, RenderResponse response) {
		System.out.println("In theViewMethod.....");
		return "view";
	}

	@RequestMapping(params = "action=to_create")
	public String toCreateCustomer(RenderRequest request,
			RenderResponse response) {
		System.out.println("In toCreateCustomer.....");
		return "create_customer";
	}

	@RequestMapping(params = "action=to_browse")
	public String toBrowseCustomer(RenderRequest request,
			RenderResponse response) {
		System.out.println("In toBrowseCustomer.....");
		return "browse_customers";
	}

	@RequestMapping
	public void processAction(ActionRequest request, ActionResponse response)
			throws SystemException {
		System.out.println("inside process action");
		String name = ParamUtil.getString(request, "name");
		String address = ParamUtil.getString(request, "address");
		System.out.println("Name : " + name + "\t" + "address : " + address);
	}

}

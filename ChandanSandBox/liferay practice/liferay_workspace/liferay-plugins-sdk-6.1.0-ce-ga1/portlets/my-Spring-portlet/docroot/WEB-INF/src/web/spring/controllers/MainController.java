package web.spring.controllers;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.util.ParamUtil;

@Controller
@RequestMapping("VIEW")
public class MainController {
	@RenderMapping
	public String setModelAndView(RenderRequest renderRequest, RenderResponse renderResponse) {
		String dcl = ParamUtil.getString(renderRequest, "dcl");
		System.out.println("dcl value:"+ dcl);
		renderRequest.setAttribute("dcl", dcl);
		return "home";
	}

	@ActionMapping
	public void handleAction(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		String dcl = ParamUtil.getString(actionRequest, "dcl");
		System.out.println("dcl value:"+ dcl);
		actionResponse.setRenderParameter("dcl", dcl);
		
	}
}

package com.liferay.portlet.shopping.action;

import java.io.File;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.shopping.CategoryNameException;
import com.liferay.portlet.shopping.NoSuchCategoryException;
import com.liferay.portlet.shopping.model.ShoppingCategory;
import com.liferay.portlet.shopping.service.ShoppingCategoryServiceUtil;
import com.slayer.model.ShoppingCategoryExt;
import com.slayer.service.ShoppingCategoryExtLocalServiceUtil;


public class EditCategoryAction2 extends BaseStrutsPortletAction{
	public void processAction(
			 StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)  
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		System.out.println("in process action");
		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateCategory(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteCategory(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof NoSuchCategoryException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.shopping.error");
			}
			else if (e instanceof CategoryNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}
	
	protected void sendRedirect(
			ActionRequest actionRequest, ActionResponse actionResponse,
			String redirect)
		throws IOException {
		System.out.println("in send redirect");
		if (SessionErrors.isEmpty(actionRequest)) {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			LayoutTypePortlet layoutTypePortlet =
				themeDisplay.getLayoutTypePortlet();

			boolean hasPortletId = false;

			String portletId = (String)actionRequest.getAttribute(
				WebKeys.PORTLET_ID);

			try {
				hasPortletId = layoutTypePortlet.hasPortletId(portletId);
			}
			catch (Exception e) {
			}

			Portlet portlet = PortletLocalServiceUtil.getPortletById(portletId);

			if (hasPortletId || portlet.isAddDefaultResource()) {
				addSuccessMessage(actionRequest, actionResponse);
			}
		}

		if (Validator.isNull(redirect)) {
			redirect = (String)actionRequest.getAttribute(WebKeys.REDIRECT);
		}

		if (Validator.isNull(redirect)) {
			redirect = ParamUtil.getString(actionRequest, "redirect");
		}

		if (Validator.isNotNull(redirect)) {

			// LPS-1928

			HttpServletRequest request = PortalUtil.getHttpServletRequest(
				actionRequest);

			if ((BrowserSnifferUtil.isIe(request)) &&
				(BrowserSnifferUtil.getMajorVersion(request) == 6.0) &&
				(redirect.contains(StringPool.POUND))) {

				String redirectToken = "&#";

				if (!redirect.contains(StringPool.QUESTION)) {
					redirectToken = StringPool.QUESTION + redirectToken;
				}

				redirect = StringUtil.replace(
					redirect, StringPool.POUND, redirectToken);
			}

			redirect = PortalUtil.escapeRedirect(redirect);

			if (Validator.isNotNull(redirect)) {
				actionResponse.sendRedirect(redirect);
			}
		}
	}
	protected void addSuccessMessage(
			ActionRequest actionRequest, ActionResponse actionResponse) {

			PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

			boolean addProcessActionSuccessMessage = GetterUtil.getBoolean(
				portletConfig.getInitParameter("add-process-action-success-action"),
				true);

			if (!addProcessActionSuccessMessage) {
				return;
			}

			String successMessage = ParamUtil.getString(
				actionRequest, "successMessage");

			SessionMessages.add(actionRequest, "request_processed", successMessage);
		}
	protected void sendRedirect(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException {

		sendRedirect(actionRequest, actionResponse, null);
	}

	protected void setForward(PortletRequest portletRequest, String forward) {
		portletRequest.setAttribute(getForwardKey(portletRequest), forward);
	}  
	public static String getForwardKey(PortletRequest portletRequest) {
		String portletId = (String)portletRequest.getAttribute(
			WebKeys.PORTLET_ID);

		String portletNamespace = PortalUtil.getPortletNamespace(portletId);

		return portletNamespace.concat("PORTLET_STRUTS_FORWARD");
	}
	
	public String render( StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		return originalStrutsPortletAction.render( null, portletConfig, renderRequest, renderResponse); 
	}  

	protected String getForward(PortletRequest portletRequest) {
		return getForward(portletRequest, null);
	}
	protected String getForward(
			PortletRequest portletRequest, String defaultValue) {

			String forward = (String)portletRequest.getAttribute(
				getForwardKey(portletRequest));

			if (forward == null) {
				return defaultValue;
			}
			else {
				return forward;
			}
		}
	protected void deleteCategory(ActionRequest actionRequest)
		throws Exception {
		System.out.println("in delete category");

		long categoryId = ParamUtil.getLong(actionRequest, "categoryId");

		ShoppingCategoryServiceUtil.deleteCategory(categoryId);
	}
	
	protected void updateCategory(ActionRequest actionRequest)
			throws Exception {

		long categoryId = ParamUtil.getLong(actionRequest, "categoryId");

		long parentCategoryId = ParamUtil.getLong(
			actionRequest, "parentCategoryId");
		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");

		boolean mergeWithParentCategory = ParamUtil.getBoolean(
			actionRequest, "mergeWithParentCategory");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			ShoppingCategory.class.getName(), actionRequest);

		if (categoryId <= 0) {

			// Add category

			ShoppingCategory shoppingCategory = ShoppingCategoryServiceUtil.addCategory(
				parentCategoryId, name, description, serviceContext);
			
			categoryId = shoppingCategory.getCategoryId();
		}
		else {

			// Update category

			ShoppingCategoryServiceUtil.updateCategory(
				categoryId, parentCategoryId, name, description,
				mergeWithParentCategory, serviceContext);
		}
		
		ShoppingCategoryExt shoppingCategoryExt = null;
		if (categoryId > 0) {
			shoppingCategoryExt = ShoppingCategoryExtLocalServiceUtil.fetchShoppingCategoryExt(categoryId);
		}
		
		if (Validator.isNull(shoppingCategoryExt)) {
			shoppingCategoryExt = ShoppingCategoryExtLocalServiceUtil.createShoppingCategoryExt(categoryId);
		}
		
		String imageURL = ParamUtil.getString(actionRequest, "smallImageURL");

		shoppingCategoryExt.setImageURL(imageURL);
		
		UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);
		
		File file = uploadPortletRequest.getFile("smallFile");
		
		if (file != null) {
			long imageId = shoppingCategoryExt.getImageId();
			
			if (imageId <= 0l) {
				imageId = CounterLocalServiceUtil.increment();
			}
			
			ImageLocalServiceUtil.updateImage(imageId, file);
			
			shoppingCategoryExt.setImageId(imageId);
		}
		
		ShoppingCategoryExtLocalServiceUtil.updateShoppingCategoryExt(shoppingCategoryExt);
	}
}
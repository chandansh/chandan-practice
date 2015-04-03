package com.shopping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.shopping.model.CartItem;

/**
 * Portlet implementation class ShoppingPortlet
 */
public class MiniCartPortlet extends MVCPortlet {

	public void removeFromCart(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		HttpSession session = PortalUtil.getHttpServletRequest(actionRequest).getSession();

		@SuppressWarnings("unchecked")
		Map<Long, CartItem> items = (HashMap<Long, CartItem>) session.getAttribute("USER_CART_ITEMS");
		
		if (Validator.isNotNull(items)) {
			long itemId = ParamUtil.getLong(actionRequest, "itemId");
			items.remove(itemId);
			System.out.println("Item removed...");
		}
	}
}

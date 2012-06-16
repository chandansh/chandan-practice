package com.shopping;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.shopping.model.ShoppingCart;
import com.liferay.portlet.shopping.model.ShoppingCategory;
import com.liferay.portlet.shopping.model.ShoppingItem;
import com.liferay.portlet.shopping.service.ShoppingCategoryLocalServiceUtil;
import com.liferay.portlet.shopping.service.ShoppingItemLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.shopping.model.CartItem;
import com.util.CartUtil;

/**
 * Portlet implementation class ShoppingPortlet
 */
public class ShoppingPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// System.out.println("HELLO,,");
		long itemId = ParamUtil.getLong(request, "itemId");

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		// String viewTemplate ="";
		long groupId = themeDisplay.getScopeGroupId();

		if (Validator.isNull(itemId)) {

			long parentCategoryId = ParamUtil.getLong(request,
					"parentCategoryId");

			try {
				List<ShoppingCategory> categories = ShoppingCategoryLocalServiceUtil
						.getCategories(groupId, parentCategoryId, 0, -1);

				if (categories != null && categories.size() > 0) {
					request.setAttribute("CATEGORIES", categories);
				}

			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				List<ShoppingItem> items = ShoppingItemLocalServiceUtil
						.getItems(groupId, parentCategoryId);
				if (items != null && items.size() > 0) {
					request.setAttribute("ITEMS", items);
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			viewTemplate = "/html/donate-now/view.jsp";

		} else {
			// System.out.println("item Id ==> " + itemId);
			request.setAttribute("ITEM_ID", String.valueOf(itemId));
			viewTemplate = "/html/donate-now/item-details.jsp";
		}

		super.render(request, response);
	}

	public void addToCart(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		System.out.println("Inside add To Cart.....");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		if (themeDisplay.isSignedIn()) {
			System.out.println("user is signed in....");

			ShoppingCart shoppingCart = CartUtil.getCart(themeDisplay);

		} else {
			System.out.println("user is NOT signed in....");
			
			CartUtil.addToCart(actionRequest);
		}
	}
}
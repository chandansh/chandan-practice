package com.util;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpSession;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.shopping.NoSuchCartException;
import com.liferay.portlet.shopping.model.ShoppingCart;
import com.liferay.portlet.shopping.service.ShoppingCartLocalServiceUtil;
import com.shopping.model.CartItem;

public class CartUtil {
	public static ShoppingCart getCart(ThemeDisplay themeDisplay) {
		
		ShoppingCart shoppingCart = null;
		
		User user = themeDisplay.getUser();
		
		try {
			shoppingCart = ShoppingCartLocalServiceUtil.getCart(user.getUserId(), themeDisplay.getScopeGroupId());
			
			System.out.println("This user already got a cart...." + shoppingCart);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			if (e instanceof NoSuchCartException) {
				
				long cartId = 0l;
				try {
					cartId = CounterLocalServiceUtil.increment();
				} catch (SystemException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				shoppingCart = ShoppingCartLocalServiceUtil.createShoppingCart(cartId);
				
				shoppingCart.setUserId(user.getUserId());
				shoppingCart.setUserName(user.getFullName());
				shoppingCart.setGroupId(themeDisplay.getScopeGroupId());
				shoppingCart.setCompanyId(user.getCompanyId());
				shoppingCart.setCreateDate(new java.util.Date());

				try {
					shoppingCart = ShoppingCartLocalServiceUtil.updateShoppingCart(shoppingCart);
				} catch (SystemException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return shoppingCart;
	}
	
	public static void addToCart(PortletRequest portletRequest) {
		HttpSession session = PortalUtil.getHttpServletRequest(portletRequest).getSession();

		@SuppressWarnings("unchecked")
		Map<Long, CartItem> items = (HashMap<Long, CartItem>) session.getAttribute("USER_CART_ITEMS");
		
		System.out.println("items ==> " + items);

		if (Validator.isNull(items)) {
			items = new HashMap<Long, CartItem>();

			session.setAttribute("USER_CART_ITEMS", items);
		}

		long itemId = ParamUtil.getLong(portletRequest, "itemIds");
		int qty = ParamUtil.getInteger(portletRequest, "qty");
		int price = ParamUtil.getInteger(portletRequest, "price");

		CartItem value = new CartItem(qty, price);
		if (itemId > 0l) {
			if (items.containsKey(itemId)) {
				value = items.get(itemId);
				value.setQty(value.getQty() + qty);
				value.setPrice(price);
			} else {
				items.put(itemId, value);
			}
		}
	}
}
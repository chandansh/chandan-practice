package com.util;

import java.util.List;

import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.shopping.model.ShoppingCategory;
import com.liferay.portlet.shopping.model.ShoppingItem;
import com.liferay.portlet.shopping.service.ShoppingCategoryLocalServiceUtil;
import com.liferay.portlet.shopping.service.ShoppingItemLocalServiceUtil;

public class NavigationUtil {
	
	private static ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();
	
	public static String getTree(long parentCategoryId, ThemeDisplay themeDisplay, PortletURL url) {
		StringBuffer sb = new StringBuffer();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ShoppingCategory.class, classLoader);
		dynamicQuery.add(PropertyFactoryUtil.forName("parentCategoryId").eq(parentCategoryId));
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		
		try {
			List<ShoppingCategory> categories = ShoppingCategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			if (categories != null && categories.size() > 0) {
				for (ShoppingCategory category : categories) {
					sb.append("<li>");
					sb.append("<span>" + category.getName() + "</span>");
					sb.append("<ul id=\"" + category.getCategoryId() + "\">");					
					sb.append(getTree(category.getCategoryId(), themeDisplay, url));
					sb.append(getItems(category.getCategoryId(), themeDisplay, url));
					sb.append("</ul>");
					sb.append("</li>");
				}
			}
			if(parentCategoryId == 0){
				sb.append(getItems(parentCategoryId, themeDisplay, url));
			}
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	private static String getItems(long categoryId, ThemeDisplay themeDisplay, PortletURL url) {
		
		StringBuffer sb = new StringBuffer();
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ShoppingItem.class, classLoader);
		dynamicQuery.add(PropertyFactoryUtil.forName("categoryId").eq(categoryId));
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		
		try {
			List<ShoppingItem> items = ShoppingItemLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			if (items != null && items.size() > 0) {
				for (ShoppingItem item: items) {
					url.setParameter("itemId", String.valueOf(item.getItemId()));
					sb.append("<li>");
					sb.append("<a href='"+ url +"'><span>" + item.getName() + "</span></a>");
					sb.append("</li>");
				}
			}
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sb.toString() + "@@@@@@@@@@@");
		
		return sb.toString();
		
	}
}

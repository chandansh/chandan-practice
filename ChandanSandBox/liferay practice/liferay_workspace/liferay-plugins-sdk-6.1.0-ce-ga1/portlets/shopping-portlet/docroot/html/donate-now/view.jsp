<%@page import="java.util.HashMap"%>
<%@page import="com.shopping.model.CartItem"%>
<%@page import="java.util.Map"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portlet.shopping.service.ShoppingCategoryLocalServiceUtil"%>
<%@ include file="/html/init.jsp" %>

<%
	List<ShoppingCategory> categories = (List<ShoppingCategory>)request.getAttribute("CATEGORIES");

	List<ShoppingItem> items = (List<ShoppingItem>)request.getAttribute("ITEMS");
	
	PortletURL fetchURL = renderResponse.createRenderURL();
	
	fetchURL.setParameter("backURL", themeDisplay.getURLCurrent());
	
	long parentCategoryId = ParamUtil.getLong(request, "parentCategoryId");
%>

<c:if test="<%= parentCategoryId > 0 %>">
	<%
		String backURL = ParamUtil.getString(request, "backURL");
	
		ShoppingCategory parentCategory = ShoppingCategoryLocalServiceUtil.fetchShoppingCategory(parentCategoryId);
	%>
	<liferay-ui:header
		backLabel="&laquo; One Level Up" 
		title="<%= parentCategory.getName() %>" 
		backURL="<%= backURL %>"
	/>
</c:if>

<c:if test="<%= (categories != null && !categories.isEmpty()) %>">
	<h2>Categories</h2>
	<table border="1px">
		<%
			for (ShoppingCategory category: categories) {
				long categoryId = category.getCategoryId();	
				%>
					<tr>
						<%
							fetchURL.setParameter("parentCategoryId", String.valueOf(categoryId));
						%>
						<td><a href="<%= fetchURL.toString() %>"><%= category.getName() %></a></td>
						<td><%= category.getDescription() %></td>
					</tr>
				<%
			}
		%>
	</table>
</c:if>

<c:if test="<%= (items != null && !items.isEmpty()) %>">
	<h2>Items</h2>
	<table border="1px">
		<%
			for (ShoppingItem item: items) {
				long itemId = item.getItemId();	
				%>
					<tr>
						<%
							fetchURL.setParameter("itemId", String.valueOf(itemId));
						%>
						<td><a href="<%= fetchURL.toString() %>"><%= item.getName() %></a></td>
						<td><%= item.getDescription() %></td>
					</tr>
				<%
			}
		%>
	</table>
</c:if>

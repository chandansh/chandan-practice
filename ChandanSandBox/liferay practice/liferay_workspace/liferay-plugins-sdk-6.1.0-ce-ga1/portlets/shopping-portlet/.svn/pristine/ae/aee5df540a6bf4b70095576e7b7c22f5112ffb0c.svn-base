<%@ include file="/html/init.jsp" %>

<%@ page import="com.liferay.portlet.shopping.service.ShoppingItemLocalServiceUtil" %>

<%
	long itemId = ParamUtil.getLong(request, "itemId");

	ShoppingItem item = ShoppingItemLocalServiceUtil.fetchShoppingItem(itemId);
	
	String backURL = ParamUtil.getString(request, "backURL");
	
	PortletURL addToCartURL = renderResponse.createActionURL();
	addToCartURL.setParameter(ActionRequest.ACTION_NAME, "addToCart");
%>

<liferay-ui:header
	backLabel="&laquo; Back to List" 
	title="<%= item.getName() %>" 
	backURL="<%= backURL %>"
/>
<%-- ID:<%=itemId %>
Price:<%=item.getPrice() %>
Qty:<%=item.getMinQuantity() %> --%>
<aui:form action="<%= addToCartURL %>" name="fm" method="POST">
<aui:input name="itemIds" value="<%= itemId%>" type="hidden" ></aui:input>
<aui:input name="qty" label="Quantity" ></aui:input>
<aui:input name="price" label="Price" ></aui:input>
	<aui:button type="submit" value="Add To Cart"/>
</aui:form>


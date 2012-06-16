<%@page import="java.io.File"%>
<%@ include file="/html/init.jsp"%>

<%@page import="com.liferay.portlet.shopping.service.ShoppingItemLocalServiceUtil"%>
<%@page import="com.liferay.portlet.shopping.model.ShoppingItem"%>
<%@page import="com.liferay.portlet.shopping.model.ShoppingCart"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.shopping.model.CartItem"%>

<%
	Map<Long, CartItem> items = (HashMap<Long, CartItem>) session.getAttribute("USER_CART_ITEMS");

	String slash = File.separator;

	String deleteIcon = themeDisplay.getTheme().getImagesPath() + slash + "application" + slash + "close.png";
%>

<c:choose>
	<c:when test="<%= (items != null && !items.isEmpty()) %>">
		<%	
			SearchContainer searchContainer = new SearchContainer();
		
			Iterator itr = items.entrySet().iterator();
			
			List<String> headerNames = new ArrayList<String>();
			
			headerNames.add("Item");
			headerNames.add("Qty");
			headerNames.add("Price");
			headerNames.add("<img src=" + deleteIcon + ">");
			
			searchContainer.setHeaderNames(headerNames);
			
			searchContainer.setHover(false);
			int total = items.size();
			
			searchContainer.setTotal(total);
			
			List<ResultRow> resultRows = searchContainer.getResultRows();
			
			PortletURL deleteItemURL = renderResponse.createActionURL();
			deleteItemURL.setParameter(ActionRequest.ACTION_NAME,"removeFromCart");
			
			int i = 0;
			int totalItems = 0;
			int totalAmount = 0;
			while (itr.hasNext()) {
				Map.Entry<Long, CartItem> pairs = (Map.Entry<Long, CartItem>) itr.next();
				CartItem cartItem = (CartItem) pairs.getValue();
			
				ResultRow row = new ResultRow((CartItem) pairs.getValue(),
						Long.parseLong(pairs.getKey().toString()), i++);
				ShoppingItem shoppingItem = ShoppingItemLocalServiceUtil
						.fetchShoppingItem(Long.parseLong(pairs.getKey()
								.toString()));
				row.addText(shoppingItem.getName());
				row.addText(Integer.toString(cartItem.getQty()));
				row.addText(Integer.toString(cartItem.getPrice()));
			
				deleteItemURL.setParameter("itemId", String.valueOf(pairs.getKey()));
			
				String removeLink = "<a href=\"" + deleteItemURL.toString() + "\">" + "<img src=" + deleteIcon + ">" + "</a>";
				row.addText(removeLink);  
				
				resultRows.add(row);
				
				totalItems += cartItem.getQty();
				totalAmount += cartItem.getPrice();
			}
			
		%>
		<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="<%=false%>" />
		<br/>
		Total items: <%= totalItems %>  Amount: <%= totalAmount %>
	</c:when>
	<c:otherwise>Your cart is empty. Please add your subscriptions.</c:otherwise>
</c:choose>
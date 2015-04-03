<%@page import="com.test.slayer.service.AddressLocalServiceUtil"%>
<%@page import="com.test.slayer.model.Address"%>
<%@page import="com.liferay.portal.security.permission.PermissionCheckerFactoryUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/addressbook/init.jsp" %>

<h1>List of books in our Library</h1>

<%
	int count = AddressLocalServiceUtil.getAddressesCount();
	List<Address> addresses = AddressLocalServiceUtil.getAddresses(0, count);
%>

<%-- 
<table border="1" width="80%">
	<tr>
		<th>Book Title</th>
		<th>Author</th>
		<th>Date Added</th>
	</tr>
	
	<% 
		for (LMSBook book : books) {
			%>
				<tr>
					<td><%= book.getBookTitle() %></td>
					<td><%= book.getAuthor() %></td>
					<td><%= book.getDateAdded() %></td>
				</tr>
			<%
		}
	%>
</table>
--%>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/html/addressbook/list.jsp");
	
	PortletURL deleteBookURL = renderResponse.createActionURL();
	deleteBookURL.setParameter(ActionRequest.ACTION_NAME, "deleteBook");
	deleteBookURL.setParameter("redirectURL", iteratorURL.toString());
	
	PortletURL detailsURL = renderResponse.createRenderURL();
	detailsURL.setParameter("jspPage", "/html/addressbook/details.jsp");
%>

<liferay-ui:search-container delta="4" iteratorURL="<%= iteratorURL %>" 
	emptyResultsMessage="Sorry. There are no items to display.">

	<liferay-ui:search-container-results 
		total="<%= addresses.size() %>"
		results="<%= ListUtil.subList(addresses, searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>
		
	<liferay-ui:search-container-row modelVar="address" 
		className="com.test.slayer.model.Address">
		
		<% 
			detailsURL.setParameter("addId", String.valueOf(address.getAddId()));
			detailsURL.setParameter("backURL", themeDisplay.getURLCurrent());
		%>
		<liferay-ui:search-container-column-text name="Address">
			<aui:a href="<%= detailsURL.toString() %>"><%= address.getAddress() %></aui:a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="city" property="city" />
		<liferay-ui:search-container-column-text name="state" property="state" />
		<liferay-ui:search-container-column-text name="pin" property="pin" />
		
		<liferay-ui:search-container-column-jsp name="Actions" 
			path="/html/addressbook/actions.jsp" />
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

</liferay-ui:search-container>

<br/><a href="<portlet:renderURL/>">&laquo; Go Back</a>
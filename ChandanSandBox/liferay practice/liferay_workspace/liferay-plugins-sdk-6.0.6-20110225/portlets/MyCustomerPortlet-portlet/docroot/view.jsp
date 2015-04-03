<%@page
	import="com.mpower.training.customer.service.MyCustomerLocalServiceUtil"%>
<%@page import="com.mpower.training.customer.model.MyCustomer"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />
<%
	PortletURL newCustomerURL = renderResponse.createRenderURL();
	newCustomerURL.setParameter("action", "newCustomer");

	PortletURL deleteURL = renderResponse.createActionURL();
	deleteURL.setParameter("action", "deleteCustomer");
	
	PortletURL editURL = renderResponse.createRenderURL();
	editURL.setParameter("action", "editCustomer");
%>

<h2>Customer Management Application</h2>
You can add, delete or update customer related stuff from this portlet.
<br>
<liferay-ui:success key="success" message="Customer saved successfully!" />
<liferay-ui:success key="delete-success" message="Customer deleted successfully!" />
<liferay-ui:success key="update-success" message="Customer updated successfully!" />
<a href="<%=newCustomerURL%>">Add New Customer</a><br>

<table border="1" style="width: 90%">
	<tr>
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Customer Address</th>
	</tr>

	<%
		List<MyCustomer> customers = MyCustomerLocalServiceUtil.getMyCustomers(0, 100);
		for (MyCustomer customer : customers) {
			deleteURL.setParameter("id", String.valueOf(customer.getId()));
			editURL.setParameter("id", String.valueOf(customer.getId()));
	%>
	<tr>
		<td><%=customer.getId()%></td>
		<td><%=customer.getName()%></td>
		<td><%=customer.getAddress()%></td>
		<td><a href="<%=deleteURL%>">delete</a>&nbsp;&nbsp;<a href="<%=editURL%>">Edit</a></td>
	</tr>
	<%
		}
	%>
</table>



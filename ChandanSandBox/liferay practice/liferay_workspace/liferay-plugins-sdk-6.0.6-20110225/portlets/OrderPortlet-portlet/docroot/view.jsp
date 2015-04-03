<%@page import="com.mpower.training.model.SalesOrder"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Date"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<%
	//PortletURL url= renderResponse.createRenderURL();
	PortletURL url = renderResponse.createActionURL();
%>
This is the
<b>Order Portlet</b>
Enter the Order Details.
<hr>

<aui:form action="<%=url%>" method="post">
	<aui:input name="orderId" value="Enter order Id" label="Order Id" />
	<aui:input name="customer" value="Enter customer Name" label="Customer" />
	<aui:input name="amount" value="0" label="Amount" />
	<aui:button type="submit" value="save" />
</aui:form>

<table border="1">
<tr>
<th>Order Id</th>
<th>Customer</th>
<th>Amount</th>
</tr>
<%
	List<SalesOrder> list = (List<SalesOrder>) renderRequest.getAttribute("orderList");
	for (SalesOrder item : list) 
	{
		
		out.print("<tr><td>"+item.getOrderId() + "</td><td>" + item.getCustomer() + "</td><td>" + item.getAmount() + "</td></tr>");
	}
%>
</table>

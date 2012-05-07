<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />
<portlet:actionURL var="actionUrl" />
<%
	PortletURL listCustomerURL = renderResponse.createRenderURL();
%>
<h2>Add new Customer</h2>
<a href="<%=listCustomerURL%>">Back to List</a><br>
<aui:form action="<%=actionUrl%>" method="post">
	<aui:input name="name" label="Customer Name"></aui:input>
	<aui:input name="address" label="Customer Address"></aui:input>
	<aui:input name="action" type="hidden" value="newCustomer"></aui:input>
	<br>
	<aui:button type="submit" vaule="submit"></aui:button>
</aui:form>
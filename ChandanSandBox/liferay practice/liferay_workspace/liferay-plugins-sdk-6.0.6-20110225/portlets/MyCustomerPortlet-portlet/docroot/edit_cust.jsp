<%@page
	import="com.mpower.training.customer.service.MyCustomerLocalServiceUtil"%>
<%@page import="com.mpower.training.customer.model.MyCustomer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />
<portlet:actionURL var="actionUrl" />
<%
	PortletURL listCustomerURL = renderResponse.createRenderURL();
	long id = (Long) renderRequest.getAttribute("id");
	MyCustomer theCustomer = MyCustomerLocalServiceUtil.getMyCustomer(id);
%>
<h2>Update the Customer</h2>
<a href="<%=listCustomerURL%>">Back to List</a>
<br>
<aui:form action="<%=actionUrl%>" method="post">
	<aui:model-context bean="<%=theCustomer%>"
		model="<%=MyCustomer.class%>"></aui:model-context>
	<aui:input name="id" label="Customer Id" disabled="true"></aui:input>
	<aui:input name="custId" type="hidden"
		value="<%=theCustomer.getId() %>"></aui:input>
	<aui:input name="name" label="Customer Name"></aui:input>
	<aui:input name="address" label="Customer Address"></aui:input>
	<aui:input name="action" type="hidden" value="updateCustomer"></aui:input>
	<br>
	<aui:button type="submit" vaule="submit"></aui:button>
</aui:form>
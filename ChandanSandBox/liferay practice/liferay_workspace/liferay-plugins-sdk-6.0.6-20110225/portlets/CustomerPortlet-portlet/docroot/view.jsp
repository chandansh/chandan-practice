<%@page import="com.mpoer.training.customer.model.Customer"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false"%>
<%@page
	import="com.mpoer.training.customer.service.CustomerLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:actionURL var="actionUrl"></portlet:actionURL>
<portlet:defineObjects />

This is the
<b>Customer Portlet</b>
portlet.
<hr>
<%
	Customer theCustomer = null;
%>
<liferay-ui:success key="success" message="Customer saved successfully!" />
<liferay-ui:success key="delete-success" message="Customer deleted successfully!" />
<liferay-ui:success key="update-success" message="Customer updated successfully!" />
<hr>
<c:forEach items="${customers}" var="item">
	<h4>
		ID :
		<c:out value="${item.id}" />
		&nbsp;&nbsp;Name:
		<c:out value="${item.name}" />
	</h4>
</c:forEach>

<aui:form action="<%=actionUrl %>" method="post">
	<aui:model-context bean="<%=theCustomer%>" model="<%=Customer.class%>"></aui:model-context>
	<aui:input name="id" label="Customer Id"></aui:input>
	<aui:input name="name" label="Customer Name"></aui:input>
	<aui:input name="address" label="Address"></aui:input>
	<aui:input name="inductionDate" label="Induction Date"></aui:input>
	<aui:input name="action" type="hidden" value="create"></aui:input>
	<aui:button type="submit" value="submit"></aui:button>

</aui:form>
<hr>
<h2>Delete Customer Form</h2>
<aui:form action="<%=actionUrl %>" method="post">
	<aui:input name="id" label="Customer Id to Delete"></aui:input>
	<aui:input name="action" type="hidden" value="delete"></aui:input>
	<br>
	<aui:button type="submit" value="submit"></aui:button>
</aui:form>
<hr>
<h2>Update Customer Form</h2>
<aui:form action="<%=actionUrl %>" method="post">
	<aui:input name="id" label="Customer Id to Update"></aui:input>
	<aui:input name="name" label="Customer Name to Update"></aui:input>
	<aui:input name="address" label="Address to Update"></aui:input>
	<aui:input name="action" type="hidden" value="update"></aui:input>
	<br>
	<aui:button type="submit" value="submit"></aui:button>
</aui:form>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />


<liferay-ui:success key="success" message="Employee Added Successfully"/>
<liferay-ui:error key="error" message="Sorry, error Occured" />
Name : <%= renderRequest.getParameter("username") %>
<portlet:actionURL var="actionURL"></portlet:actionURL>
<aui:form action="<%=actionURL %>" method="post">
<aui:input  name="name" type="text" label="Name"/><br>
<aui:input type="text" name="add" label="Address"/><br>
<aui:input type="submit" name="Submit" value="Submit"/>
</aui:form>

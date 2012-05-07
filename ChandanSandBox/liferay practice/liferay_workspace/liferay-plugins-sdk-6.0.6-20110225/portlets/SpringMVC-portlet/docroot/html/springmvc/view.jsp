<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects/>
<%
PortletURL createURL= renderResponse.createRenderURL();
createURL.setParameter("action", "to_create");
PortletURL browseURL= renderResponse.createRenderURL();
browseURL.setParameter("action", "to_browse");
PortletURL actionURL= renderResponse.createActionURL();
%>
<h1>Hello Spring Portlet</h1>
<a href="<%=createURL%>">Create Customer</a><br>
<a href="<%=browseURL%>">Browse Customer</a><br>

<aui:form action="<%=actionURL%>" method="post">
<aui:input name="name"></aui:input>
<aui:input name="address"></aui:input>
<aui:button type="submit" value="save"></aui:button>
</aui:form>
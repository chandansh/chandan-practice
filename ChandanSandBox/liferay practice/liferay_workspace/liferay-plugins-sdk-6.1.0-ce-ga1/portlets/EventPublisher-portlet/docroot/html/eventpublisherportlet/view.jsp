<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>EventPublisherPortlet</b> portlet in View mode.
<%
PortletURL url = renderResponse.createActionURL();
%>
<a href="<%=url%>">raise event</a>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<portlet:defineObjects />
<h1>This is the edit page of the portlet</h1>
<%
	PortletURL url = renderResponse.createActionURL();
	PortletURL viewUrl = renderResponse.createRenderURL();
	viewUrl.setPortletMode(PortletMode.VIEW);
	String displayStyle=portletPreferences.getValue("displayStyle", "default style");
%>
Preference display style : <%=displayStyle %><br>
<a href="<%=viewUrl %>">go to view mode</a>
<form action="<%=url%>" method="post">
	<input type="text" name="displayStyle"> 
	<input type="submit" value="save">
</form>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>SampleStruts</b> portlet.
<%
PortletURL url = renderResponse.createRenderURL();
url.setParameter("_spage", "/portlet_action/samplestruts/myaction");
%>

<a href="<%=url%>">Invoke My Action</a>
<form action="<%=url%>" method="post">
<input type="text" name="name"><br>
<input type="text" name="address"><br>
<input type="submit">
</form>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />
<h1>New Portlet View jsp</h1>
This is the
<b>SampleStruts</b>
portlet.
<%
	PortletURL url = renderResponse.createRenderURL();
	url.setParameter("_spage",
			"/portlet_action/newportlet/profileaction");
	
	PortletURL url1 = renderResponse.createActionURL();
	url1.setParameter("_spage",
			"/portlet_action/newportlet/profileaction");
%>
<h1>Html form</h1><br>
<form action="<%=url%>" method="post">
	Name : <input type="text" name="name"><br> 
	Address : <input type="text" name="address"><br> 
	Designation : <input type="text" name="designation"><br>
	Age : <input type="text" name="age"><br> 
	Salary : <input type="text" name="salary"><br>
	<input type="submit">
</form>
<%-- <br>
<h1>Struts html Form</h1><br>
 <form action="<%=url %>" method="post">
	Name :<html:text name="profileForm" property="name" /><br>
	Address :<html:password name="profileForm" property="address" /><br>
	Designation :<html:text name="profileForm" property="designation" /><br>
	Age :<html:text name="profileForm" property="age" /><br>
	Salary :<html:text name="profileForm" property="salary" /><br>
	<html:submit value="submit" />
</form>  --%>
<br>
<h1>Aui Form</h1><br>
<aui:form action="<%=url1 %>" method="post">
	<aui:input name="name"/>
	<aui:input name="address"/>
	<aui:input name="designation"/>
	<aui:input name="age"/>
	<aui:input name="salary"/>
	<aui:button type="submit" value="submit"/>
</aui:form>

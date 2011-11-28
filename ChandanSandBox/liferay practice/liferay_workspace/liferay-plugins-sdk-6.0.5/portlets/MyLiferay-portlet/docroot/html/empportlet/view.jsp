

<%@page import="javax.portlet.ActionRequest"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<portlet:actionURL var="SubmitURL">
</portlet:actionURL>


Emp ID :
<%=renderRequest.getParameter("empid")%>
<form action="<%=SubmitURL%>" method="post">Name : <input
	type="text" name="name"><br>
Address: <input type="text" name="address"><br>
<input type="submit" value="Submit"></form>

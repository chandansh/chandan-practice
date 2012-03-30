<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<portlet:defineObjects/>
<h1>Event Demo</h1>

<%

String customerID= ParamUtil.getString(request, "customerID");

%>
<h1>display customer of : <%=customerID %></h1>

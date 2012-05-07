<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />
<portlet:actionURL var="actionURL"></portlet:actionURL>

Enter the Customer details...
<form action="<%=actionURL%>" method="post">
Customer Name :<input type="text" name="cname"><br>
Company Name :<input type="text" name="company"><br>
Address :<input type="text" name="caddress"><br>
<input type="submit" value="Add"></form>

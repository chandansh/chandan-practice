<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>
<p>Hello how are you</p>
<p><a href="<s:url action="update-input" namespace="/"  />">Update Your Data</a></p>

<s:form action="welcome-user">
	<s:textfield name="userName" label="User Name"/>
	<s:submit/>
</s:form>
<h1>Hello how are you</h1>
</body>
</html>
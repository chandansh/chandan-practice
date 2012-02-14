<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="userAction" method="post">
		<s:textfield name="name" label="User Name"/>
		<s:textfield name="age" label="Age"/>
		<s:radio list="{'M','F'}" name="sex" label="Sex"/>
		<s:checkboxlist list="{'games', 'internet', 'art'}" name="hobby" label="Hobby"/>
		<s:select list="{'india','pakistan','USA'}" name="country" label="Country"/>
		<s:submit value="Submit"/>

	</s:form>
</body>
</html>
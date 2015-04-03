<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<s:head />
  </head>
  
  <body>
			<h4>Please update your class choices below.</h4> 
<!-- The action below will result in the execute method 
of class Update being called.  The execute
action returns "success" so the view rendered will be
/WEB-INF/content/update-success.jsp -->
	    <p><s:property value="person"	/></p>
	   
	   <s:form action="update" theme="simple" >
	   <p>Select your classes below:</p>
		<p style="margin-left:15px"><s:checkboxlist theme="simple" key="person.kuClassIds" list="kuClasses" listKey="classId" listValue="className" /></p>
	   
	   <p><s:submit theme="simple" /></p>
	   </s:form>
	   
	   


  </body>
</html>

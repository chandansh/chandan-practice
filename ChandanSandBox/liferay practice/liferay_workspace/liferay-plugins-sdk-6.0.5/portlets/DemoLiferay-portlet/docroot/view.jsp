
<%@page import="com.coleg.model.Emp"%>
<%@page import="com.coleg.service.EmpLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

This is the
<b>DemoLiferay</b>
portlet.

<%
	System.out.println("hello Demo Portlet");
	Emp e = EmpLocalServiceUtil.createEmp("123456");
	e.setUname("chandan");
	EmpLocalServiceUtil.updateEmp(e);
	System.out.println("user created");
%>
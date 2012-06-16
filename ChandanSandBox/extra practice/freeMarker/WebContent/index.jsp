<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="freemarker.template.Template"%>
<%@page import="freemarker.template.Configuration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Map datamodel = new HashMap();
datamodel.put("pet", "Bunny");
datamodel.put("number", new Integer(6));
Configuration cfg = new Configuration();
cfg.setServletContextForTemplateLoading(getServletContext(), "template");
Template tpl = cfg.getTemplate("example.ftl");
tpl.process(datamodel, out);

%>

</body>
</html>
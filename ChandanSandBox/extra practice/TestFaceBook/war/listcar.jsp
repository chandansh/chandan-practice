<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="mypack.Car"%>
<%@page import="com.googlecode.objectify.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
out.print("<h2>List of car Entity using ObjectifyService</h2><br>");
Objectify ofy=ObjectifyService.begin();
Query<Car> cars = ofy.query(Car.class).filter("id >",3).filter("id <",8).filter("color =","orange");
for(Car c: cars) {
	out.print(c.getId()+" "+c.getBrand()+" "+c.getColor()+" "+c.getPrice()+"<br/>");
}
out.print("<br><h2>List of car Entity using DataStoreService</h2><br>");




%>
</body>
</html>
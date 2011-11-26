<%@page import="com.google.appengine.api.datastore.Key"%>
<%@page import="com.google.appengine.api.datastore.KeyFactory"%>
<%@page import="java.util.Random"%>
<%@page import="com.google.appengine.api.datastore.Entity"%>
<%@page import="com.google.appengine.api.datastore.DatastoreServiceFactory"%>
<%@page import="com.google.appengine.api.datastore.DatastoreService"%>
<%@page import="com.googlecode.objectify.*"%>
<%@page import="mypack.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Car</title>
</head>
<body>
<h1>Add Car</h1>
<%!
private String getRandomID(int length) {
	final String GUID_CHARS = "0123456789abcdef";
	final int GUID_NUM_CHARS = GUID_CHARS.length();

	Random r = new Random();
	char[] v = new char[length];

	int idx;
	for (int i = 0; i < length; i++) {

		idx = r.nextInt(GUID_NUM_CHARS);
		v[i] = GUID_CHARS.charAt(idx);
	}

	return new String(v);

}
%>
<%
try
{
	String brand=request.getParameter("brand");
	String color=request.getParameter("color");
	double price=Double.valueOf(request.getParameter("price"));
	
	//we can use DataStoreService or Objectify API with the models
	/*Objectify obf=ObjectifyService.begin();
	Car car1=new Car(brand,color,price);
	Key<Car> k1=obf.put(car1);
	out.print("new Car added Car ID :"+car1.getId());
	out.print("<br> Key for this Entity is: "+k1);*/
	
	
	DatastoreService dsservice =DatastoreServiceFactory.getDatastoreService();
	//Entity car=new Entity("NewCar");// to generate datastore id self
	Entity car=new Entity("NewCar", getRandomID(10)); // to give the id manually
	car.setProperty("brand",brand);
	car.setProperty("color",color);
	car.setProperty("price",price);
	Key returnkey =dsservice.put(car);
	out.print("New Car added with ID "+car.getKey().getId());// if ID is long
	out.print("<br>New Car added with Name "+car.getKey().getName());// if ID is String
	Key k = KeyFactory.createKey(car.getKind(), car.getKey().getName());
	out.print("<br>Key 1 : "+k);
	out.print("<br>Key 2 : "+car.getKey());
	out.print("<br>Returned Key :"+returnkey);
	out.print("<br>Is equals :"+k.equals(car.getKey()));
	
}
catch(Exception e)
{
	e.printStackTrace(System.err);
}
%>
</body>
</html>
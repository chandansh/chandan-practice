<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Car</h2><br/>
<a href="listcar.jsp">List Cars</a>
<br/>
	<form action="addcar.jsp" method="post">
	<input type="text" name="brand"><br>
	<input type="text" name="color"><br>
	<input type="text" name="price"><br/>
	<input type="submit" value="Add Car"><br>
	</form>
	<hr/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
Hello Restlet
<script type="text/javascript">
$(document).ready(function(){
	$.post(
		"j/hws/cities",
			//contentType: "application/json; charset=utf-8",
			{ "status":"Idle","tonerRemaining":25, "jobs": ["a", "b"] },
	 		function(data) {
		    	alert("Data Loaded: " + data);
	  		}
	);
	//alert("hello");
});
</script>


</body>
</html>
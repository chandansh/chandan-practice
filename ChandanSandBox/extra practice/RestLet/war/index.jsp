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
<p id="resp"></p>
<script type="text/javascript">
jQuery(document).ready(function(){
// 	$.ajax(
// 		{
// 			type: "POST",
// 			url: "j/hws/ss",
// 			contentType: "application/json; charset=utf-8",
// 			data: "status=abcd",
// 	 		success: function(data) {
// 		    	alert("Data Loaded: " + data);
// 	  		},
// 	  		error: function(xhr, status, e) {
// 	  			alert('Error: ' + status);
// 	  		}
// 	});
	
	jQuery.post(
			"j/hws/cities",
				//contentType: "application/json; charset=utf-8",
				{ "status":"Idle","tonerRemaining":25, "jobs": ["a", "b"] },
		 		function(data) {
					alert('Data: \ncode: ' + data['code'] + '\nM: '+ data['message']
						+ '\nresult: ' + data['result']);
					/*
			    	alert("Data Loaded: " + JSON.stringify(data));
			    	
			    	var items = [];

			    	  $.each(data, function(key, val) {
			    	    items.push('<li id="' + key + '">' + val + '</li>');
			    	  });

			    	  $('<ul/>', {
			    	    'class': 'my-new-list',
			    	    html: items.join('')
			    	  }).appendTo('body');
			    	  //*/
		  		}
		);
	//alert("hello");
});
</script>


</body>
</html>
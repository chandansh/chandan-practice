<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Introducing Servlet 3.0</title>
<link rel=stylesheet type="text/css" href="styles.css">
</head>
<body>
	<p class="mainpara">
		results.jsp: completed processing of long running activity with id: <span
			style="color: #ff3300"> <%=request.getParameter("id")%>
		</span> <br /> received at:
		<%=request.getAttribute("receivedAt")%>: <br /> completed at:
		<%=request.getAttribute("result")%>
	</p>
	<p class="copyright">Damodar Chetty, Software Engineering
		Solutions, Inc.</p>
</body>
</html>
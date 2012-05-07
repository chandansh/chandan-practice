<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width: 600px;">
	<pg:pager items="100" index="center"
				maxPageItems="10"
				maxIndexPages="10" 
				export="currentPageNumber=pageNumber" scope="request">
	<pg:param name="style" />
				<pg:param name="position" />
				<pg:param name="index" />
				<pg:param name="maxPageItems" />
				<pg:param name="maxIndexPages" />
		
		
			<jsp:include page="/WEB-INF/jsp/yahoo.jsp"  />
		
		
		<%
			for (int i = 1; i <= 100; i++) {
		%>

		<pg:item>

		your data …<%=i%><br>

		</pg:item>

		<%
			}
		%>

		
			<pg:index>
			<jsp:include page="/WEB-INF/jsp/yahoo.jsp"  />
			</pg:index>
		
	</pg:pager>

</div>
</body>
</html>





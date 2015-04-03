<%@page import="com.library.slayer.model.LIBBook"%>
<%@page import="com.library.slayer.service.LIBBookLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%
	int count = LIBBookLocalServiceUtil.getLIBBooksCount();
	List<LIBBook> books = 
		LIBBookLocalServiceUtil.getLIBBooks(0, count);
%>

<%= books%>
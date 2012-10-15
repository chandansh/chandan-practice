<%@page import="com.slayer.model.Post"%>
<%@page import="com.slayer.model.AuthorPost"%>
<%@page import="java.util.List"%>
<%@page import="com.slayer.service.PostLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

This is the
<b>CustomSqlPortlet</b>
portlet in View mode.
<%
	List<AuthorPost> posts = PostLocalServiceUtil.findByTitleContentAuthor(
			"java", "", "chandan", 0, 10);
	out.print("size :" + posts.size());
	for (AuthorPost post : posts) {
		out.print("<br>PostTitle : " + post.getTitle() + " Post Author : "+post.getName() +"<br>");
	}
%>
<%@page import="javax.portlet.PortletURL"%>
<%@page
	import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page
	import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>

<%@ page isELIgnored="false" %>
<portlet:defineObjects />
<theme:defineObjects />
<portlet:renderURL var="createURL">
	<portlet:param name="jspPage" value="/html/addressbook/update.jsp"/>
	
</portlet:renderURL>

<%
	boolean addEntry = PortletPermissionUtil.contains(permissionChecker, plid.longValue(),
			"addressbook_WAR_samplepermissionportlet",
			ActionKeys.ADD_ENTRY);
	pageContext.setAttribute("addEntry", addEntry);
	if(addEntry){
%>
	<br/><a href="<%= createURL %>">Add new Book &raquo;</a>
<%
	}
%>





<%
	PortletURL listBooksURL = renderResponse.createRenderURL();
	listBooksURL.setParameter("jspPage", "/html/addressbook/list.jsp");
	
%>

<a href="<%= listBooksURL.toString() %>">Show all books &raquo;</a>


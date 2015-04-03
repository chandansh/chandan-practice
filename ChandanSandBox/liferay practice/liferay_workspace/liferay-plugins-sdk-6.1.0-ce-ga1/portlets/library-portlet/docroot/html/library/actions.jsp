<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/library/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	LMSBook book = (LMSBook) row.getObject();
	
	PortletURL editBookURL = renderResponse.createRenderURL();
	editBookURL.setParameter("bookId", String.valueOf(book.getBookId()));
	editBookURL.setParameter("jspPage", "/html/library/update.jsp");
	
	PortletURL viewBookURL = renderResponse.createRenderURL();
	viewBookURL.setWindowState(LiferayWindowState.EXCLUSIVE);
	viewBookURL.setParameter("jspPage", "/html/library/details.jsp");
	viewBookURL.setParameter("bookId", String.valueOf(book.getBookId()));
	viewBookURL.setParameter("showHeader", "false");
	
	String popup = "javascript:popup('"+ viewBookURL.toString()+"');";
%>

<%-- <liferay-security:permissions URL
    modelResource="<%= LMSBook.class.getName() %>"
    modelResourceDescription="<%= book.getBookTitle() %>"
    resourcePrimKey="<%= String.valueOf(book.getBookId()) %>"
    var="entryURL"
/> --%>

<liferay-ui:icon-menu>
<%if(LibraryPermission.actionContains(permissionChecker, book, ActionKeys.UPDATE))
{%>
	<liferay-ui:icon image="edit" message="Edit Book" url="<%= editBookURL.toString() %>" />
<%} %>
	<liferay-ui:icon image="view" message="View Details" url="<%= popup %>" />
	<%-- <liferay-ui:icon image="permissions" url="<%= entryURL %>" />  --%>
</liferay-ui:icon-menu>
<aui:script>
	Liferay.provide(
		window,
		'popup',
		function(url) {
			var A = AUI();

			var data = {};

			var dialog = new A.Dialog(
				{
					centered: true,
					destroyOnClose: true,
					draggable: true,
					height: 330,
					width: 343,
					resizable: false,
					modal: true,
					title: 'Book Details'
				}
				).render();
					dialog.plug(
						A.Plugin.IO,
						{
							data: data,
							uri: url
						}
					);
			},
		['aui-dialog', 'aui-io']
	);
</aui:script>




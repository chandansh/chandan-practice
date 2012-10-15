<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ include file="/html/library/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%
String keyword=(String)request.getAttribute("keyword");
List<LMSBook> book1 = LMSBookLocalServiceUtil.searchBooks(PortalUtil.getCompanyId(request), keyword);

PortletURL iteratorURL=renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage","/html/library/search.jsp"); 
%>
<%-- <table border="1" width="80%">
<tr>
<th>Book Title</th>
<th>Author</th>
<th>Date Added</th>
</tr>
<%
for (LMSBook adbook : book1) 
{
%>
<tr>
 <td><%= adbook.getBookTitle() %></td>
<td><%= adbook.getAuthor() %></td>
<td><%= adbook.getAddedDate() %></td> 
</tr>
<%
}
%>
</table> --%>

<liferay-ui:search-container delta="4" iteratorURL="<%= iteratorURL %>" >
								
								
<liferay-ui:search-container-results
total="<%= book1.size() %>" results="<%= ListUtil.subList(book1,searchContainer.getStart(),searchContainer.getEnd()) %>"/>
<liferay-ui:search-container-row modelVar="book" className="com.library.slayer.model.LMSBook">
<liferay-ui:search-container-column-text name="Book Title" property="bookTitle"/>
<liferay-ui:search-container-column-text name="Author" property="author" />
<liferay-ui:search-container-column-text name="Date Added" property="addedDate"/>
<liferay-ui:search-container-column-text name="Description" property="description"/>
</liferay-ui:search-container-row>

<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

</liferay-ui:search-container>
<br/><a href="<portlet:renderURL/>">&laquo; Go Back</a> 

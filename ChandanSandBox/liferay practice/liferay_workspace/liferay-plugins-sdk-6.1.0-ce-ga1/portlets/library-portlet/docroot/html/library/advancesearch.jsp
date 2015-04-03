<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/library/init.jsp" %>
<%
String type = ParamUtil.getString(request, "type");
String title = ParamUtil.getString(request, "title");
String author = ParamUtil.getString(request, "author");
String desc = ParamUtil.getString(request, "desc");
PortletURL iteratorURL= renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage","/html/library/advancesearch.jsp");
List<LMSBook> lmsBooks = new ArrayList<LMSBook>();
if(type.equals("Any"))
{
lmsBooks = LMSBookLocalServiceUtil.AdvanceSearchAny(PortalUtil.getCompanyId(request), PortalUtil.getScopeGroupId(request), title, author, desc);
System.out.println("hello-------->");
System.out.println(lmsBooks);
} 
else if(type.equals("All"))
{
	lmsBooks = LMSBookLocalServiceUtil.advanceSearchAll(PortalUtil.getCompanyId(request), PortalUtil.getScopeGroupId(request), title, author, desc, type);
	System.out.println("hello-from All------->");
	System.out.println(lmsBooks);
}
%>
<liferay-ui:search-container delta="5" iteratorURL="<%= iteratorURL %>" emptyResultsMessage="No Such Books Available" >

<liferay-ui:search-container-results
total="<%= lmsBooks.size() %>" results="<%= ListUtil.subList(lmsBooks, searchContainer.getStart(), searchContainer.getEnd()) %>"/>
<liferay-ui:search-container-row modelVar="book" className="com.library.slayer.model.LMSBook">
<liferay-ui:search-container-column-text name="Book Title" property="bookTitle"/>
<liferay-ui:search-container-column-text name="Author" property="author" />
<liferay-ui:search-container-column-text name="Date Added" property="addedDate"/>
<liferay-ui:search-container-column-text name="Description" property="description"/>
</liferay-ui:search-container-row>

<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />

</liferay-ui:search-container>
<br/><a href="<portlet:renderURL/>">&laquo; Go Back</a> 

 

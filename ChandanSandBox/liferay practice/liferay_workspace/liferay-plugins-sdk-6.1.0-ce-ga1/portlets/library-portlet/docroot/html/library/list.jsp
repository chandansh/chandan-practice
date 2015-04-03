<%@page import="javax.portlet.ResourceURL"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>

<%@ include file="/html/library/init.jsp" %>

<script type="text/javascript"charset="utf-8">

AUI().ready( 'aui-autocomplete', 'json',  function(A){
	var url = "<portlet:resourceURL />";
	
	getBookdetails = function(bookId)
	{
		AUI().io.request(url, {
			method: "GET",
			data: {
				"cmd":"get-book-details",
				"bookId":bookId
			},
			dataType: 'json',
			on: {
				success: function(){
					Liferay.trigger('retrieveValue', JSON.stringify(this.get("responseData")));
					return false;
				},
			}
		});
	};
});

</script>


<h1>List of books in our Library</h1>
<%
String cur = request.getParameter("cur");
if(cur == null){
	cur = "1";
}

List<LMSBook> books = LMSBookLocalServiceUtil.getAllBooksWithPermission();
//List<LMSBook> books = LMSBookLocalServiceUtil.getLMSBooks(0, -1); 
 
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("book", "deleted");//added by kanchan
iteratorURL.setParameter("jspPage", "/html/library/list.jsp");

PortletURL deleteBookURL = renderResponse.createActionURL();
deleteBookURL.setParameter(ActionRequest.ACTION_NAME, "deleteBook");
deleteBookURL.setParameter("book", "deleted");//added by kanchan
deleteBookURL.setParameter("redirectURL", iteratorURL.toString());

PortletURL detailsURL = renderResponse.createRenderURL();
detailsURL.setParameter("jspPage", "/html/library/details.jsp");
String defaultColumn="bookTitle";

%>
<%@ include file="/html/library/common_sort.jsp" %>
<%
	BeanComparator comp = new BeanComparator(orderByCol);
	if (direction.equalsIgnoreCase("desc")) {
	    Collections.sort(books, comp);
	    Collections.reverse(books);
	} else {
	    Collections.sort(books, comp);
	}
	iteratorURL.setParameter("cur", cur);
	iteratorURL.setParameter("curSort", orderByCol);
	iteratorURL.setParameter("curDirect",direction);
%> 

<liferay-ui:search-container delta="5" iteratorURL="<%= iteratorURL%>"
	emptyResultsMessage="Sorry. There are no items to display.">

	<liferay-ui:search-container-results 
		total="<%= books.size() %>"
		results="<%= ListUtil.subList(books, searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>
			
	<liferay-ui:search-container-row modelVar="book" 
		className="com.library.slayer.model.LMSBook" >
		
		<% 
			detailsURL.setParameter("bookId", String.valueOf(book.getBookId()));
			detailsURL.setParameter("backURL", themeDisplay.getURLCurrent());
		%>
		
		<liferay-ui:search-container-column-text name="Book Title" orderable="true" orderableProperty="bookTitle">
			<a href="<%=detailsURL.toString() %>" onClick="getBookdetails(<%=book.getBookId()%>);"><%= book.getBookTitle() %></a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Author" property="author" orderable="true" orderableProperty="author"/>
		<liferay-ui:search-container-column-text property="status" name="Status" orderable="true" orderableProperty="status"/>
		
		<liferay-ui:search-container-column-text name="bookPreview" >
		<%
		ResourceURL Url = renderResponse.createResourceURL();
		Url.setParameter("fileName", book.getFileName());
		Url.setParameter("bookId", String.valueOf(book.getBookId()));
		%>
		 <a href="<%=Url%>"><%=book.getFileName()%></a>
		</liferay-ui:search-container-column-text>

		
		<liferay-ui:search-container-column-text name="Date Added" orderable="true" orderableProperty="createDate">
			<fmt:formatDate value="<%= book.getCreateDate() %>" pattern="dd/MMM/yyyy"/>
		</liferay-ui:search-container-column-text>
		
		<% deleteBookURL.setParameter("bookId", String.valueOf(book.getBookId())); %>
		<liferay-ui:search-container-column-text name="Delete">
			<a href="<%= deleteBookURL.toString() %>">Delete &raquo;</a>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-jsp name="Actions" 
			path="/html/library/actions.jsp" />
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />

</liferay-ui:search-container>

<a href="<portlet:renderURL/>">&laquo; Go Back</a>
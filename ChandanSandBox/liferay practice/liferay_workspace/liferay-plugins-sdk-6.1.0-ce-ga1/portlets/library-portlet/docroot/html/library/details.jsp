

<%@ include file="/html/library/init.jsp" %>


<%

	PortletURL currentURLObj = null;
	currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String currentURL = currentURLObj.toString();
	
	PortletURL bookmarkURL = renderResponse.createRenderURL();
	bookmarkURL.setParameter("jspPage", "/html/library/details.jsp");


	String backURL = ParamUtil.getString(request, "backURL");
	boolean showHeader = ParamUtil.getBoolean(request, "showHeader", true);
%>

<c:if test="<%= showHeader %>">
	<liferay-ui:header backLabel="&laquo; Back to List" title="Book Details" backURL="<%= backURL %>"/>
</c:if>

<%
	LMSBook book = null;
	long bookId = ParamUtil.getLong(request, "bookId");

	if (bookId > 0L) {
		book = LMSBookLocalServiceUtil.getLMSBook(bookId);
	}
%>
<label>Tags</label>
<liferay-ui:asset-tags-summary
    className="<%= LMSBook.class.getName() %>"
    classPK="<%= book.getPrimaryKey() %>"
/>


<c:if test="<%= Validator.isNotNull(book) %>">
	<table border="2">
		<tr>
			<th>Book Title</th>
			<td><%= book.getBookTitle() %></td>
		</tr>
		
		<tr>
			<th>Author</th>
			<td><%= book.getAuthor() %></td>
		</tr>
		<tr>
			<th>Status</th>
			<td><%= book.getStatus()%></td>
		</tr>
		<tr>
			<th> Create Date</th>
			<td>
				<fmt:formatDate value="<%= book.getCreateDate() %>" pattern="dd/MMM/yyyy"/>
			</td>
		</tr>	
		
		<tr>
			<th>Date Modified</th>
			<td>
<%-- 				<fmt:formatDate value="<%= book.getDateModified() %>" pattern="dd/MMM/yyyy"/> --%>
			</td>
		</tr>					
	</table>
</c:if>

<liferay-ui:ratings
 className="<%= LMSBook.class.getName() %>"
 classPK="<%= book.getBookId() %>"
/>
<liferay-ui:social-bookmarks
    url="<%= bookmarkURL.toString() %>"
    title="<%= book.getBookTitle() %>"
    target="_blank"
    />

<liferay-ui:panel-container extended="<%= false %>" id="libraryCommentsPanelContainer" persistState="<%= true %>">
            <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="libraryCommentsPanel" persistState="<%= true %>" title='<%= LanguageUtil.get(pageContext, "comments") %>'>
                <portlet:actionURL var="discussionURL" name="invokeTaglibDiscussion" />

                <liferay-ui:discussion
                    className="<%= LMSBook.class.getName() %>"
                    classPK="<%= book.getBookId() %>"
                    formAction="<%= discussionURL %>"
                    formName="fm2"
                    ratingsEnabled="true"
                    redirect="<%= currentURL %>"
                    subject="<%= book.getBookTitle() %>"
                    userId="<%= themeDisplay.getUserId() %>"
                />
            </liferay-ui:panel>
</liferay-ui:panel-container>

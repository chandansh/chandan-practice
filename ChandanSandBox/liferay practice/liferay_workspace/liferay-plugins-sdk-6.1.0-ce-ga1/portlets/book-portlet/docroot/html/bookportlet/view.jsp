<%@include file="/html/common/init.jsp" %>

<%
ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
List<Book> list = BookLocalServiceUtil.getBooks(0, -1);

String dealAction = renderRequest.getParameter("action");

PortletURL editURL=renderResponse.createRenderURL();
editURL.setParameter("jspPage", "/html/bookportlet/edit.jsp");

System.out.println("list is......."+list );
%>

<aui:form action="<%=editURL %>">
<aui:button name="submit" value="Add Book" type="submit" />
</aui:form>
<liferay-ui:search-container delta="5" deltaConfigurable="false" emptyResultsMessage="No-Books Availabe">
	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(list , searchContainer.getStart(), searchContainer.getEnd())  %>"
		total="<%=list.size()%>"
	/>

	<liferay-ui:search-container-row
		className="com.mpower.services.model.Book"
		modelVar="book"
	>	
			<liferay-ui:search-container-column-text property="bookNumber" name="Book Number" align="right" />
			<liferay-ui:search-container-column-text property="writerName" name="Writer Name" />
			<liferay-ui:search-container-column-text property="createDate" name="Create Date" align="right" />
			<liferay-ui:search-container-column-text property="firstName" name="First Name" align="right" />
			<liferay-ui:search-container-column-text property="lastName" name="Last Name" align="right" />
			<liferay-ui:search-container-column-text property="quantity" name="Quantity" align="right" />
			<liferay-ui:search-container-column-text property="totalCost" name="Total Cost" align="right" />
			<liferay-ui:search-container-column-text property="status" name="Status" align="right" />
			<%
				editURL.setParameter("bookId",(String.valueOf(book.getBookId())));
		
			%>
			<liferay-ui:search-container-column-text name="View">
				<a href="<%=editURL%>">View</a>
				
			</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>



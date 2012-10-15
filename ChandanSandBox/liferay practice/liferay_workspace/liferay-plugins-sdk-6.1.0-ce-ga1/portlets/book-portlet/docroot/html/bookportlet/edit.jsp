<%@include file="/html/common/init.jsp" %>


<portlet:renderURL var="renderURL"/>
<portlet:actionURL name="addBook" var="addBookURL"/>

<%
	String url = addBookURL.toString();
	boolean disabled = false;
	long bookId = ParamUtil.getLong(renderRequest, "bookId");
	Book book = new BookImpl();
	if(bookId > 0){
		book = BookLocalServiceUtil.getBook(bookId);
		url = renderURL.toString();
		disabled = true;
	}
%>

<aui:form action="<%= url %>" method="post">
	<aui:fieldset>
	
			<aui:input disabled="<%=disabled %>" name="bookNumber" value="<%=book.getBookNumber()%>" size="45" />
			<aui:input disabled="<%=disabled %>" name="writerName" value="<%=book.getWriterName() %>" size="45" />		
			<aui:input disabled="<%=disabled %>" name="firstName" value="<%=book.getFirstName() %>" size="45" />
			<aui:input disabled="<%=disabled %>" name="lastName" value="<%=book.getLastName() %>" size="45" />
			<aui:input disabled="<%=disabled %>" name="quantity" value="<%=book.getQuantity() %>" size="45" />
			<aui:input disabled="<%=disabled %>" name="totalCost" value="<%=book.getTotalCost() %>" size="45" />
	
			<aui:input name="workflowAction" type="hidden" value="<%= WorkflowConstants.ACTION_SAVE_DRAFT %>" />
			<aui:input name="bookId" type="hidden" value="<%=bookId %>"/>
			<aui:button-row>
				<%
					if(bookId > 0) { 
				%>
				<aui:button name="back" value="Back" type="submit" />
				<% 
					} else { 
				%>
				<aui:button name="submit" value="Submit" type="submit" />
				<%
					}
				%>
			</aui:button-row>
	</aui:fieldset>
</aui:form>
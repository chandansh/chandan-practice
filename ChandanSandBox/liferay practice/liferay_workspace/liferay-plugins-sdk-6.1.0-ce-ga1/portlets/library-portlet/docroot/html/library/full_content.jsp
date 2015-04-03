<%@include file="/html/library/init.jsp" %>


<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>

<%

LMSBook book = (LMSBook)request.getAttribute("LMS_ENTRY");
System.out.println("this is sop from full_content.jsp..!!!");
 
%>

<h5>Book Id =<%=book.getBookId()%></h5>


<%=book.getBookTitle() %> <br/>
<%=book.getAuthor() %> <br/>
  


 
<liferay-ui:custom-attributes-available className="<%=LMSBook.class.getName() %>">
	
	<liferay-ui:custom-attribute-list classPK="<%=book.getPrimaryKey() %>" 
									  className="<%=LMSBook.class.getName() %>" 
									  editable="<%=false %>" 
									  label="<%=true %>"/>


</liferay-ui:custom-attributes-available>





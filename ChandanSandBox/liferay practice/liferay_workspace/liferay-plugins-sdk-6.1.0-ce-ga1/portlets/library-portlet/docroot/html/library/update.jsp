
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.library.slayer.BookExistsException"%>
<%@page import="com.liferay.portal.service.ResourceLocalService"%>

<%@ include file="/html/library/init.jsp" %>

<script type="text/javascript">
function addBookThruJSON() {
	alert('Service layer invocation through JSON');
	var frm = document.<portlet:namespace />fm;
	alert('Form :'+frm);
	var bookTitle = frm.<portlet:namespace />bookTitle.value;
	alert('Book Title : '+bookTitle);
	var author = frm.<portlet:namespace />author.value;
	alert('Author :'+author);
	var groupId = frm.<portlet:namespace />groupId.value;
	alert('groupId :'+groupId);
	var params = {
			bookTitle:bookTitle,
			author:author,
			groupId:groupId
	};
	Liferay.Service.LMS.LMSBook.addLibraryBook(params);
	alert('Book successfully added');
	frm.<portlet:namespace />book_title.value = "";
}
</script>

<h1>Add / Edit Form </h1>

<% 
	PortletURL updateBookURL = renderResponse.createActionURL();
	updateBookURL.setParameter(ActionRequest.ACTION_NAME, "updateBook");
	
	LMSBook book = new LMSBookImpl();
	long bookId = ParamUtil.getLong(request, "bookId", 0l);

	if (bookId > 0L) {
		book = LMSBookLocalServiceUtil.getLMSBook(bookId);
	}
	 
	long groupId = themeDisplay.getScopeGroupId();
%>
 
<liferay-ui:error exception="<%= BookExistsException.class %>" message="Book Already Exists" />

<aui:form name="fm" method="post" action="<%=updateBookURL.toString() %>" >

	<aui:input type="hidden" name="redirectURL" value="<%= renderResponse.createRenderURL().toString() %>"/>
	<aui:input type="hidden" name="bookId" value="<%= String.valueOf(book.getBookId()) %>"/>
	<aui:input name="bookTitle" label="Book Title" value="<%= book.getBookTitle() %>"/>
	<aui:input name="groupId" type="hidden" value="<%=  String.valueOf(groupId) %>"/>
	<aui:input name="author" value="<%= book.getAuthor() %>"/>
	<aui:input name="description" value="<%= book.getDescription() %>"/>
	<aui:input name="addAttachment" type="file" label="Add Attachment " />
	
			
	
	
	<aui:field-wrapper label="permissions">
		<liferay-ui:input-permissions formName="select" modelName="<%= LMSBook.class.getName() %>" />
	</aui:field-wrapper>
	
	<liferay-ui:panel defaultState="closed" extended="<%=false%>" id="bookEntryCategorizationPanel" persistState="<%=true%>" title="categorization">
		<liferay-ui:asset-categories-selector
			className="<%= book.getClass().getName() %>"
			classPK="<%= book.getPrimaryKey() %>"
		/>
		<label>Tags</label>
		<liferay-ui:asset-tags-selector
			className="<%= book.getClass().getName() %>"
			classPK="<%= book.getPrimaryKey() %>"
		/>
	</liferay-ui:panel>
	
	<aui:button type="submit" value="Save"/>
	<%-- <aui:button type="submit" value="JSON Save" onClick="addBookThruJSON();"/> --%>
</aui:form>

<a href="<portlet:renderURL/>">&laquo; Go Back</a>

<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery("#<portlet:namespace/>fm").validate();
	  	jQuery("#<portlet:namespace/>bookTitle").addClass("required");
	  	jQuery("#<portlet:namespace/>author").addClass("required");
	});
</script>
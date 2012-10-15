<%@page import="com.library.slayer.model.LMSBookAddressBean"%>
<%@page import="com.library.slayer.model.LMSBookJoin"%>
<%@ include file="/html/library/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.library.slayer.model.LMSBook"%>
<%
	List<LMSBookAddressBean> books = (List) request.getAttribute("result");
	if (Validator.isNull(books))
		books = new ArrayList<LMSBookAddressBean>();
%>
<liferay-ui:search-container delta="10"
	emptyResultsMessage="no-books-were-found">
	<liferay-ui:search-container-results results="<%=books %>"
		total="<%= books.size( )%>" />
	<liferay-ui:search-container-row
		className="com.library.slayer.model.LMSBookAddressBean"
		modelVar="book">
		<liferay-ui:search-container-column-text name="Book Title"
			property="bookTitle" />
		<liferay-ui:search-container-column-text name="Author"
			property="author" />
		<liferay-ui:search-container-column-text name="UserId"
			property="userId" />
		<liferay-ui:search-container-column-text name="FirstName"
			property="firstName" />
		<liferay-ui:search-container-column-text name="LastName"
			property="lastName" />
		<liferay-ui:search-container-column-text name="City" property="city" />
		<liferay-ui:search-container-column-text name="Zip" property="zip" />
		<liferay-ui:search-container-column-text name="EmailAddress"
			property="emailAddress" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
	

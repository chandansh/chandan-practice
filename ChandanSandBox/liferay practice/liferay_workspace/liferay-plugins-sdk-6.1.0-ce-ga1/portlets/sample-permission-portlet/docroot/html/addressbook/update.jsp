<%@page import="com.test.slayer.service.AddressLocalServiceUtil"%>
<%@page import="com.test.slayer.model.Address"%>
<%@page import="com.test.slayer.model.impl.AddressImpl"%>
<%@page import="com.liferay.portal.service.ResourceLocalService"%>
<%@ include file="/html/addressbook/init.jsp" %>

<h1>Add / Edit Form </h1>

<% 
	PortletURL updateBookURL = renderResponse.createActionURL();
	updateBookURL.setParameter(ActionRequest.ACTION_NAME, "updateBook");
	
	Address address = new AddressImpl();
	long addId = ParamUtil.getLong(request, "addId");
	if (addId > 0L) {
		address = AddressLocalServiceUtil.getAddress(addId);
	}
%>

<%-- 
<form name="<portlet:namespace/>fm" method="POST" action="<%= updateBookURL.toString() %>">
	Book Title: <input type="text" name="<portlet:namespace/>bookTitle" />
	<br/>Author: <input type="text" name="<portlet:namespace/>author" />
	<br/><input type="submit" value="Save" />
</form><script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js" />
--%>

<aui:form name="fm" method="POST" action="<%= updateBookURL.toString() %>" >
	<aui:input type="hidden" name="redirectURL" value="<%= renderResponse.createRenderURL().toString() %>"/>
	<aui:input type="hidden" name="addId" value="<%= String.valueOf(address.getAddId()) %>"/>
	<aui:input name="address" label="Address" value="<%= address.getAddress() %>"/>
	<aui:input name="city" value="<%= address.getCity() %>"/>
	<aui:field-wrapper label="permissions">
	 <liferay-ui:input-permissions formName="select" modelName="<%= Address.class.getName() %>" />
	</aui:field-wrapper>
	<aui:button type="submit" value="Save"/>
</aui:form>
<br/><a href="<portlet:renderURL/>">&laquo; Go Back</a>

<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery("#<portlet:namespace/>fm").validate();
	  	jQuery("#<portlet:namespace/>bookTitle").addClass("required");
	  	jQuery("#<portlet:namespace/>author").addClass("required");
	});
</script>
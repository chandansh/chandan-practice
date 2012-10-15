<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<portlet:actionURL name="createAuthor" var="createAuthorURL"/>
This is the <b>CreateAuthorPortlet</b> portlet in View mode.
<aui:form action="<%=createAuthorURL%>">
	<aui:input name="name" title="Name"></aui:input>
	<aui:input name="specialization" title="Specialization"></aui:input>
	<aui:button type="submit" value="Save"></aui:button>
</aui:form>
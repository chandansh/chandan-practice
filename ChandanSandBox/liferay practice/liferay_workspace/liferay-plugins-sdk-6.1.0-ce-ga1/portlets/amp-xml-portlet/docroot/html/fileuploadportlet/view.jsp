<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />

This is the <b>FileUploadPortlet</b> portlet in View mode.
<portlet:actionURL var="actionURL"/>
<aui:form name="uploadForm" action="<%= actionURL %>" method="post" enctype="multipart/form-data" >
	<aui:input name="myfile" type="file"></aui:input>
	<aui:button type="submit" value="Submit"/>
</aui:form>

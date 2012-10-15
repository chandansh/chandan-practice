<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />
<portlet:actionURL name="createPost" var="createPostURL"/>
This is the
<b>CreatePostPortlet</b>
portlet in View mode.
<aui:form action="<%=createPostURL%>">
	<aui:input name="title" title="Title" />
	<aui:input name="content" title="content" />
	<aui:select name="authorId" title="Author">
		<aui:option value="1">Chandan</aui:option>
		<aui:option value="2">Raju</aui:option>
	</aui:select>
	<aui:button type="submit" value="Save" />
</aui:form>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />
<portlet:actionURL var="submitAction">
<portlet:param name="alpha" value="beta"/>
</portlet:actionURL>

<h1> Create users in bulk </h1>

<aui:form name="form1" action="<%= submitAction %>" method="post">
<aui:input name="username" label="User's Name" type="textarea" title="First Name and Last Name of the user" /><br>
<aui:input name="email" label="E-mail" type="textarea" title="Email ID's should be entered corresponding to above user's name" /> <br>
<aui:select name="organization">
<aui:option>ICA</aui:option>
<aui:option>ICA</aui:option>
</aui:select>
<aui:button value="submit" name="submit"></aui:button>
</aui:form>


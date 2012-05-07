<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />
<portlet:actionURL var="submitAction">
<portlet:param name="alpha" value="beta"/>
</portlet:actionURL>

<h1> Form </h1>

<aui:form name="uploadForm" action="<%= submitAction %>" method="post"  enctype="multipart/form-data">
<aui:input name="nameField" label="Enter name" type="text"></aui:input>
<aui:button value="submit" name="submit"></aui:button>
</aui:form>




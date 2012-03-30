<%@page import="javax.portlet.PortletURL"%>
<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
%>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<portlet:defineObjects />
<%
			PortletURL url=renderResponse.createRenderURL();
		 	PortletURL url1=renderResponse.createActionURL();
%>

This is the <b>My Order Portlet</b> portlet by chandan.
<form action="<%=url1%>" method="post">
<input type="text" name="name">
<input type="submit">

</form>


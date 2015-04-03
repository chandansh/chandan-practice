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
<%@page import="javax.portlet.PortletURL"%>
<%-- <%@include file="/html/init.jsp"%> --%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />
<theme:defineObjects/>

<%
PortletURL url=renderResponse.createRenderURL();
url.setParameter("action","friendPortlet");

PortletURL editURL=renderResponse.createRenderURL();
editURL.setParameter("action", "facebook");
editURL.setParameter("urlTitle", "MyTitle");

PortletURL invoiceURL=renderResponse.createRenderURL();
invoiceURL.setParameter("action", "view-invoice");
invoiceURL.setParameter("invoiceId", "1235");

PortletURL showinvoiceURL=renderResponse.createRenderURL();
showinvoiceURL.setParameter("action", "view-invoice-with-name");
showinvoiceURL.setParameter("invoiceId", "1235");
showinvoiceURL.setParameter("invoiceName", "companyInvoice");
%>

<a href="<%=url %>">TestURL</a><br>
<a href="<%=editURL %>">editURL</a><br>
<a href="<%=invoiceURL %>">invoiceURL</a><br>
<a href="<%=showinvoiceURL %>">showinvoiceURL</a><br>


This is the <b>FriendPortlet</b> portlet in View mode.
<!-- ------------------------------------------------------------------------------- -->


<%
long groupId = scopeGroupId;
String nameOfPortlet = portletDisplay.getRootPortletId();
String resourcePrimaryKey = portletDisplay.getResourcePK();
String actionId = "ALLOW_MODEL_CONFIGURATION";
%>


Do you have the permissions to Config this portlet?
<b>
<c:choose>
    <c:when test="<%= permissionChecker.hasPermission(groupId, nameOfPortlet,
            resourcePrimaryKey, actionId) %>">
        <aui:button value="Allow Config" />
    </c:when>
    <c:otherwise>
        You do not have rights to Config
    </c:otherwise>
</c:choose>
</b>
<br /><br />

<%
 String modelResource = "com.pg.portlets.Profile";

%>
<portlet:renderURL var="redirectURL" />
<liferay-security:permissionsURL
    redirect="<%= redirectURL %>"
    modelResource="<%= modelResource %>"
    modelResourceDescription='<%= "Profile Permissions" %>'
    resourcePrimKey="<%= resourcePrimaryKey %>"
    var="permissionsURL"
/>
<a href="<%=permissionsURL%>">
  <liferay-ui:icon image="permissions"></liferay-ui:icon>
</a>


<hr>
Do you have the DELETE permission for the model <b>Profile</b>       

<c:choose>
    <c:when test='<%= permissionChecker.hasPermission(groupId, modelResource,resourcePrimaryKey, "DELETE") %>'>
        <b>Yes</b>
    </c:when>
    <c:otherwise>
        <b>No</b>
    </c:otherwise>
</c:choose>
<hr>
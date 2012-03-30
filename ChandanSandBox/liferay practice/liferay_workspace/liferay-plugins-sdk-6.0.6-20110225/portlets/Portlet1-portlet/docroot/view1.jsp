
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<portlet:defineObjects />

This is the
<b>Portlet 1 view 1 </b><br>
portlet. Session Attribute is :<%=portletSession.getAttribute("sessionAttr",
					PortletSession.APPLICATION_SCOPE)%><br>
Session Attribute1 is :<%=portletSession.getAttribute("sessionAttr1")%>				
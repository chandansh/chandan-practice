<%@page import="com.liferay.portal.kernel.xml.Element"%>
<%@page import="com.acs.FreeMarkerUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>


<portlet:defineObjects />
<theme:defineObjects/>

<portlet:actionURL var ="actionUrl"></portlet:actionURL>
<aui:form name="form1" action="<%=actionUrl %>" method="post">
<%

Element element = (Element)renderRequest.getAttribute("element");

%>

<%-- <%= FreeMarkerUtil.getHtml(pageContext, renderRequest, "") %> --%>

<aui:input name="name" maxlength="2" ></aui:input>
<input type="text"  />

</aui:form>	
	
	

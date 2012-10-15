<%@page import="com.test.util.RuntimePortletEmbedUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects/>
<%
//String productPortletContent = RuntimePortletEmbedUtil.renderPortlet(renderRequest, renderResponse, "product_WAR_ampcloudportlet", "addServer=addServer&newOrder=newOrder");
String productPortletContent = RuntimePortletEmbedUtil.renderPortlet(renderRequest, renderResponse, "eventlstenerportlet_WAR_EventPublisherportlet", "addServer=addServer&newOrder=newOrder");
//String cartPortletContent = RuntimePortletEmbedUtil.renderPortlet(renderRequest, renderResponse, "cart_WAR_ampcloudportlet", "");
//System.out.println(productPortletContent);
%>
<%=productPortletContent %>
<h1>Hello</h1>
<!-- <liferay-portlet:runtime portletName="portlet_eventlstenerportlet_WAR_EventPublisherportlet" /> -->
<%@page import="com.liferay.portal.model.Portlet"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.LayoutTypePortlet"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>EventPublisherPortlet</b> portlet in View mode.
<%
PortletURL url = renderResponse.createActionURL();
%>
<a href="<%=url%>">raise event</a>

<%

Layout lout= LayoutLocalServiceUtil.getFriendlyURLLayout(10180, false, "/test-page");
//System.out.println("Plid :: " + lout.getPlid());
PortletURL url1 = PortletURLFactoryUtil.create(renderRequest, "eventlstenerportlet_WAR_EventPublisherportlet", lout.getPlid(), "0");

Layout lout1= LayoutLocalServiceUtil.getFriendlyURLLayout(10180, false, "/home");
//System.out.println("Plid :: " + lout.getPlid());
//PortletURL url2 = PortletURLFactoryUtil.create(renderRequest, "eventlstenerportlet_WAR_EventPublisherportlet", lout.getPlid(), "0");
LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) lout1.getLayoutType();
List<Portlet> portlets = layoutTypePortlet.getAllPortlets();


Portlet assetPortlet = null;
for(Portlet p:portlets){
	System.out.println("portlet Id ::" + p.getPortletId() + "  Name :: " + p.getPortletName() );
	System.out.println("portlet instance Id ::" + p.getInstanceId());
	if(p.getPortletName().equalsIgnoreCase("101")){
		assetPortlet = p;
		break;
	}
}

PortletURL redirectUrl = renderResponse.createRenderURL();

%><br>
<a href="<%=url1%>">go</a><br>
<a href="home/-/asset_publisher/<%= assetPortlet.getInstanceId() %>/content/test-tit-1?redirect=<%=redirectUrl.toString()%>">view 1</a><br>
<a href="home/-/asset_publisher/<%= assetPortlet.getInstanceId() %>/content/test-title?redirect=<%=redirectUrl.toString()%>">view 2</a><br>
<a href="home/-/asset_publisher/Odsf65dgfddffsd/content/test-tit-1">view 3</a><br>

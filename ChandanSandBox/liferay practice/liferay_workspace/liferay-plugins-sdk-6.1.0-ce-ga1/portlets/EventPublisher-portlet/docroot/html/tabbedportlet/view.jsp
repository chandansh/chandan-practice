<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.test.util.RuntimePortletEmbedUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<liferay-theme:defineObjects />
<portlet:defineObjects/>
 
//A renderURL is created because we need to render a jsp page you need to use //renderURL we can also  pass parameters if required
 
<liferay-portlet:renderURL var="portletURL"/>
 
<%
//We must Specify a default value for tabs. In this example it is sunday. Else it //will throw an error.
String tabValue = ParamUtil.getString(request, "tab", "sunday");
String tabsURL = "/html/tabbedportlet/" + tabValue.trim() + ".jsp";
String tabNames="Sunday,Monday,Tuesday" ;
String tabVal="sunday,monday,tuesday" ;
if(permissionChecker.isCompanyAdmin(themeDisplay.getCompanyId())){
tabNames+=",Admin" ;
tabVal+=",admin" ;
}
%>
 
<liferay-ui:tabs
names="<%=tabNames%>"
tabsValues="<%=tabVal%>"
param="tab"
url="<%= portletURL %>"
/>
 
//this wud render the tab page
<c:import url="<%= tabsURL %>"></c:import>

<liferay-ui:tabs
	names="Sample Tab 1, Sample Tab 2, Sample Tab 3"
	refresh="<%= false %>"
>
	<liferay-ui:section>
		sample 1
	</liferay-ui:section>
	<liferay-ui:section>
		sample 2
	</liferay-ui:section>
	<liferay-ui:section>
		sample 3
	</liferay-ui:section>
</liferay-ui:tabs>

<a href="#" onClick="addServerPopup();">call page</a>
<%
PortletURL addServerURL = renderResponse.createRenderURL();
addServerURL.setWindowState(LiferayWindowState.EXCLUSIVE);
addServerURL.setParameter("jspPage","/html/common/portletrender.jsp");
%>
<script>
function addServerPopup() {

		var A = AUI();
		var data = {};

		AUI().ready('aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {
		var dialog = new A.Dialog({
				centered: true,
				//destroyOnClose: true,
				draggable: true,
				height: 'auto',
				width: '800',
				resizable: true,
				modal: true,
				title: Liferay.Language.get('Add Server'),
			}).render();
				dialog.plug(
					A.Plugin.IO,
					{
						//data: data,
						uri: '<%=addServerURL %>',
					}
				);
		 });
	}
</script>
<%
//String productPortletContent = RuntimePortletEmbedUtil.renderPortlet(renderRequest, renderResponse, "product_WAR_ampcloudportlet", "addServer=addServer&newOrder=newOrder");
String productPortletContent = RuntimePortletEmbedUtil.renderPortlet(renderRequest, renderResponse, "eventlstenerportlet_WAR_EventPublisherportlet", "addServer=addServer&newOrder=newOrder");
//String cartPortletContent = RuntimePortletEmbedUtil.renderPortlet(renderRequest, renderResponse, "cart_WAR_ampcloudportlet", "");
//System.out.println(productPortletContent);
%>
<%=productPortletContent %>
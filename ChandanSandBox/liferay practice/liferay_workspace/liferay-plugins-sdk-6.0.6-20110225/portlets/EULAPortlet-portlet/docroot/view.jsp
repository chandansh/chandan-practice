<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />

<script type="text/javascript">
function registrationPopup(url) {

	var A = AUI();
	var data = {};
	
	AUI().ready('aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {
	var dialog = new A.Dialog({
			centered: true,
			destroyOnClose: true,
			draggable: true,
			height: 'auto',
			width: 600,
			resizable: false,
			modal: true,
			title: Liferay.Language.get('End User Licence Agreement'),
		}).render();
			dialog.plug(
				A.Plugin.IO,
				{
					data: data,
					uri: url,
				}
			);
	 });	
}

function showOrderId(data){
    AUI().ready('aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {
          var dialog = new A.Dialog({  
           title: 'Thank you', 
           centered: true,
			destroyOnClose: true,
			draggable: true,
			height: 'auto',
			width: 400,
			resizable: false,
			modal: true,
           bodyContent: data
           }).render();
       });
}
</script>
<%
PortletURL popupURL=renderResponse.createRenderURL();
popupURL.setWindowState(LiferayWindowState.EXCLUSIVE);
popupURL.setParameter("jspPage","/eula.jsp");
String popupScript = "registrationPopup('"+popupURL+"')";
%>
<aui:button value="Open" onclick="<%=popupScript%>" />
<aui:button value="show dialog" onclick="showOrderId('Hello Dialog box');" />

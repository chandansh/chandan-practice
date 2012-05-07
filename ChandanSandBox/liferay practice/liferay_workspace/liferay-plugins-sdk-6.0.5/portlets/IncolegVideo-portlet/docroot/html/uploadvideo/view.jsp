<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects />

<portlet:renderURL var='formURL' windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
    <portlet:param name="jspPage" value='/html/uploadvideo/form.jsp'/>
</portlet:renderURL>

<jsp:include page="form.jsp"></jsp:include>

<script type="text/javascript">

    function <portlet:namespace />showPopup() {
        AUI().use("aui-dialog", "aui-io", "event", "event-custom", function(A) {
            var dlg = new A.Dialog({
                title: "Upload Form",
                modal: true,
                centered: true,
                width: 400,
                height: 400,
                buttons: [
                    {
                        	text: "OK",
                        	handler: function(){ this.fire('close');}
                    }
                        ]
            
            }).plug(A.Plugin.IO, { uri: "<%= formURL %>" }).render();
            dlg.show();
        });
    }
</script>
	
<!--  <a href="javascript:void(0)" onclick="<portlet:namespace/>showPopup()">Click Here to upload</a> -->
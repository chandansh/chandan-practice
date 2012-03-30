<%@page	import="com.softslate.commerce.businessobjects.order.OrderItemBean"%>
<%@page import="com.softslate.commerce.businessobjects.order.OrderBean"%>
<%@ include file="/html/portlet/common/init.jsp"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.ArrayList"%>

<%
int orderId = ParamUtil.getInteger(renderRequest, "orderId");

System.out.println("AMPCLOUD VIEW.JSP orderId ===>"+orderId);

PortletURL editURL=renderResponse.createRenderURL();
PortletURL deleteURL=renderResponse.createRenderURL();

PortletURL renderURL = renderResponse.createRenderURL();
renderURL.setWindowState(LiferayWindowState.EXCLUSIVE);

PortletURL registrationPageURL = renderResponse.createRenderURL();
registrationPageURL.setWindowState(LiferayWindowState.EXCLUSIVE);
registrationPageURL.setParameter("orderId", String.valueOf(orderId));
registrationPageURL.setParameter("jspPage","/html/portlet/checkout/short_registration.jsp");

ResourceURL checkoutURL = renderResponse.createResourceURL();
checkoutURL.setParameter("orderId", String.valueOf(orderId));
checkoutURL.setParameter("jspPage","/html/portlet/checkout/successmessage.jsp");
String redirect = themeDisplay.getPortalURL()+"/web/guest/my-dashboard";

String popupScript = "";
if(!themeDisplay.isSignedIn()) {
	popupScript = "registrationPopup('"+registrationPageURL+"')"; 
} else {
	popupScript = "checkout('"+checkoutURL+"')"; 
}
%>

<portlet:resourceURL var="resourceURL" />

<script>
	AUI().ready("event","node",function(A){
	    
	    Liferay.on("cart-event",function(event){
	    	var resourceURL="<%=renderURL.toString()%>";
	        var handleSuccess = function(event, id, obj){
	       	var response = this.get("responseData");
	     	var div = A.one("#cart-result");
	      	div.html(response);
	      	div.fadeIn();
	        };
	        
	        A.io.request(resourceURL, {
	        	data: {
	        		productId:event.productId,
	        		quantity:event.quantity
	        	},
	        	on:{
	        		success : handleSuccess
	        	}
	        });
	    });
	});
	
	function registrationPopup(url) {

		var A = AUI();
		var data = {};
		
		AUI().ready('aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {
		var dialog = new A.Dialog({
				centered: true,
				destroyOnClose: true,
				draggable: true,
				height: 'auto',
				width: 400,
				resizable: false,
				modal: true,
				title: Liferay.Language.get('Customer Information'),
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

	function checkout(url){
		
		jQuery.ajax({
			type: "POST",
			url: url,
			error: function() {
				//alert("Internal Error - Please provide the details again.");
			},
			success: function(data){
				refreshCartPortlet();
				showOrderId(data);
		    } 
		});
		return true;
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

	function refreshCartPortlet() {
	    var plid = themeDisplay.getPlid();
	    var nsShort = ("<portlet:namespace/>".substr(1)).substr(0, "<portlet:namespace/>".length-2);
	    var portletId = "#p_p_id<portlet:namespace/>";
	    var loadId = "p_load<portlet:namespace/>";
	    url = "/c/portal/render_portlet?p_l_id=" + plid+ "&p_p_id="+nsShort+"&p_p_action=0&p_p_state=normal&p_p_mode=view";
	    
	    jQuery(portletId).load(url);
	}
	
	
</script>
<div id="cart-result">
	<%
		ArrayList<OrderItemBean> items = null;
		Map result = (HashMap) portletSession.getAttribute("cart-results",PortletSession.APPLICATION_SCOPE);
		if ( result != null){
			items = (ArrayList)result.get("newOrderItems");
			//System.out.println("values==========>"+items.size());
	%>

	<liferay-ui:search-container emptyResultsMessage="No-Product-Added-To-Cart">
		<liferay-ui:search-container-results
			results="<%=com.liferay.portal.kernel.util.ListUtil.subList(items, searchContainer.getStart(), searchContainer.getEnd())  %>"
			total="<%= items.size() %>" />

		<liferay-ui:search-container-row
			className="com.softslate.commerce.businessobjects.order.OrderItemBean"
			modelVar="orderItemBean">
			<%
				editURL.setParameter("orderId",(String.valueOf(orderItemBean.getOrderID())));
				editURL.setParameter("productId",(String.valueOf(orderItemBean.getProductID())));
				deleteURL.setParameter("productId",(String.valueOf(orderItemBean.getProductID())));
			%>
			<liferay-ui:search-container-column-text value="<%=(String.valueOf(orderItemBean.getOrder().getOrderID())) %>" name="Requisition Id" />
			<liferay-ui:search-container-column-text>
			<a href="<%=editURL %>">Edit</a>
			<a href="<%=deleteURL %>">Delete</a>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="code" name="code"  />
			<liferay-ui:search-container-column-text property="name" name="name"  />
			<liferay-ui:search-container-column-text property="quantity" name="quantity"  />
			<liferay-ui:search-container-column-text property="total" value="total"  />
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

	<aui:button value="Checkout >" onclick="<%= popupScript %>" />
	<% }else{
		out.println("No cart available.");
	}
	%>
</div>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />


This is the
<b>Portlet 2 </b>
portlet. Parameter customer Id is:
<%=ParamUtil.getLong(renderRequest, "customerId")%>
Session Attribute is :<%=portletSession.getAttribute("sessionAttr")%>

<h1><%=session.hashCode()%></h1>
<h1><%=session.getId()%></h1>
<%
	PortletURL showCustomerDetails = renderResponse.createRenderURL();
	showCustomerDetails.setParameter("action", "showCustomerDetails");
	showCustomerDetails.setWindowState(LiferayWindowState.EXCLUSIVE);
	//showCustomerDetails.setParameter("customerID", "100000");
%>


<a href="<%=showCustomerDetails%>">Show Customer Details</a>

<script>

AUI().ready("event","node",function(A){
	Liferay.on("customerSelectedEvent",function(event){
		alert("Portlet2  Customer Id :"+event.customerID);
		getCustomerDetails(event.customerID);
	});
	
	
});

function getCustomerDetails(custID){
	var showCustomerDetails = "<%=showCustomerDetails%>";

	  alert("before request");

		  AUI().use("event", "aui-io-request", "node", function(A) {
			  
		    handleSuccess = function(event, id, obj) {
		         var responseData = this.get("responseData");
			     var divObj = A.one("#customerDetails");
			     divObj.html(responseData);
				}

			A.io.request(showCustomerDetails, {
				data : {
					customerID : custID
				},
				on : {
					success : handleSuccess
				}

			});
			
		});
		 
		  alert("after request");

	}
	
	function getCustomers() {

		AUI().use("event", "node", function(A) {
			var divObj = A.one("#customerListing");
			divObj.html("<h3>Hello</h3>");
			divObj.fadeIn();
		});
	}
</script>

<aui:button value="Get customers" onClick="getCustomers()"></aui:button>
<aui:button value="Get customer Details" onClick="getCustomerDetails(101)"></aui:button>
<div id="customerDetails"></div>

<div id="customerListing">
	<h1>Customer Listing....</h1>
</div>
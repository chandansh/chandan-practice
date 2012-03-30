
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>Portlet 1 </b> portlet.
<%
	PortletURL url= renderResponse.createRenderURL();
	url.setParameter("customerId","555");
	portletSession.setAttribute("sessionAttr1", "chandan1");
	portletSession.setAttribute("sessionAttr", "chandan", PortletSession.APPLICATION_SCOPE);
	
	
	String cName =this.getClass().getClassLoader().getParent().getParent().getParent().getParent().getClass().getName();
	String cname =this.getClass().getClassLoader().getParent().getParent().getParent().getClass().getName();
	String uCName= UserLocalServiceUtil.class.getClassLoader().getClass().getName();
%>
<h2><%=cname %></h2>
User class class Loader <%=uCName %>
<a href="<%=url%>">Render URL</a>
<h1><%=session.hashCode() %></h1>
<h1><%=session.getId() %></h1>
Parameter customer Id is: <%=ParamUtil.getLong(renderRequest,"customerId")%><br>
Session Attribute is :<%=portletSession.getAttribute("sessionAttr", PortletSession.APPLICATION_SCOPE)%><br>
Session Attribute1 is :<%=portletSession.getAttribute("sessionAttr1")%>

<script>

function getDetails(custID){
	
	//var emp= {id:101, name:"Shakir", Location:{city:"mumbai", state:"MH"}};
	//alert("before firing event");
	Liferay.fire("customerSelectedEvent",{customerID:custID});
	//alert("after firing event");
	
}
</script>
<ol>
  <li> <a href="javascript:;" onclick="getDetails(101)">IBM</a> </li>
  <li> <a href="javascript:;" onclick="getDetails(102)">Infy</a> </li>
  <li> <a href="javascript:;" onclick="getDetails(103)">CA</a> </li>
</ol>

<hr />


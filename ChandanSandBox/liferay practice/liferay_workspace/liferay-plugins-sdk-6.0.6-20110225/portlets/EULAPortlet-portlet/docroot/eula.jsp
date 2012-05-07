<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:actionURL var="EULAaction" />

<style>
#eulaForm textarea{
	width: 500px;
	height: 100px;
}
</style>

<h3 align="center">User Agreements</h3>
<div id="eulaForm">
<aui:form action="<%=EULAaction%>" method="post">
	<b>End User License Agreements (EULAs)</b>&nbsp;<a href="#">Download PDF version</a>
	<aui:input name="eula1" type="textarea" value="abc" label="" />
	<aui:input name="eula-checkbox1" type="checkbox" label="I Agree" />
	
	<br>
	<b>End User Agreements / Terms of Use</b>&nbsp;<a href="#">Download PDF version</a>
	<aui:input name="eula2" type="textarea" value="xyz" label="" cssClass="eula-textarea"  />
	<aui:input name="eula-checkbox2" type="checkbox" label="I Agree" />
	
	<aui:button type="submit" value="submit"></aui:button>
</aui:form>
</div>
<%@ include file="/html/library/init.jsp" %>
<%@ page import=" com.library.slayer.model.SocialBean "%>

<%

SocialBean beanOne = new SocialBean();
beanOne=(SocialBean)session.getAttribute("bean");

%>
<portlet:actionURL name="firstForm" var="formoneURL" />

<aui:form name="fm" method="POST"  action="<%=formoneURL.toString() %>">
	<aui:input name="form" type="hidden" value="formone" />
	
	<aui:input name="firstName" label="First Name" value="<%=((beanOne!=null))?beanOne.getFirstName():' '%>" helpMessage="please enter your first name">
		<aui:validator name="required" errorMessage="please specify your first name" />
	</aui:input>
	<aui:input name="lastName" label="Last Name" value="<%=((beanOne!=null))?beanOne.getLastName():' '%>" helpMessage="please enter your second name">
		<aui:validator name="required" errorMessage="please specify your last name" />
	</aui:input>
	<aui:input name="streetAddress1" label="StreetAddress1" value="<%=((beanOne!=null))?beanOne.getStreet1():' '%>" helpMessage="please enter your address">
		<aui:validator name="required" errorMessage="please specify your address" />
	</aui:input>
	<aui:input name="streetAddress2" value="<%=((beanOne!=null))?beanOne.getStreet2():' '%>" label="StreetAddress2" />
	<aui:input name="city" label="City" value="<%=((beanOne!=null))?beanOne.getCity():' '%>" helpMessage="please enter your city">
		<aui:validator name="required" errorMessage="please specify your city"></aui:validator>
	</aui:input>
	<aui:input name="zip" label="Zip" value="<%=((beanOne!=null))?beanOne.getZip():' '%>" helpMessage="please enter  zip">
		<aui:validator name="required" errorMessage="please specify your zip"></aui:validator>
	</aui:input>
	
	<input name="" type="submit" value="next"  />
</aui:form>

<%@ include file="/html/library/init.jsp" %>
<%@ page import=" com.library.slayer.model.SocialBean "%>

<%

PortletURL submitURL = renderResponse.createActionURL();
submitURL.setParameter(ActionRequest.ACTION_NAME, "formSubmit");

PortletURL backURL = renderResponse.createActionURL();
backURL.setParameter(ActionRequest.ACTION_NAME, "firstForm");

SocialBean socialBeanTwo = (SocialBean)session.getAttribute("beanTwo");
if(Validator.isNotNull(session.getAttribute("beanTwo")))
{
	System.out.println("form one bean" + socialBeanTwo);
}


%>
<aui:form name="fm2" method="POST"  action="<%=submitURL.toString() %>">
	<aui:input name="form" type="hidden" value="formtwo" />
	
	<aui:input name="emailAddress" label="Email Address"  value="<%=((socialBeanTwo!=null))?socialBeanTwo.getEmailAddress():' ' %>" helpMessage="please enter your email address">
		<aui:validator name="required" errorMessage="please specify your email address" />
	</aui:input>
	<aui:input name="phoneNumber" label="Phone Number" value="<%=((socialBeanTwo!=null))?socialBeanTwo.getPhoneNumber():' ' %>" helpMessage="please enter your phone number"/>
	<aui:input name="mobileNumber" value="<%=((socialBeanTwo!=null))?socialBeanTwo.getMobileNumber():' ' %>" label="Mobile Number" >
		<aui:validator name="required" errorMessage="please specify your mobile number" />
	</aui:input>
	
	<aui:button-row cssClass="align_right">
    	<aui:button type="button"  value="prev" name="prev" onClick="javascript:previous();" />
       	<aui:button type="submit"  value="submit" name="submit" />
    </aui:button-row>
</aui:form>

<script type="text/javascript">
function previous(){
	alert("want to go back");
    document.<portlet:namespace />fm2.action = "<%=backURL.toString() %>";
   	document.<portlet:namespace />fm2.submit();
}
</script>

<%@taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />
<h1>My spring Portlet</h1>
<script type="text/javascript">
function submitForm(){
	alert("hi");
	document.<portlet:namespace />fm.submit();
}

</script>

<aui:form name="fm" action="<%=renderResponse.createActionURL()%>" method="post">
	<aui:select name="dcl" onChange="submitForm()">
		<aui:option value="dallas">dallas</aui:option>
		<aui:option value="delhi">Delhi</aui:option>
	</aui:select>
</aui:form>

Hello <c:out value="${dcl}"></c:out>

<a href="#" onclick="submitForm();">hi</a>
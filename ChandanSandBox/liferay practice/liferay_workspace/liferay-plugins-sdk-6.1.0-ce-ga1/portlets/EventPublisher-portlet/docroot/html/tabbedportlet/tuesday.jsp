<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<h1>Tuesday</h1>
<c:if test="<%=themeDisplay.isSignedIn()%>" >
 
<liferay-ui:user-display
displayStyle="0"
userId="<%= themeDisplay.getUser().getUserId() %>"
/>
</c:if>

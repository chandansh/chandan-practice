<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<portlet:defineObjects/>
<h2>Hello ${model.username}. Can you guess a number
from ${model.minimum} to ${model.maximum}?</h2>
<%
String context = renderRequest.getPortletSession().getPortletContext().getPortletContextName();
%>
<form method="POST" action="<portlet:actionURL/>">
	<img src="/<%=context%>/images/guess.png"/>
	<input type="text" name="answer" value=""/>
	<input type="submit" name="submit" value="submit"/>
</form>

<i>Hint: The correct answer is <b>${model.number}</b></i>

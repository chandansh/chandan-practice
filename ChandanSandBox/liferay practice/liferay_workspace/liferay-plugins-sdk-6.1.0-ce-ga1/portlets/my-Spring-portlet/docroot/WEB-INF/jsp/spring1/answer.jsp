<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<portlet:defineObjects/>
<%
String context = renderRequest.getPortletSession().getPortletContext().getPortletContextName();
%>
<img src="/<%=context%>/images/guess.png"/><br/>

<h2><c:if test="${model.correct}"><b>Correct!</b></c:if></h2>
<h2><c:if test="${model.correct == false}">Sorry, <b>${model.answer}</b> is incorrect.</c:if></h2>

<br/>The answer was <b>${model.number}</b>.<br/>

<a href="<portlet:renderURL/>"> - Play Again - </a>
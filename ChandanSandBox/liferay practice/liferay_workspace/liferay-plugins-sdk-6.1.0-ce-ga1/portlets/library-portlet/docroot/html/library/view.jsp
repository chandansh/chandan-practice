<%@ include file="/html/library/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:actionURL var="findURL" name="findBooks" />
<%
	PortletURL listBooksURL = renderResponse.createRenderURL();
	listBooksURL.setParameter("list", "list");
	listBooksURL.setParameter("jspPage", "/html/library/list.jsp");

	String toolbarItem = ParamUtil.getString(request, "toolbarItem", "view");
%>
<h1>Welcome to our library</h1>

<portlet:renderURL var="updateBookURL">
	<portlet:param name="jspPage" value="/html/library/update.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="userInfoURL">
	<portlet:param name="jspPage" value="/html/library/userInfo.jsp"/>
</portlet:renderURL>
<c:if test="<%=themeDisplay.getLayout().getGroup().isControlPanel() %>">

<div class="lfr-portlet-toolbar">
	
	<span class="lfr-toolbar-button view-button <%=toolbarItem.equals("view-all") ? "current" : StringPool.BLANK%>">
		<a href="<%=listBooksURL%>"><liferay-ui:message key="view-all" /></a>
	</span>
	
	<liferay-ui:icon-menu align="left" cssClass='<%= "lfr-toolbar-button add-button " + (toolbarItem.equals("add") ? "current" : StringPool.BLANK) %>' direction="down" extended="<%= false %>" icon='<%= themeDisplay.getPathThemeImages() + "/common/add.png" %>' message="add" showWhenSingleIcon="<%= true %>">

	<liferay-ui:icon
		image="user_icon"
		message="Book"
		url="<%= updateBookURL %>"
	/>
			
	</liferay-ui:icon-menu>
</div>

</c:if>

 <a href="<%=updateBookURL%>">Add new Book &raquo;</a>
 <a href="<%=listBooksURL.toString()%>">Show all books &raquo;</a>
 <a href="<%=userInfoURL%>">User Information &raquo;</a>
  
 
<liferay-ui:error exception="<%= BookExistsException.class %>" message="Book Already Exists" />
<%
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("jspPage", "/html/library/search.jsp");

	PortletURL advancesearchURL = renderResponse.createRenderURL();
	advancesearchURL.setParameter("jspPage", "/html/library/advancesearch.jsp");
%>

<aui:form method="POST" action="<%=searchURL.toString() %>">
	<aui:input  name="keyword" label="Enter Search Keyword"/> 
	<aui:button type="submit" value="search"/>
</aui:form> 


<aui:form method="POST" action="<%=advancesearchURL.toString() %>">
	<aui:select name="type" label="Match Type">
		<aui:option name="match" label="Any" value="Any"/>
		<aui:option name="match" label="All" value="All"/>
	</aui:select>
	<aui:input  name="title" label="BookTitle"/>
	<aui:input  name="author" label="Author"/>
	<aui:input  name="desc" label="Description"/>
	<aui:button type="submit" value="search"/>
</aui:form>

<form action="<%=findURL.toString()%>" name="fm" method="post">

	<label>Book Title</label> <input name="bookTitle" value="" /> 
	<input type="submit" value="Search" />

</form>

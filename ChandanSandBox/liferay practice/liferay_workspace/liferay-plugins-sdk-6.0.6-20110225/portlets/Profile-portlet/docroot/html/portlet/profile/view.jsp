<%@ include file="/html/init.jsp"%>
<h1>Hello Struts portlet</h1>
<%
   PortletURL url = renderResponse.createRenderURL();
   url.setParameter("_spage", "/portlet_action/profile/edit_profile");
   url.setParameter("actionMethod", "saveProfile");

%>

<a href="<%=url%>">Edit Profile</a>
<%@page import="java.util.Enumeration"%>
<%@page import="com.google.appengine.repackaged.org.json.JSONObject"%>
<%@page import="com.googlecode.objectify.ObjectifyService"%>
<%@page import="com.incoleg.fb.server.model.FacebookUser"%>
<%@page import="com.googlecode.objectify.Objectify"%>
<%@page import="com.incoleg.fb.server.model.Payload"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.google.appengine.api.urlfetch.HTTPMethod"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="com.incoleg.fb.server.util.FacebookUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%!
	private static final String APP_ID = "266730843346616";
	private static final String APP_SECRET = "8b2e0dbdcc73975a0de79861c2c79d98";
%>
<% System.err.println("METHOD: " + request.getMethod()); %>
<!DOCTYPE html>
<html xmlns:og="http://ogp.me/ns#" xmlns:fb="https://www.facebook.com/2008/fbml" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Login Page</title>
	<style type="text/css">
		body { font-family: Verdana; font-size: 12px; }
	</style>
</head>
<body>
	<div id="fb-root"></div>
	<script src="http://connect.facebook.net/en_US/all.js"></script>
	<script type="text/javascript">
		//FB.Canvas.setSize({ height: 600 });
	</script>
	This is Login Page<br>
	Code: <%= session.getAttribute("state") %>
	<br/>
	Access Token: <%= request.getParameter("signed_request") %>
	<br/>
	<%
	Enumeration<String> pns = request.getParameterNames();
	while (pns.hasMoreElements()) {
		String name = pns.nextElement();
		String value = request.getParameter(name);
%><%=name%>: <%=value%>
<%
	}
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String sr = request.getParameter("signed_request");
		System.out.println(sr);
		String guid = FacebookUtil.random(16);
		session.setAttribute("state", guid);
		String diagURL = "https://www.facebook.com/dialog/oauth?client_id=" + APP_ID + "&redirect_uri="
				+ URLEncoder.encode("http://" + request.getLocalName() + ":" + request.getLocalPort() + "/xfb/login.jsp", "UTF-8")
				+ "&scope=" + URLEncoder.encode("email,read_stream,publish_stream,manage_pages,offline_access,user_groups,friends_groups", "UTF-8")
				+ "&state=" + URLEncoder.encode(guid, "UTF-8");
		{
			if(sr != null)
			{
				String[] parts = FacebookUtil.decodeSignedRequest(sr);
				Payload payload = new Payload(parts[1]);
				if(payload != null && payload.has("user_id") && payload.has("oauth_token"))
				{
					Objectify ofy = ObjectifyService.begin();
					FacebookUser fu = ofy.find(FacebookUser.class, payload.getUserID());
					Map<String, String> p = new HashMap<String, String>();
					p.put("fields", "email,name,first_name,last_name,gender,link,username,third_party_id,verified,birthday,bio,friends");
					//p.put("fields", "name,first_name,last_name,gender,link,username,third_party_id,verified,birthday,bio,groups");
					String meData = FacebookUtil.fetchData(FacebookUtil.Service.GRAPH, "/me", HTTPMethod.GET, payload.getOAuthToken(), p);

					if(fu != null) {
		%>
		<div>User exists, first access at: <%= fu.getFirstAccessTime() %></div>
		<%
					} else {
		%>
		<div>User does not exist</div>
		<%
						fu = new FacebookUser();
						fu.setUserId(payload.getUserID());
						fu.setAccessToken(payload.getOAuthToken());
						fu.setFirstAccessTime(new java.util.Date());
						fu.setActive(true);
						fu.setExpiryTime(payload.getExpiryTime());
						ofy.put(fu);
		%>
		<div>Added...</div>
		<%
					}

					{
						JSONObject meObj = new JSONObject(meData);
						fu.setEmail(meObj.has("email") ? meObj.getString("email") : "");
						fu.setFirstName(meObj.has("first_name") ? meObj.getString("first_name") : "");
						fu.setLastName(meObj.has("last_name") ? meObj.getString("last_name") : "");
						fu.setGender(meObj.has("gender") ? meObj.getString("gender") : "");
						fu.setLink(meObj.has("link") ? meObj.getString("link") : "");
						fu.setUsername(meObj.has("username") ? meObj.getString("username") : "");
						fu.setVerified(meObj.has("verified") ? meObj.getBoolean("verified") : false);
						ofy.put(fu);
		%>
		<div style='overflow: auto; height: 500px; border: 1px solid #cccccc; background-color: #f2f2f2'><pre>Me = <%= meObj.toString(1) %></pre></div>
		<%
					}
		%>
		<div>Updated...</div>
	<%
				} else
				{
	%>
		<div id='go' style='cursor: hand; cursor: pointer; margin-top: 10px'>Login with facebook</div>
		<script type="text/javascript">
		<!--
			document.getElementById('go').onclick = function() {
				top.location.href = '<%= diagURL %>';
			};
		//-->
		</script>
	<%
				}
			} else if(state!=null && state.equals(session.getAttribute("state")))
			{
				//String accessTokenResponse = 
				Map<String, String> ps = new HashMap<String, String>();
				ps.put("client_id", APP_ID);
				ps.put("redirect_uri", "http://" + request.getLocalName() + ":" + request.getLocalPort() + "/xfb/login.jsp");
				ps.put("client_secret", APP_SECRET);
				ps.put("code", code);

				String atr = FacebookUtil.fetchData(FacebookUtil.Service.GRAPH, "/oauth/access_token", HTTPMethod.POST, null, ps);
	%>
	<div>Response: <%= atr %></div>
	<script type="text/javascript">
	<!--
		top.location.href = "http://apps.facebook.com/withmyalumni";
	//-->
	</script>
	<%
			} else
			{
	%>
	Session State: <%= session.getAttribute("state") %>
	<div>Forgery ho gayee bhaiyya</div>
	
	<div id='go' style='cursor: hand; cursor: pointer; margin-top: 10px'>Login with facebook</div>
		<script type="text/javascript">
		<!--
			document.getElementById('go').onclick = function() {
				top.location.href = '<%= diagURL %>';
			};
		//-->
		</script>
	<%
			}
		}
	%>
</body>
</html>















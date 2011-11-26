<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.appengine.repackaged.org.json.JSONObject"%>
<%@page import="com.google.appengine.api.urlfetch.HTTPMethod"%>
<%@page import="java.text.MessageFormat"%>
<%@page import="javax.crypto.spec.SecretKeySpec"%>
<%@page import="javax.crypto.Mac"%>
<%@page import="com.incoleg.fb.server.model.FacebookUser"%>
<%@page import="com.googlecode.objectify.Objectify"%>
<%@page import="com.googlecode.objectify.ObjectifyService"%>
<%@page import="com.incoleg.fb.server.model.Payload"%>
<%@page import="com.incoleg.fb.server.util.FacebookUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%!
	//App ID is of the app "Alumni Network"
	private static final String APP_ID = "163062557110040";
	private static final String APP_SECRET = "3763a1c885e30a19155e621f5f5b44d4";
%>
<% System.err.println("METHOD: " + request.getMethod()); %>
<!DOCTYPE html>
<html xmlns:og="http://ogp.me/ns#" xmlns:fb="https://www.facebook.com/2008/fbml" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Main Page</title>
	<style type="text/css">
		body { font-family: Verdana; font-size: 12px; }
	</style>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
</head>
<body>
	<div id="fb-root"></div>
	<script src="http://connect.facebook.net/en_US/all.js"></script>
	<script>

		//FB.Canvas.setAutoResize(true);
		window.fbAsyncInit = function() {
			//FB.Canvas.setAutoResize();
			FB.Canvas.setSize({ height: 540 });
		};

		function showAllPropsAndValues(item) {
			var _t = "";
			for(var idx in item) {
				_t += idx + ":" + item[idx] + '\n';
			}
			alert('Props:\n' + _t);
		}

		jQuery(document).ready(function() {
			FB.init({
				appId : '<%= APP_ID %>',
				cookie : true,
				status : true,
				xfbml : true
			});

			FB.getLoginStatus(function(response) {
				//showAllPropsAndValues(response || { });
				//alert('Got Login Status: ' + response + ", ar: " + response.authResponse + ", status: " + response.status);
				if(response.session) {
					jQuery("#login").html("Welcome <b>" + response.session.uid + "</b>");
				}
			});

			jQuery("#check").click(function() {
				FB.getLoginStatus(function(response) {
					//showAllPropsAndValues(response || { });
					if(response.session) {
						jQuery("#login").html("Welcome <b>" + response.authResponse.userID + "</b>");
					}
				});
			});
		});
	</script>
	<div id="login">
		<fb:login-button
			redirect-uri="http://127.0.0.1:8888/xfb/"
			onlogin="doWork.apply(this, arguments)"
			perms="email,read_stream,publish_stream,user_groups,friends_groups">Login with Facebook</fb:login-button>
	</div>
	<button id='check'>Check</button>
	<hr/>
	<%
		String signedRequest = request.getParameter("signed_request");
		if(signedRequest != null) {
			String[] parts = FacebookUtil.decodeSignedRequest(signedRequest);

			if(request.getAttribute("abcd") != null)
			{
				Mac mac = Mac.getInstance("HmacSHA256");
				SecretKeySpec sks = new SecretKeySpec(APP_SECRET.getBytes(), "HmacSHA256");
				mac.init(sks);
				byte[] rawOut = mac.doFinal(parts[1].getBytes());
				for(int i = 0; i < rawOut.length; i++)
				{
			%><%= String.format("%1$x", rawOut[i]) %><%
				}
			%><br/><%
				for(byte b: parts[0].getBytes())
				{
			%><%= String.format("%1$x", b) %><%
				}
			}
			Payload payload = new Payload(parts[1]);
	%>
	<br/>
	<div>Signature: <%= parts[0] %></div>
	<!-- div>Payload: <%= parts[1].replace(",", ", ") %></div-->
	<div>&nbsp;</div>
	<%
			if(payload != null && payload.has("user_id") && payload.has("oauth_token")) {
				Objectify ofy = ObjectifyService.begin();
				FacebookUser fu = ofy.find(FacebookUser.class, payload.getUserID());
				Map<String, String> p = new HashMap<String, String>();
				p.put("fields", "name,first_name,last_name,gender,link,username,third_party_id,verified,birthday,bio");
				String meData = FacebookUtil.fetchData(FacebookUtil.Service.GRAPH, "/me", HTTPMethod.GET, payload.getOAuthToken(), p);

				if(fu != null) {
	%>
	<div>User exists, first access at: <%= fu.getFirstAccessTime() %></div>
	<%
				} else {
	%>
	<div>User does not exist index.jsp page </div>
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
	<div><pre>Me = <%= meObj.toString(1) %></pre></div>
	<%
				}
	%>
	<div>Updated...</div>
	<%
	
			} else {
				%>
				<div>Oops! User ID not found. Probably, not authenticated... will redirect in 5 seconds</div>
				<%
				String diagURL = "https://www.facebook.com/dialog/oauth?client_id=" + APP_ID + "&redirect_uri="
					+ URLEncoder.encode("http://" + request.getLocalName() + ":" + request.getLocalPort() + "/login.jsp", "UTF-8")
					+ "&scope=" + URLEncoder.encode("email,read_stream,publish_stream,manage_pages,friends_groups,user_groups", "UTF-8");
				%>
				<div>Will redirect to <%= diagURL %></div>
				<script type="text/javascript">
				<!--
					//setTimeout(function() { top.location.href = '<%= diagURL %>'; }, 1000);
				//-->
				</script>
				<%
			}
		}
				%>
</body>
</html>















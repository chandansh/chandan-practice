<!doctype html>
<%@page import="com.google.appengine.repackaged.org.json.JSONException"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="base64.MyBase64"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.appengine.api.urlfetch.HTTPHeader"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.google.appengine.api.urlfetch.HTTPMethod"%>
<%@page import="com.google.appengine.api.urlfetch.HTTPResponse"%>
<%@page import="com.google.appengine.api.urlfetch.URLFetchService"%>
<%@page
	import="com.google.appengine.api.urlfetch.URLFetchServiceFactory"%>
<%@page import="java.net.URL"%>
<%@page import="com.google.appengine.api.urlfetch.HTTPRequest"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.google.appengine.repackaged.org.json.JSONObject"%>
<%@page import="java.util.Enumeration"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="http://connect.facebook.net/en_US/all.js"></script>
<script type="text/javascript">
// 	jQuery(document).ready(function() {
// 		FB.init({
// 			appId : '266730843346616',
// 			cookie : true,
// 			status : true,
// 			xfbml : true
// 		});
// 	});

	function onLogin() {
		//FB.getLoginStatus()
	}

	//alert('JSON, stringfy: ' + (typeof JSON.stringify));
</script>
</head>
<body>
<%!
String oauth_token = null;
String signed_request=null;
%>
	<div id="fb-root"></div>
	<fb:login-button onlogin="onLogin()"
		perms="email,read_stream,publish_stream">Login With Facebook</fb:login-button>
	<hr />
	<fb:add-to-timeline></fb:add-to-timeline>
	<a href="car.jsp">Car</a>
	<pre>
	<%
		Enumeration<String> pns = request.getParameterNames();
		while (pns.hasMoreElements()) {
			String name = pns.nextElement();
			String value = request.getParameter(name);
	%><%=name%>: <%=value%>
	<%
		}
		signed_request = request.getParameter("signed_request");
		
		if (signed_request != null) {
			String val = signed_request.substring(signed_request
					.indexOf(".") + 1);
			System.out.println("signed_request :");
			System.out.println(val);

			//String s = "eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImV4cGlyZXMiOjEzMTcwNTI4MDAsImlzc3VlZF9hdCI6MTMxNzA0NjQ3MCwib2F1dGhfdG9rZW4iOiJBQUFEeWx4MHJGcmdCQU1FYUtURmJWN05RWWExSHdGOGxtMThBWDJFWXdoZWg1TlpBaUppUVB2QnF4eVRINWlTbmJicERWNFVzamdBS1ZaQUdNbW8wSmEwUFRKTXZxdWtOTmVaQ2t3aVpCTlI4UE1BYXYwc1ciLCJ1c2VyIjp7ImNvdW50cnkiOiJpbiIsImxvY2FsZSI6ImVuX1VTIiwiYWdlIjp7Im1pbiI6MjF9fSwidXNlcl9pZCI6IjEwMDAwMDU0NTI0NTA5OCJ9";
			byte[] b1 = MyBase64.decode(val);
			// System.out.println(new String(b));

			try {
				String jsonRespo = new String(b1, "UTF-8");
				JSONObject obj = new JSONObject(jsonRespo);
				if (obj.has("oauth_token")) {
					oauth_token = obj.getString("oauth_token");
				}
				// 			String user_id = obj.getString("user_id");
				// 			System.out.println("auth token : " + oauth_token);
				// 			System.out.println("user ID : " + user_id);

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	%>
	</pre>
	<hr />
	<form action="index.jsp" method="post">
		<input type="text" name="wall_post"> <input type="submit"
			value="post on your wall">
	</form>
	<hr />
	<br />

	<pre>
		<%
			Logger l = Logger.getLogger(getClass().getName());
			try {

				if (oauth_token != null) {
					//String accToken = "AAADylx0rFrgBAMEaKTFbV7NQYa1HwF8lm18AX2EYwheh5NZAiJiQPvBqxyTH5iSnbbpDV4UsjgAKVZAGMmo0Ja0PTJMvqukNNeZCkwiZBNR8PMAav0sW";
					String accToken = oauth_token;
					HTTPRequest req = new HTTPRequest(new URL(
							"https://graph.facebook.com/me?access_token="
									+ accToken), HTTPMethod.GET);
					//req.setPayload()
					URLFetchService svc = URLFetchServiceFactory
							.getURLFetchService();

					HTTPResponse respo = svc.fetch(req);
					byte[] output = respo.getContent();
					String jsonRespo = new String(output, "UTF-8");
					JSONObject obj = new JSONObject(jsonRespo);
					String fbid = obj.getString("id");
					String name = obj.getString("name");
					JSONObject obj1 = obj.getJSONObject("location");
					String address = obj1.getString("name");
					out.print("facebook ID :" + fbid + "\n");
					out.print("Hello " + name + "\nAddress :" + address + "\n");
					String wall_post = request.getParameter("wall_post");

					System.err.println("User ID: " + fbid);
					l.log(Level.SEVERE, "User ID: " + fbid);
					System.err.println("Access Token: " + accToken);
					l.log(Level.SEVERE, "Access Token: " + accToken);

					if (wall_post != null) {
						HTTPRequest req1 = new HTTPRequest(
								new URL("https://graph.facebook.com/" + fbid
										+ "/feed"), HTTPMethod.POST);

						StringBuilder indata = new StringBuilder();
						Map<String, String> rindata = new HashMap<String, String>();
						rindata.put("message", wall_post);
						rindata.put("access_token", accToken);
						//rindata.put("app_id","266730843346616");

						boolean first = true;
						for (String k : rindata.keySet()) {
							if (!first) {
								indata.append('&');
							}
							first = false;
							indata.append(k);
							indata.append('=');
							indata.append(rindata.get(k));
						}

						String rawPayload = indata.toString();

						System.err.println("Raw Payload: " + rawPayload);
						l.log(Level.WARNING, "Raw Payload: " + rawPayload);

						byte[] payload = rawPayload.getBytes();
						req1.setHeader(new HTTPHeader("Content-Type",
								"application/x-www-form-urlencoded"));
						req1.setHeader(new HTTPHeader("Content-Length", String
								.valueOf(payload.length)));
						req1.setPayload(payload);

						HTTPResponse respo1 = svc.fetch(req1);
						byte[] output1 = respo1.getContent();
						String jsonrespo1 = new String(output1, "UTF-8");
						JSONObject obj2 = new JSONObject(jsonrespo1);
						out.print("wall post reponse :\n<hr/>");
						out.print(obj2.toString(2));
					}
					out.print("\n<hr/>");
					out.print(obj.toString(2));
				}
		%>
		
		
		
	<%
								} catch (Throwable t) {
									t.printStackTrace(System.err);
									t.printStackTrace(System.out);
									throw new ServletException(t.getMessage(), t);
								}
							%>
	</pre>
</body>
</html>












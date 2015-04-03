import java.io.UnsupportedEncodingException;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class TestBase64 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*String s = "eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImV4cGlyZXMiOjEzMTcwNTI4MDAsImlzc3VlZF9hdCI6MTMxNzA0NjQ3MCwib2F1dGhfdG9rZW4iOiJBQUFEeWx4MHJGcmdCQU1FYUtURmJWN05RWWExSHdGOGxtMThBWDJFWXdoZWg1TlpBaUppUVB2QnF4eVRINWlTbmJicERWNFVzamdBS1ZaQUdNbW8wSmEwUFRKTXZxdWtOTmVaQ2t3aVpCTlI4UE1BYXYwc1ciLCJ1c2VyIjp7ImNvdW50cnkiOiJpbiIsImxvY2FsZSI6ImVuX1VTIiwiYWdlIjp7Im1pbiI6MjF9fSwidXNlcl9pZCI6IjEwMDAwMDU0NTI0NTA5OCJ9";
		byte[] b = MyBase64.decode(s);
		// System.out.println(new String(b));
		String jsonRespo;
		try {
			jsonRespo = new String(b, "UTF-8");
			JSONObject obj = new JSONObject(jsonRespo);
			String oauth_token = obj.getString("oauth_token");
			String user_id = obj.getString("user_id");
			System.out.println("auth token : " + oauth_token);
			System.out.println("user ID : " + user_id);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

//		String signed_request = "qMVU0PH0h8u3KjoXsu5g8OX-WF2G7tXUOHMeHUE1NNo.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImV4cGlyZXMiOjEzMTcwNTI4MDAsImlzc3VlZF9hdCI6MTMxNzA0NjYzMywib2F1dGhfdG9rZW4iOiJBQUFEeWx4MHJGcmdCQU1FYUtURmJWN05RWWExSHdGOGxtMThBWDJFWXdoZWg1TlpBaUppUVB2QnF4eVRINWlTbmJicERWNFVzamdBS1ZaQUdNbW8wSmEwUFRKTXZxdWtOTmVaQ2t3aVpCTlI4UE1BYXYwc1ciLCJ1c2VyIjp7ImNvdW50cnkiOiJpbiIsImxvY2FsZSI6ImVuX1VTIiwiYWdlIjp7Im1pbiI6MjF9fSwidXNlcl9pZCI6IjEwMDAwMDU0NTI0NTA5OCJ9";
		String signed_request="eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImlzc3VlZF9hdCI6MTMxNzA0OTYwNywidXNlciI6eyJjb3VudHJ5IjoiaW4iLCJsb2NhbGUiOiJlbl9VUyIsImFnZSI6eyJtaW4iOjIxfX19";
		String val = signed_request.substring(signed_request.indexOf(".") + 1);
		System.out.println("signed_request :");
		System.out.println(val);

		//String s = "eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImV4cGlyZXMiOjEzMTcwNTI4MDAsImlzc3VlZF9hdCI6MTMxNzA0NjQ3MCwib2F1dGhfdG9rZW4iOiJBQUFEeWx4MHJGcmdCQU1FYUtURmJWN05RWWExSHdGOGxtMThBWDJFWXdoZWg1TlpBaUppUVB2QnF4eVRINWlTbmJicERWNFVzamdBS1ZaQUdNbW8wSmEwUFRKTXZxdWtOTmVaQ2t3aVpCTlI4UE1BYXYwc1ciLCJ1c2VyIjp7ImNvdW50cnkiOiJpbiIsImxvY2FsZSI6ImVuX1VTIiwiYWdlIjp7Im1pbiI6MjF9fSwidXNlcl9pZCI6IjEwMDAwMDU0NTI0NTA5OCJ9";
		byte[] b1 = MyBase64.decode(val);
		// System.out.println(new String(b));
		
		try {
			String jsonRespo = new String(b1, "UTF-8");
			JSONObject obj = new JSONObject(jsonRespo);
			System.out.println(obj.has("oauth_token"));
			String oauth_token = obj.getString("oauth_token");
			String user_id = obj.getString("user_id");
			System.out.println("auth token : " + oauth_token);
			System.out.println("user ID : " + user_id);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

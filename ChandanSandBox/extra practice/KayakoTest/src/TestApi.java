import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class TestApi {

	public static void main(String[] args) throws ClientProtocolException,
			IOException, URISyntaxException, GeneralSecurityException {
		HttpClient client = new DefaultHttpClient();

		String secretKey = "N2JmMzI3ZjUtNDc3MC04ZTU0LWIxNzktOGZjZDcyNGRlOGY5NThlMzVkNzAtZjg5MS0yZjk0LWIxYmMtNDU3YTc0M2MxNTkx";
		String salt = "1234567890";

		String firstname = "raju";
		String lastname = "kumar";
		String username = "raju";
		String password = "raju123";
		String staffgroupid = "2";
		String email = "raju@mpowerglobal.com";

		String generateHmacSHA256Signature = GenerateSalt
				.generateHmacSHA256Signature(salt, secretKey);
		System.out.println("Signature: " + generateHmacSHA256Signature);
		String urlEncodedSign = URLEncoder.encode(generateHmacSHA256Signature,
				"UTF-8");

		/*
		 * String urlEncodedSign =
		 * URLEncoder.encode(generateHmacSHA256Signature, "UTF-8");
		 * 
		 * System.out.println("Url encoded value: " + urlEncodedSign);
		 */

		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		qparams.add(new BasicNameValuePair("apikey",
				"9237786b-b154-a264-d137-7b1513d8479a"));
		qparams.add(new BasicNameValuePair("salt", salt));
		qparams.add(new BasicNameValuePair("signature",
				generateHmacSHA256Signature));
		qparams.add(new BasicNameValuePair("firstname", firstname));
		qparams.add(new BasicNameValuePair("lastname", lastname));
		qparams.add(new BasicNameValuePair("username", username));
		qparams.add(new BasicNameValuePair("password", password));
		qparams.add(new BasicNameValuePair("staffgroupid", staffgroupid));
		qparams.add(new BasicNameValuePair("email", email));

		/*
		 * URIBuilder builder = new URIBuilder();
		 * builder.setScheme("http").setHost
		 * ("liferaytest.kayako.com").setPath("/api/Base/Staff")
		 * .setParameter("apikey", "87cc54b4-7484-0984-858f-a3168b0e89c8")
		 * .setParameter("salt", salt) .setParameter("signature",
		 * urlEncodedSign); URI uri = builder.build(); HttpGet httpget = new
		 * HttpGet(uri); System.out.println(httpget.getURI());
		 */

		HttpPost httpPost = new HttpPost(
				"http://temp.kayako.com/api/Base/Staff");
		httpPost.setEntity(new UrlEncodedFormEntity(qparams));

		// System.out.println(httpPost.);

		HttpResponse response = client.execute(httpPost);
		System.out.println(response.getProtocolVersion());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());
		System.out.println(response.getStatusLine().toString());
		System.out.println(response.getEntity().toString());

		System.out.println(convertStreamToString(response.getEntity()
				.getContent()));
	}

	public static String convertStreamToString(InputStream is)
			throws IOException {
		if (is != null) {
			StringBuilder sb = new StringBuilder();
			String line;

			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "UTF-8"));
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n");
				}
			} finally {
				is.close();
			}
			return sb.toString();
		} else {
			return "";
		}
	}
}
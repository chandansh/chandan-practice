import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class GETTestApi {

	public static void main(String[] args) throws ClientProtocolException,
			IOException, URISyntaxException, GeneralSecurityException {
		HttpClient client = new DefaultHttpClient();

		String apikey = "9237786b-b154-a264-d137-7b1513d8479a";
		String secretKey = "N2JmMzI3ZjUtNDc3MC04ZTU0LWIxNzktOGZjZDcyNGRlOGY5NThlMzVkNzAtZjg5MS0yZjk0LWIxYmMtNDU3YTc0M2MxNTkx";
		String salt = "1234567890";

		String generateHmacSHA256Signature = GenerateSalt
				.generateHmacSHA256Signature(salt, secretKey);
		System.out.println("Signature: " + generateHmacSHA256Signature);
		String urlEncodedSign = URLEncoder.encode(generateHmacSHA256Signature,
				"UTF-8");
		String encodedSalt = URLEncoder.encode(salt, "UTF-8");
		String encodedAPIKey = URLEncoder.encode(apikey, "UTF-8");

		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("temp.kayako.com")
				.setPath("/api/Base/Staff")
				.setParameter("apikey", encodedAPIKey)
				.setParameter("salt", encodedSalt)
				.setParameter("signature", urlEncodedSign);
		URI uri = builder.build();
		HttpGet httpget = new HttpGet(uri);
		/*httpget.setHeader("apikey", apikey);
		httpget.setHeader("salt", salt);
		httpget.setHeader("signature", generateHmacSHA256Signature);*/
		
		System.out.println(httpget.getURI());

		HttpResponse response1 = client.execute(httpget);
		System.out.println(response1.getProtocolVersion());
		System.out.println(response1.getStatusLine().getStatusCode());
		System.out.println(response1.getStatusLine().getReasonPhrase());
		System.out.println(response1.getStatusLine().toString());
		//System.out.println(response1.getEntity().toString());
		System.out.println(convertStreamToString(response1.getEntity()
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
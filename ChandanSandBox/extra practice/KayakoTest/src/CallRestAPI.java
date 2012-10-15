import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;


//import org.bouncycastle.util.encoders.Base64Encoder;

public class CallRestAPI {

	public static void main(String[] args) throws GeneralSecurityException,
			IOException {
		String response, request;

		String secretKey = "secretKey";
		String salt = "Mi";

		String generateHmacSHA256Signature = generateHmacSHA256Signature(salt,
				secretKey);
		System.out.println("Signature: " + generateHmacSHA256Signature);

		String urlEncodedSign = URLEncoder.encode(generateHmacSHA256Signature,
				"UTF-8");

		System.out.println("Url encoded value: " + urlEncodedSign);

		try {
			// URL url = new
			// URL("http://liferaytest.kayako.com/api/Base/User/Filter/1/1000");
			URL url = new URL("http://liferaytest.kayako.com/api/Base/Staff/"
					+ urlEncodedSign);
			// make connection, use post mode, and send query
			URLConnection urlc = url.openConnection();
			urlc.setDoOutput(true);
			urlc.setAllowUserInteraction(false);

			// String encodedPost = URLEncoder.encode(request);
			PrintStream ps = new PrintStream(urlc.getOutputStream());
			System.out.println(ps.toString());
			// ps.print("launchData="+encodedPost);
			ps.close();
			// retrieve result
			BufferedReader br = new BufferedReader(new InputStreamReader(
					urlc.getInputStream()));
			String str;
			StringBuffer sb = new StringBuffer();
			while ((str = br.readLine()) != null) {
				sb.append(str);
				sb.append("\n");
			}
			br.close();
			response = sb.toString();
			if (response == null) {
				/*
				 * setErrorMessage(request,
				 * "Launch REST Web Service returned nothing");
				 */
				System.out.println("Launch REST Web Service returned nothing");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed REST service call. Exception="
					+ e.getMessage());
			// setErrorMessage(request,
			// "Failed REST service call. Exception="+e);
			response = null;
		}
	}

	public static String generateHmacSHA256Signature(String data, String key)
			throws GeneralSecurityException {
		byte[] hmacData = null;

		try {
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"),
					"HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(secretKey);
			hmacData = mac.doFinal(data.getBytes("UTF-8"));
			return new BASE64Encoder().encode(hmacData);
		} catch (UnsupportedEncodingException e) {
			throw new GeneralSecurityException(e);
		}
	}
}

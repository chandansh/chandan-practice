import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;
 

 
public class GenerateSalt {
 
    public static void main(String[] args) throws GeneralSecurityException, IOException {
 
        String secretKey = "ZjU1MjE2NTItYjJkOC05NGU0LTJkN2EtMWUwN2M1NGE1YjEwMmZiNjRlNzctYmE1Yi1lMWY0LWZkYjUtYWFjZGFiMTA4NDkw";
        String salt = "1234567890";
 
        String generateHmacSHA256Signature = generateHmacSHA256Signature(salt, secretKey);
        System.out.println("Signature: " + generateHmacSHA256Signature);
 
        String urlEncodedSign = URLEncoder.encode(generateHmacSHA256Signature, "UTF-8");
 
        System.out.println("Url encoded value: " + urlEncodedSign);
    }
 
    public static String generateHmacSHA256Signature(String data, String key) throws GeneralSecurityException {
        byte[] hmacData = null;
        byte[] encodeed = null;
        String encodedString = "";
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKey);
            hmacData = mac.doFinal(data.getBytes("UTF-8"));
            encodedString = new BASE64Encoder().encode(hmacData);
            //System.out.println(new String(encodeed));
            //System.out.println("new :: " + org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(hmacData));
           // new Base64Encoder().encode(hmacData,0,hmacData.length,new FileOutputStream("myFile"));
           
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        } /*catch (FileNotFoundException e) {
			e.printStackTrace();
		} */catch (IOException e) {
			e.printStackTrace();
		}
        return encodedString;
    }
}
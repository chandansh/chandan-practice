package org.usaopengov.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author <a href="http://www.benmccann.com/">Ben McCann</a>
 */
public final class UrlUtil {

  private UrlUtil() {}
  
  public static String encodeUrl(String url) {
    try {
      return URLEncoder.encode(url, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      // this should be an unchecked exception
      return null;
    }
  }
  
  public static String getUrlContents(URL url) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    StringBuffer doc = new StringBuffer();
    String line;
    while ((line = reader.readLine()) != null) {
      doc.append(line);
    }
    return doc.toString();
  }
  
}

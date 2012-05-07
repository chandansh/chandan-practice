package com.incoleg.fb.server.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.google.appengine.repackaged.com.google.common.util.Base64;
import com.google.appengine.repackaged.com.google.common.util.Base64DecoderException;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class FacebookUtil
{
	private static final Map<Service, String> SVC_HOST_MAP = new HashMap<Service, String>();
	private static final String GUID_CHARS = "0123456789abcdef";
	private static final int GUID_NUM_CHARS = GUID_CHARS.length();

	public enum Service
	{
		GRAPH
	}

	static
	{
		// SVC_HOST_MAP.put("www", "http://www.facebook.com");
		SVC_HOST_MAP.put(Service.GRAPH, "https://graph.facebook.com");
	}

	public static String random(int length)
	{
		Random r = new Random();
		char[] v = new char[length];

		int idx;
		for(int i = 0; i < length; i++)
		{
			idx = r.nextInt(GUID_NUM_CHARS);
			v[i] = GUID_CHARS.charAt(idx);
		}

		return new String(v);
	}
	
	public static String fetchData(Service service, String file, HTTPMethod method, String accessToken,
			Map<String, String> parameters) throws IOException
	{
		String rv = null;

		URLFetchService svc = URLFetchServiceFactory.getURLFetchService();

		String host = SVC_HOST_MAP.get(service);

		String queryPart = null;
		if(parameters == null)
		{
			parameters = new HashMap<String, String>();
		}

		if(accessToken != null)
		{
			parameters.put("access_token", accessToken);
		}

		if(parameters != null)
		{
			StringBuilder sb = new StringBuilder();
			for(String key : parameters.keySet())
			{
				sb.append('&');
				sb.append(URLEncoder.encode(key, "UTF-8"));
				sb.append('=');
				sb.append(URLEncoder.encode(parameters.get(key), "UTF-8"));
			}
			String paramQuery = sb.toString().substring(1);

			queryPart = paramQuery;
		}

		String path = file;
		if(!HTTPMethod.POST.equals(method) && queryPart != null)
		{
			path += '?';
			path += queryPart;
		}

		HTTPRequest req = new HTTPRequest(new URL(host + path), method);
		System.out.println("Request URL: " + req.getURL());
		if(HTTPMethod.POST.equals(method))
		{
			// req.setHeader(new HTTPHeader("Content-Type", "x-www-form-urlencoded"));
			req.setPayload(queryPart.getBytes());
		}

		HTTPResponse response = svc.fetch(req);

		if(response.getResponseCode() == 200)
		{
			byte[] input = response.getContent();
			rv = new String(input, "UTF-8");
		}

		return rv;
	}

	public static String base64URLDecode(String encoded)
	{
		String decoded = null;
		if(encoded != null)
		{
			decoded = encoded.replace('-', '+').replace('_', '/');

			int length = decoded.length();
			int p4 = 4 - (length % 4);
			switch(p4)
			{
				case 2:
					decoded += '=';
				case 1:
					decoded += '=';
				default:
					break;
			}
			byte[] rawPayload = {};
			try
			{
				rawPayload = Base64.decode(decoded);
				decoded = new String(rawPayload, "UTF-8");
			} catch(Base64DecoderException e)
			{
				e.printStackTrace();
			} catch(UnsupportedEncodingException e)
			{
				e.printStackTrace();
			}
		}
		return decoded;
	}

	public static JSONObject getJSONObject(String jsonString)
	{
		JSONObject rv = null;
		try
		{
			rv = new JSONObject(jsonString);
		} catch(JSONException e)
		{
			e.printStackTrace();
		}
		return rv;
	}

	public static String[] decodeSignedRequest(String signedPayload)
	{
		String[] rv = null;

		if(signedPayload != null && signedPayload.length() >= 3)
		{
			int dotIndex = signedPayload.indexOf('.');

			if(dotIndex > 0)
			{
				String signature = signedPayload.substring(0, dotIndex);
				String payload = signedPayload.substring(dotIndex + 1);
				// signature = base64URLDecode(signature);
				payload = base64URLDecode(payload);

				rv = new String[] {
					signature, payload
				};
			}
		}

		return rv;
	}
}

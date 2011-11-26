package com.incoleg.fb;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.google.appengine.repackaged.com.google.common.util.Base64;
import com.google.appengine.repackaged.com.google.common.util.Base64DecoderException;
import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public abstract class BaseFacebook
{
	private static final String KEY_SIGNED_REQUEST = "signed_request";

	private static final String[] DROP_PARAMS = {
		"code", "state", KEY_SIGNED_REQUEST
	};

	private static final Map<String, String> DOMAIN_MAP = new HashMap<String, String>();

	static {
		DOMAIN_MAP.put("api", "http://api.facebook.com/");
		DOMAIN_MAP.put("api_video", "http://api-video.facebook.com/");
		DOMAIN_MAP.put("api_read", "http://api-read.facebook.com/");
		DOMAIN_MAP.put("graph", "http://graph.facebook.com/");
		DOMAIN_MAP.put("www", "http://www.facebook.com/");
	}

	protected String appId;
	protected String appSecret;
	protected String userId;

	protected String state;	//tag, token

	protected String signedRequest;
	
	protected String accessToken;

	protected Map<String, String> requestParams;
	protected Map<String, String> cookies;

	public BaseFacebook(String appId, String appSecret, Map<String, String> requestParams, Map<String, String> cookies)
	{
		this.appId = appId;
		this.appSecret = appSecret;
		this.requestParams = requestParams;
		this.cookies = cookies;
	}

	protected abstract String getPersistentData(String key);
	protected abstract void setPersistentData(String key, Object value);

	protected String getSessionKey(String name)
	{
		String key = "fb_" + appId + "_name";
		return key;
	}

	public String getAppId()
	{
		return appId;
	}

	public void setAppId(String appId)
	{
		this.appId = appId;
	}

	public String getAppSecret()
	{
		return appSecret;
	}

	public void setAppSecret(String appSecret)
	{
		this.appSecret = appSecret;
	}

	public String getAccessToken()
	{
		//FIXME: getApplicationAccessToken, getUserAccessToken
		return accessToken;
	}

	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	protected String getUserAccessToken()
	{
		String sr = getSignedRequest();
		return null;
	}

	protected String getSignedRequest()
	{
		if(signedRequest == null)
		{
			if(requestParams.containsKey(KEY_SIGNED_REQUEST))
			{
				signedRequest = requestParams.get(KEY_SIGNED_REQUEST);
			} else if(cookies.containsKey("fbsr_" + getAppId()))
			{
				String rawSR = cookies.get("fbsr_" + getAppId());
				int dot = rawSR.indexOf('.');
				String encSig = rawSR.substring(0, dot + 1);
				String payload = rawSR.substring(dot + 2);

				encSig = encSig.replace('-', '+').replace('_', '/');
				String sig = "";
				JSONObject obj;
				try
				{
					sig = new String(Base64.decode(encSig));
					payload = new String(Base64.decode(payload));
					obj = new JSONObject(payload);
				} catch(Base64DecoderException e)
				{
					e.printStackTrace();
				} catch(JSONException e)
				{
					e.printStackTrace();
				}
			}
		}
		return signedRequest;
	}
}





























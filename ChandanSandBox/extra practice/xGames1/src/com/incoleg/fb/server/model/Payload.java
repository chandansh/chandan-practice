package com.incoleg.fb.server.model;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class Payload
{
	private JSONObject payload;
	private PayloadUser user;

	public Payload(String payload) throws JSONException
	{
		JSONObject obj = new JSONObject(payload);
		initialize(obj);
	}

	public Payload(JSONObject payload)
	{
		initialize(payload);
	}

	private void initialize(JSONObject payload)
	{
		this.payload = payload;
		if(payload != null)
		{
			try
			{
				user = new PayloadUser(payload.getJSONObject("user"));
			} catch(JSONException e)
			{
				e.printStackTrace();
			}
		}
	}

	public boolean has(String key)
	{
		return payload.has(key);
	}
	
	public String getAlgorithm() throws JSONException
	{
		return payload.getString("algorithm");
	}

	public long issueTime() throws JSONException
	{
		return payload.getLong("issued_at");
	}

	public long getExpiryTime() throws JSONException
	{
		if(payload.has("expires"))
		{
			return payload.getLong("expires");
		}
		return -1;
	}

	public String getOAuthToken() throws JSONException
	{
		if(payload.has("oauth_token"))
		{
			return payload.getString("oauth_token");
		}
		return null;
	}

	public String getUserID() throws JSONException
	{
		if(payload.has("user_id"))
		{
			return payload.getString("user_id");
		}
		return null;
	}

	public PayloadUser getUser()
	{
		return user;
	}

	@Override
	public String toString()
	{
		String rv = "null";
		try
		{
			if(payload != null)
			{
				rv = payload.toString(1);
			}
		} catch(JSONException e)
		{
			e.printStackTrace();
		}
		return rv;
	}
}

package com.incoleg.fb.server.model;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

public class PayloadUser
{
	private JSONObject payload;

	public PayloadUser(JSONObject payload)
	{
		this.payload = payload;
	}
	
	public String getCountry() throws JSONException
	{
		return payload.getString("country");
	}

	public String getLocale() throws JSONException
	{
		return payload.getString("locale");
	}

	public int getAgeMin() throws JSONException
	{
		if(payload.has("age"))
		{
			JSONObject obj = payload.getJSONObject("age");
			if(obj != null && obj.has("min"))
			{
				return obj.getInt("min");
			}
		}
		return -1;
	}
}











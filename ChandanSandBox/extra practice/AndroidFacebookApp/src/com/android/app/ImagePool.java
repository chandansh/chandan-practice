package com.android.app;

import java.util.HashMap;

import android.graphics.Bitmap;

public class ImagePool {

	private static HashMap<String, Bitmap> pool = new HashMap<String, Bitmap>();

	private static final int MAX_POOL_SIZE = 50;

	public static void add(String id, Bitmap value)
	{
		if(pool.size() >= MAX_POOL_SIZE)
		{
			String idr = pool.keySet().iterator().next();
			pool.remove(idr);
		}
		pool.put(id, value);
	}

	public static Bitmap get(String id)
	{
		return pool.get(id);
	}
}

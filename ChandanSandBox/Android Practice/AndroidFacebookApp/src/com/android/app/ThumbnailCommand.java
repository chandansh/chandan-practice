package com.android.app;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.android.app.core.IResponseHandler;

public class ThumbnailCommand implements ICommand {

	private int id;
	private String url;
	private IResponseHandler handler;
	private Object tag;

	public ThumbnailCommand(Object tag) {
		this.tag = tag;
	}

	public ThumbnailCommand(int id, String url, IResponseHandler handler, Object tag) {
		super();
		this.tag = tag;
		this.id = id;
		this.url = url;
		this.handler = handler;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public IResponseHandler getHandler() {
		return handler;
	}

	public void setHandler(IResponseHandler handler) {
		this.handler = handler;
	}

	@Override
	public void exec() {
		try {
			Log.i("CA", "getting image" + url);
			HttpGet request = new HttpGet(url);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(request);

			InputStream input = response.getEntity().getContent();
			Bitmap bmp = BitmapFactory.decodeStream(input);

//			Message msg = Message.obtain();
//			msg.what = 123456;
//			msg.obj = bmp;
//			handler.sendMessage(msg);
			handler.onResponse(123456, tag, bmp);
			Log.i("CA", "image receive and msg send." + url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

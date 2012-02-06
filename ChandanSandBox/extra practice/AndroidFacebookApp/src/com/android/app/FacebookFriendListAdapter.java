package com.android.app;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FacebookFriendListAdapter extends BaseAdapter {

	private Context context;
	private String[] users;
	private Bitmap bmp;

	public FacebookFriendListAdapter(Context context, String[] users) {
		super();
		this.context = context;
		this.users = users;
	}

	@Override
	public int getCount() {
		return users.length;
	}

	@Override
	public Object getItem(int position) {
		return users[position];
	}

	@Override
	public long getItemId(int position) {
		return users[position].hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewGroup view;

		if (convertView == null) {
			Log.i("CA", "getView::Instantiating @" + position);
			LayoutInflater li = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = (ViewGroup) li.inflate(R.layout.list_item, null, false);
		} else {
			Log.i("CA", "getView::Reusing @" + position);
			view = (ViewGroup) convertView;
		}
		//view.setTag(getItem(position));
		final ImageView imageview = (ImageView) view.findViewById(R.id.iv);
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				Log.i("CA", "Handler handle message...");
				switch (msg.what) {
				case 123456:
					imageview.setImageBitmap(bmp);
					break;
				default:
					super.handleMessage(msg);
				}
			}
		};

		((TextView) view.findViewById(R.id.tv)).setText("List => "
				+ getItem(position));
		// ((ImageView) view.findViewById(R.id.iv))
		String url = "http://graph.facebook.com/" + getItemId(position)
				+ "/picture";
		loadImageFromWeb(url, new IWebCallback() {

			@Override
			public void onResponse() {
				Log.i("CA", "IWebCallback::onResponse...");
				Message msg = Message.obtain();
				msg.what = 123456;
				handler.sendMessage(msg);
			}
		});

		return view;
	}

	static interface IWebCallback {
		void onResponse();
	}

	private void loadImageFromWeb(final String url, final IWebCallback callback) {
		Log.i("CA", "Fetching image");

		try {
			Runnable runnable = new Runnable() {

				@Override
				public void run() {

					try {
						HttpGet request = new HttpGet(url);
						HttpClient client = new DefaultHttpClient();
						HttpResponse response = client.execute(request);

						InputStream input = response.getEntity().getContent();
						bmp = BitmapFactory.decodeStream(input);
						callback.onResponse();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			};
			Thread t = new Thread(runnable);
			t.start();
			// runnable.run();
			Log.i("CA", "Created image from stream");
		} catch (Exception e) {
			// TODO handle error
			Log.i("CA", "Error fetching image");
			System.out.println("Exception : " + e);
		}
	}

}

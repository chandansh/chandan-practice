package com.android.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;

public class UserHomeActivity extends Activity {

	private Facebook fb = new Facebook("298380290220484");
	private String id;
	private Bitmap bmp;
	private String token;
	private String link;
	private ImageView iview;

	private Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg) {
			Log.i("CA", "Handler handle message...");
			
			switch(msg.what)
			{
			case 123456:
				iview.setImageBitmap(bmp);
				break;
			default:
				super.handleMessage(msg);
			}
		}
	};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userhomelayout);
		Intent intent = getIntent();
		String name = intent.getStringExtra("username");
		id = intent.getStringExtra("id");
		token = intent.getStringExtra("token");
		link =intent.getStringExtra("link");
		
		fb.setAccessToken(token);
		TextView tv = (TextView) findViewById(R.id.textView1);

		tv.setText(name);
		String imgUrl = "http://graph.facebook.com/" + id + "/picture";
		iview = (ImageView) findViewById(R.id.imageView1);
		// TODO Auto-generated method stub
		loadImageFromWeb(imgUrl, new IWebCallback() {
			@Override
			public void onResponse() {
				Log.i("CA", "IWebCallback::onResponse...");
				Message msg = Message.obtain();
				msg.what = 123456;
				handler.sendMessage(msg);
			}
		});
		//iview.setImageBitmap(loadImageFromWeb(imgUrl));

		TextView linkTxt = (TextView) findViewById(R.id.textlink);
		
		linkTxt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent i = new Intent(Intent.ACTION_VIEW);
				 i.addCategory(Intent.CATEGORY_DEFAULT);
				 i.setData(Uri.parse(link));
				 startActivity(i);
			}
		});
		
		Button btn = (Button) findViewById(R.id.friendbtn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AsyncFacebookRunner runner = new AsyncFacebookRunner(fb);

				runner.request("/me/friends", new RequestListener() {

					@Override
					public void onMalformedURLException(
							MalformedURLException e, Object state) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onIOException(IOException e, Object state) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onFileNotFoundException(
							FileNotFoundException e, Object state) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onFacebookError(FacebookError e, Object state) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onComplete(String response, Object state) {
						Log.i("CA", response);
						try {
							JSONObject resp = new JSONObject(response);
							JSONArray friendsJson = resp.getJSONArray("data");
							int size = friendsJson.length() < 25 ? friendsJson
									.length() : 25;
							String[] friends = new String[size];
							for (int i = 0; i < size; i++) {
								JSONObject obj = friendsJson.getJSONObject(i);
								friends[i] = obj.getString("id");
							}
							Intent i = new Intent(UserHomeActivity.this,
									FriendsListActivity.class);
							i.putExtra("token", token);
							i.putExtra("friends", friends);
							
							startActivity(i);

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});

			}
		});

		
	}

	static interface IWebCallback
	{
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
			Thread t=new Thread(runnable);
			t.start();
			//runnable.run();
			Log.i("CA", "Created image from stream");
		} catch (Exception e) {
			// TODO handle error
			Log.i("CA", "Error fetching image");
			System.out.println("Exception : " + e);
		}
	}

}

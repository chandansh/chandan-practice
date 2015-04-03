package com.android.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class AndroidFacebookAppActivity extends Activity {
	/** Called when the activity is first created. */

	Facebook fb = new Facebook("298380290220484");
	Button btn;
	TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.i("CA", "fcebook app");

		btn = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.tv);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				fb.authorize(AndroidFacebookAppActivity.this,
						new DialogListener() {

							@Override
							public void onFacebookError(FacebookError e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onError(DialogError e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onComplete(Bundle values) {
								Log.i("CA", "connected to facebook");
								AsyncFacebookRunner runner = new AsyncFacebookRunner(
										fb);

								Log.i("CA", "Firing request...");
								runner.request("/me", new RequestListener() {

									@Override
									public void onMalformedURLException(
											MalformedURLException e,
											Object state) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onIOException(IOException e,
											Object state) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onFileNotFoundException(
											FileNotFoundException e,
											Object state) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onFacebookError(
											FacebookError e, Object state) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onComplete(String response,
											Object state) {
										// TODO Auto-generated method stub
										Log.i("CA", "Login... onComplete");
										Log.i("CA", "response " + response);

										try {
											JSONObject resp = new JSONObject(
													response);
											String name = resp
													.getString("name");
											String id = resp.getString("id");
											String link= resp.getString("link");
											// tv.setText(name);
											Intent i = new Intent(
													AndroidFacebookAppActivity.this,
													UserHomeActivity.class);
											i.putExtra("username", name);
											i.putExtra("id", id);
											i.putExtra("token",
													fb.getAccessToken());
											i.putExtra("link", link);

											startActivity(i);

											Log.i("CA", "name : " + name);
										} catch (JSONException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

									}
								});
								Log.i("CA", "/me request fired...");

							}

							@Override
							public void onCancel() {
								// TODO Auto-generated method stub

							}
						});
			}
		});
	}

}
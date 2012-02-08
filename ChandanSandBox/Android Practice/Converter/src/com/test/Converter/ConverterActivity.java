package com.test.Converter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class ConverterActivity extends Activity {
	/** Called when the activity is first created. */

	private EditText text;
	private Facebook fb = new Facebook("298380290220484");

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		setContentView(R.layout.ll);
		// text = (EditText) findViewById(R.id.editText1);

//		{
//			Context ctx = this;
//			LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.fb_list_item, null, false);
//			
//			ImageView iview = (ImageView) ll.findViewById(R.id.iv);
//
//			HttpGet request = new HttpGet("/me");
//			HttpClient client = new DefaultHttpClient();
//
//			try {
//				HttpResponse response = client.execute(request);
//				
//				InputStream input = response.getEntity().getContent();
//				
//				Bitmap bmp = BitmapFactory.decodeStream(input);
//				iview.setImageBitmap(bmp);
//				
//			} catch (ClientProtocolException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			
//		}
		
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				fb.authorize(ConverterActivity.this, new DialogListener() {

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
						// TODO Auto-generated method stub
						Log.i("CA", "onComplete... fb");
						
						AsyncFacebookRunner runner = new AsyncFacebookRunner(fb);
						//fb.getAccessToken()
						runner.request("/me", new AsyncFacebookRunner.RequestListener() {
							
							@Override
							public void onMalformedURLException(MalformedURLException e, Object state) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void onIOException(IOException e, Object state) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void onFileNotFoundException(FileNotFoundException e, Object state) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void onFacebookError(FacebookError e, Object state) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void onComplete(String response, Object state) {
								// TODO Auto-generated method stub
								Log.i("CA", "Response ready: " + response);
							}
						});
					}

					@Override
					public void onCancel() {
						// TODO Auto-generated method stub

					}
				});

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		fb.authorizeCallback(requestCode, resultCode, data);
	}

	// This method is called at button click because we assigned the name to the
	// "On Click property" of the button
	public void myClickHandler(View view) {
		switch (view.getId()) {

		case R.id.btn1:
			Intent i = new Intent("com.chandan.action.RELATIVE");
			i.addCategory(Intent.CATEGORY_DEFAULT);
			i.putExtra("key", "converter");
			startActivity(i);
			break;

		case R.id.button1:
			RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
			RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
			if (text.getText().length() == 0) {
				Toast.makeText(this, "Please enter a valid number",
						Toast.LENGTH_LONG).show();
				return;
			}
			float inputValue = Float.parseFloat(text.getText().toString());
			if (celsiusButton.isChecked()) {
				text.setText(String
						.valueOf(convertFahrenheitToCelsius(inputValue)));
				celsiusButton.setChecked(false);
				fahrenheitButton.setChecked(true);
			} else {
				text.setText(String
						.valueOf(convertCelsiusToFahrenheit(inputValue)));
				fahrenheitButton.setChecked(false);
				celsiusButton.setChecked(true);
			}
			break;
		}
	}

	// Converts to celsius
	private float convertFahrenheitToCelsius(float fahrenheit) {
		return ((fahrenheit - 32) * 5 / 9);
	}

	// Converts to fahrenheit
	private float convertCelsiusToFahrenheit(float celsius) {
		return ((celsius * 9) / 5) + 32;
	}

}
package com.test.socialapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class RelativeLayoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relativemain);
		Intent intent = getIntent();
		String key = intent.getStringExtra("key");
		Toast.makeText(RelativeLayoutActivity.this, "Extra key:" + key,
				Toast.LENGTH_LONG).show();

		findViewById(R.id.ok).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

}

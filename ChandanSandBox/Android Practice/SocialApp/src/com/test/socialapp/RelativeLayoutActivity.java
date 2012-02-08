package com.test.socialapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.SearchView;
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

		registerForContextMenu(findViewById(R.id.cancel));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// menu.add("helllo");
		// menu.add("hello2");
		MenuInflater inf = getMenuInflater();
		inf.inflate(R.menu.optionmenu, menu);
		
		SearchView searchView = (SearchView) menu.findItem(R.id.item4).getActionView();
		

		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// menu.add("hello3");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		MenuInflater inf = getMenuInflater();
		inf.inflate(R.menu.optionmenu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
		return true;
	}
}

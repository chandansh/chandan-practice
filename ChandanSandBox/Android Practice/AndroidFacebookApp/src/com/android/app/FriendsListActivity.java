package com.android.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.app.core.ThreadPool;
import com.facebook.android.Facebook;

public class FriendsListActivity extends ListActivity {
	Facebook fb = new Facebook("298380290220484");

	String token;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		ThreadPool.get().init();
		super.onCreate(savedInstanceState);

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		Intent i = getIntent();
		token = i.getStringExtra("token");
		String[] friends = i.getStringArrayExtra("friends");

		fb.setAccessToken(token);

//		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
//				friends));
		setListAdapter(new FacebookFriendListAdapter(this, friends));

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}

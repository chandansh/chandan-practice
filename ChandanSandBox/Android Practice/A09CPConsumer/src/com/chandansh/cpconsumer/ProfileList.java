package com.chandansh.cpconsumer;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ProfileList extends ListActivity {

	private static final int CODE_ADD_OR_EDIT = 1;
	private MenuItem one;
	private MenuItem two;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.profile_list);

		String msg = getResources().getString(R.string.msg_fmt, "Whatever", 23);
		Log.i("CP", "Resource, String => " + msg);
		
		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(Uri.parse("content://com.chandan.cp.profiles/p"),
				null, null, null, null);
		List<Profile> profiles = new ArrayList<Profile>();
		while (c.moveToNext()) {

			Profile p = new Profile(c.getString(0), c.getString(1));
			profiles.add(p);
		}

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		setListAdapter(new ProfileAdapter(this, profiles));

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Profile profile = (Profile) view.getTag();

				Intent i = new Intent(ProfileList.this, ProfileActivity.class);
				i.putExtra("uid", profile.getId());
				startActivityForResult(i, CODE_ADD_OR_EDIT);
			}
		});

		registerForContextMenu(findViewById(R.id.addBtn));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		one = menu.add(1, 1, 1, "One");
		one.setIcon(R.drawable.ic_launcher);
		two = menu.add(1, 2, 0, "Two");
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		one.setEnabled(!one.isEnabled());
		//menu.add(1, 3, 3, "Teen");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, "Menu => " + item.getTitle() + " clicked", Toast.LENGTH_LONG).show();
		return true;
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {

		//item.getItemId();
		Toast.makeText(this, "Menu => " + item.getTitle() + " clicked", Toast.LENGTH_LONG).show();
		
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		
		menu.add(1, 1, 1, "One");
		menu.add(1, 2, 0, "Two");

		//super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		switch(requestCode)
		{
			case CODE_ADD_OR_EDIT:
				switch(resultCode)
				{
				case RESULT_CANCELED:
					Toast.makeText(this, "Operation Cancelled", Toast.LENGTH_LONG).show();
					break;
				case RESULT_OK:
					Toast.makeText(this, "Operation Successful", Toast.LENGTH_LONG).show();
					break;
				}
				break;
		}

		super.onActivityResult(requestCode, resultCode, data);
	}
	
	public void doAdd(View v)
	{
		Intent i = new Intent(ProfileList.this, ProfileActivity.class);
		startActivityForResult(i, CODE_ADD_OR_EDIT);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		
		//newConfig.orientation
		//newConfig.
		
		super.onConfigurationChanged(newConfig);
	}
}






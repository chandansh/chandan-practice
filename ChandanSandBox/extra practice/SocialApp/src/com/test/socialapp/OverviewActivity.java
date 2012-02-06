package com.test.socialapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class OverviewActivity extends Activity {

	SharedPreferences preferences;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button = (Button) findViewById(R.id.button1);
		// Initialize preferences
		preferences = PreferenceManager.getDefaultSharedPreferences(this);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String username = preferences.getString("username", "n/a");
				String password = preferences.getString("password", "n/a");
				showPrefs(username, password);
			}
		});
		Button buttonChangePreferences = (Button) findViewById(R.id.button2);
		buttonChangePreferences.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				updatePreferenceValue();
			}
		});

	}

	public void openMyDialog(View view) {
		showDialog(10);
	}

	public void showRelativeActivity(View v) {
		// Launch RelativeLayout activity
		Intent i = new Intent("com.chandan.action.RELATIVE");
		i.addCategory(Intent.CATEGORY_DEFAULT);
		// OverviewActivity.this,RelativeLayoutActivity.class);
		// Intent i = new Intent(Intent.ACTION_VIEW);
		// i.addCategory(Intent.CATEGORY_DEFAULT);
		// i.setData(Uri.parse("http://www.google.com"));
		i.putExtra("key", "Chandan");
		startActivity(i);

		// to put some extra info
		// Some feedback to the user
	}

	public void showListActivity(View v) {
		Intent i = new Intent(OverviewActivity.this, HelloListView.class);
		startActivity(i);
	}
	
	public void showGridActivity(View v) {
		Intent i = new Intent(OverviewActivity.this, HelloGridView.class);
		startActivity(i);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 10:
			// Create out AlterDialog
			Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("This will end the activity");
			builder.setCancelable(true);
			builder.setPositiveButton("I agree",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							OverviewActivity.this.finish();
						}
					});
			builder.setNegativeButton("No, no",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getApplicationContext(),
									"Activity will continue", Toast.LENGTH_LONG)
									.show();
						}
					});
			AlertDialog dialog = builder.create();
			dialog.show();
		}
		return super.onCreateDialog(id);
	}

	private void showPrefs(String username, String password) {
		Toast.makeText(OverviewActivity.this,
				"Input: " + username + " and password: " + password,
				Toast.LENGTH_LONG).show();
	}

	private void updatePreferenceValue() {
		Editor edit = preferences.edit();
		String username = preferences.getString("username", "n/a");
		// We will just revert the current user name and save again
		StringBuffer buffer = new StringBuffer();
		for (int i = username.length() - 1; i >= 0; i--) {
			buffer.append(username.charAt(i));
		}
		edit.putString("username", buffer.toString());
		edit.commit();
		// A toast is a view containing a quick little message for the
		// user. We give a little feedback
		Toast.makeText(OverviewActivity.this,
				"Reverted string sequence of user name.", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// We have only one menu option
		case R.id.preferences:
			// Launch Preference activity
			Intent i = new Intent(OverviewActivity.this,
					MyPreferenceActivity.class);
			startActivity(i);
			// Some feedback to the user
			Toast.makeText(OverviewActivity.this,
					"Enter your user credentials.", Toast.LENGTH_LONG).show();
			break;
		// If home icon is clicked return to main Activity
		case android.R.id.home:
			Toast.makeText(OverviewActivity.this,
					"Enter your user credentials." + item.getItemId(),
					Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this, OverviewActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;

		}
		return true;

	}

}
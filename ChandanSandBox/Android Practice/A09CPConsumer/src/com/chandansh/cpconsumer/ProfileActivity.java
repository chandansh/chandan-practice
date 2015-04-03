package com.chandansh.cpconsumer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ProfileActivity extends Activity {

	private String id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile_form);

		Intent intent = getIntent();

		Bundle extras = intent.getExtras();
		id = null;
		if (extras != null) {
			id = extras.getString("uid");
		}

		Toast.makeText(this, "ID: " + id, Toast.LENGTH_LONG).show();

		if (id != null) {
			getContentResolver().query(
					Uri.parse("content://com.chandan.cp.profiles/p/" + id),
					null, null, null, null);
			showEditBtns();
		} else {
			showSaveBtns();
		}
		setResult(RESULT_CANCELED);
	}

	public void doSave(View v) {
		setResult(RESULT_OK);
		if (id != null) {
			showEditBtns();
		} else {
			wrapUp();
		}
	}

	private void showEditBtns() {
		findViewById(R.id.layout_btns_default).setVisibility(View.VISIBLE);
		findViewById(R.id.layout_btns_edit).setVisibility(View.GONE);
	}

	private void wrapUp() {
		finish();
	}

	public void doDelete(View v) {
		//
	}

	public void doEdit(View v) {
		showSaveBtns();
	}

	private void showSaveBtns() {
		findViewById(R.id.layout_btns_default).setVisibility(View.GONE);
		findViewById(R.id.layout_btns_edit).setVisibility(View.VISIBLE);
	}

	public void doCancel(View v) {
		if (id != null) {
			showEditBtns();
		} else {
			wrapUp();
		}
	}
}

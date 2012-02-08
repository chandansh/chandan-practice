package com.chandansh.cpconsumer;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class A09CPConsumerActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Uri uri, String[] projection, String selection, String[]
		// selectionArgs, String sortOrder

		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(Uri.parse("content://com.chandan.cp.profiles/p"),
				null, null, null, null);

		// EditText et;
		// et.setEnabled(false);

		TextView tc = (TextView) findViewById(R.id.tc);
		if (c == null) {
			tc.setText("No cursor found...");
		} else {
			tc.setText("Total Records: " + c.getCount());
		}

		cr.delete(Uri.parse("content://com.chandan.cp.profiles/1"), null, null);
//		ContentValues record = new ContentValues();
//		int i = new Random().nextInt();
//		record.put("fname", "First " + i);
//		record.put("lname", "Last " + i);
//		record.put("designation", "Desgn " + i);
//		record.put("age", i + 20);
		// Uri u = cr.insert(Uri.parse("content://com.chandan.cp.profiles/"),
		// record);

		// TextView ins = (TextView) findViewById(R.id.ins);
		// ins.setText("URI: " + u);

		Log.i("CP", "Consumer => Cursor: " + c);

		findViewById(R.id.list_btn).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent("com.chandan.LIST_PROFILE");
				i.addCategory(Intent.CATEGORY_DEFAULT);
				startActivity(i);

			}
		});
	}
}
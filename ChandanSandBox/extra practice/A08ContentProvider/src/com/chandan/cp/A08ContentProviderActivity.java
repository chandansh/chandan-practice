package com.chandan.cp;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class A08ContentProviderActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(Uri.parse("content://com.chandan.cp.profiles/p"),
				null, null, null, null);

		((TextView) findViewById(R.id.hw)).setText("Count: " + c.getCount());

		// SQLiteDatabase db = new EmployeeDBHelper(this).getWritableDatabase();
		//
		// for (int i = 0; i < 5; i++) {
		// ContentValues record = new ContentValues();
		// record.put("fname", "First " + i + "_n");
		// record.put("lname", "Last " + i + "_n");
		// record.put("designation", "Desgn " + i + "_n");
		// record.put("age", i + 20);
		//
		// long id = db.insert("UserProfile", null, record);
		// Log.w("CP", "Added with id: " + id);
		// }
		// db.close();

	}
}
package com.chandan.cp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDBHelper extends SQLiteOpenHelper {

	private static final String CREATE_UP_TABLE = "CREATE TABLE UserProfile(" +
			"_id INTEGER PRIMARY KEY," +
			"fname TEXT," +
			"lname TEXT," +
			"age INTEGER," +
			"designation TEXT" +
			");";

	public EmployeeDBHelper(Context context) {
		super(context, "EmployeeDB.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_UP_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS UserProfile");
		db.execSQL(CREATE_UP_TABLE);
	}

}

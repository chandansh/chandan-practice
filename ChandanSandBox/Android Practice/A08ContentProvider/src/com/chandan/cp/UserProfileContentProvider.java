package com.chandan.cp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class UserProfileContentProvider extends ContentProvider {

	public static final String AUTHORITY = "com.chandan.cp.profiles";
	public static final String CP_BASE = "content://" + AUTHORITY;
	private static final String PROFILES_ALL = CP_BASE + "/p";
	private static final String PROFILES_ONE = CP_BASE + "/p/#";

	public static final Uri URI_PROFILES_ALL = Uri.parse(PROFILES_ALL);
	public static final Uri URI_PROFILES_ONE = Uri.parse(PROFILES_ONE);
	private SQLiteDatabase db;

	private static final int MATCH_PROFILES_ALL = 1;
	private static final int MATCH_PROFILE_ONE = 2;
	private static final int MATCH_PROFILE_DEPTS_ALL = 3;
	private static final int MATCH_PROFILE_DEPTS_ONE = 4;

	private static final UriMatcher matcher = new UriMatcher(
			UriMatcher.NO_MATCH);

	static {
		matcher.addURI(AUTHORITY, "p", MATCH_PROFILES_ALL);
		matcher.addURI(AUTHORITY, "p/#", MATCH_PROFILE_ONE);
		matcher.addURI(AUTHORITY, "p/#/d", MATCH_PROFILE_DEPTS_ALL);
		matcher.addURI(AUTHORITY, "p/#/d/#", MATCH_PROFILE_DEPTS_ONE);
	}

	@Override
	public boolean onCreate() {
		db = new EmployeeDBHelper(getContext()).getWritableDatabase();
		return true;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {

		int rv = 0;

		int code = matcher.match(uri);

		switch (code) {
		case MATCH_PROFILE_ONE:
			String id = uri.getPathSegments().get(1);
			if (id.length() > 0) {
				if (selection != null) {
					selection = " _ID = " + id + " AND (" + selection + ")";
				} else {
					selection = " _ID = " + id;
				}
				rv = db.delete("UserProfile", selection, selectionArgs);
			}
			break;
		}

		return rv;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long id = db.insert("UserProfile", null, values);
		return Uri.parse(PROFILES_ALL + id);
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {

		Log.w("CP", "Query... uri: " + uri);

		int code = matcher.match(uri);

		switch (code) {
		case MATCH_PROFILES_ALL:
			return db.query("UserProfile", new String[] { "_id", "fname",
					"lname", "age", "designation" }, null, null, null, null,
					null);
		case MATCH_PROFILE_ONE:
			String id = uri.getPathSegments().get(1);
			return db.query("UserProfile", new String[] { "_id", "fname",
					"lname", "age", "designation" }, " _id = " + id, null,
					null, null, null);
		}

		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {

		int rv = 0;

		int code = matcher.match(uri);

		switch (code) {
		case MATCH_PROFILE_ONE:
			String id = uri.getPathSegments().get(1);
			if (id.length() > 0) {
				if (selection != null) {
					selection = " _ID = " + id + " AND (" + selection + ")";
				} else {
					selection = " _ID = " + id;
				}
				rv = db.update("UserProfile", values, selection, selectionArgs);
			}
			break;
		}

		return rv;
	}

}

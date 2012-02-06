package com.chandan.biz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

public class LoginCommand implements ICommand {

	@Override
	public void go(int cmdId, final Object tag, Object params) {
		Log.i("BAA", "LoginCommand::go started");
		Object[] data = (Object[]) params;
		String fbAppId = (String) data[0];
		
		Activity a = (Activity) data[1];

		final Facebook fb = new Facebook(fbAppId);
		GlobalData.fb = fb;
		fb.authorize(a, new DialogListener() {

			@Override
			public void onFacebookError(FacebookError e) {
			}
			
			@Override
			public void onError(DialogError e) {
			}
			
			@Override
			public void onComplete(Bundle values) {
				Log.i("BAA", "LoginCommand::go => fb::authorize => onComplete called");
				EventRegistrar.getInstance().fire(IIdList.EVENT_LOGIN_SUCCESS, tag, fb);
				Log.i("BAA", "LoginCommand::go => fb::authorize => onComplete, event fired");
			}
			
			@Override
			public void onCancel() {
			}
		});
		Log.i("BAA", "LoginCommand::go => fb::authorize called");
	}

}

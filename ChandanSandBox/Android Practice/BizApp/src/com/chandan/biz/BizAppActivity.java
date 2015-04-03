package com.chandan.biz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BizAppActivity extends Activity {

	private IEventHandler loginSuccessHandler = new IEventHandler() {
		@Override
		public void onEvent(int id, Object tag, Object data) {
			Log.i("BAA", "loginSuccessHandler::onEvent Started");
			loginButton.setText("Logout...");
			Log.i("BAA", "loginSuccessHandler::onEvent completed");
		}
	};

	private Button loginButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		EventRegistrar.getInstance().subscribe(IIdList.EVENT_LOGIN_SUCCESS, loginSuccessHandler);

		loginButton = (Button) findViewById(R.id.loginBtn);
		loginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("BAA", "onClick, will fire command");
				CommandRegistrar.getInstance().go(IIdList.COMMAND_LOGIN, null, new Object[] { "298380290220484", BizAppActivity.this });
				Log.i("BAA", "onClick, command fired");
			}
		});
	}

	@Override
	protected void onDestroy() {
		EventRegistrar.getInstance().unsubscribe(IIdList.EVENT_LOGIN_SUCCESS, loginSuccessHandler);
		super.onDestroy();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i("BAA", "onActivityResult called");
		super.onActivityResult(requestCode, resultCode, data);
		if(GlobalData.fb != null)
		{
			Log.i("BAA", "onActivityResult => authorizeCallback being called");
			GlobalData.fb.authorizeCallback(requestCode, resultCode, data);
			Log.i("BAA", "onActivityResult => authorizeCallback called");
		}
	}
}




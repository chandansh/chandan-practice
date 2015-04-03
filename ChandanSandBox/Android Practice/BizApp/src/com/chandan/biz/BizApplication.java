package com.chandan.biz;

import android.app.Application;

public class BizApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		EventRegistrar.getInstance().initialize(this);
	}
	
}

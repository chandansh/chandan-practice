package com.chandan.svc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MySimpleService extends Service {

	private class MathServiceImpl extends MathService.Stub
	{
		@Override
		public int add(int x, int y) throws RemoteException {
			Log.i("SVC", "Impl => inside Add => " + this.toString());
			return x + y;
		}
	}

	private Runnable svcThread = new Runnable() {
		@Override
		public void run() {
			doServiceWork();
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		return new MathServiceImpl();
	}

	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}
	
	@Override
	public void onCreate() {
		Log.i("SVC", "Serice::onCreate");
		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.i("SVC", "Serice::onStart => " + startId);
		super.onStart(intent, startId);
		
		new Thread(svcThread).start();
	}
	
		

	private void doServiceWork() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stopSelf();
	}

	@Override
	public void onDestroy() {
		Log.i("SVC", "Serice::onDestroy");
		super.onDestroy();
	}

}



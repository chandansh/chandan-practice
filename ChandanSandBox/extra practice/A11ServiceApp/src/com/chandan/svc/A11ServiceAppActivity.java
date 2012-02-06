package com.chandan.svc;

import com.chandan.svc.MathService.Stub;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

public class A11ServiceAppActivity extends Activity {
    private ServiceConnection conn;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void doStartService(View v)
    {
    	Intent i = new Intent(this, MySimpleService.class);
    	//startService(i);
    	
    	conn = new ServiceConnection() {
			@Override
			public void onServiceDisconnected(ComponentName name) {
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				MathService.Stub svc = (Stub) service;
				Log.i("SVC", "Instance: => " + svc.toString());
				try {
					Log.i("SVC", "Result => " + svc.add(12, 34));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				unbindService(conn);
			}
		};

    	bindService(i, conn, BIND_AUTO_CREATE);
    }
}
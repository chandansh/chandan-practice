package com.test.socialapp;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressBarActivity extends Activity {

	private static final int PBAR_STARTED = 1;
	private static final int PBAR_STOPPED = 2;
	private static final int PBAR_RUNNING = 3;
	private ProgressBar pbar;
	private Button startBtn;
	//private Button btn_dbl_click;
	private static long flag = 0;

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case PBAR_STARTED:
				startBtn.setEnabled(false);
				break;
			case PBAR_STOPPED:
				startBtn.setEnabled(true);
				break;
			case PBAR_RUNNING:
				pbar.setProgress(msg.arg1);
				break;
			default:
				super.handleMessage(msg);
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pbar);

		pbar = (ProgressBar) findViewById(R.id.pbar_1);
		startBtn = (Button) findViewById(R.id.btn_pbar_start);

		startBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				handleStartClicked();

			}
		});

		((Button)findViewById(R.id.btn_dbl_click)).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				long flag1 = new Date().getTime();
				long delta = flag1 - flag;
				if (delta < 500) {
					Toast.makeText(ProgressBarActivity.this, "Double clicked",
							Toast.LENGTH_SHORT).show();
				}
				flag = flag1;
			}
		});

	}

	private void handleStartClicked() {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				Message msg = Message.obtain();
				msg.what = PBAR_STARTED;
				handler.sendMessage(msg);
				for (int i = 0; i < 100; i++) {
					msg = Message.obtain();
					msg.what = PBAR_RUNNING;
					msg.arg1 = i;
					handler.sendMessage(msg);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				msg = Message.obtain();
				msg.what = PBAR_STOPPED;
				handler.sendMessage(msg);

			}
		};
		Thread t = new Thread(r);
		t.start();
		startBtn.setEnabled(false);

	}

}

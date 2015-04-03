package com.chandansh.cpconsumer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class FlipperAnimationActivity extends Activity {

	private Handler showHandler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			vf.showNext();
			showHandler.sendMessageDelayed(Message.obtain(), 3500);
			super.handleMessage(msg);
		};
	};
	private ViewFlipper vf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final Button btn = new Button(this);
		btn.setText("Helloo");

		setContentView(btn);
		
		final Animation anim = AnimationUtils.loadAnimation(this, R.anim.shrink);

		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				anim.setDuration(2000);
				btn.startAnimation(anim);
			}
		});
		
//		setContentView(R.layout.layout_flip);
//
//		vf = (ViewFlipper) findViewById(R.id.vf);
//		vf.setOutAnimation(this, R.anim.shrink);
//		vf.setInAnimation(this, R.anim.grow);
//		showHandler.sendMessageDelayed(Message.obtain(), 3500);
	}

}

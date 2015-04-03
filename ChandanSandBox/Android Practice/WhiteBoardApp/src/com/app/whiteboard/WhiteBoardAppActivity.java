package com.app.whiteboard;

import android.app.Activity;
import android.os.Bundle;

public class WhiteBoardAppActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) findViewById(R.id.mcq);
		mcq.setQuestion("This is a very simple question...");

		// Spanned html = Html.fromHtml("This is question with image." +
		// "<img src=\"android_assets://\"> Let's see", new ImageGetter() {
		//
		// @Override
		// public Drawable getDrawable(String source) {
		// Log.w("WB", "Loading image @ " + source);
		// return getResources().getDrawable(R.drawable.ic_launcher);
		// }
		// }, null);

		// mcq.setQuestion((Spannable) html);
	}
}

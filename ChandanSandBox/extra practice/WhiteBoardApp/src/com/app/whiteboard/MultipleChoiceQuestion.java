package com.app.whiteboard;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MultipleChoiceQuestion extends LinearLayout {

	private TextView qview;
	private RadioButton rb1, rb2, rb3, rb4;

	public MultipleChoiceQuestion(Context context) {
		super(context);
		initialize(context);
	}

	public MultipleChoiceQuestion(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}

	private void initialize(Context ctx)
	{
		setOrientation(VERTICAL);
		LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.layout_mcq, this, true);
		
		qview = (TextView) findViewById(R.id.question);
	}

	public void setQuestion(String text)
	{
		qview.setText(text);
	}

	public void setQuestion(Spannable text)
	{
		qview.setText(text);
	}
}



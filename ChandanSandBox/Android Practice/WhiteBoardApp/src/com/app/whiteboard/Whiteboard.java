package com.app.whiteboard;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Whiteboard extends View {

	private Paint border;
	private Paint drawing;

	private ArrayList<PointFWithInfo> points = new ArrayList<PointFWithInfo>();

	public Whiteboard(Context context) {
		super(context);
		initialize();
	}

	public Whiteboard(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	public Whiteboard(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize();
	}

	private void initialize()
	{
		border = new Paint();
		border.setColor(0xFFFFFF00);

		drawing = new Paint();
		drawing.setColor(0xFFFFFF00);
		drawing.setStyle(Style.STROKE);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int width = calcWidth(widthMeasureSpec);
		int height = calcHeight(heightMeasureSpec);

		setMeasuredDimension(width, height);
	}

	private int calcHeight(int heightMeasureSpec) {
		int mode = MeasureSpec.getMode(heightMeasureSpec);
		int size = MeasureSpec.getSize(heightMeasureSpec);

		if (mode == MeasureSpec.EXACTLY) {
			return size;
		}

		int rv = 200;

		if (mode == MeasureSpec.AT_MOST) {
			rv = Math.min(rv, size);
		}

		return rv;
	}

	private int calcWidth(int widthMeasureSpec) {

		int mode = MeasureSpec.getMode(widthMeasureSpec);
		int size = MeasureSpec.getSize(widthMeasureSpec);

		if (mode == MeasureSpec.EXACTLY) {
			return size;
		}

		int rv = 200;

		if (mode == MeasureSpec.AT_MOST) {
			rv = Math.min(rv, size);
		}

		return rv;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawLine(2, 2, getWidth() - 2, 2, border);
		canvas.drawLine(2, 3, getWidth() - 2, 3, border);

		canvas.drawLine(2, getHeight() - 2, getWidth() - 2, getHeight() - 2, border);
		canvas.drawLine(2, getHeight() - 3, getWidth() - 2, getHeight() - 3, border);

		canvas.drawLine(2, 2, 2, getHeight() - 2, border);
		canvas.drawLine(3, 2, 3, getHeight() - 2, border);

		canvas.drawLine(getWidth() - 2, 2, getWidth() - 2, getHeight() - 2, border);
		canvas.drawLine(getWidth() - 3, 2, getWidth() - 3, getHeight() - 2, border);

		int size = points.size();
		PointFWithInfo prev = null;
		for(int i = 0; i < size; i++)
		{
			PointFWithInfo pf = points.get(i);
			canvas.drawPoint(pf.x, pf.y, drawing);
			canvas.drawPoint(pf.x - 1, pf.y - 1, drawing);
			canvas.drawPoint(pf.x, pf.y - 1, drawing);
			canvas.drawPoint(pf.x + 1, pf.y - 1, drawing);
			canvas.drawPoint(pf.x - 1, pf.y, drawing);
			canvas.drawPoint(pf.x + 1, pf.y, drawing);
			canvas.drawPoint(pf.x - 1, pf.y + 1, drawing);
			canvas.drawPoint(pf.x, pf.y + 1, drawing);
			canvas.drawPoint(pf.x + 1, pf.y + 1, drawing);
			Log.w("WB", "Drawing @(" + pf.x + "," + pf.y + ")");

			if(prev != null)
			{
				canvas.drawLine(prev.x, prev.y, pf.x, pf.y, drawing);
			}

			prev = pf.action == MotionEvent.ACTION_MOVE ? pf : null;
		}

		canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth() / 2, getHeight() / 2) - 5, drawing);
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth() / 2, getHeight() / 2) - 4, drawing);
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth() / 2, getHeight() / 2) - 6, drawing);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		int action = event.getAction();

		float x = event.getX();
		float y = event.getY();

		switch(action)
		{
			case MotionEvent.ACTION_DOWN:
				Log.i("WB", "Touch Down, x: " + x + ", y: " + y);
				break;
			case MotionEvent.ACTION_UP:
				Log.i("WB", "Touch Up, x: " + x + ", y: " + y);
				points.add(new PointFWithInfo(x, y, action));
				break;
			case MotionEvent.ACTION_MOVE:
				Log.i("WB", "Touch Move, x: " + x + ", y: " + y);
				captureAndRedraw(event);
				break;
		}

		return true;
	}

	private void captureAndRedraw(MotionEvent event) {
		points.add(new PointFWithInfo(event.getX(), event.getY(), event.getAction()));
		int hsize = event.getHistorySize();
		for(int i = 0; i < hsize; i++)
		{
			float x = event.getHistoricalX(i);
			float y = event.getHistoricalY(i);
			PointFWithInfo pf = new PointFWithInfo(x, y, event.getAction());
			points.add(pf);
		}

		//requestLayout()
		invalidate();
		//postInvalidate()
	}
}















package com.app.whiteboard;

import android.graphics.Point;
import android.graphics.PointF;

public class PointFWithInfo extends PointF {

	public int action;

	public PointFWithInfo() {
		super();
	}

	public PointFWithInfo(float x, float y) {
		super(x, y);
	}

	public PointFWithInfo(float x, float y, int action) {
		super(x, y);
		this.action = action;
	}

	public PointFWithInfo(Point p) {
		super(p);
	}

}

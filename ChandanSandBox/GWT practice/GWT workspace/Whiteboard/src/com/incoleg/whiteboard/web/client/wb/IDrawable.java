package com.incoleg.whiteboard.web.client.wb;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.FillStrokeStyle;
import com.google.gwt.user.client.Event;
import com.incoleg.whiteboard.web.client.wb.WhiteboardWidget.DrawStyle;

public interface IDrawable
{
	void draw(Context2d context);

	FillStrokeStyle getFillStyle();

	void setFillStyle(FillStrokeStyle fillStyle);

	FillStrokeStyle getStrokeStyle();

	void setStrokeStyle(FillStrokeStyle strokeStyle);

	double getAngle();

	void setAngle(double angle);

	Point getTranslate();

	void setTranslate(Point translate);

	DrawStyle getDrawStyle();

	void setDrawStyle(DrawStyle drawStyle);

	Point getScale();

	void setScale(Point scale);

	IDrawable deepClone();

	boolean handleMouseEvent(Context2d context, Event event);

	void merge(IDrawable currentDrawable);

	double getX();

	void setX(double x);

	double getY();

	void setY(double y);

	double getHeight();

	void setHeight(double height);

	double getWidth();

	void setWidth(double width);

	int getLineWidth();

	void setLineWidth(int width);
}

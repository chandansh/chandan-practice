package com.incoleg.whiteboard.web.client.wb;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.FillStrokeStyle;
import com.google.gwt.user.client.Event;
import com.incoleg.whiteboard.web.client.wb.WhiteboardWidget.DrawStyle;

public abstract class BaseDrawable implements IDrawable
{
	protected FillStrokeStyle fillStyle;
	protected FillStrokeStyle strokeStyle;
	protected DrawStyle drawStyle = DrawStyle.FillAndStroke;

	protected double angle = 0;
	protected Point translate;
	protected Point scale;
	protected int lineWidth = 1;

	// protected int lastDownX, lastDownY;
	protected boolean isMouseDown = false;

	protected double x;
	protected double y;
	protected double width;
	protected double height;

	public FillStrokeStyle getFillStyle()
	{
		return fillStyle;
	}

	public void setFillStyle(FillStrokeStyle fillStyle)
	{
		this.fillStyle = fillStyle;
	}

	public FillStrokeStyle getStrokeStyle()
	{
		return strokeStyle;
	}

	public void setStrokeStyle(FillStrokeStyle strokeStyle)
	{
		this.strokeStyle = strokeStyle;
	}

	public double getAngle()
	{
		return angle;
	}

	public void setAngle(double angle)
	{
		this.angle = angle;
	}

	public DrawStyle getDrawStyle()
	{
		return drawStyle;
	}

	public void setDrawStyle(DrawStyle drawStyle)
	{
		this.drawStyle = drawStyle;
	}

	public Point getScale()
	{
		return scale;
	}

	public void setScale(Point scale)
	{
		if(scale != null && scale.x == 1 && scale.y == 1)
		{
			scale = null;
		}
		this.scale = scale;
	}

	public Point getTranslate()
	{
		return translate;
	}

	public void setTranslate(Point translate)
	{
		this.translate = translate;
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public double getWidth()
	{
		return width;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	@Override
	public void draw(Context2d context)
	{
		preDrawContent(context);
		if(fillStyle != null)
		{
			context.setFillStyle(fillStyle);
		}
		if(strokeStyle != null)
		{
			context.setStrokeStyle(strokeStyle);
			context.setLineWidth(lineWidth);
		}
		if(scale != null)
		{
			// GWT.log("Scale: " + scale);
			context.scale(scale.x, scale.y);
		}
		if(angle != 0)
		{
			context.rotate(angle);
		}
		if(translate != null)
		{
			context.translate(translate.x, translate.y);
		}
		drawContent(context);
	}

	protected void preDrawContent(Context2d context)
	{
	}

	protected abstract void drawContent(Context2d context);

	@Override
	public IDrawable deepClone()
	{
		IDrawable id = getCloneObject();
		id.setAngle(angle);
		id.setDrawStyle(drawStyle);
		id.setFillStyle(fillStyle);
		id.setScale(scale);
		id.setStrokeStyle(strokeStyle);
		id.setTranslate(translate);
		id.setX(x);
		id.setY(y);
		id.setHeight(height);
		id.setWidth(width);

		return id;
	}

	protected abstract IDrawable getCloneObject();

	@Override
	public boolean handleMouseEvent(Context2d context, Event event)
	{
		switch(event.getTypeInt())
		{
			case Event.ONMOUSEDOWN:
				handleMouseDown(context, event);
				break;
			case Event.ONMOUSEMOVE:
				handleMouseMove(context, event);
				break;
			case Event.ONMOUSEUP:
				handleMouseUp(context, event);
				break;
		}
		return true;
	}

	protected void handleMouseMove(Context2d context, Event event)
	{
		int currentX = event.getClientX();
		int currentY = event.getClientY();

		currentX = currentX - context.getCanvas().getAbsoluteLeft();
		currentY = currentY - context.getCanvas().getAbsoluteTop();

		width = currentX - this.x;
		height = currentY - this.y;

		if(isMouseDown)
		{
			context.clearRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
			draw(context);
		}
	}

	protected void handleMouseDown(Context2d context, Event event)
	{
		int x = event.getClientX();
		int y = event.getClientY();

		x = x - context.getCanvas().getAbsoluteLeft();
		y = y - context.getCanvas().getAbsoluteTop();

		this.x = x;
		this.y = y;

		// context.clearRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
		isMouseDown = true;
	}

	protected void handleMouseUp(Context2d context, Event event)
	{
		isMouseDown = false;
	}

	@Override
	public void merge(IDrawable other)
	{
		if(other != null)
		{
			IDrawable _this = this;
			_this.setAngle(other.getAngle());
			_this.setDrawStyle(other.getDrawStyle());
			_this.setFillStyle(other.getFillStyle());
			_this.setScale(other.getScale());
			_this.setStrokeStyle(other.getStrokeStyle());
			_this.setTranslate(other.getTranslate());
			_this.setX(other.getX());
			_this.setY(other.getY());
			_this.setHeight(other.getHeight());
			_this.setWidth(other.getWidth());
			_this.setLineWidth(other.getLineWidth());
		}
	}

	public int getLineWidth()
	{
		return lineWidth;
	}

	public void setLineWidth(int lineWidth)
	{
		this.lineWidth = lineWidth;
	}
}

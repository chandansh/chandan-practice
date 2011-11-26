package com.incoleg.whiteboard.web.client.wb;

import com.google.gwt.canvas.dom.client.Context2d;

public class Arc extends BaseDrawable
{

	private double radius;
	private double startAngle;
	private double endAngle;
	private boolean antiClockwise = false;

	@Override
	public void drawContent(Context2d context)
	{
		if(fillStyle != null)
		{
			context.setFillStyle(fillStyle);
		}
		if(strokeStyle != null)
		{
			context.setStrokeStyle(strokeStyle);
		}
		context.arc(x, y, radius, startAngle, endAngle, antiClockwise);
	}

	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	public double getStartAngle()
	{
		return startAngle;
	}

	public void setStartAngle(double startAngle)
	{
		this.startAngle = startAngle;
	}

	public double getEndAngle()
	{
		return endAngle;
	}

	public void setEndAngle(double endAngle)
	{
		this.endAngle = endAngle;
	}

	public boolean isAntiClockwise()
	{
		return antiClockwise;
	}

	public void setAntiClockwise(boolean antiClockwise)
	{
		this.antiClockwise = antiClockwise;
	}

	@Override
	protected IDrawable getCloneObject()
	{
		Arc arc = new Arc();

		return arc;
	}

}

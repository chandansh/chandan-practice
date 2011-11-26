package com.incoleg.whiteboard.web.client.wb;

import com.google.gwt.canvas.dom.client.Context2d;

public class Ellipse extends BaseDrawable
{
	@Override
	public void drawContent(Context2d context)
	{
		double kappa = .5522848;
		double ox = (width / 2) * kappa;
		double oy = (height / 2) * kappa;
		double xe = x + width;
		double ye = y + height;
		double xm = x + width / 2;
		double ym = y + height / 2;

		context.beginPath();
		context.moveTo(x, ym);
		context.bezierCurveTo(x, ym - oy, xm - ox, y, xm, y);
		context.bezierCurveTo(xm + ox, y, xe, ym - oy, xe, ym);
		context.bezierCurveTo(xe, ym + oy, xm + ox, ye, xm, ye);
		context.bezierCurveTo(xm - ox, ye, x, ym + oy, x, ym);
		context.closePath();

		switch(drawStyle)
		{
			case Fill:
				context.fill();
				break;
			case Stroke:
				context.stroke();
				break;
			case FillAndStroke:
				context.fill();
				context.stroke();
				break;
		}
	}

	@Override
	protected IDrawable getCloneObject()
	{
		Ellipse e = new Ellipse();
		return e;
	}
}

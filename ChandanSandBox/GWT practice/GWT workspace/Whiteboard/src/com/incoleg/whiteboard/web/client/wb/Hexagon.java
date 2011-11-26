/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.incoleg.whiteboard.web.client.wb;

import com.google.gwt.canvas.dom.client.Context2d;

/**
 * This is a brief description of Hexagon. <br/>
 * gvaish must provide more details about the type.
 * 
 * @author gvaish
 * 
 */
public class Hexagon extends BaseDrawable
{
	@Override
	public void drawContent(Context2d context)
	{
		context.beginPath();
		context.moveTo(x + width / 2, y);
		context.lineTo(x + width, y + height / 4);
		context.lineTo(x + width, y + (3 * height) / 4);
		context.lineTo(x + width / 2, y + height);
		context.lineTo(x, y + (3 * height) / 4);
		context.lineTo(x, y + height / 4);
		context.lineTo(x + width / 2, y);

		switch(drawStyle)
		{
			case Fill:
				context.fill();
				break;
			case FillAndStroke:
				context.fill();
				context.stroke();
				break;
			case Stroke:
				context.stroke();
				break;
		}
	}

	@Override
	protected IDrawable getCloneObject()
	{
		Hexagon hx = new Hexagon();
		return hx;
	}
}

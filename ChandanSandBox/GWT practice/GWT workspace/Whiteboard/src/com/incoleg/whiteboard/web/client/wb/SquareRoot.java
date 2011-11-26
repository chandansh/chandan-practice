/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.incoleg.whiteboard.web.client.wb;

import com.google.gwt.canvas.dom.client.Context2d;

/**
 * This is a brief description of SquareRoot. <br/>
 * gvaish must provide more details about the type.
 * 
 * @author gvaish
 * 
 */
public class SquareRoot extends BaseDrawable
{
	@Override
	protected void preDrawContent(Context2d context)
	{
		super.preDrawContent(context);
		context.beginPath();
	}

	@Override
	protected void drawContent(Context2d context)
	{
		context.moveTo(x, y + (2 * height) / 3);
		context.lineTo(x + width / 9, y + (height / 3));
		context.lineTo(x + (2 * width) / 9, y + height);
		context.lineTo(x + (3 * width) / 9, y);
		context.lineTo(x + width, y);

		context.stroke();
	}

	@Override
	protected IDrawable getCloneObject()
	{
		SquareRoot sr = new SquareRoot();
		return sr;
	}
}

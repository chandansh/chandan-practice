/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.incoleg.whiteboard.web.client.wb;

import com.google.gwt.canvas.dom.client.Context2d;

/**
 * This is a brief description of Line. <br/>
 * gvaish must provide more details about the type.
 * 
 * @author gvaish
 * 
 */
public class Line extends BaseDrawable
{
	@Override
	protected void drawContent(Context2d context)
	{
		context.beginPath();
		context.moveTo(x, y);
		context.lineTo(x + width, y + height);
		context.stroke();
	}

	@Override
	protected IDrawable getCloneObject()
	{
		return new Line();
	}

}

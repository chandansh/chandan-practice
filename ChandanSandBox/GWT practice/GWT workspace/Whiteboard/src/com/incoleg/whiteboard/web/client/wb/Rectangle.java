package com.incoleg.whiteboard.web.client.wb;

import com.google.gwt.canvas.dom.client.Context2d;

public class Rectangle extends BaseDrawable
{
	@Override
	public void drawContent(Context2d context)
	{
		switch(drawStyle)
		{
			case Fill:
				context.fillRect(x, y, width, height);
				break;
			case Stroke:
				context.strokeRect(x, y, width, height);
				break;
			case FillAndStroke:
				context.fillRect(x, y, width, height);
				context.strokeRect(x - 1, y - 1, width + 1, height + 1);
		}
	}

	@Override
	protected IDrawable getCloneObject()
	{
		Rectangle r = new Rectangle();
		return r;
	}

}

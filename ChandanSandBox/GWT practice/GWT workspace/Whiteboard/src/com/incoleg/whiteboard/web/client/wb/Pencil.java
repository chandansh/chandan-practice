/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.incoleg.whiteboard.web.client.wb;

import java.util.ArrayList;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Event;

/**
 * This is a brief description of Pencil. <br/>
 * gvaish must provide more details about the type.
 * 
 * @author gvaish
 * 
 */
public class Pencil extends BaseDrawable
{
	private ArrayList<Point> movedPoints = new ArrayList<Point>();

	@Override
	protected void handleMouseMove(Context2d context, Event event)
	{
		super.handleMouseMove(context, event);

		if(isMouseDown)
		{
			int currentX = event.getClientX();
			int currentY = event.getClientY();

			currentX = currentX - context.getCanvas().getAbsoluteLeft();
			currentY = currentY - context.getCanvas().getAbsoluteTop();
			GWT.log("[hmm] cx,cy=" + currentX + "," + currentY);
			movedPoints.add(new Point(currentX, currentY));
		}
	}

	@Override
	protected void preDrawContent(Context2d context)
	{
		super.preDrawContent(context);
	}

	@Override
	protected void drawContent(Context2d context)
	{
		context.beginPath();
		context.moveTo(x, y);
		for(Point mp : movedPoints)
		{
			GWT.log("[dc] mx,my=" + mp.x + "," + mp.y);
			context.lineTo(mp.x, mp.y);
		}
		context.stroke();
	}

	@Override
	protected IDrawable getCloneObject()
	{
		Pencil p = new Pencil();
		// p.movedPoints.addAll(movedPoints);
		return p;
	}

}

package com.incoleg.whiteboard.web.client.wb;

import java.util.Stack;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.FillStrokeStyle;
import com.google.gwt.canvas.dom.client.ImageData;
import com.google.gwt.canvas.dom.client.TextMetrics;
import com.google.gwt.canvas.dom.client.Context2d.Composite;
import com.google.gwt.canvas.dom.client.Context2d.LineCap;
import com.google.gwt.canvas.dom.client.Context2d.LineJoin;
import com.google.gwt.canvas.dom.client.Context2d.TextAlign;
import com.google.gwt.canvas.dom.client.Context2d.TextBaseline;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Widget;

public class WhiteboardWidget extends Widget
{

	public enum DrawMode
	{
		Arc,
		Ellipse,
		Polygon,
		Rectangle,
		Hexagon,
		Line,
		Pencil,
		Text,
		Select,
		SquareRoot
	}

	public enum DrawStyle
	{
		FillAndStroke,
		Fill,
		Stroke
	}

	private DrawMode drawMode = DrawMode.Rectangle;

	private DivElement wrapperElement;
	private Canvas c;
	private Canvas ghost;

	private Context2d ctx;
	private Context2d ghostCtx;

	private Stack<IDrawable> drawables = new Stack<IDrawable>();
	private Stack<IDrawable> undoList = new Stack<IDrawable>();

	private IDrawable currentDrawable = null;

	public WhiteboardWidget(int width, int height)
	{

		String w = width + "px";
		String h = height + "px";

		wrapperElement = Document.get().createDivElement();
		Style ws = wrapperElement.getStyle();
		ws.setPosition(Position.RELATIVE);
		ws.setBorderStyle(BorderStyle.DOTTED);
		ws.setBorderWidth(1, Unit.PX);
		ws.setBorderColor("black");
		setElement(wrapperElement);

		c = Canvas.createIfSupported();
		ghost = Canvas.createIfSupported();

		setWidth(w);
		setHeight(h);

		if(c == null || ghost == null)
		{
			wrapperElement.setInnerHTML("Your browser does not support canvas");
		} else
		{
			c.setWidth(w);
			c.setHeight(h);

			c.setCoordinateSpaceWidth(width);
			c.setCoordinateSpaceHeight(height);

			ghost.setWidth(w);
			ghost.setHeight(h);
			ghost.setCoordinateSpaceWidth(width);
			ghost.setCoordinateSpaceHeight(height);

			wrapperElement.appendChild(c.getElement());
			Element ghostElement = ghost.getElement();
			Style s = ghostElement.getStyle();
			s.setPosition(Position.ABSOLUTE);
			s.setLeft(0, Unit.PX);
			s.setTop(0, Unit.PX);

			wrapperElement.appendChild(ghostElement);
			ctx = c.getContext2d();
			ghostCtx = ghost.getContext2d();

			sinkEvents(Event.MOUSEEVENTS);
			sinkEvents(Event.TOUCHEVENTS);
		}
	}

	@Override
	public void onBrowserEvent(Event event)
	{
		int eventType = event.getTypeInt();
		if((eventType & Event.MOUSEEVENTS) != 0x00)
		{
			handleMouseEvent(event);
		}
		// if((eventType & Event.TOUCHEVENTS) != 0x00)
		// {
		// handleMouseEvent(event);
		// }

		super.onBrowserEvent(event);
	}

	private void handleMouseEvent(Event event)
	{
		switch(event.getTypeInt())
		{
			case Event.ONMOUSEDOWN:
			case Event.ONTOUCHSTART:
				handleMouseDown(event);
				break;
			case Event.ONMOUSEMOVE:
			case Event.ONTOUCHMOVE:
				handleMouseMove(event);
				break;
			case Event.ONMOUSEUP:
			case Event.ONTOUCHEND:
			case Event.ONTOUCHCANCEL:
				handleMouseUp(event);
				break;
		}
	}

	private void handleMouseDown(Event event)
	{
		if(currentDrawable != null)
		{
			currentDrawable.handleMouseEvent(ghostCtx, event);
		}
	}

	private void handleMouseUp(Event event)
	{
		// isMouseDown = false;
		if(currentDrawable != null)
		{
			currentDrawable.handleMouseEvent(ghostCtx, event);
		}
		commit();
	}

	private void handleMouseMove(Event event)
	{
		if(currentDrawable != null)
		{
			currentDrawable.handleMouseEvent(ghostCtx, event);
		}
	}

	private void initializeCurrentDrawable()
	{
		// GWT.log("Initializing the drawable...");
		IDrawable id = null;
		switch(drawMode)
		{
			case Ellipse:
				id = new Ellipse();
				break;
			case Rectangle:
				id = new Rectangle();
				break;
			case Hexagon:
				id = new Hexagon();
				break;
			case Line:
				id = new Line();
				break;
			case Pencil:
				id = new Pencil();
				break;
			case SquareRoot:
				id = new SquareRoot();
				break;
		}

		GWT.log("[WhiteboardWidget] Changed the drawable to: " + id);
		if(id != null)
		{
			if(currentDrawable != null)
			{
				id.merge(currentDrawable);
			}
			currentDrawable = id;
		}
		currentDrawable.setDrawStyle(DrawStyle.FillAndStroke);
	}

	public final FillStrokeStyle getFillStyle()
	{
		return ghostCtx.getFillStyle();
	}

	public final String getFont()
	{
		return ghostCtx.getFont();
	}

	public final double getGlobalAlpha()
	{
		return ghostCtx.getGlobalAlpha();
	}

	public final String getGlobalCompositeOperation()
	{
		return ghostCtx.getGlobalCompositeOperation();
	}

	public final ImageData getImageData(double sx, double sy, double sw, double sh)
	{
		return ghostCtx.getImageData(sx, sy, sw, sh);
	}

	public final String getLineCap()
	{
		return ghostCtx.getLineCap();
	}

	public final String getLineJoin()
	{
		return ghostCtx.getLineJoin();
	}

	public final double getLineWidth()
	{
		return ghostCtx.getLineWidth();
	}

	public final double getMiterLimit()
	{
		return ghostCtx.getMiterLimit();
	}

	public final double getShadowBlur()
	{
		return ghostCtx.getShadowBlur();
	}

	public final String getShadowColor()
	{
		return ghostCtx.getShadowColor();
	}

	public final double getShadowOffsetX()
	{
		return ghostCtx.getShadowOffsetX();
	}

	public final double getShadowOffsetY()
	{
		return ghostCtx.getShadowOffsetY();
	}

	public final FillStrokeStyle getStrokeStyle()
	{
		// return ghostCtx.getStrokeStyle();
		if(currentDrawable != null)
		{
			return currentDrawable.getStrokeStyle();
		}
		return null;
	}

	public final String getTextAlign()
	{
		return ghostCtx.getTextAlign();
	}

	public final String getTextBaseline()
	{
		return ghostCtx.getTextBaseline();
	}

	public final boolean isPointInPath(double x, double y)
	{
		return ghostCtx.isPointInPath(x, y);
	}

	public final TextMetrics measureText(String text)
	{
		return ghostCtx.measureText(text);
	}

	public final void rotate(double angle)
	{
		if(currentDrawable != null)
		{
			currentDrawable.setAngle(angle);
		}
	}

	public final void scale(double x, double y)
	{
		if(currentDrawable != null)
		{
			currentDrawable.setScale(new Point(x, y));
		}
	}

	public final void setFillStyle(FillStrokeStyle fillStyle)
	{
		if(currentDrawable != null)
		{
			currentDrawable.setFillStyle(fillStyle);
		}
	}

	public final void setFont(String f)
	{
		ghostCtx.setFont(f);
	}

	public final void setGlobalAlpha(double alpha)
	{
		ghostCtx.setGlobalAlpha(alpha);
	}

	public final void setGlobalCompositeOperation(Composite composite)
	{
		ghostCtx.setGlobalCompositeOperation(composite);
	}

	public final void setGlobalCompositeOperation(String globalCompositeOperation)
	{
		ghostCtx.setGlobalCompositeOperation(globalCompositeOperation);
	}

	public final void setLineCap(LineCap lineCap)
	{
		ghostCtx.setLineCap(lineCap);
	}

	public final void setLineCap(String lineCap)
	{
		ghostCtx.setLineCap(lineCap);
	}

	public final void setLineJoin(LineJoin lineJoin)
	{
		ghostCtx.setLineJoin(lineJoin);
	}

	public final void setLineJoin(String lineJoin)
	{
		ghostCtx.setLineJoin(lineJoin);
	}

	public final void setLineWidth(double lineWidth)
	{
		ghostCtx.setLineWidth(lineWidth);
	}

	public final void setMiterLimit(double miterLimit)
	{
		ghostCtx.setMiterLimit(miterLimit);
	}

	public final void setShadowBlur(double shadowBlur)
	{
		ghostCtx.setShadowBlur(shadowBlur);
	}

	public final void setShadowColor(String shadowColor)
	{
		ghostCtx.setShadowColor(shadowColor);
	}

	public final void setShadowOffsetX(double shadowOffsetX)
	{
		ghostCtx.setShadowOffsetX(shadowOffsetX);
	}

	public final void setShadowOffsetY(double shadowOffsetY)
	{
		ghostCtx.setShadowOffsetY(shadowOffsetY);
	}

	public final void setStrokeStyle(FillStrokeStyle strokeStyle)
	{
		if(currentDrawable != null)
		{
			currentDrawable.setStrokeStyle(strokeStyle);
		}
	}

	public final void setTextAlign(String align)
	{
		ghostCtx.setTextAlign(align);
	}

	public final void setTextAlign(TextAlign align)
	{
		ghostCtx.setTextAlign(align);
	}

	public final void setTextBaseline(String baseline)
	{
		ghostCtx.setTextBaseline(baseline);
	}

	public final void setTextBaseline(TextBaseline baseline)
	{
		ghostCtx.setTextBaseline(baseline);
	}

	public final void setTransform(double m11, double m12, double m21, double m22, double dx, double dy)
	{
		ghostCtx.setTransform(m11, m12, m21, m22, dx, dy);
	}

	public final void transform(double m11, double m12, double m21, double m22, double dx, double dy)
	{
		ghostCtx.transform(m11, m12, m21, m22, dx, dy);
	}

	public final void translate(double x, double y)
	{
		// ghostCtx.translate(x, y);
		if(currentDrawable != null)
		{
			currentDrawable.setTranslate(new Point(x, y));
		}
	}

	public void commit()
	{
		if(currentDrawable != null)
		{
			int width = ghost.getCoordinateSpaceWidth();
			int height = ghost.getCoordinateSpaceHeight();

			ctx.drawImage(ghostCtx.getCanvas(), 0, 0, width, height);
			ghostCtx.clearRect(0, 0, width, height);

			drawables.push(currentDrawable);
			currentDrawable = currentDrawable.deepClone();
		}
	}

	public DrawMode getDrawMode()
	{
		return drawMode;
	}

	public void setDrawMode(DrawMode drawMode)
	{
		this.drawMode = drawMode;
		initializeCurrentDrawable();
	}

	public DrawStyle getDrawStyle()
	{
		return currentDrawable.getDrawStyle();
	}

	public void setDrawStyle(DrawStyle drawStyle)
	{
		if(currentDrawable != null)
		{
			currentDrawable.setDrawStyle(drawStyle);
		}
	}

	public boolean canUndo()
	{
		return drawables.size() > 0;
	}

	public boolean canRedo()
	{
		return undoList.size() > 0;
	}

	public void undo()
	{
		if(drawables.size() > 0)
		{
			IDrawable id = drawables.pop();
			undoList.add(id);
			invalidate();
		}
	}

	public void redo()
	{
		if(undoList.size() > 0)
		{
			IDrawable id = undoList.pop();
			drawables.push(id);
			invalidate();
		}
	}

	public void invalidate()
	{
		ctx.clearRect(0, 0, ctx.getCanvas().getWidth(), ctx.getCanvas().getHeight());
		for(int i = 0; i < drawables.size(); i++)
		{
			IDrawable d = drawables.get(i);
			ctx.save();
			d.draw(ctx);
			ctx.restore();
		}
	}

	public String toDataURL()
	{
		return c.toDataUrl("image/png");
	}
}

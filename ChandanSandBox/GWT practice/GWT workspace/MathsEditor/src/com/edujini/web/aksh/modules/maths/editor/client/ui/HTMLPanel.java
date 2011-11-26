/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.edujini.web.aksh.modules.maths.editor.client.ui;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * This is a brief description of HTMLPanel.
 * <br/>
 * gvaish must provide more details about the type.
 *
 * @author gvaish
 *
 */
public class HTMLPanel extends com.google.gwt.user.client.ui.HTMLPanel implements HasMouseOverHandlers, HasMouseOutHandlers
{
	public HTMLPanel(SafeHtml safeHtml)
	{
		super(safeHtml);
		initialize();
	}

	public HTMLPanel(String tag, String html)
	{
		super(tag, html);
		initialize();
	}

	public HTMLPanel(String html)
	{
		super(html);
		initialize();
	}

	private void initialize()
	{
		addMouseOverHandler(new MouseOverHandler()
		{
			@Override
			public void onMouseOver(MouseOverEvent event)
			{
				getElement().getStyle().setOverflow(Overflow.VISIBLE);
			}
		});

		addMouseOutHandler(new MouseOutHandler()
		{
			@Override
			public void onMouseOut(MouseOutEvent event)
			{
				getElement().getStyle().setOverflow(Overflow.HIDDEN);
			}
		});
	}
	
	@Override
	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler)
	{
		return addDomHandler(handler, MouseOutEvent.getType());
	}

	@Override
	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler)
	{
		return addDomHandler(handler, MouseOverEvent.getType());
	}
}

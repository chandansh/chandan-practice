/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.edujini.web.aksh.modules.maths.editor.client.ui.tooltip;

import java.util.HashMap;

import com.edujini.web.aksh.modules.maths.editor.client.ui.IHasTooltip;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.UIObject;

/**
 * This is a brief description of TooltipManager. <br/>
 * gvaish must provide more details about the type.
 * 
 * @author gvaish
 * 
 */
public class TooltipManager
{
	private static final TooltipManager instance = new TooltipManager();

	private UIObject theUIObject;
	private Tooltip tooltipWidget;
	private PopupPanel ttipPanel;

	private HashMap<Object, HandlerRegistration[]> regs = new HashMap<Object, HandlerRegistration[]>();

	private MouseOverHandler mover = new MouseOverHandler()
	{
		@Override
		public void onMouseOver(MouseOverEvent event)
		{
			Object obj = (IHasTooltip) event.getSource();
			if(obj != null && obj instanceof IHasTooltip)
			{
				IHasTooltip iht = (IHasTooltip) obj;
				String tooltip = iht.getTooltip();
				if(tooltip != null && tooltip.length() > 0)
				{
					tooltipWidget.setHTML(tooltip);
					theUIObject = (UIObject) obj;
					ttipPanel.showRelativeTo(theUIObject);
				}
			}
		}
	};

	private MouseOutHandler mout = new MouseOutHandler()
	{
		@Override
		public void onMouseOut(MouseOutEvent event)
		{
			ttipPanel.hide();
		}
	};

	private TooltipManager()
	{
		tooltipWidget = new Tooltip();
		ttipPanel = new PopupPanel(true, false)
		{
			@Override
			public void setPopupPosition(int left, int top)
			{
				if(theUIObject != null)
				{
					left += theUIObject.getOffsetWidth() + 5;
					top += 5;
				}
				super.setPopupPosition(left, top);
			}
		};
		ttipPanel.setStyleName("aksh-Tooltip-Panel");
		ttipPanel.setWidget(tooltipWidget);
		ttipPanel.hide();
		ttipPanel.getElement().getStyle().setZIndex(20000);
	}

	public <T extends HasMouseOverHandlers & HasMouseOutHandlers & IHasTooltip> void unregister(T widget)
	{
		HandlerRegistration[] hr = regs.get(widget);
		if(hr != null)
		{
			hr[0].removeHandler();
			hr[1].removeHandler();
		}
	}

	public <T extends HasMouseOverHandlers & HasMouseOutHandlers> void register(T widget)
	{
		HandlerRegistration[] hr = new HandlerRegistration[2];
		hr[0] = widget.addMouseOverHandler(mover);
		hr[1] = widget.addMouseOutHandler(mout);
		regs.put(widget, hr);
	}

	public static TooltipManager getInstance()
	{
		return instance;
	}
}

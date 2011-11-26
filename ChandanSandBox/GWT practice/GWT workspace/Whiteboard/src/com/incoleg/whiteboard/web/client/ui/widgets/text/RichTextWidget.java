package com.incoleg.whiteboard.web.client.ui.widgets.text;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class RichTextWidget extends VerticalPanel implements IsWidget, HasHTML, HasValue<String>
{
	private RichTextToolbar toolbar;
	private RichTextArea area;
	private String value;

	private static RichTextWidget instance;

	private HandlerRegistration registration;

	public static RichTextWidget getSingleton()
	{
		if(instance == null)
		{
			instance = new RichTextWidget();
		}
		return instance; // new RichTextWidget();
	}

	public RichTextWidget()
	{
		area = new RichTextArea();
		area.setWidth("100%");
		area.setHeight("100%");
		Style style = getElement().getStyle();
		style.setBorderColor("#92C1F0");
		style.setBorderStyle(BorderStyle.SOLID);
		style.setBorderWidth(1, Unit.PX);

		toolbar = new RichTextToolbar(area);
		toolbar.setWidth("100%");

		super.add(toolbar);
		super.add(area);

		area.addBlurHandler(new BlurHandler()
		{
			@Override
			public void onBlur(BlurEvent event)
			{
				updateValue();
			}
		});

		addStyleName("aksh-plainRoundedBorder");
	}

	private void updateValue()
	{
		String theValue = area.getHTML();
		if(!theValue.equals(value))
		{
			setValue(theValue, true);
		}
	}

	public void setEditorHeight(String width)
	{
		area.setHeight(width);
	}

	@Override
	public Widget asWidget()
	{
		return this;
	}

	public String getHTML()
	{
		return area.getHTML();
	}

	public String getText()
	{
		return getHTML();
	}

	@Override
	public void setHTML(String html)
	{
		if(html == null)
		{
			html = "";
		}
		value = html;
		area.setHTML(html);
	}

	@Override
	public void setText(String text)
	{
		setText(text);
	}

	@Override
	public void add(IsWidget child)
	{
		throw new RuntimeException("Nothing more allowed in RichTextWidget, got IsWidget => "
				+ child.getClass().getName());
	}

	@Override
	public void add(Widget w)
	{
		throw new RuntimeException("Nothing more allowed in RichTextWidget, got Widget => " + w.getClass().getName());
	}

	@Override
	public String getValue()
	{
		return area.getHTML();
	}

	@Override
	public void setValue(String value)
	{
		setValue(value, false);
	}

	@Override
	public void setValue(String value, boolean fireEvents)
	{
		// if(value == null)
		// {
		// value = "";
		// }
		// this.value = value;
		// area.setHTML(value);
		setHTML(value);
		if(fireEvents)
		{
			fireValueChange();
		}
	}

	private void fireValueChange()
	{
		ValueChangeEvent.fire(this, value);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler)
	{
		GWT.log("[RichTextWidget::addValueChangeHandler] handler = " + handler.getClass().getName());
		if(registration != null)
		{
			try
			{
				GWT.log("[RichTextWidget::addValueChangeHandler] removing old handler");
				registration.removeHandler();
			} catch(Throwable t)
			{
				GWT.log("Error while removing... " + t.getMessage());
			}
		}
		registration = addHandler(handler, ValueChangeEvent.getType());
		return registration;
	}

	public RichTextArea getTextArea()
	{
		return area;
	}

	@Override
	public void setHeight(String height)
	{
		super.setHeight(height);
		area.getElement().getParentElement().setAttribute("height", height);
	}
}

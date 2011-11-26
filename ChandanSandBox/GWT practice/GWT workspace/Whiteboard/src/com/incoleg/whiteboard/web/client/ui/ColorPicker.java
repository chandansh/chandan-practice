package com.incoleg.whiteboard.web.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

// This class is adapted from ColorPicker at Apache James
// http://svn.apache.org/viewvc/james/hupa/trunk/widgets/src/main/java/org/apache/hupa/widgets/editor/ColorPicker.java?view=markup&pathrev=899307
public class ColorPicker extends PopupPanel implements ClickHandler, HasValueChangeHandlers<String>
{
	private static ColorPickerUiBinder uiBinder = GWT.create(ColorPickerUiBinder.class);

	interface ColorPickerUiBinder extends UiBinder<Widget, ColorPicker>
	{
	}

	@UiField
	FlexTable colorTable;

	private String selectedColor;

	int[] colors = new int[] {
		0xffffff, 0xcccccc, 0xc0c0c0, 0x999999, 0x666666, 0x333333, 0x000000, 0xffcccc, 0xff6666, 0xff0000, 0xcc0000,
		0x990000, 0x660000, 0x330000, 0xffcc99, 0xff9966, 0xff9900, 0xfd6500, 0xcb6500, 0x983200, 0x653200, 0xffff99,
		0xffff66, 0xffcc66, 0xfdcb32, 0xcb9832, 0x986532, 0x653232, 0xffffcc, 0xffff33, 0xffff00, 0xfdcb00, 0x989800,
		0x656500, 0x323200, 0x99ff99, 0x66ff99, 0x33ff33, 0x32cb00, 0x009800, 0x006500, 0x003200, 0x99ffff, 0x33ffff,
		0x66cccc, 0x00cbcb, 0x329898, 0x326565, 0x003232, 0xccffff, 0x66ffff, 0x33ccff, 0x3265fd, 0x3232fd, 0x000098,
		0x000065, 0xccccff, 0x9999ff, 0x6666cc, 0x6532fd, 0x6500cb, 0x323298, 0x320098, 0xffccff, 0xff99ff, 0xcc66cc,
		0xcb32cb, 0x983298, 0x653265, 0x320032,
	};

	public ColorPicker()
	{
		super(true, false);
		setWidget(uiBinder.createAndBindUi(this));

		int index = 0;
		int totalColors = colors.length;

		for(int row = 0; index < totalColors; row++)
		{
			for(int col = 0; col < 6 && index < totalColors; col++)
			{
				ColorCell cc = new ColorCell(colors[index]);
				cc.addClickHandler(this);
				colorTable.setWidget(row, col, cc);
				index++;
			}
		}

		setAnimationEnabled(true);
	}

	public String getSelectedColor()
	{
		return selectedColor;
	}

	@Override
	public void onClick(ClickEvent event)
	{
		ColorCell cc = (ColorCell) event.getSource();
		this.selectedColor = cc.getColor();

		ValueChangeEvent.fire(this, this.selectedColor);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler)
	{
		return addHandler(handler, ValueChangeEvent.getType());
	}

	private class ColorCell extends Label
	{
		String color;

		public ColorCell(int color)
		{
			this(Integer.toHexString(color));
		}

		// No names (like red, blue) allowed
		public ColorCell(String color)
		{
			setColor(color.toUpperCase());
			setTitle(this.color);
			setSize("14px", "12px");
			DOM.setStyleAttribute(getElement(), "backgroundColor", this.color);
			setBorderColor("#cccccc");

			addMouseOverHandler(new MouseOverHandler()
			{
				@Override
				public void onMouseOver(MouseOverEvent event)
				{
					setBorderColor("#FFFFFF");
				}
			});

			addMouseOutHandler(new MouseOutHandler()
			{
				@Override
				public void onMouseOut(MouseOutEvent event)
				{
					setBorderColor("#CCCCCC");
				}
			});
		}

		public void setBorderColor(String color)
		{
			DOM.setStyleAttribute(getElement(), "border", "1px solid " + color);
		}

		public String getColor()
		{
			return this.color;
		}

		public void setColor(String newColor)
		{
			while(newColor.length() < 6)
			{
				newColor = '0' + newColor;
			}
			this.color = '#' + newColor;
		}
	}
}

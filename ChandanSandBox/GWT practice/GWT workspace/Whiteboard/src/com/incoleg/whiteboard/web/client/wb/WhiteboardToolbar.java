package com.incoleg.whiteboard.web.client.wb;

import java.util.HashMap;

import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;
import com.incoleg.whiteboard.web.client.ui.ColorPicker;
import com.incoleg.whiteboard.web.client.wb.WhiteboardWidget.DrawMode;
import com.incoleg.whiteboard.web.client.wb.WhiteboardWidget.DrawStyle;

public class WhiteboardToolbar extends Composite implements HasClickHandlers
{
	private static WhiteboardToolbarUiBinder uiBinder = GWT.create(WhiteboardToolbarUiBinder.class);

	interface WhiteboardToolbarUiBinder extends UiBinder<Widget, WhiteboardToolbar>
	{
	}

	@UiField
	ToggleButton circle;

	@UiField
	ToggleButton hexagon;

	@UiField
	ToggleButton rectangle;

	@UiField
	ToggleButton sqroot;

	@UiField
	ToggleButton line;

	@UiField
	ToggleButton pencil;

	@UiField
	Button undo;

	@UiField
	Button redo;

	@UiField
	Button download;

	@UiField
	Button add;

	@UiField
	Label borderColorPicker;

	@UiField
	Label fillColorPicker;

	@UiField
	ToggleButton transparent;

	private Label ccpicker;

	private Widget currentModeWidget;

	private HashMap<Widget, DrawMode> modes = new HashMap<Widget, DrawMode>();
	private WhiteboardWidget ww;

	private ColorPicker picker = new ColorPicker();

	public WhiteboardToolbar()
	{
		initWidget(uiBinder.createAndBindUi(this));

		modes.put(circle, DrawMode.Ellipse);
		modes.put(rectangle, DrawMode.Rectangle);
		modes.put(hexagon, DrawMode.Hexagon);
		modes.put(line, DrawMode.Line);
		modes.put(pencil, DrawMode.Pencil);
		modes.put(sqroot, DrawMode.SquareRoot);

		borderColorPicker.getElement().getStyle().setProperty("fontFamily", "Verdana");
		borderColorPicker.getElement().getStyle().setBackgroundColor(borderColorPicker.getText());
		fillColorPicker.getElement().getStyle().setProperty("fontFamily", "Verdana");
		fillColorPicker.getElement().getStyle().setBackgroundColor(fillColorPicker.getText());

		initHandlers();
	}

	private void initHandlers()
	{
		resetAllButtons();
		transparent.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				if(transparent.isDown())
				{
					ww.setDrawStyle(DrawStyle.Stroke);
				} else
				{
					ww.setDrawStyle(DrawStyle.FillAndStroke);
				}
			}
		});

		picker.addValueChangeHandler(new ValueChangeHandler<String>()
		{
			public void onValueChange(ValueChangeEvent<String> event)
			{
				picker.hide();
				String selectedColor = picker.getSelectedColor();

				ccpicker.setText(selectedColor);
				ccpicker.getElement().getStyle().setBackgroundColor(ccpicker.getText());
				if(ccpicker == borderColorPicker)
				{
					ww.setStrokeStyle(CssColor.make(selectedColor));
				} else if(ccpicker == fillColorPicker)
				{
					ww.setFillStyle(CssColor.make(selectedColor));
				}
			}
		});
	}

	@UiHandler( {
		"circle", "hexagon", "rectangle", "line", "pencil", "sqroot"
	})
	void handleModeClick(ClickEvent event)
	{
		ToggleButton tb = (ToggleButton) event.getSource();

		currentModeWidget = null;
		if(tb.isDown())
		{
			resetAllButtons();
			tb.setDown(true);
			currentModeWidget = tb;
			ww.setDrawMode(getMode());
		}
	}

	private void resetAllButtons()
	{
		circle.setDown(false);
		rectangle.setDown(false);
		hexagon.setDown(false);
		line.setDown(false);
		pencil.setDown(false);
		sqroot.setDown(false);
	}

	public DrawMode getMode()
	{
		if(currentModeWidget != null)
		{
			return modes.get(currentModeWidget);
		}
		return DrawMode.Select;
	}

	public void setWhiteboardWidget(WhiteboardWidget ww)
	{
		this.ww = ww;
	}

	@UiHandler(value = {
		"borderColorPicker", "fillColorPicker"
	})
	void handleBorderColorPickerClick(ClickEvent event)
	{
		Widget w = (Widget) event.getSource();
		picker.showRelativeTo(w);
		ccpicker = (Label) w;
	}

	@UiHandler("undo")
	void handleUndoClick(ClickEvent event)
	{
		ww.undo();
	}

	@UiHandler("redo")
	void handleRedoClick(ClickEvent event)
	{
		ww.redo();
	}

	@UiHandler("download")
	void handleDownloadClick(ClickEvent event)
	{
		String url = ww.toDataURL();
		url = url.replaceFirst("image/png", "application/octet-stream");
		Location.assign(url);
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler)
	{
		return add.addClickHandler(handler);
	}
}

package com.incoleg.whiteboard.web.client.wb;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.incoleg.whiteboard.web.client.wb.WhiteboardWidget.DrawStyle;

public class Whiteboard extends Composite implements HasClickHandlers
{

	private static WhiteboardUiBinder uiBinder = GWT.create(WhiteboardUiBinder.class);

	interface WhiteboardUiBinder extends UiBinder<Widget, Whiteboard>
	{
	}

	@UiField(provided = true)
	WhiteboardWidget board;

	@UiField
	WhiteboardToolbar toolbar;

	public Whiteboard(int width, int height)
	{
		board = new WhiteboardWidget(width, height);
		initWidget(uiBinder.createAndBindUi(this));
		toolbar.setWhiteboardWidget(board);
		board.setDrawStyle(DrawStyle.FillAndStroke);

		initHandlers();
	}

	private void initHandlers()
	{
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler)
	{
		return toolbar.addClickHandler(handler);
	}

	public String getDataURL()
	{
		return board.toDataURL();
	}
}

package com.incoleg.whiteboard.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RichTextArea.Formatter;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.incoleg.whiteboard.web.client.ui.widgets.text.RichTextWidget;
import com.incoleg.whiteboard.web.client.wb.Whiteboard;

public class WhiteboardApp extends VerticalPanel implements EntryPoint
{

	private SplitLayoutPanel dashboard;

	@Override
	public void onModuleLoad()
	{
		dashboard = new SplitLayoutPanel();

		HorizontalPanel hp = new HorizontalPanel();
		hp.setWidth("100%");

		final RichTextWidget rtw = new RichTextWidget();
		rtw.setHeight("400px");
		Style style = rtw.getElement().getStyle();
		style.setMarginTop(20, Unit.PX);
		style.setMarginLeft(20, Unit.PX);
		hp.add(rtw);

		final Whiteboard wb = new Whiteboard(320, 240);
		style = wb.getElement().getStyle();
		style.setMarginTop(20, Unit.PX);
		hp.add(wb);

		dashboard.add(hp);

		RootPanel.get().add(dashboard);
		Window.addResizeHandler(new ResizeHandler()
		{
			public void onResize(ResizeEvent event)
			{
				resizeDashboard();
			}
		});
		resizeDashboard();

		wb.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				Formatter fmt = rtw.getTextArea().getFormatter();
				fmt.insertImage(wb.getDataURL());
			}
		});
	}

	private void resizeDashboard()
	{
		int ch = Window.getClientHeight();
		int top = dashboard.getAbsoluteTop();
		dashboard.setHeight((ch - top) + "px");
	}
}











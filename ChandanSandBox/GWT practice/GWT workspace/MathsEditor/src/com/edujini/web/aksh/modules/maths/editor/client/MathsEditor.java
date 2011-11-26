/**
 * (C) 2008 - 2011, Edujini Labs Pvt Ltd. All rights reserved.
 */
package com.edujini.web.aksh.modules.maths.editor.client;

import com.edujini.web.aksh.modules.maths.editor.client.ui.SymbolImage;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

/**
 * This is a brief description of MathsEditor. <br/>
 * gvaish must provide more details about the type.
 * 
 * @author gvaish
 * 
 */
public class MathsEditor extends Composite
{
	private static MathsEditorUiBinder uiBinder = GWT.create(MathsEditorUiBinder.class);

	interface MathsEditorUiBinder extends UiBinder<Widget, MathsEditor>
	{
	}

	// @UiField
	// FocusPanel stylePanel, spacePanel, binaryPanel, symbolsPanel;

	@UiField
	Image finalImage;

	@UiField
	TextArea editorArea;

	private String editorValue = "";

	public MathsEditor()
	{
		initWidget(uiBinder.createAndBindUi(this));

		editorArea.getElement().setPropertyInt("maxLength", 200);
		finalImage.addErrorHandler(new ErrorHandler()
		{
			@Override
			public void onError(ErrorEvent event)
			{
				finalImage.getElement().getStyle().setDisplay(Display.NONE);
			}
		});

		finalImage.addLoadHandler(new LoadHandler()
		{
			@Override
			public void onLoad(LoadEvent event)
			{
				finalImage.getElement().getStyle().setDisplay(Display.INLINE);
			}
		});
	}

	private ScheduledCommand cmd = new ScheduledCommand()
	{
		@Override
		public void execute()
		{
			String value = editorArea.getValue();
			if(!editorValue.equals(value))
			{
				editorValue = value;
				getAndShowImage();
			}
		}
	};

	@UiHandler("editorArea")
	void handleEditorKeyPress(KeyPressEvent event)
	{
		Scheduler.get().scheduleDeferred(cmd);
	}

	@UiHandler("editorArea")
	void handleEditorKeyDown(KeyDownEvent event)
	{
		Scheduler.get().scheduleDeferred(cmd);
	}

	@UiHandler("editorArea")
	void handleEditorContentChanged(ValueChangeEvent<String> event)
	{
		editorValue = editorArea.getValue();
		getAndShowImage();
	}

	@UiHandler("generateBtn")
	void handleGenerateClick(ClickEvent event)
	{
		editorValue = editorArea.getValue();
		getAndShowImage();
	}

	private void getAndShowImage()
	{
		// GWT.log("Will update and show image... '" + editorValue + "'");
		finalImage.getElement().getStyle().setDisplay(Display.INLINE);
		if(editorValue.length() > 200)
		{
			editorValue = editorValue.substring(0, 199);
			editorArea.setValue(editorValue, false);
		}
		String v = escape(editorValue);
		v = v.replace("+", "%2B");
		finalImage.setUrl("http://chart.googleapis.com/chart?cht=tx&chf=bg,s,00000000&chl=" + v);
	}

	private native String escape(String raw) /*-{
		return $wnd.escape(raw || '');
	}-*/;

	public void insertSymbol(String symbol)
	{
		symbol = symbol.replace("\\nn", "\n");
		String cvalue = editorArea.getValue();
		int pos = editorArea.getCursorPos();
		int selLength = editorArea.getSelectionLength();

		// GWT.log("pos: " + pos + ", l: " + selLength);

		if(pos == -1)
		{
			editorArea.setValue(cvalue + symbol, true);
		} else
		{
			String fp = cvalue.substring(0, pos);
			String lp = cvalue.substring(pos + selLength);

			editorArea.setValue(fp + symbol + lp, true);
		}
	}

	public void setValue(String value)
	{
		editorArea.setValue(value, true);
	}

	private void processClick(ClickEvent event)
	{
		SymbolImage si = (SymbolImage) event.getSource();
		String symbol = si.getSymbol();
		insertSymbol(symbol);
	}

	public String getEquationImageURL()
	{
		return finalImage.getUrl();
	}
}

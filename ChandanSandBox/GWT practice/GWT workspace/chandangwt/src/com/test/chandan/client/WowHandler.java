package com.test.chandan.client;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.TextBox;

public class WowHandler implements KeyUpHandler {
	private Chandangwt app;

	public WowHandler(Chandangwt app) {
		this.app = app;
	}

	public void onKeyUp(KeyUpEvent event) {
		TextBox textfield = (TextBox) event.getSource();
		String text = textfield.getText();
		if (text.equalsIgnoreCase("gwt")) {
			app.resultArea.setHTML("<span class='wow'>Wow!</span>");
			app.backgroundRed();
		} else {
			app.resultArea.setHTML(text);
			app.backgroundNormal();
		}
	}

}

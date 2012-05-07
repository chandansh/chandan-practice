package de.vogella.gwt.uibinder.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class MyHTMLTable extends Composite {
	// Annotation can be used to change the name of the associated xml file
	// @UiTemplate("HelloWidgetWorld.ui.xml")
	interface MyUiBinder extends UiBinder<Widget, MyHTMLTable> {
	}

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField
	TextBox name;

	@UiField
	PasswordTextBox password;

	public MyHTMLTable(String... names) {
		// sets listBox
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("logIn")
	void handleClick(ClickEvent e) {
		if (name.getText().startsWith("a")
				&& password.getText().startsWith("b"))
			Window.alert("Hello, " + name.getText() + " login successful.");
		else
			Window.alert("User name or Password incorrect try again..");
	}
}
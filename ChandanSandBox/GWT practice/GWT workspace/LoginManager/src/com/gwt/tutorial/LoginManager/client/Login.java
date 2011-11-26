package com.gwt.tutorial.LoginManager.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends Composite {
	private TextBox textBoxUserName;
	private TextBox textBoxPassword;

	public Login() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("291px", "115px");

		Label lblNewLabel = new Label("Sign in to your account");
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		lblNewLabel.setDirectionEstimator(true);
		lblNewLabel.setStyleName("gwt-label-login");
		verticalPanel.add(lblNewLabel);

		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		flexTable.setSize("282px", "37px");

		Label lblNewLabel_1 = new Label("User Name");
		lblNewLabel_1.setStyleName("gwt-label-login");
		flexTable.setWidget(0, 0, lblNewLabel_1);
		lblNewLabel_1.setWidth("106px");

		textBoxUserName = new TextBox();
		flexTable.setWidget(0, 1, textBoxUserName);

		Label lblNewLabel_2 = new Label("Password");
		lblNewLabel_2.setStyleName("gwt-label-login");
		flexTable.setWidget(1, 0, lblNewLabel_2);

		textBoxPassword = new TextBox();
		flexTable.setWidget(1, 1, textBoxPassword);

		Button btnNewButton = new Button("New button");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (textBoxUserName.getText().length() == 0
						|| textBoxPassword.getText().length() == 0) {
					Window.alert("Username or password is empty.");
				}
			}
		});
		btnNewButton.setText("Sign in");
		flexTable.setWidget(2, 1, btnNewButton);
	}

}

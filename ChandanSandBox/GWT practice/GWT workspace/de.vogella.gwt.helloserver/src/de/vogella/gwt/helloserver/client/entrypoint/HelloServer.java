package de.vogella.gwt.helloserver.client.entrypoint;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwt.tutorial.LoginManager.client.Login;

import de.vogella.gwt.helloserver.client.service.MyUserCallback;
import de.vogella.gwt.helloserver.client.service.MyUserService;
import de.vogella.gwt.helloserver.client.service.MyUserServiceAsync;
import de.vogella.gwt.helloserver.client.table.MyTable;
import de.vogella.gwt.module.model.Person;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class HelloServer implements EntryPoint {

	private MyTable table;

	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {
		Person p = new Person();
		p.setFirstName("Chandan");
		p.setLastName("Sharma");
		Label label = new Label("Hello " + p.getFirstName() + " "
				+ p.getLastName());
		RootPanel rootPanel = RootPanel.get();
		rootPanel.add(label);

		table = new MyTable(null);

		Button button = new Button("Fetch Data");

		Button button1 = new Button("Clear Data");
		// We can add style names
		button.addStyleName("pc-template-btn");
		// or we can set an id on a specific element for styling

		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setSize("540px", "589px");
		vPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);

		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.setWidth("80%");
		hPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		hPanel.add(button);
		hPanel.add(button1);

		vPanel.add(hPanel);
		vPanel.add(table);

		// Add table and button to the RootPanel
		rootPanel.add(vPanel, 20, 37);

		Login login = new Login();
		vPanel.add(login);

		final Image img = new Image();
		vPanel.add(img);

//		final Whiteboard whiteboard = new Whiteboard(300, 200);
//		whiteboard.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				// Window.alert("Image: " + whiteboard.getDataURL());
//				img.setUrl(whiteboard.getDataURL());
//			}
//		});
//		vPanel.add(whiteboard);
//
//		final RichTextWidget rtw = new RichTextWidget();
//		rtw.setHeight("400px");
//		Style style = rtw.getElement().getStyle();
//		style.setMarginTop(20, Unit.PX);
//		style.setMarginLeft(20, Unit.PX);
//		vPanel.add(rtw);
		// Create the dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Welcome to GWT Server Communication!");
		dialogBox.setAnimationEnabled(true);
		Button closeButton = new Button("Ok");
		final Label dialogLabel = new Label();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.setWidth("100%");
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		dialogVPanel.add(dialogLabel);
		dialogVPanel.add(closeButton);

		closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});

		// Set the contents of the Widget
		dialogBox.setWidget(dialogVPanel);

		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				MyUserServiceAsync service = (MyUserServiceAsync) GWT
						.create(MyUserService.class);
				// ServiceDefTarget serviceDef = (ServiceDefTarget) service;
				// serviceDef.setServiceEntryPoint(GWT.getModuleBaseURL()+
				// "userService");
				MyUserCallback myUserCallback = new MyUserCallback(table);
				service.getUserList(myUserCallback);
				dialogLabel.setText("Data fetched from Server...");
				dialogBox.center();
			}
		});

		button1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				table.setInput(null);
				dialogLabel.setText("Data cleared...");
				dialogBox.center();
			}
		});

	}
}

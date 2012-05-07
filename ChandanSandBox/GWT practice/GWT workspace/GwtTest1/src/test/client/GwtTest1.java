package test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class GwtTest1 implements EntryPoint {
	private final ShowServiceAsync showSvc = GWT.create(ShowService.class);

	public void onModuleLoad() {
		final Button sendButton = new Button("Submit");
		final TextBox nameField = new TextBox();
		nameField.setText("please enter your name");
		RootPanel rootPanel = RootPanel.get();
		rootPanel.add(nameField);
		rootPanel.add(sendButton);
		
		sendButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				showSvc.showMsg(nameField.getText(), new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						Window.alert(result);
						
					}
					
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
				
				
			}
		});
		
	}
}

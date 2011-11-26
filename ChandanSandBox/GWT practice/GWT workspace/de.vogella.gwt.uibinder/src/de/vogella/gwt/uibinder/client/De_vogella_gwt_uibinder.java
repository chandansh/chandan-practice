package de.vogella.gwt.uibinder.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import de.vogella.gwt.module.model.Person;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class De_vogella_gwt_uibinder implements EntryPoint {
	
	public void onModuleLoad() {

		HelloWidgetWorld helloWorld =
		  new HelloWidgetWorld("Red", "Green", "Blue");
		Person p = new Person();
		p.setFirstName("Chandan");
		p.setLastName("Sharma");
		Label label = new Label("Hello " + p.getFirstName()+" "+p.getLastName());
		RootPanel.get().add(label);
        RootPanel.get().add(helloWorld);
        RootPanel.get().add(new MyHTMLTable());
    }

}
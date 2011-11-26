package com.test.chandan.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Chandangwt implements EntryPoint {
	private TextBox textfield;
	public HTML resultArea;

	public void onModuleLoad() {
		buttonSetup();
		listSetup();
		textBoxSetup();
	}

	private void textBoxSetup() {
		textfield = new TextBox();
		textfield.addKeyUpHandler(new WowHandler(this));
		resultArea = new HTML("<i>Result will go here</i>");
		RootPanel.get().addStyleName("tan");
		RootPanel.get("textfieldID").add(textfield);
		RootPanel.get("resultID").add(resultArea);
		
	}

	private void listSetup() {
		ListBox stateList = new ListBox();
		populateStateList(stateList);
		stateList.setVisibleItemCount(1);
		ListBox cityList = new ListBox();
		cityList.addItem("Select City");
		cityList.setVisibleItemCount(1);
		cityList.setEnabled(false);
		stateList.addChangeHandler(new StateHandler(stateList, cityList));
		RootPanel.get("stateListHolder").add(stateList);
		RootPanel.get("cityListHolder").add(cityList);

	}

	private void populateStateList(ListBox stateList) {
		stateList.addItem("Select State");
		StateInfo[] nearbyStates = StateInfo.getNearbyStates();
		for (StateInfo state : nearbyStates) {
			stateList.addItem(state.getStateName());
		}

	}

	private void buttonSetup() {
		Button randomNumberButton = new Button("Show Random Number");
		HTML randomNumberResult = new HTML("<i>Num will go here</i>");
		randomNumberButton
				.addClickHandler(new RanNumHandler(randomNumberResult));
		RootPanel.get("numberButtonHolder").add(randomNumberButton);
		RootPanel.get("numberResultHolder").add(randomNumberResult);

	}

	public void backgroundRed() {
		RootPanel.get().addStyleName("red");
	}

	public void backgroundNormal() {
		RootPanel.get().removeStyleName("red");
	}
}

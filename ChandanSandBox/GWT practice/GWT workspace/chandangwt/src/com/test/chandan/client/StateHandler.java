package com.test.chandan.client;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.ListBox;

public class StateHandler implements ChangeHandler {
	private ListBox stateList, cityList;

	public StateHandler(ListBox stateList, ListBox cityList) {
		this.stateList = stateList;
		this.cityList = cityList;
	}

	public void onChange(ChangeEvent event) {
		int index = stateList.getSelectedIndex();
		String state = stateList.getItemText(index);
		StateInfo[] nearbyStates = StateInfo.getNearbyStates();
		String[] cities = StateInfo.findCities(nearbyStates, state);
		cityList.clear();
		for (String city : cities) {
			cityList.addItem(city);
		}
		cityList.setEnabled(true);
	}
}

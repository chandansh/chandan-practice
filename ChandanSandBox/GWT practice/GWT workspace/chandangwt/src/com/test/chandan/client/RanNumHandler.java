package com.test.chandan.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;

public class RanNumHandler implements ClickHandler {
	private HTML resultRegion;

	@Override
	public void onClick(ClickEvent event) {
		resultRegion.setText("Number: " + Math.random() * 10000);
	}

	public RanNumHandler() {
		super();
	}

	public RanNumHandler(HTML resultRegion) {
		this.resultRegion = resultRegion;
	}

	public HTML getResultRegion() {
		return resultRegion;
	}

	public void setResultRegion(HTML resultRegion) {
		this.resultRegion = resultRegion;
	}

}

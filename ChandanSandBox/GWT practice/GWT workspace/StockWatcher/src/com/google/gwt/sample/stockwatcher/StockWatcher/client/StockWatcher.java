/*
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.gwt.sample.stockwatcher.StockWatcher.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Image;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class StockWatcher implements EntryPoint {
	private static final int REFRESH_INTERVAL = 5000;
	private VerticalPanel verticalPanel;
	private FlexTable stocksFlexTable;
	private TextBox newSymbolTextBox;
	private HorizontalPanel addPanel;
	private Button addButton;
	private Label lastUpdatedLabel;
	private ArrayList<String> stocks = new ArrayList<String>(); // Add this line

	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();

		verticalPanel = new VerticalPanel();
		rootPanel.add(verticalPanel, 66, 48);
		verticalPanel.setSize("374px", "252px");

		Image image = new Image("images/googlecode.png");
		verticalPanel.add(image);

		stocksFlexTable = new FlexTable();

		// Add these lines
		stocksFlexTable.setText(0, 0, "Symbol");
		stocksFlexTable.setText(0, 1, "Price");
		stocksFlexTable.setText(0, 2, "Change");
		stocksFlexTable.setText(0, 3, "Remove");

		stocksFlexTable.setCellPadding(6);
		// Add styles to elements in the stock list table.
		stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
		stocksFlexTable.addStyleName("watchList");
		stocksFlexTable.getCellFormatter().addStyleName(0, 1,
				"watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(0, 2,
				"watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(0, 3,
				"watchListRemoveColumn");
		verticalPanel.add(stocksFlexTable);
		stocksFlexTable.setSize("406px", "34px");

		addPanel = new HorizontalPanel();
		verticalPanel.add(addPanel);
		addPanel.setSize("318px", "36px");

		newSymbolTextBox = new TextBox();
		newSymbolTextBox.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {
				if (event.getCharCode() == KeyCodes.KEY_ENTER) {
					addStock();
				}
			}
		});
		newSymbolTextBox.setFocus(true);
		addPanel.add(newSymbolTextBox);

		addButton = new Button("Add");
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addStock();
			}

		});
		addPanel.add(addButton);

		lastUpdatedLabel = new Label("New label");
		verticalPanel.add(lastUpdatedLabel);

		// setup timer to refresh list automatically
		Timer refreshTimer = new Timer() {
			public void run() {
				refreshWatchList();
			}
		};
		refreshTimer.scheduleRepeating(REFRESH_INTERVAL);

	}

	protected void refreshWatchList() {
		final double MAX_PRICE = 100.0; // $100.00
		final double MAX_PRICE_CHANGE = 0.02; // +/- 2%

		StockPrice[] prices = new StockPrice[stocks.size()];
		for (int i = 0; i < stocks.size(); i++) {
			double price = Random.nextDouble() * MAX_PRICE;
			double change = price * MAX_PRICE_CHANGE
					* (Random.nextDouble() * 2.0 - 1.0);

			prices[i] = new StockPrice((String) stocks.get(i), price, change);
		}

		updateTable(prices);
	}

	@SuppressWarnings("deprecation")
	private void updateTable(StockPrice[] prices) {
		for (int i = 0; i < prices.length; i++) {
			updateTable(prices[i]);
		}

		// change the last update timestamp
		lastUpdatedLabel.setText("Last update : "
				+ DateTimeFormat.getFullDateTimeFormat().format(new Date()));

	}

	private void updateTable(StockPrice stockPrice) {
		// make sure the stock is still in our watch list
		if (!stocks.contains(stockPrice.getSymbol())) {
			return;
		}

		int row = stocks.indexOf(stockPrice.getSymbol()) + 1;

		// Format the data in the Price and Change fields.
		String priceText = NumberFormat.getFormat("#,##0.00").format(
				stockPrice.getPrice());
		NumberFormat changeFormat = NumberFormat
				.getFormat("+#,##0.00;-#,##0.00");
		String changeText = changeFormat.format(stockPrice.getChange());
		String changePercentText = changeFormat.format(stockPrice
				.getChangePercent());

		// Populate the Price and Change fields with new data.
		stocksFlexTable.setText(row, 1, priceText);
//		stocksFlexTable.setText(row, 2, changeText + " (" + changePercentText
//				+ "%)");
		Label changeWidget = (Label)stocksFlexTable.getWidget(row, 2);
	    changeWidget.setText(changeText + " (" + changePercentText + "%)");

	 // Change the color of text in the Change field based on its value.
	    String changeStyleName = "noChange";
	    if (stockPrice.getChangePercent() < -0.1f) {
	      changeStyleName = "negativeChange";
	    }
	    else if (stockPrice.getChangePercent() > 0.1f) {
	      changeStyleName = "positiveChange";
	    }

	    changeWidget.setStyleName(changeStyleName);
	}

	private void addStock() {
		final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
		newSymbolTextBox.setFocus(true);

		// symbol must be between 1 and 10 chars that are numbers, letters, or
		// dots
		if (!symbol.matches("^[0-9a-zA-Z\\.]{1,10}$")) {
			Window.alert("'" + symbol + "' is not a valid symbol.");
			newSymbolTextBox.selectAll();
			return;
		}

		newSymbolTextBox.setText("");

		// don't add the stock if it's already in the watch list
		if (stocks.contains(symbol))
			return;

		// add the stock to the list
		int row = stocksFlexTable.getRowCount();
		stocks.add(symbol);
		stocksFlexTable.setText(row, 0, symbol);
		stocksFlexTable.setWidget(row, 2, new Label());
		stocksFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
	    stocksFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
	    stocksFlexTable.getCellFormatter().addStyleName(row, 3, "watchListRemoveColumn");
		// add button to remove this stock from the list
		Button removeStock = new Button("x");
		removeStock.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int removedIndex = stocks.indexOf(symbol);
				stocks.remove(removedIndex);
				stocksFlexTable.removeRow(removedIndex + 1);
			}
		});
		stocksFlexTable.setWidget(row, 3, removeStock);
	}
}

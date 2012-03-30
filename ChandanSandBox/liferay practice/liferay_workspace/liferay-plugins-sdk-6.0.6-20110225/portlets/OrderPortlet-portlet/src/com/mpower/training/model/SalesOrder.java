
package com.mpower.training.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SalesOrder implements Serializable {

	private String orderId;
	private String customer;
	private int amount;

	public String getOrderId() {

		return orderId;
	}

	public void setOrderId(String orderId) {

		this.orderId = orderId;
	}

	public String getCustomer() {

		return customer;
	}

	public void setCustomer(String customer) {

		this.customer = customer;
	}

	public int getAmount() {

		return amount;
	}

	public void setAmount(int amount) {

		this.amount = amount;
	}

	public SalesOrder(String orderId, String customer, int amount) {

		super();
		this.orderId = orderId;
		this.customer = customer;
		this.amount = amount;
	}

	public SalesOrder() {

	}

}

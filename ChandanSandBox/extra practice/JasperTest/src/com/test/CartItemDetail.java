package com.test;

public class CartItemDetail {

	private String sku;
	private String name;
	private long quantity;
	private double unitPrice;
	private double amount;
	private String parentXPath;

	public CartItemDetail() {

	}

	public CartItemDetail(String sku, String name, int quantity,
			double unitPrice, double amount, String parentXPath) {
		super();
		this.sku = sku;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.amount = amount;
		this.parentXPath = parentXPath;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getParentXPath() {
		return parentXPath;
	}

	public void setParentXPath(String parentXPath) {
		this.parentXPath = parentXPath;
	}

	@Override
	public String toString() {
		return "CartItemDetail [sku=" + sku + ", name=" + name + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", amount=" + amount
				+ "]";
	}
	
	

}

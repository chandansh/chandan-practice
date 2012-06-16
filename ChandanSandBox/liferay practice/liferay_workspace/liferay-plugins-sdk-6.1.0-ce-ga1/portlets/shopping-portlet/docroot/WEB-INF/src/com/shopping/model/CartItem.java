package com.shopping.model;

public class CartItem {
	int qty;
	int price;

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public CartItem() {

	}

	public CartItem(int qty, int price) {
		this.qty = qty;
		this.price = price;
	}
}
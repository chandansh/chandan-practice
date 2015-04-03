package com.test;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private long orderId;
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	private double cartTotal;
	private long primaryOrganizationId;
	private double organizationDiscountAmount = 0.00d;
	private String organizationDiscountType;

	public Cart() {

	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	public void addToCart(CartItem item) {
		cartItems.add(item);
	}

	public void removeCartItem(int index) {
		cartItems.remove(index);
	}

	public void addToCart(int index, CartItem item) {
		cartItems.add(index, item);
	}

	public CartItem getCartItem(int itemIndex) {
		return cartItems.get(itemIndex);
	}

	public int getCartItemSize() {
		return cartItems.size();
	}

	public long getPrimaryOrganizationId() {
		return primaryOrganizationId;
	}

	public void setPrimaryOrganizationId(long primaryOrganizationId) {
		this.primaryOrganizationId = primaryOrganizationId;
	}

	public double getOrganizationDiscountAmount() {
		return organizationDiscountAmount;
	}

	public void setOrganizationDiscountAmount(double organizationDiscountAmount) {
		this.organizationDiscountAmount = organizationDiscountAmount;
	}

	public String getOrganizationDiscountType() {
		return organizationDiscountType;
	}

	public void setOrganizationDiscountType(String organizationDiscountType) {
		this.organizationDiscountType = organizationDiscountType;
	}
	
	

	
	
	
	
	

}

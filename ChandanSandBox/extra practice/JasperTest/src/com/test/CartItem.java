package com.test;

import java.util.List;

public class CartItem {
	private long recipeId;
	private String recipeName;
	private String dataCenter;
	private double total;
	private String orderItemXml;
	private List<CartItemDetail> cartItemDetails;

	public CartItem() {
	}

	public CartItem(long recipeId, String recipeName, String dataCenter,
			double total, String orderItemXml,
			List<CartItemDetail> cartItemDetails) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.dataCenter = dataCenter;
		this.total = total;
		this.orderItemXml = orderItemXml;
		this.cartItemDetails = cartItemDetails;
	}

	public long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getDataCenter() {
		return dataCenter;
	}

	public void setDataCenter(String dataCenter) {
		this.dataCenter = dataCenter;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getOrderItemXml() {
		return orderItemXml;
	}

	public void setOrderItemXml(String orderItemXml) {
		this.orderItemXml = orderItemXml;
	}

	public List<CartItemDetail> getCartItemDetails() {
		return cartItemDetails;
	}

	public void setCartItemDetails(List<CartItemDetail> cartItemDetails) {
		this.cartItemDetails = cartItemDetails;
	}

}

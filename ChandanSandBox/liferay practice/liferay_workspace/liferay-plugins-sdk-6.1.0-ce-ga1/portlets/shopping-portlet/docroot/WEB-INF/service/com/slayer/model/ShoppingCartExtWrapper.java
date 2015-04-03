/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.slayer.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingCartExt}.
 * </p>
 *
 * @author    ahmedhasan
 * @see       ShoppingCartExt
 * @generated
 */
public class ShoppingCartExtWrapper implements ShoppingCartExt,
	ModelWrapper<ShoppingCartExt> {
	public ShoppingCartExtWrapper(ShoppingCartExt shoppingCartExt) {
		_shoppingCartExt = shoppingCartExt;
	}

	public Class<?> getModelClass() {
		return ShoppingCartExt.class;
	}

	public String getModelClassName() {
		return ShoppingCartExt.class.getName();
	}

	/**
	* Returns the primary key of this shopping cart ext.
	*
	* @return the primary key of this shopping cart ext
	*/
	public long getPrimaryKey() {
		return _shoppingCartExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shopping cart ext.
	*
	* @param primaryKey the primary key of this shopping cart ext
	*/
	public void setPrimaryKey(long primaryKey) {
		_shoppingCartExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the rec ID of this shopping cart ext.
	*
	* @return the rec ID of this shopping cart ext
	*/
	public long getRecId() {
		return _shoppingCartExt.getRecId();
	}

	/**
	* Sets the rec ID of this shopping cart ext.
	*
	* @param recId the rec ID of this shopping cart ext
	*/
	public void setRecId(long recId) {
		_shoppingCartExt.setRecId(recId);
	}

	/**
	* Returns the cart ID of this shopping cart ext.
	*
	* @return the cart ID of this shopping cart ext
	*/
	public long getCartId() {
		return _shoppingCartExt.getCartId();
	}

	/**
	* Sets the cart ID of this shopping cart ext.
	*
	* @param cartId the cart ID of this shopping cart ext
	*/
	public void setCartId(long cartId) {
		_shoppingCartExt.setCartId(cartId);
	}

	/**
	* Returns the item ID of this shopping cart ext.
	*
	* @return the item ID of this shopping cart ext
	*/
	public long getItemId() {
		return _shoppingCartExt.getItemId();
	}

	/**
	* Sets the item ID of this shopping cart ext.
	*
	* @param itemId the item ID of this shopping cart ext
	*/
	public void setItemId(long itemId) {
		_shoppingCartExt.setItemId(itemId);
	}

	/**
	* Returns the amount of this shopping cart ext.
	*
	* @return the amount of this shopping cart ext
	*/
	public java.lang.Integer getAmount() {
		return _shoppingCartExt.getAmount();
	}

	/**
	* Sets the amount of this shopping cart ext.
	*
	* @param amount the amount of this shopping cart ext
	*/
	public void setAmount(java.lang.Integer amount) {
		_shoppingCartExt.setAmount(amount);
	}

	public boolean isNew() {
		return _shoppingCartExt.isNew();
	}

	public void setNew(boolean n) {
		_shoppingCartExt.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingCartExt.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingCartExt.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingCartExt.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingCartExt.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shoppingCartExt.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingCartExt.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingCartExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingCartExtWrapper((ShoppingCartExt)_shoppingCartExt.clone());
	}

	public int compareTo(ShoppingCartExt shoppingCartExt) {
		return _shoppingCartExt.compareTo(shoppingCartExt);
	}

	@Override
	public int hashCode() {
		return _shoppingCartExt.hashCode();
	}

	public com.liferay.portal.model.CacheModel<ShoppingCartExt> toCacheModel() {
		return _shoppingCartExt.toCacheModel();
	}

	public ShoppingCartExt toEscapedModel() {
		return new ShoppingCartExtWrapper(_shoppingCartExt.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shoppingCartExt.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingCartExt.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCartExt.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ShoppingCartExt getWrappedShoppingCartExt() {
		return _shoppingCartExt;
	}

	public ShoppingCartExt getWrappedModel() {
		return _shoppingCartExt;
	}

	public void resetOriginalValues() {
		_shoppingCartExt.resetOriginalValues();
	}

	private ShoppingCartExt _shoppingCartExt;
}
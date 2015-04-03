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
 * This class is a wrapper for {@link ShoppingCategoryExt}.
 * </p>
 *
 * @author    ahmedhasan
 * @see       ShoppingCategoryExt
 * @generated
 */
public class ShoppingCategoryExtWrapper implements ShoppingCategoryExt,
	ModelWrapper<ShoppingCategoryExt> {
	public ShoppingCategoryExtWrapper(ShoppingCategoryExt shoppingCategoryExt) {
		_shoppingCategoryExt = shoppingCategoryExt;
	}

	public Class<?> getModelClass() {
		return ShoppingCategoryExt.class;
	}

	public String getModelClassName() {
		return ShoppingCategoryExt.class.getName();
	}

	/**
	* Returns the primary key of this shopping category ext.
	*
	* @return the primary key of this shopping category ext
	*/
	public long getPrimaryKey() {
		return _shoppingCategoryExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shopping category ext.
	*
	* @param primaryKey the primary key of this shopping category ext
	*/
	public void setPrimaryKey(long primaryKey) {
		_shoppingCategoryExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this shopping category ext.
	*
	* @return the category ID of this shopping category ext
	*/
	public long getCategoryId() {
		return _shoppingCategoryExt.getCategoryId();
	}

	/**
	* Sets the category ID of this shopping category ext.
	*
	* @param categoryId the category ID of this shopping category ext
	*/
	public void setCategoryId(long categoryId) {
		_shoppingCategoryExt.setCategoryId(categoryId);
	}

	/**
	* Returns the image ID of this shopping category ext.
	*
	* @return the image ID of this shopping category ext
	*/
	public long getImageId() {
		return _shoppingCategoryExt.getImageId();
	}

	/**
	* Sets the image ID of this shopping category ext.
	*
	* @param imageId the image ID of this shopping category ext
	*/
	public void setImageId(long imageId) {
		_shoppingCategoryExt.setImageId(imageId);
	}

	/**
	* Returns the image u r l of this shopping category ext.
	*
	* @return the image u r l of this shopping category ext
	*/
	public java.lang.String getImageURL() {
		return _shoppingCategoryExt.getImageURL();
	}

	/**
	* Sets the image u r l of this shopping category ext.
	*
	* @param imageURL the image u r l of this shopping category ext
	*/
	public void setImageURL(java.lang.String imageURL) {
		_shoppingCategoryExt.setImageURL(imageURL);
	}

	public boolean isNew() {
		return _shoppingCategoryExt.isNew();
	}

	public void setNew(boolean n) {
		_shoppingCategoryExt.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingCategoryExt.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingCategoryExt.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingCategoryExt.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingCategoryExt.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shoppingCategoryExt.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingCategoryExt.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingCategoryExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingCategoryExtWrapper((ShoppingCategoryExt)_shoppingCategoryExt.clone());
	}

	public int compareTo(ShoppingCategoryExt shoppingCategoryExt) {
		return _shoppingCategoryExt.compareTo(shoppingCategoryExt);
	}

	@Override
	public int hashCode() {
		return _shoppingCategoryExt.hashCode();
	}

	public com.liferay.portal.model.CacheModel<ShoppingCategoryExt> toCacheModel() {
		return _shoppingCategoryExt.toCacheModel();
	}

	public ShoppingCategoryExt toEscapedModel() {
		return new ShoppingCategoryExtWrapper(_shoppingCategoryExt.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shoppingCategoryExt.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingCategoryExt.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryExt.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ShoppingCategoryExt getWrappedShoppingCategoryExt() {
		return _shoppingCategoryExt;
	}

	public ShoppingCategoryExt getWrappedModel() {
		return _shoppingCategoryExt;
	}

	public void resetOriginalValues() {
		_shoppingCategoryExt.resetOriginalValues();
	}

	private ShoppingCategoryExt _shoppingCategoryExt;
}
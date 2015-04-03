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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    ahmedhasan
 * @generated
 */
public class ShoppingCategoryExtSoap implements Serializable {
	public static ShoppingCategoryExtSoap toSoapModel(ShoppingCategoryExt model) {
		ShoppingCategoryExtSoap soapModel = new ShoppingCategoryExtSoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setImageId(model.getImageId());
		soapModel.setImageURL(model.getImageURL());

		return soapModel;
	}

	public static ShoppingCategoryExtSoap[] toSoapModels(
		ShoppingCategoryExt[] models) {
		ShoppingCategoryExtSoap[] soapModels = new ShoppingCategoryExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ShoppingCategoryExtSoap[][] toSoapModels(
		ShoppingCategoryExt[][] models) {
		ShoppingCategoryExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ShoppingCategoryExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ShoppingCategoryExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ShoppingCategoryExtSoap[] toSoapModels(
		List<ShoppingCategoryExt> models) {
		List<ShoppingCategoryExtSoap> soapModels = new ArrayList<ShoppingCategoryExtSoap>(models.size());

		for (ShoppingCategoryExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ShoppingCategoryExtSoap[soapModels.size()]);
	}

	public ShoppingCategoryExtSoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public String getImageURL() {
		return _imageURL;
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	private long _categoryId;
	private long _imageId;
	private String _imageURL;
}
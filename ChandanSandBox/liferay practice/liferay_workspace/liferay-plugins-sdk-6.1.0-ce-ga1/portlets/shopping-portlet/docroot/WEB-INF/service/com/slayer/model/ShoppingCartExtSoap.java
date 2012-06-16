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
public class ShoppingCartExtSoap implements Serializable {
	public static ShoppingCartExtSoap toSoapModel(ShoppingCartExt model) {
		ShoppingCartExtSoap soapModel = new ShoppingCartExtSoap();

		soapModel.setRecId(model.getRecId());
		soapModel.setCartId(model.getCartId());
		soapModel.setItemId(model.getItemId());
		soapModel.setAmount(model.getAmount());

		return soapModel;
	}

	public static ShoppingCartExtSoap[] toSoapModels(ShoppingCartExt[] models) {
		ShoppingCartExtSoap[] soapModels = new ShoppingCartExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ShoppingCartExtSoap[][] toSoapModels(
		ShoppingCartExt[][] models) {
		ShoppingCartExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ShoppingCartExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ShoppingCartExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ShoppingCartExtSoap[] toSoapModels(
		List<ShoppingCartExt> models) {
		List<ShoppingCartExtSoap> soapModels = new ArrayList<ShoppingCartExtSoap>(models.size());

		for (ShoppingCartExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ShoppingCartExtSoap[soapModels.size()]);
	}

	public ShoppingCartExtSoap() {
	}

	public long getPrimaryKey() {
		return _recId;
	}

	public void setPrimaryKey(long pk) {
		setRecId(pk);
	}

	public long getRecId() {
		return _recId;
	}

	public void setRecId(long recId) {
		_recId = recId;
	}

	public long getCartId() {
		return _cartId;
	}

	public void setCartId(long cartId) {
		_cartId = cartId;
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public Integer getAmount() {
		return _amount;
	}

	public void setAmount(Integer amount) {
		_amount = amount;
	}

	private long _recId;
	private long _cartId;
	private long _itemId;
	private Integer _amount;
}
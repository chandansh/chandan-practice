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

package com.slayer.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.slayer.model.ShoppingCartExt;

import java.io.Serializable;

/**
 * The cache model class for representing ShoppingCartExt in entity cache.
 *
 * @author ahmedhasan
 * @see ShoppingCartExt
 * @generated
 */
public class ShoppingCartExtCacheModel implements CacheModel<ShoppingCartExt>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{recId=");
		sb.append(recId);
		sb.append(", cartId=");
		sb.append(cartId);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", amount=");
		sb.append(amount);
		sb.append("}");

		return sb.toString();
	}

	public ShoppingCartExt toEntityModel() {
		ShoppingCartExtImpl shoppingCartExtImpl = new ShoppingCartExtImpl();

		shoppingCartExtImpl.setRecId(recId);
		shoppingCartExtImpl.setCartId(cartId);
		shoppingCartExtImpl.setItemId(itemId);
		shoppingCartExtImpl.setAmount(amount);

		shoppingCartExtImpl.resetOriginalValues();

		return shoppingCartExtImpl;
	}

	public long recId;
	public long cartId;
	public long itemId;
	public Integer amount;
}
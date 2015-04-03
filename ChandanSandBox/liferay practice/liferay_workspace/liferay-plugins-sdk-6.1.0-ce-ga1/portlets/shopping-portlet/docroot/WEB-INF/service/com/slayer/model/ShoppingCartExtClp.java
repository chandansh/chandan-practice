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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.slayer.service.ShoppingCartExtLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author ahmedhasan
 */
public class ShoppingCartExtClp extends BaseModelImpl<ShoppingCartExt>
	implements ShoppingCartExt {
	public ShoppingCartExtClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingCartExt.class;
	}

	public String getModelClassName() {
		return ShoppingCartExt.class.getName();
	}

	public long getPrimaryKey() {
		return _recId;
	}

	public void setPrimaryKey(long primaryKey) {
		setRecId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_recId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoppingCartExtLocalServiceUtil.addShoppingCartExt(this);
		}
		else {
			ShoppingCartExtLocalServiceUtil.updateShoppingCartExt(this);
		}
	}

	@Override
	public ShoppingCartExt toEscapedModel() {
		return (ShoppingCartExt)Proxy.newProxyInstance(ShoppingCartExt.class.getClassLoader(),
			new Class[] { ShoppingCartExt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ShoppingCartExtClp clone = new ShoppingCartExtClp();

		clone.setRecId(getRecId());
		clone.setCartId(getCartId());
		clone.setItemId(getItemId());
		clone.setAmount(getAmount());

		return clone;
	}

	public int compareTo(ShoppingCartExt shoppingCartExt) {
		long primaryKey = shoppingCartExt.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ShoppingCartExtClp shoppingCartExt = null;

		try {
			shoppingCartExt = (ShoppingCartExtClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = shoppingCartExt.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{recId=");
		sb.append(getRecId());
		sb.append(", cartId=");
		sb.append(getCartId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.slayer.model.ShoppingCartExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recId</column-name><column-value><![CDATA[");
		sb.append(getRecId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cartId</column-name><column-value><![CDATA[");
		sb.append(getCartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _recId;
	private long _cartId;
	private long _itemId;
	private Integer _amount;
}
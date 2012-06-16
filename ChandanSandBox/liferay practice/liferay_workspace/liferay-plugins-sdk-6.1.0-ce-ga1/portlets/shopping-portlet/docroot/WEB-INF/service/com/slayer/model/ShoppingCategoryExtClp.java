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

import com.slayer.service.ShoppingCategoryExtLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author ahmedhasan
 */
public class ShoppingCategoryExtClp extends BaseModelImpl<ShoppingCategoryExt>
	implements ShoppingCategoryExt {
	public ShoppingCategoryExtClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingCategoryExt.class;
	}

	public String getModelClassName() {
		return ShoppingCategoryExt.class.getName();
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_categoryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			ShoppingCategoryExtLocalServiceUtil.addShoppingCategoryExt(this);
		}
		else {
			ShoppingCategoryExtLocalServiceUtil.updateShoppingCategoryExt(this);
		}
	}

	@Override
	public ShoppingCategoryExt toEscapedModel() {
		return (ShoppingCategoryExt)Proxy.newProxyInstance(ShoppingCategoryExt.class.getClassLoader(),
			new Class[] { ShoppingCategoryExt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ShoppingCategoryExtClp clone = new ShoppingCategoryExtClp();

		clone.setCategoryId(getCategoryId());
		clone.setImageId(getImageId());
		clone.setImageURL(getImageURL());

		return clone;
	}

	public int compareTo(ShoppingCategoryExt shoppingCategoryExt) {
		long primaryKey = shoppingCategoryExt.getPrimaryKey();

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

		ShoppingCategoryExtClp shoppingCategoryExt = null;

		try {
			shoppingCategoryExt = (ShoppingCategoryExtClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = shoppingCategoryExt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", imageId=");
		sb.append(getImageId());
		sb.append(", imageURL=");
		sb.append(getImageURL());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.slayer.model.ShoppingCategoryExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageURL</column-name><column-value><![CDATA[");
		sb.append(getImageURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _categoryId;
	private long _imageId;
	private String _imageURL;
}
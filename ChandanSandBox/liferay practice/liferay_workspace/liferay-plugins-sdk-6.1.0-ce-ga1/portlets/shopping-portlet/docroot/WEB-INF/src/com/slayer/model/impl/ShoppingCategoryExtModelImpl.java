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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.slayer.model.ShoppingCategoryExt;
import com.slayer.model.ShoppingCategoryExtModel;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the ShoppingCategoryExt service. Represents a row in the &quot;hr_ShoppingCategoryExt&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.slayer.model.ShoppingCategoryExtModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingCategoryExtImpl}.
 * </p>
 *
 * @author ahmedhasan
 * @see ShoppingCategoryExtImpl
 * @see com.slayer.model.ShoppingCategoryExt
 * @see com.slayer.model.ShoppingCategoryExtModel
 * @generated
 */
public class ShoppingCategoryExtModelImpl extends BaseModelImpl<ShoppingCategoryExt>
	implements ShoppingCategoryExtModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a shopping category ext model instance should use the {@link com.slayer.model.ShoppingCategoryExt} interface instead.
	 */
	public static final String TABLE_NAME = "hr_ShoppingCategoryExt";
	public static final Object[][] TABLE_COLUMNS = {
			{ "categoryId", Types.BIGINT },
			{ "imageId", Types.BIGINT },
			{ "imageURL", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table hr_ShoppingCategoryExt (categoryId LONG not null primary key,imageId LONG,imageURL VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table hr_ShoppingCategoryExt";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.slayer.model.ShoppingCategoryExt"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.slayer.model.ShoppingCategoryExt"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.slayer.model.ShoppingCategoryExt"));

	public ShoppingCategoryExtModelImpl() {
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

	public Class<?> getModelClass() {
		return ShoppingCategoryExt.class;
	}

	public String getModelClassName() {
		return ShoppingCategoryExt.class.getName();
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
		if (_imageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageURL;
		}
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	@Override
	public ShoppingCategoryExt toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ShoppingCategoryExt)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					ShoppingCategoryExt.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		ShoppingCategoryExtImpl shoppingCategoryExtImpl = new ShoppingCategoryExtImpl();

		shoppingCategoryExtImpl.setCategoryId(getCategoryId());
		shoppingCategoryExtImpl.setImageId(getImageId());
		shoppingCategoryExtImpl.setImageURL(getImageURL());

		shoppingCategoryExtImpl.resetOriginalValues();

		return shoppingCategoryExtImpl;
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

		ShoppingCategoryExt shoppingCategoryExt = null;

		try {
			shoppingCategoryExt = (ShoppingCategoryExt)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<ShoppingCategoryExt> toCacheModel() {
		ShoppingCategoryExtCacheModel shoppingCategoryExtCacheModel = new ShoppingCategoryExtCacheModel();

		shoppingCategoryExtCacheModel.categoryId = getCategoryId();

		shoppingCategoryExtCacheModel.imageId = getImageId();

		shoppingCategoryExtCacheModel.imageURL = getImageURL();

		String imageURL = shoppingCategoryExtCacheModel.imageURL;

		if ((imageURL != null) && (imageURL.length() == 0)) {
			shoppingCategoryExtCacheModel.imageURL = null;
		}

		return shoppingCategoryExtCacheModel;
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

	private static ClassLoader _classLoader = ShoppingCategoryExt.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ShoppingCategoryExt.class
		};
	private long _categoryId;
	private long _imageId;
	private String _imageURL;
	private transient ExpandoBridge _expandoBridge;
	private ShoppingCategoryExt _escapedModelProxy;
}
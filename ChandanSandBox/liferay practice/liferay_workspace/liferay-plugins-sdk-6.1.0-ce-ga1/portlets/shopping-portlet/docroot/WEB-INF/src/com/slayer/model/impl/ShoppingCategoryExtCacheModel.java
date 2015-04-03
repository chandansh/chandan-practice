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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.slayer.model.ShoppingCategoryExt;

import java.io.Serializable;

/**
 * The cache model class for representing ShoppingCategoryExt in entity cache.
 *
 * @author ahmedhasan
 * @see ShoppingCategoryExt
 * @generated
 */
public class ShoppingCategoryExtCacheModel implements CacheModel<ShoppingCategoryExt>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", imageURL=");
		sb.append(imageURL);
		sb.append("}");

		return sb.toString();
	}

	public ShoppingCategoryExt toEntityModel() {
		ShoppingCategoryExtImpl shoppingCategoryExtImpl = new ShoppingCategoryExtImpl();

		shoppingCategoryExtImpl.setCategoryId(categoryId);
		shoppingCategoryExtImpl.setImageId(imageId);

		if (imageURL == null) {
			shoppingCategoryExtImpl.setImageURL(StringPool.BLANK);
		}
		else {
			shoppingCategoryExtImpl.setImageURL(imageURL);
		}

		shoppingCategoryExtImpl.resetOriginalValues();

		return shoppingCategoryExtImpl;
	}

	public long categoryId;
	public long imageId;
	public String imageURL;
}
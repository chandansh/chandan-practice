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

import com.slayer.model.Author;

import java.io.Serializable;

/**
 * The cache model class for representing Author in entity cache.
 *
 * @author Chandan
 * @see Author
 * @generated
 */
public class AuthorCacheModel implements CacheModel<Author>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{authorId=");
		sb.append(authorId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", specialization=");
		sb.append(specialization);
		sb.append("}");

		return sb.toString();
	}

	public Author toEntityModel() {
		AuthorImpl authorImpl = new AuthorImpl();

		authorImpl.setAuthorId(authorId);

		if (name == null) {
			authorImpl.setName(StringPool.BLANK);
		}
		else {
			authorImpl.setName(name);
		}

		if (specialization == null) {
			authorImpl.setSpecialization(StringPool.BLANK);
		}
		else {
			authorImpl.setSpecialization(specialization);
		}

		authorImpl.resetOriginalValues();

		return authorImpl;
	}

	public long authorId;
	public String name;
	public String specialization;
}
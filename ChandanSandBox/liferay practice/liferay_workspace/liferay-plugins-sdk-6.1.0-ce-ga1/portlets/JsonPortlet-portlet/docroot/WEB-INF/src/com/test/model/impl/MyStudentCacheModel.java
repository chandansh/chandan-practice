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

package com.test.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.test.model.MyStudent;

import java.io.Serializable;

/**
 * The cache model class for representing MyStudent in entity cache.
 *
 * @author Chandan
 * @see MyStudent
 * @generated
 */
public class MyStudentCacheModel implements CacheModel<MyStudent>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public MyStudent toEntityModel() {
		MyStudentImpl myStudentImpl = new MyStudentImpl();

		myStudentImpl.setId(id);

		if (name == null) {
			myStudentImpl.setName(StringPool.BLANK);
		}
		else {
			myStudentImpl.setName(name);
		}

		myStudentImpl.resetOriginalValues();

		return myStudentImpl;
	}

	public long id;
	public String name;
}
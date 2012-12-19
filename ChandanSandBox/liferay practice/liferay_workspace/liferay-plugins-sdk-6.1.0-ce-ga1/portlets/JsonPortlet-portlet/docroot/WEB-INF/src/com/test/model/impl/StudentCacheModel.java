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

import com.test.model.Student;

import java.io.Serializable;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Chandan
 * @see Student
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", standard=");
		sb.append(standard);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}

	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		if (uuid == null) {
			studentImpl.setUuid(StringPool.BLANK);
		}
		else {
			studentImpl.setUuid(uuid);
		}

		studentImpl.setStudentId(studentId);

		if (name == null) {
			studentImpl.setName(StringPool.BLANK);
		}
		else {
			studentImpl.setName(name);
		}

		if (standard == null) {
			studentImpl.setStandard(StringPool.BLANK);
		}
		else {
			studentImpl.setStandard(standard);
		}

		if (address == null) {
			studentImpl.setAddress(StringPool.BLANK);
		}
		else {
			studentImpl.setAddress(address);
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	public String uuid;
	public long studentId;
	public String name;
	public String standard;
	public String address;
}
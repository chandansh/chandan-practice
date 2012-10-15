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

import com.slayer.service.AuthorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Chandan
 */
public class AuthorClp extends BaseModelImpl<Author> implements Author {
	public AuthorClp() {
	}

	public Class<?> getModelClass() {
		return Author.class;
	}

	public String getModelClassName() {
		return Author.class.getName();
	}

	public long getPrimaryKey() {
		return _authorId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAuthorId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_authorId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSpecialization() {
		return _specialization;
	}

	public void setSpecialization(String specialization) {
		_specialization = specialization;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AuthorLocalServiceUtil.addAuthor(this);
		}
		else {
			AuthorLocalServiceUtil.updateAuthor(this);
		}
	}

	@Override
	public Author toEscapedModel() {
		return (Author)Proxy.newProxyInstance(Author.class.getClassLoader(),
			new Class[] { Author.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AuthorClp clone = new AuthorClp();

		clone.setAuthorId(getAuthorId());
		clone.setName(getName());
		clone.setSpecialization(getSpecialization());

		return clone;
	}

	public int compareTo(Author author) {
		long primaryKey = author.getPrimaryKey();

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

		AuthorClp author = null;

		try {
			author = (AuthorClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = author.getPrimaryKey();

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

		sb.append("{authorId=");
		sb.append(getAuthorId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", specialization=");
		sb.append(getSpecialization());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.slayer.model.Author");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specialization</column-name><column-value><![CDATA[");
		sb.append(getSpecialization());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _authorId;
	private String _name;
	private String _specialization;
}
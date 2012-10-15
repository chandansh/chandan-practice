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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Chandan
 */
public class AuthorPostClp extends BaseModelImpl<AuthorPost>
	implements AuthorPost {
	public AuthorPostClp() {
	}

	public Class<?> getModelClass() {
		return AuthorPost.class;
	}

	public String getModelClassName() {
		return AuthorPost.class.getName();
	}

	public long getPrimaryKey() {
		return _authorPostId;
	}

	public void setPrimaryKey(long primaryKey) {
		setAuthorPostId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_authorPostId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getAuthorPostId() {
		return _authorPostId;
	}

	public void setAuthorPostId(long authorPostId) {
		_authorPostId = authorPostId;
	}

	public long getPostId() {
		return _postId;
	}

	public void setPostId(long postId) {
		_postId = postId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
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

	@Override
	public AuthorPost toEscapedModel() {
		return (AuthorPost)Proxy.newProxyInstance(AuthorPost.class.getClassLoader(),
			new Class[] { AuthorPost.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AuthorPostClp clone = new AuthorPostClp();

		clone.setAuthorPostId(getAuthorPostId());
		clone.setPostId(getPostId());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setAuthorId(getAuthorId());
		clone.setName(getName());
		clone.setSpecialization(getSpecialization());

		return clone;
	}

	public int compareTo(AuthorPost authorPost) {
		long primaryKey = authorPost.getPrimaryKey();

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

		AuthorPostClp authorPost = null;

		try {
			authorPost = (AuthorPostClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = authorPost.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{authorPostId=");
		sb.append(getAuthorPostId());
		sb.append(", postId=");
		sb.append(getPostId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", authorId=");
		sb.append(getAuthorId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", specialization=");
		sb.append(getSpecialization());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.slayer.model.AuthorPost");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>authorPostId</column-name><column-value><![CDATA[");
		sb.append(getAuthorPostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postId</column-name><column-value><![CDATA[");
		sb.append(getPostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
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

	private long _authorPostId;
	private long _postId;
	private String _title;
	private String _content;
	private long _authorId;
	private String _name;
	private String _specialization;
}
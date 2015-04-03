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

package com.library.slayer.model;

import com.library.slayer.service.LMSBookJoinLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Ahmed Hasan
 */
public class LMSBookJoinClp extends BaseModelImpl<LMSBookJoin>
	implements LMSBookJoin {
	public LMSBookJoinClp() {
	}

	public Class<?> getModelClass() {
		return LMSBookJoin.class;
	}

	public String getModelClassName() {
		return LMSBookJoin.class.getName();
	}

	public long getPrimaryKey() {
		return _joinId;
	}

	public void setPrimaryKey(long primaryKey) {
		setJoinId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_joinId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getJoinId() {
		return _joinId;
	}

	public void setJoinId(long joinId) {
		_joinId = joinId;
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getBookTitle() {
		return _bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		_bookTitle = bookTitle;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LMSBookJoinLocalServiceUtil.addLMSBookJoin(this);
		}
		else {
			LMSBookJoinLocalServiceUtil.updateLMSBookJoin(this);
		}
	}

	@Override
	public LMSBookJoin toEscapedModel() {
		return (LMSBookJoin)Proxy.newProxyInstance(LMSBookJoin.class.getClassLoader(),
			new Class[] { LMSBookJoin.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LMSBookJoinClp clone = new LMSBookJoinClp();

		clone.setJoinId(getJoinId());
		clone.setBookId(getBookId());
		clone.setUserId(getUserId());
		clone.setBookTitle(getBookTitle());
		clone.setAuthor(getAuthor());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setCity(getCity());
		clone.setZip(getZip());
		clone.setEmailAddress(getEmailAddress());

		return clone;
	}

	public int compareTo(LMSBookJoin lmsBookJoin) {
		long primaryKey = lmsBookJoin.getPrimaryKey();

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

		LMSBookJoinClp lmsBookJoin = null;

		try {
			lmsBookJoin = (LMSBookJoinClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = lmsBookJoin.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{joinId=");
		sb.append(getJoinId());
		sb.append(", bookId=");
		sb.append(getBookId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", bookTitle=");
		sb.append(getBookTitle());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", zip=");
		sb.append(getZip());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.library.slayer.model.LMSBookJoin");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>joinId</column-name><column-value><![CDATA[");
		sb.append(getJoinId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookTitle</column-name><column-value><![CDATA[");
		sb.append(getBookTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zip</column-name><column-value><![CDATA[");
		sb.append(getZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _joinId;
	private long _bookId;
	private long _userId;
	private String _userUuid;
	private String _bookTitle;
	private String _author;
	private String _firstName;
	private String _lastName;
	private String _city;
	private String _zip;
	private String _emailAddress;
}
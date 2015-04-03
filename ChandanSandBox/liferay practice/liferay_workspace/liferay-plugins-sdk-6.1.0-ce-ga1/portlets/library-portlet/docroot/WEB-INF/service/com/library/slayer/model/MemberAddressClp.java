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

import com.library.slayer.service.MemberAddressLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Ahmed Hasan
 */
public class MemberAddressClp extends BaseModelImpl<MemberAddress>
	implements MemberAddress {
	public MemberAddressClp() {
	}

	public Class<?> getModelClass() {
		return MemberAddress.class;
	}

	public String getModelClassName() {
		return MemberAddress.class.getName();
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public String getStreetAddress1() {
		return _streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		_streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return _streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		_streetAddress2 = streetAddress2;
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

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return _mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		_mobileNumber = mobileNumber;
	}

	public Date getDateAdded() {
		return _dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		_dateAdded = dateAdded;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			MemberAddressLocalServiceUtil.addMemberAddress(this);
		}
		else {
			MemberAddressLocalServiceUtil.updateMemberAddress(this);
		}
	}

	@Override
	public MemberAddress toEscapedModel() {
		return (MemberAddress)Proxy.newProxyInstance(MemberAddress.class.getClassLoader(),
			new Class[] { MemberAddress.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MemberAddressClp clone = new MemberAddressClp();

		clone.setUserId(getUserId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setStreetAddress1(getStreetAddress1());
		clone.setStreetAddress2(getStreetAddress2());
		clone.setCity(getCity());
		clone.setZip(getZip());
		clone.setEmailAddress(getEmailAddress());
		clone.setPhoneNumber(getPhoneNumber());
		clone.setMobileNumber(getMobileNumber());
		clone.setDateAdded(getDateAdded());

		return clone;
	}

	public int compareTo(MemberAddress memberAddress) {
		long primaryKey = memberAddress.getPrimaryKey();

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

		MemberAddressClp memberAddress = null;

		try {
			memberAddress = (MemberAddressClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = memberAddress.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", streetAddress1=");
		sb.append(getStreetAddress1());
		sb.append(", streetAddress2=");
		sb.append(getStreetAddress2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", zip=");
		sb.append(getZip());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(", mobileNumber=");
		sb.append(getMobileNumber());
		sb.append(", dateAdded=");
		sb.append(getDateAdded());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.library.slayer.model.MemberAddress");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>streetAddress1</column-name><column-value><![CDATA[");
		sb.append(getStreetAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>streetAddress2</column-name><column-value><![CDATA[");
		sb.append(getStreetAddress2());
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
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobileNumber</column-name><column-value><![CDATA[");
		sb.append(getMobileNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateAdded</column-name><column-value><![CDATA[");
		sb.append(getDateAdded());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private String _firstName;
	private String _lastName;
	private String _streetAddress1;
	private String _streetAddress2;
	private String _city;
	private String _zip;
	private String _emailAddress;
	private String _phoneNumber;
	private String _mobileNumber;
	private Date _dateAdded;
}
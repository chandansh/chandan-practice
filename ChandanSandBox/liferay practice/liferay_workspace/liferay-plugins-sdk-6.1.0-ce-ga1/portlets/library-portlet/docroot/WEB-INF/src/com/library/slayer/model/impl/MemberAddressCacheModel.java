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

package com.library.slayer.model.impl;

import com.library.slayer.model.MemberAddress;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing MemberAddress in entity cache.
 *
 * @author Ahmed Hasan
 * @see MemberAddress
 * @generated
 */
public class MemberAddressCacheModel implements CacheModel<MemberAddress>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", streetAddress1=");
		sb.append(streetAddress1);
		sb.append(", streetAddress2=");
		sb.append(streetAddress2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", dateAdded=");
		sb.append(dateAdded);
		sb.append("}");

		return sb.toString();
	}

	public MemberAddress toEntityModel() {
		MemberAddressImpl memberAddressImpl = new MemberAddressImpl();

		memberAddressImpl.setUserId(userId);

		if (firstName == null) {
			memberAddressImpl.setFirstName(StringPool.BLANK);
		}
		else {
			memberAddressImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			memberAddressImpl.setLastName(StringPool.BLANK);
		}
		else {
			memberAddressImpl.setLastName(lastName);
		}

		if (streetAddress1 == null) {
			memberAddressImpl.setStreetAddress1(StringPool.BLANK);
		}
		else {
			memberAddressImpl.setStreetAddress1(streetAddress1);
		}

		if (streetAddress2 == null) {
			memberAddressImpl.setStreetAddress2(StringPool.BLANK);
		}
		else {
			memberAddressImpl.setStreetAddress2(streetAddress2);
		}

		if (city == null) {
			memberAddressImpl.setCity(StringPool.BLANK);
		}
		else {
			memberAddressImpl.setCity(city);
		}

		if (zip == null) {
			memberAddressImpl.setZip(StringPool.BLANK);
		}
		else {
			memberAddressImpl.setZip(zip);
		}

		if (emailAddress == null) {
			memberAddressImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			memberAddressImpl.setEmailAddress(emailAddress);
		}

		if (phoneNumber == null) {
			memberAddressImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			memberAddressImpl.setPhoneNumber(phoneNumber);
		}

		if (mobileNumber == null) {
			memberAddressImpl.setMobileNumber(StringPool.BLANK);
		}
		else {
			memberAddressImpl.setMobileNumber(mobileNumber);
		}

		if (dateAdded == Long.MIN_VALUE) {
			memberAddressImpl.setDateAdded(null);
		}
		else {
			memberAddressImpl.setDateAdded(new Date(dateAdded));
		}

		memberAddressImpl.resetOriginalValues();

		return memberAddressImpl;
	}

	public long userId;
	public String firstName;
	public String lastName;
	public String streetAddress1;
	public String streetAddress2;
	public String city;
	public String zip;
	public String emailAddress;
	public String phoneNumber;
	public String mobileNumber;
	public long dateAdded;
}
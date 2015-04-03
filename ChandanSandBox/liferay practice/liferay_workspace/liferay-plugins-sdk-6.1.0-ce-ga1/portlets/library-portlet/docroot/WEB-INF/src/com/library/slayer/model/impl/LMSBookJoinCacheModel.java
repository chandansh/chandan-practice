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

import com.library.slayer.model.LMSBookJoin;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing LMSBookJoin in entity cache.
 *
 * @author Ahmed Hasan
 * @see LMSBookJoin
 * @generated
 */
public class LMSBookJoinCacheModel implements CacheModel<LMSBookJoin>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{joinId=");
		sb.append(joinId);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", bookTitle=");
		sb.append(bookTitle);
		sb.append(", author=");
		sb.append(author);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append("}");

		return sb.toString();
	}

	public LMSBookJoin toEntityModel() {
		LMSBookJoinImpl lmsBookJoinImpl = new LMSBookJoinImpl();

		lmsBookJoinImpl.setJoinId(joinId);
		lmsBookJoinImpl.setBookId(bookId);
		lmsBookJoinImpl.setUserId(userId);

		if (bookTitle == null) {
			lmsBookJoinImpl.setBookTitle(StringPool.BLANK);
		}
		else {
			lmsBookJoinImpl.setBookTitle(bookTitle);
		}

		if (author == null) {
			lmsBookJoinImpl.setAuthor(StringPool.BLANK);
		}
		else {
			lmsBookJoinImpl.setAuthor(author);
		}

		if (firstName == null) {
			lmsBookJoinImpl.setFirstName(StringPool.BLANK);
		}
		else {
			lmsBookJoinImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			lmsBookJoinImpl.setLastName(StringPool.BLANK);
		}
		else {
			lmsBookJoinImpl.setLastName(lastName);
		}

		if (city == null) {
			lmsBookJoinImpl.setCity(StringPool.BLANK);
		}
		else {
			lmsBookJoinImpl.setCity(city);
		}

		if (zip == null) {
			lmsBookJoinImpl.setZip(StringPool.BLANK);
		}
		else {
			lmsBookJoinImpl.setZip(zip);
		}

		if (emailAddress == null) {
			lmsBookJoinImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			lmsBookJoinImpl.setEmailAddress(emailAddress);
		}

		lmsBookJoinImpl.resetOriginalValues();

		return lmsBookJoinImpl;
	}

	public long joinId;
	public long bookId;
	public long userId;
	public String bookTitle;
	public String author;
	public String firstName;
	public String lastName;
	public String city;
	public String zip;
	public String emailAddress;
}
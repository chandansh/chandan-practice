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

import com.library.slayer.model.LMSBook;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LMSBook in entity cache.
 *
 * @author Ahmed Hasan
 * @see LMSBook
 * @generated
 */
public class LMSBookCacheModel implements CacheModel<LMSBook>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append(", bookTitle=");
		sb.append(bookTitle);
		sb.append(", author=");
		sb.append(author);
		sb.append(", description=");
		sb.append(description);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", downloaded=");
		sb.append(downloaded);
		sb.append(", status=");
		sb.append(status);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append("}");

		return sb.toString();
	}

	public LMSBook toEntityModel() {
		LMSBookImpl lmsBookImpl = new LMSBookImpl();

		if (uuid == null) {
			lmsBookImpl.setUuid(StringPool.BLANK);
		}
		else {
			lmsBookImpl.setUuid(uuid);
		}

		lmsBookImpl.setBookId(bookId);

		if (bookTitle == null) {
			lmsBookImpl.setBookTitle(StringPool.BLANK);
		}
		else {
			lmsBookImpl.setBookTitle(bookTitle);
		}

		if (author == null) {
			lmsBookImpl.setAuthor(StringPool.BLANK);
		}
		else {
			lmsBookImpl.setAuthor(author);
		}

		if (description == null) {
			lmsBookImpl.setDescription(StringPool.BLANK);
		}
		else {
			lmsBookImpl.setDescription(description);
		}

		if (fileName == null) {
			lmsBookImpl.setFileName(StringPool.BLANK);
		}
		else {
			lmsBookImpl.setFileName(fileName);
		}

		lmsBookImpl.setDownloaded(downloaded);
		lmsBookImpl.setStatus(status);
		lmsBookImpl.setCompanyId(companyId);
		lmsBookImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			lmsBookImpl.setCreateDate(null);
		}
		else {
			lmsBookImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lmsBookImpl.setModifiedDate(null);
		}
		else {
			lmsBookImpl.setModifiedDate(new Date(modifiedDate));
		}

		lmsBookImpl.setUserId(userId);

		if (userName == null) {
			lmsBookImpl.setUserName(StringPool.BLANK);
		}
		else {
			lmsBookImpl.setUserName(userName);
		}

		lmsBookImpl.resetOriginalValues();

		return lmsBookImpl;
	}

	public String uuid;
	public long bookId;
	public String bookTitle;
	public String author;
	public String description;
	public String fileName;
	public int downloaded;
	public int status;
	public long companyId;
	public long groupId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String userName;
}
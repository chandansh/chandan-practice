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

package com.mpower.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.mpower.services.model.Book;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Meenu
 * @see Book
 * @generated
 */
public class BookCacheModel implements CacheModel<Book>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", bookNumber=");
		sb.append(bookNumber);
		sb.append(", writerName=");
		sb.append(writerName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", totalCost=");
		sb.append(totalCost);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public Book toEntityModel() {
		BookImpl bookImpl = new BookImpl();

		bookImpl.setBookId(bookId);
		bookImpl.setBookNumber(bookNumber);

		if (writerName == null) {
			bookImpl.setWriterName(StringPool.BLANK);
		}
		else {
			bookImpl.setWriterName(writerName);
		}

		if (createDate == Long.MIN_VALUE) {
			bookImpl.setCreateDate(null);
		}
		else {
			bookImpl.setCreateDate(new Date(createDate));
		}

		if (firstName == null) {
			bookImpl.setFirstName(StringPool.BLANK);
		}
		else {
			bookImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			bookImpl.setLastName(StringPool.BLANK);
		}
		else {
			bookImpl.setLastName(lastName);
		}

		bookImpl.setQuantity(quantity);
		bookImpl.setTotalCost(totalCost);

		if (status == null) {
			bookImpl.setStatus(StringPool.BLANK);
		}
		else {
			bookImpl.setStatus(status);
		}

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	public long bookId;
	public long bookNumber;
	public String writerName;
	public long createDate;
	public String firstName;
	public String lastName;
	public int quantity;
	public double totalCost;
	public String status;
}
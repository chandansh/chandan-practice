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

import com.library.slayer.model.LIBBook;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing LIBBook in entity cache.
 *
 * @author veena
 * @see LIBBook
 * @generated
 */
public class LIBBookCacheModel implements CacheModel<LIBBook>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", bookTitle=");
		sb.append(bookTitle);
		sb.append(", author=");
		sb.append(author);
		sb.append("}");

		return sb.toString();
	}

	public LIBBook toEntityModel() {
		LIBBookImpl libBookImpl = new LIBBookImpl();

		libBookImpl.setBookId(bookId);

		if (bookTitle == null) {
			libBookImpl.setBookTitle(StringPool.BLANK);
		}
		else {
			libBookImpl.setBookTitle(bookTitle);
		}

		if (author == null) {
			libBookImpl.setAuthor(StringPool.BLANK);
		}
		else {
			libBookImpl.setAuthor(author);
		}

		libBookImpl.resetOriginalValues();

		return libBookImpl;
	}

	public long bookId;
	public String bookTitle;
	public String author;
}
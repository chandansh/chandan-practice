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

package com.library.slayer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LMSBookService}.
 * </p>
 *
 * @author    Ahmed Hasan
 * @see       LMSBookService
 * @generated
 */
public class LMSBookServiceWrapper implements LMSBookService,
	ServiceWrapper<LMSBookService> {
	public LMSBookServiceWrapper(LMSBookService lmsBookService) {
		_lmsBookService = lmsBookService;
	}

	public com.library.slayer.model.LMSBook addLibraryBook(
		java.lang.String bookTitle, java.lang.String author,
		java.lang.String groupId) {
		return _lmsBookService.addLibraryBook(bookTitle, author, groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LMSBookService getWrappedLMSBookService() {
		return _lmsBookService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLMSBookService(LMSBookService lmsBookService) {
		_lmsBookService = lmsBookService;
	}

	public LMSBookService getWrappedService() {
		return _lmsBookService;
	}

	public void setWrappedService(LMSBookService lmsBookService) {
		_lmsBookService = lmsBookService;
	}

	private LMSBookService _lmsBookService;
}
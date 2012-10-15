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

package com.mpower.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BookService}.
 * </p>
 *
 * @author    Meenu
 * @see       BookService
 * @generated
 */
public class BookServiceWrapper implements BookService,
	ServiceWrapper<BookService> {
	public BookServiceWrapper(BookService bookService) {
		_bookService = bookService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BookService getWrappedBookService() {
		return _bookService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBookService(BookService bookService) {
		_bookService = bookService;
	}

	public BookService getWrappedService() {
		return _bookService;
	}

	public void setWrappedService(BookService bookService) {
		_bookService = bookService;
	}

	private BookService _bookService;
}
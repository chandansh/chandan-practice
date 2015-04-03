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

package com.slayer;

import com.liferay.portal.NoSuchModelException;

/**
 * @author ahmedhasan
 */
public class NoSuchShoppingCategoryExtException extends NoSuchModelException {

	public NoSuchShoppingCategoryExtException() {
		super();
	}

	public NoSuchShoppingCategoryExtException(String msg) {
		super(msg);
	}

	public NoSuchShoppingCategoryExtException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchShoppingCategoryExtException(Throwable cause) {
		super(cause);
	}

}
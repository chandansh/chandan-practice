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

package com.test.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link MyStudentService}.
 * </p>
 *
 * @author    Chandan
 * @see       MyStudentService
 * @generated
 */
public class MyStudentServiceWrapper implements MyStudentService,
	ServiceWrapper<MyStudentService> {
	public MyStudentServiceWrapper(MyStudentService myStudentService) {
		_myStudentService = myStudentService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public MyStudentService getWrappedMyStudentService() {
		return _myStudentService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedMyStudentService(MyStudentService myStudentService) {
		_myStudentService = myStudentService;
	}

	public MyStudentService getWrappedService() {
		return _myStudentService;
	}

	public void setWrappedService(MyStudentService myStudentService) {
		_myStudentService = myStudentService;
	}

	private MyStudentService _myStudentService;
}
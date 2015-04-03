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

package com.liferay.test.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeService}.
 * </p>
 *
 * @author    Chandan
 * @see       EmployeeService
 * @generated
 */
public class EmployeeServiceWrapper implements EmployeeService,
	ServiceWrapper<EmployeeService> {
	public EmployeeServiceWrapper(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	public com.liferay.test.model.Employee create(
		com.liferay.test.model.Employee model)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeService.create(model);
	}

	public com.liferay.test.model.Employee update(
		com.liferay.test.model.Employee model)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.NoSuchEmployeeException {
		return _employeeService.update(model);
	}

	public java.util.List<com.liferay.test.model.Employee> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeService.findByName(name);
	}

	public com.liferay.test.model.Employee remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.NoSuchEmployeeException {
		return _employeeService.remove(id);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EmployeeService getWrappedEmployeeService() {
		return _employeeService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEmployeeService(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	public EmployeeService getWrappedService() {
		return _employeeService;
	}

	public void setWrappedService(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	private EmployeeService _employeeService;
}
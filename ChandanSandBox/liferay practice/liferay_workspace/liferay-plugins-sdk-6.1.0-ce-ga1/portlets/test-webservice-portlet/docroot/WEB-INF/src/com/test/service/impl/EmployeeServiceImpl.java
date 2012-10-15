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

package com.test.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.test.NoSuchEmployeeException;
import com.test.model.Employee;
import com.test.service.EmployeeLocalServiceUtil;
import com.test.service.base.EmployeeServiceBaseImpl;

/**
 * The implementation of the employee remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.test.service.EmployeeService} interface.
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author Chandan
 * @see com.test.service.base.EmployeeServiceBaseImpl
 * @see com.test.service.EmployeeServiceUtil
 */
public class EmployeeServiceImpl extends EmployeeServiceBaseImpl {
	public Employee create(Employee model) throws SystemException {
		return EmployeeLocalServiceUtil.create(model);
	}

	public Employee update(Employee model) throws NoSuchEmployeeException,
			SystemException {
		return EmployeeLocalServiceUtil.update(model);
	}

	public List<Employee> findByName(String name) throws SystemException {
		return EmployeeLocalServiceUtil.findByName(name);
	}

	public Employee remove(long id) throws NoSuchEmployeeException,
			SystemException {
		return EmployeeLocalServiceUtil.remove(id);
	}
}
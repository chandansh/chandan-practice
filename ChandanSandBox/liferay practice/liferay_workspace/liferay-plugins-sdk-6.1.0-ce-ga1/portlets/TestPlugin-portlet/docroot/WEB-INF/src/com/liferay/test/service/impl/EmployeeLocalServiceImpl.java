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

package com.liferay.test.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.test.NoSuchEmployeeException;
import com.liferay.test.model.Employee;
import com.liferay.test.service.base.EmployeeLocalServiceBaseImpl;
import com.liferay.test.service.persistence.EmployeeUtil;

/**
 * The implementation of the employee local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.test.service.EmployeeLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Chandan
 * @see com.liferay.test.service.base.EmployeeLocalServiceBaseImpl
 * @see com.liferay.test.service.EmployeeLocalServiceUtil
 */
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	public Employee create(Employee model) throws SystemException {
		long id = CounterLocalServiceUtil.increment(Employee.class.getName());
		model.setId(id);
		Employee newModel = EmployeeUtil.create(model.getId());

		newModel.setName(model.getName());
		EmployeeUtil.update(newModel, true);
		return newModel;
	}

	public Employee update(Employee model) throws NoSuchEmployeeException,
			SystemException {
		Employee newModel = EmployeeUtil.findByPrimaryKey(model.getId());

		newModel.setName(model.getName());

		EmployeeUtil.update(newModel, true);

		return newModel;
	}

	public List<Employee> findByName(String name) throws SystemException {
		return EmployeeUtil.findByName(name);
	}

	public Employee remove(long id) throws NoSuchEmployeeException,
			SystemException {
		return EmployeeUtil.remove(id);
	}
}
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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the employee remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Chandan
 * @see EmployeeServiceUtil
 * @see com.liferay.test.service.base.EmployeeServiceBaseImpl
 * @see com.liferay.test.service.impl.EmployeeServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EmployeeService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeServiceUtil} to access the employee remote service. Add custom service methods to {@link com.liferay.test.service.impl.EmployeeServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.liferay.test.model.Employee create(
		com.liferay.test.model.Employee model)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.test.model.Employee update(
		com.liferay.test.model.Employee model)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.NoSuchEmployeeException;

	public java.util.List<com.liferay.test.model.Employee> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.test.model.Employee remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.NoSuchEmployeeException;
}
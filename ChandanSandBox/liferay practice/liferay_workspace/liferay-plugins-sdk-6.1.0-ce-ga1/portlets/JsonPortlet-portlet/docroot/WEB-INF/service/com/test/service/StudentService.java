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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the student remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Chandan
 * @see StudentServiceUtil
 * @see com.test.service.base.StudentServiceBaseImpl
 * @see com.test.service.impl.StudentServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface StudentService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentServiceUtil} to access the student remote service. Add custom service methods to {@link com.test.service.impl.StudentServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.test.model.Student insert(long studentId, java.lang.String name,
		java.lang.String standard, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.test.model.Student update(long studentId, java.lang.String name,
		java.lang.String standard, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.test.model.Student> getAllStudent()
		throws com.liferay.portal.kernel.exception.SystemException;
}
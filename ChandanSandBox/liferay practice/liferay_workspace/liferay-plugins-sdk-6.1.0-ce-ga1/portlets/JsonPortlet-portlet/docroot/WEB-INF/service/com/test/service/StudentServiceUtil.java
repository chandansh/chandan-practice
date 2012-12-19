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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the student remote service. This utility wraps {@link com.test.service.impl.StudentServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Chandan
 * @see StudentService
 * @see com.test.service.base.StudentServiceBaseImpl
 * @see com.test.service.impl.StudentServiceImpl
 * @generated
 */
public class StudentServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.test.service.impl.StudentServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.test.model.Student insert(long studentId,
		java.lang.String name, java.lang.String standard,
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().insert(studentId, name, standard, address);
	}

	public static com.test.model.Student update(long studentId,
		java.lang.String name, java.lang.String standard,
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().update(studentId, name, standard, address);
	}

	public static void deleteStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteStudent(studentId);
	}

	public static java.util.List<com.test.model.Student> getAllStudent()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllStudent();
	}

	public static void clearService() {
		_service = null;
	}

	public static StudentService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StudentService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					StudentService.class.getName(), portletClassLoader);

			_service = new StudentServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(StudentServiceUtil.class,
				"_service");
			MethodCache.remove(StudentService.class);
		}

		return _service;
	}

	public void setService(StudentService service) {
		MethodCache.remove(StudentService.class);

		_service = service;

		ReferenceRegistry.registerReference(StudentServiceUtil.class, "_service");
		MethodCache.remove(StudentService.class);
	}

	private static StudentService _service;
}
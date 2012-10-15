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
 * The utility for the employee remote service. This utility wraps {@link com.test.service.impl.EmployeeServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Chandan
 * @see EmployeeService
 * @see com.test.service.base.EmployeeServiceBaseImpl
 * @see com.test.service.impl.EmployeeServiceImpl
 * @generated
 */
public class EmployeeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.test.service.impl.EmployeeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.test.model.Employee create(com.test.model.Employee model)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create(model);
	}

	public static com.test.model.Employee update(com.test.model.Employee model)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.test.NoSuchEmployeeException {
		return getService().update(model);
	}

	public static java.util.List<com.test.model.Employee> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByName(name);
	}

	public static com.test.model.Employee remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.test.NoSuchEmployeeException {
		return getService().remove(id);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmployeeService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmployeeService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					EmployeeService.class.getName(), portletClassLoader);

			_service = new EmployeeServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(EmployeeServiceUtil.class,
				"_service");
			MethodCache.remove(EmployeeService.class);
		}

		return _service;
	}

	public void setService(EmployeeService service) {
		MethodCache.remove(EmployeeService.class);

		_service = service;

		ReferenceRegistry.registerReference(EmployeeServiceUtil.class,
			"_service");
		MethodCache.remove(EmployeeService.class);
	}

	private static EmployeeService _service;
}
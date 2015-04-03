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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Chandan
 */
public class EmployeeServiceClp implements EmployeeService {
	public EmployeeServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_createMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"create", com.liferay.test.model.Employee.class);

		_updateMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"update", com.liferay.test.model.Employee.class);

		_findByNameMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByName", java.lang.String.class);

		_removeMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"remove", long.class);
	}

	public com.liferay.test.model.Employee create(
		com.liferay.test.model.Employee model)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createMethodKey0,
				ClpSerializer.translateInput(model));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.test.model.Employee)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.test.model.Employee update(
		com.liferay.test.model.Employee model)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.NoSuchEmployeeException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateMethodKey1,
				ClpSerializer.translateInput(model));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.test.NoSuchEmployeeException) {
				throw (com.liferay.test.NoSuchEmployeeException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.test.model.Employee)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.liferay.test.model.Employee> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByNameMethodKey2,
				ClpSerializer.translateInput(name));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.test.model.Employee>)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.test.model.Employee remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.NoSuchEmployeeException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_removeMethodKey3, id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.test.NoSuchEmployeeException) {
				throw (com.liferay.test.NoSuchEmployeeException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.test.model.Employee)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _createMethodKey0;
	private MethodKey _updateMethodKey1;
	private MethodKey _findByNameMethodKey2;
	private MethodKey _removeMethodKey3;
}
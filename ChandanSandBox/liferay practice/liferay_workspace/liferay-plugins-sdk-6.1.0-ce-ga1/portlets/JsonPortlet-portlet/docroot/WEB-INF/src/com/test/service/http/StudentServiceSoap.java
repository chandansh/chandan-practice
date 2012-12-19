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

package com.test.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.test.service.StudentServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.test.service.StudentServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.test.model.StudentSoap}.
 * If the method in the service utility returns a
 * {@link com.test.model.Student}, that is translated to a
 * {@link com.test.model.StudentSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Chandan
 * @see       StudentServiceHttp
 * @see       com.test.model.StudentSoap
 * @see       com.test.service.StudentServiceUtil
 * @generated
 */
public class StudentServiceSoap {
	public static com.test.model.StudentSoap insert(long studentId,
		java.lang.String name, java.lang.String standard,
		java.lang.String address) throws RemoteException {
		try {
			com.test.model.Student returnValue = StudentServiceUtil.insert(studentId,
					name, standard, address);

			return com.test.model.StudentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.test.model.StudentSoap update(long studentId,
		java.lang.String name, java.lang.String standard,
		java.lang.String address) throws RemoteException {
		try {
			com.test.model.Student returnValue = StudentServiceUtil.update(studentId,
					name, standard, address);

			return com.test.model.StudentSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteStudent(long studentId) throws RemoteException {
		try {
			StudentServiceUtil.deleteStudent(studentId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.test.model.Student[] getAllStudent()
		throws RemoteException {
		try {
			java.util.List<com.test.model.Student> returnValue = StudentServiceUtil.getAllStudent();

			return returnValue.toArray(new com.test.model.Student[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(StudentServiceSoap.class);
}
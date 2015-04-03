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
 * This class is a wrapper for {@link StudentService}.
 * </p>
 *
 * @author    Chandan
 * @see       StudentService
 * @generated
 */
public class StudentServiceWrapper implements StudentService,
	ServiceWrapper<StudentService> {
	public StudentServiceWrapper(StudentService studentService) {
		_studentService = studentService;
	}

	public com.test.model.Student insert(long studentId, java.lang.String name,
		java.lang.String standard, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentService.insert(studentId, name, standard, address);
	}

	public com.test.model.Student update(long studentId, java.lang.String name,
		java.lang.String standard, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentService.update(studentId, name, standard, address);
	}

	public void deleteStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_studentService.deleteStudent(studentId);
	}

	public java.util.List<com.test.model.Student> getAllStudent()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentService.getAllStudent();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public StudentService getWrappedStudentService() {
		return _studentService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedStudentService(StudentService studentService) {
		_studentService = studentService;
	}

	public StudentService getWrappedService() {
		return _studentService;
	}

	public void setWrappedService(StudentService studentService) {
		_studentService = studentService;
	}

	private StudentService _studentService;
}
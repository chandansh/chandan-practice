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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.test.model.Student;
import com.test.service.base.StudentServiceBaseImpl;

/**
 * The implementation of the student remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.service.StudentService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Chandan
 * @see com.test.service.base.StudentServiceBaseImpl
 * @see com.test.service.StudentServiceUtil
 */
public class StudentServiceImpl extends StudentServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.test.service.StudentServiceUtil} to access the student remote service.
	 */
	public Student insert(long studentId, String name, String standard,
			String address) throws SystemException {
		Student student = studentLocalService.createStudent(studentId);
		student.setName(name);
		student.setAddress(address);
		student.setStandard(standard);
		return studentLocalService.addStudent(student);
	}

	public Student update(long studentId, String name, String standard,
			String address) throws SystemException {
		Student student = null;
		try {
			student = studentLocalService.getStudent(studentId);
			student.setName(name);
			student.setAddress(address);
			student.setStandard(standard);
			student = studentLocalService.updateStudent(student);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return student;
	}

	public void deleteStudent(long studentId) throws PortalException, SystemException {
		studentLocalService.deleteStudent(studentId);
	}
	
	
	public List<Student> getAllStudent() throws SystemException{
		return studentLocalService.getStudents(0, -1);
	}
}
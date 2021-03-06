/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.coleg.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the employee local service. This utility wraps {@link com.coleg.service.impl.EmployeeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.coleg.service.impl.EmployeeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author chandan
 * @see EmployeeLocalService
 * @see com.coleg.service.base.EmployeeLocalServiceBaseImpl
 * @see com.coleg.service.impl.EmployeeLocalServiceImpl
 * @generated
 */
public class EmployeeLocalServiceUtil {
	/**
	* Adds the employee to the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee to add
	* @return the employee that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Employee addEmployee(
		com.coleg.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmployee(employee);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param id the primary key for the new employee
	* @return the new employee
	*/
	public static com.coleg.model.Employee createEmployee(java.lang.String id) {
		return getService().createEmployee(id);
	}

	/**
	* Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the employee to delete
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployee(java.lang.String id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployee(id);
	}

	/**
	* Deletes the employee from the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteEmployee(com.coleg.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteEmployee(employee);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the employee with the primary key.
	*
	* @param id the primary key of the employee to get
	* @return the employee
	* @throws PortalException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Employee getEmployee(java.lang.String id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployee(id);
	}

	/**
	* Gets a range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of employees to return
	* @param end the upper bound of the range of employees to return (not inclusive)
	* @return the range of employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.coleg.model.Employee> getEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(start, end);
	}

	/**
	* Gets the number of employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmployeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployeesCount();
	}

	/**
	* Updates the employee in the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee to update
	* @return the employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Employee updateEmployee(
		com.coleg.model.Employee employee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmployee(employee);
	}

	/**
	* Updates the employee in the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee to update
	* @param merge whether to merge the employee with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the employee that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Employee updateEmployee(
		com.coleg.model.Employee employee, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmployee(employee, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmployeeLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					EmployeeLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new EmployeeLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(EmployeeLocalService service) {
		_service = service;
	}

	private static EmployeeLocalService _service;
}
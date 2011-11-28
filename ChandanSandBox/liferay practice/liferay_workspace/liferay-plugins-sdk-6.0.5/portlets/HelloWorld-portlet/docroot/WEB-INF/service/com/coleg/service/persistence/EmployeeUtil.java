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

package com.coleg.service.persistence;

import com.coleg.model.Employee;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the employee service. This utility wraps {@link EmployeePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author chandan
 * @see EmployeePersistence
 * @see EmployeePersistenceImpl
 * @generated
 */
public class EmployeeUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Employee employee) {
		getPersistence().clearCache(employee);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Employee> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Employee remove(Employee employee) throws SystemException {
		return getPersistence().remove(employee);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Employee update(Employee employee, boolean merge)
		throws SystemException {
		return getPersistence().update(employee, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Employee update(Employee employee, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(employee, merge, serviceContext);
	}

	/**
	* Caches the employee in the entity cache if it is enabled.
	*
	* @param employee the employee to cache
	*/
	public static void cacheResult(com.coleg.model.Employee employee) {
		getPersistence().cacheResult(employee);
	}

	/**
	* Caches the employees in the entity cache if it is enabled.
	*
	* @param employees the employees to cache
	*/
	public static void cacheResult(
		java.util.List<com.coleg.model.Employee> employees) {
		getPersistence().cacheResult(employees);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param id the primary key for the new employee
	* @return the new employee
	*/
	public static com.coleg.model.Employee create(java.lang.String id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the employee to remove
	* @return the employee that was removed
	* @throws com.coleg.NoSuchEmployeeException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Employee remove(java.lang.String id)
		throws com.coleg.NoSuchEmployeeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.coleg.model.Employee updateImpl(
		com.coleg.model.Employee employee, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(employee, merge);
	}

	/**
	* Finds the employee with the primary key or throws a {@link com.coleg.NoSuchEmployeeException} if it could not be found.
	*
	* @param id the primary key of the employee to find
	* @return the employee
	* @throws com.coleg.NoSuchEmployeeException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Employee findByPrimaryKey(java.lang.String id)
		throws com.coleg.NoSuchEmployeeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Finds the employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the employee to find
	* @return the employee, or <code>null</code> if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Employee fetchByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Finds all the employees.
	*
	* @return the employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.coleg.model.Employee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the employees.
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
	public static java.util.List<com.coleg.model.Employee> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of employees to return
	* @param end the upper bound of the range of employees to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of employees
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.coleg.model.Employee> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmployeePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmployeePersistence)PortletBeanLocatorUtil.locate(com.coleg.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					EmployeePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(EmployeePersistence persistence) {
		_persistence = persistence;
	}

	private static EmployeePersistence _persistence;
}
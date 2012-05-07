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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the employee service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link EmployeeUtil} to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author supriya
 * @see EmployeePersistenceImpl
 * @see EmployeeUtil
 * @generated
 */
public interface EmployeePersistence extends BasePersistence<Employee> {
	/**
	* Caches the employee in the entity cache if it is enabled.
	*
	* @param employee the employee to cache
	*/
	public void cacheResult(com.coleg.model.Employee employee);

	/**
	* Caches the employees in the entity cache if it is enabled.
	*
	* @param employees the employees to cache
	*/
	public void cacheResult(java.util.List<com.coleg.model.Employee> employees);

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param id the primary key for the new employee
	* @return the new employee
	*/
	public com.coleg.model.Employee create(java.lang.String id);

	/**
	* Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the employee to remove
	* @return the employee that was removed
	* @throws com.coleg.NoSuchEmployeeException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.coleg.model.Employee remove(java.lang.String id)
		throws com.coleg.NoSuchEmployeeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.coleg.model.Employee updateImpl(
		com.coleg.model.Employee employee, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the employee with the primary key or throws a {@link com.coleg.NoSuchEmployeeException} if it could not be found.
	*
	* @param id the primary key of the employee to find
	* @return the employee
	* @throws com.coleg.NoSuchEmployeeException if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.coleg.model.Employee findByPrimaryKey(java.lang.String id)
		throws com.coleg.NoSuchEmployeeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the employee to find
	* @return the employee, or <code>null</code> if a employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.coleg.model.Employee fetchByPrimaryKey(java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the employees.
	*
	* @return the employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.coleg.model.Employee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.coleg.model.Employee> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.coleg.model.Employee> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the employees.
	*
	* @return the number of employees
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
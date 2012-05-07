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

import com.coleg.model.Emp;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the emp service. This utility wraps {@link EmpPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see EmpPersistence
 * @see EmpPersistenceImpl
 * @generated
 */
public class EmpUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Emp emp) {
		getPersistence().clearCache(emp);
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
	public static List<Emp> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Emp> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Emp> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Emp remove(Emp emp) throws SystemException {
		return getPersistence().remove(emp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Emp update(Emp emp, boolean merge) throws SystemException {
		return getPersistence().update(emp, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Emp update(Emp emp, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(emp, merge, serviceContext);
	}

	/**
	* Caches the emp in the entity cache if it is enabled.
	*
	* @param emp the emp to cache
	*/
	public static void cacheResult(com.coleg.model.Emp emp) {
		getPersistence().cacheResult(emp);
	}

	/**
	* Caches the emps in the entity cache if it is enabled.
	*
	* @param emps the emps to cache
	*/
	public static void cacheResult(java.util.List<com.coleg.model.Emp> emps) {
		getPersistence().cacheResult(emps);
	}

	/**
	* Creates a new emp with the primary key. Does not add the emp to the database.
	*
	* @param empId the primary key for the new emp
	* @return the new emp
	*/
	public static com.coleg.model.Emp create(java.lang.String empId) {
		return getPersistence().create(empId);
	}

	/**
	* Removes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empId the primary key of the emp to remove
	* @return the emp that was removed
	* @throws com.coleg.NoSuchEmpException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Emp remove(java.lang.String empId)
		throws com.coleg.NoSuchEmpException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(empId);
	}

	public static com.coleg.model.Emp updateImpl(com.coleg.model.Emp emp,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(emp, merge);
	}

	/**
	* Finds the emp with the primary key or throws a {@link com.coleg.NoSuchEmpException} if it could not be found.
	*
	* @param empId the primary key of the emp to find
	* @return the emp
	* @throws com.coleg.NoSuchEmpException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Emp findByPrimaryKey(java.lang.String empId)
		throws com.coleg.NoSuchEmpException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(empId);
	}

	/**
	* Finds the emp with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empId the primary key of the emp to find
	* @return the emp, or <code>null</code> if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Emp fetchByPrimaryKey(java.lang.String empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empId);
	}

	/**
	* Finds all the emps.
	*
	* @return the emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.coleg.model.Emp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the emps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of emps to return
	* @param end the upper bound of the range of emps to return (not inclusive)
	* @return the range of emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.coleg.model.Emp> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the emps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of emps to return
	* @param end the upper bound of the range of emps to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.coleg.model.Emp> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the emps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the emps.
	*
	* @return the number of emps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpPersistence)PortletBeanLocatorUtil.locate(com.coleg.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					EmpPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(EmpPersistence persistence) {
		_persistence = persistence;
	}

	private static EmpPersistence _persistence;
}
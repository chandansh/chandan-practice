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

package com.library.slayer.service.persistence;

import com.library.slayer.model.LMSBookJoin;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l m s book join service. This utility wraps {@link LMSBookJoinPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmed Hasan
 * @see LMSBookJoinPersistence
 * @see LMSBookJoinPersistenceImpl
 * @generated
 */
public class LMSBookJoinUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(LMSBookJoin lmsBookJoin) {
		getPersistence().clearCache(lmsBookJoin);
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
	public static List<LMSBookJoin> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LMSBookJoin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LMSBookJoin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LMSBookJoin update(LMSBookJoin lmsBookJoin, boolean merge)
		throws SystemException {
		return getPersistence().update(lmsBookJoin, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LMSBookJoin update(LMSBookJoin lmsBookJoin, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lmsBookJoin, merge, serviceContext);
	}

	/**
	* Caches the l m s book join in the entity cache if it is enabled.
	*
	* @param lmsBookJoin the l m s book join
	*/
	public static void cacheResult(
		com.library.slayer.model.LMSBookJoin lmsBookJoin) {
		getPersistence().cacheResult(lmsBookJoin);
	}

	/**
	* Caches the l m s book joins in the entity cache if it is enabled.
	*
	* @param lmsBookJoins the l m s book joins
	*/
	public static void cacheResult(
		java.util.List<com.library.slayer.model.LMSBookJoin> lmsBookJoins) {
		getPersistence().cacheResult(lmsBookJoins);
	}

	/**
	* Creates a new l m s book join with the primary key. Does not add the l m s book join to the database.
	*
	* @param joinId the primary key for the new l m s book join
	* @return the new l m s book join
	*/
	public static com.library.slayer.model.LMSBookJoin create(long joinId) {
		return getPersistence().create(joinId);
	}

	/**
	* Removes the l m s book join with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param joinId the primary key of the l m s book join
	* @return the l m s book join that was removed
	* @throws com.library.slayer.NoSuchBookJoinException if a l m s book join with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LMSBookJoin remove(long joinId)
		throws com.library.slayer.NoSuchBookJoinException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(joinId);
	}

	public static com.library.slayer.model.LMSBookJoin updateImpl(
		com.library.slayer.model.LMSBookJoin lmsBookJoin, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lmsBookJoin, merge);
	}

	/**
	* Returns the l m s book join with the primary key or throws a {@link com.library.slayer.NoSuchBookJoinException} if it could not be found.
	*
	* @param joinId the primary key of the l m s book join
	* @return the l m s book join
	* @throws com.library.slayer.NoSuchBookJoinException if a l m s book join with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LMSBookJoin findByPrimaryKey(
		long joinId)
		throws com.library.slayer.NoSuchBookJoinException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(joinId);
	}

	/**
	* Returns the l m s book join with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param joinId the primary key of the l m s book join
	* @return the l m s book join, or <code>null</code> if a l m s book join with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LMSBookJoin fetchByPrimaryKey(
		long joinId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(joinId);
	}

	/**
	* Returns all the l m s book joins.
	*
	* @return the l m s book joins
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.library.slayer.model.LMSBookJoin> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the l m s book joins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l m s book joins
	* @param end the upper bound of the range of l m s book joins (not inclusive)
	* @return the range of l m s book joins
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.library.slayer.model.LMSBookJoin> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the l m s book joins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l m s book joins
	* @param end the upper bound of the range of l m s book joins (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l m s book joins
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.library.slayer.model.LMSBookJoin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l m s book joins from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l m s book joins.
	*
	* @return the number of l m s book joins
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LMSBookJoinPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LMSBookJoinPersistence)PortletBeanLocatorUtil.locate(com.library.slayer.service.ClpSerializer.getServletContextName(),
					LMSBookJoinPersistence.class.getName());

			ReferenceRegistry.registerReference(LMSBookJoinUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(LMSBookJoinPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(LMSBookJoinUtil.class,
			"_persistence");
	}

	private static LMSBookJoinPersistence _persistence;
}
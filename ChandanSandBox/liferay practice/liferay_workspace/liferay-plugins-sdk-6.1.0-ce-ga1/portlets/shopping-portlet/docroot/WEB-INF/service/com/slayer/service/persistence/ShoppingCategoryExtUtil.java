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

package com.slayer.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.slayer.model.ShoppingCategoryExt;

import java.util.List;

/**
 * The persistence utility for the shopping category ext service. This utility wraps {@link ShoppingCategoryExtPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ahmedhasan
 * @see ShoppingCategoryExtPersistence
 * @see ShoppingCategoryExtPersistenceImpl
 * @generated
 */
public class ShoppingCategoryExtUtil {
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
	public static void clearCache(ShoppingCategoryExt shoppingCategoryExt) {
		getPersistence().clearCache(shoppingCategoryExt);
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
	public static List<ShoppingCategoryExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShoppingCategoryExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShoppingCategoryExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ShoppingCategoryExt update(
		ShoppingCategoryExt shoppingCategoryExt, boolean merge)
		throws SystemException {
		return getPersistence().update(shoppingCategoryExt, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ShoppingCategoryExt update(
		ShoppingCategoryExt shoppingCategoryExt, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(shoppingCategoryExt, merge, serviceContext);
	}

	/**
	* Caches the shopping category ext in the entity cache if it is enabled.
	*
	* @param shoppingCategoryExt the shopping category ext
	*/
	public static void cacheResult(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt) {
		getPersistence().cacheResult(shoppingCategoryExt);
	}

	/**
	* Caches the shopping category exts in the entity cache if it is enabled.
	*
	* @param shoppingCategoryExts the shopping category exts
	*/
	public static void cacheResult(
		java.util.List<com.slayer.model.ShoppingCategoryExt> shoppingCategoryExts) {
		getPersistence().cacheResult(shoppingCategoryExts);
	}

	/**
	* Creates a new shopping category ext with the primary key. Does not add the shopping category ext to the database.
	*
	* @param categoryId the primary key for the new shopping category ext
	* @return the new shopping category ext
	*/
	public static com.slayer.model.ShoppingCategoryExt create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the shopping category ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the shopping category ext
	* @return the shopping category ext that was removed
	* @throws com.slayer.NoSuchShoppingCategoryExtException if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCategoryExt remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchShoppingCategoryExtException {
		return getPersistence().remove(categoryId);
	}

	public static com.slayer.model.ShoppingCategoryExt updateImpl(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shoppingCategoryExt, merge);
	}

	/**
	* Returns the shopping category ext with the primary key or throws a {@link com.slayer.NoSuchShoppingCategoryExtException} if it could not be found.
	*
	* @param categoryId the primary key of the shopping category ext
	* @return the shopping category ext
	* @throws com.slayer.NoSuchShoppingCategoryExtException if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCategoryExt findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchShoppingCategoryExtException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the shopping category ext with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the shopping category ext
	* @return the shopping category ext, or <code>null</code> if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCategoryExt fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the shopping category exts.
	*
	* @return the shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.slayer.model.ShoppingCategoryExt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the shopping category exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping category exts
	* @param end the upper bound of the range of shopping category exts (not inclusive)
	* @return the range of shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.slayer.model.ShoppingCategoryExt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the shopping category exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping category exts
	* @param end the upper bound of the range of shopping category exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.slayer.model.ShoppingCategoryExt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the shopping category exts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of shopping category exts.
	*
	* @return the number of shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ShoppingCategoryExtPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShoppingCategoryExtPersistence)PortletBeanLocatorUtil.locate(com.slayer.service.ClpSerializer.getServletContextName(),
					ShoppingCategoryExtPersistence.class.getName());

			ReferenceRegistry.registerReference(ShoppingCategoryExtUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ShoppingCategoryExtPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ShoppingCategoryExtUtil.class,
			"_persistence");
	}

	private static ShoppingCategoryExtPersistence _persistence;
}
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

import com.library.slayer.model.LIBBook;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l i b book service. This utility wraps {@link LIBBookPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author veena
 * @see LIBBookPersistence
 * @see LIBBookPersistenceImpl
 * @generated
 */
public class LIBBookUtil {
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
	public static void clearCache(LIBBook libBook) {
		getPersistence().clearCache(libBook);
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
	public static List<LIBBook> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LIBBook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LIBBook> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LIBBook update(LIBBook libBook, boolean merge)
		throws SystemException {
		return getPersistence().update(libBook, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LIBBook update(LIBBook libBook, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(libBook, merge, serviceContext);
	}

	/**
	* Caches the l i b book in the entity cache if it is enabled.
	*
	* @param libBook the l i b book
	*/
	public static void cacheResult(com.library.slayer.model.LIBBook libBook) {
		getPersistence().cacheResult(libBook);
	}

	/**
	* Caches the l i b books in the entity cache if it is enabled.
	*
	* @param libBooks the l i b books
	*/
	public static void cacheResult(
		java.util.List<com.library.slayer.model.LIBBook> libBooks) {
		getPersistence().cacheResult(libBooks);
	}

	/**
	* Creates a new l i b book with the primary key. Does not add the l i b book to the database.
	*
	* @param bookId the primary key for the new l i b book
	* @return the new l i b book
	*/
	public static com.library.slayer.model.LIBBook create(long bookId) {
		return getPersistence().create(bookId);
	}

	/**
	* Removes the l i b book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the l i b book
	* @return the l i b book that was removed
	* @throws com.library.slayer.NoSuchBookException if a l i b book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LIBBook remove(long bookId)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bookId);
	}

	public static com.library.slayer.model.LIBBook updateImpl(
		com.library.slayer.model.LIBBook libBook, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(libBook, merge);
	}

	/**
	* Returns the l i b book with the primary key or throws a {@link com.library.slayer.NoSuchBookException} if it could not be found.
	*
	* @param bookId the primary key of the l i b book
	* @return the l i b book
	* @throws com.library.slayer.NoSuchBookException if a l i b book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LIBBook findByPrimaryKey(long bookId)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bookId);
	}

	/**
	* Returns the l i b book with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the l i b book
	* @return the l i b book, or <code>null</code> if a l i b book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LIBBook fetchByPrimaryKey(
		long bookId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bookId);
	}

	/**
	* Returns all the l i b books.
	*
	* @return the l i b books
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.library.slayer.model.LIBBook> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the l i b books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l i b books
	* @param end the upper bound of the range of l i b books (not inclusive)
	* @return the range of l i b books
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.library.slayer.model.LIBBook> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the l i b books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l i b books
	* @param end the upper bound of the range of l i b books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l i b books
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.library.slayer.model.LIBBook> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l i b books from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l i b books.
	*
	* @return the number of l i b books
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LIBBookPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LIBBookPersistence)PortletBeanLocatorUtil.locate(com.library.slayer.service.ClpSerializer.getServletContextName(),
					LIBBookPersistence.class.getName());

			ReferenceRegistry.registerReference(LIBBookUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(LIBBookPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(LIBBookUtil.class, "_persistence");
	}

	private static LIBBookPersistence _persistence;
}
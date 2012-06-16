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

import com.liferay.portal.service.persistence.BasePersistence;

import com.slayer.model.ShoppingCategoryExt;

/**
 * The persistence interface for the shopping category ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ahmedhasan
 * @see ShoppingCategoryExtPersistenceImpl
 * @see ShoppingCategoryExtUtil
 * @generated
 */
public interface ShoppingCategoryExtPersistence extends BasePersistence<ShoppingCategoryExt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoppingCategoryExtUtil} to access the shopping category ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the shopping category ext in the entity cache if it is enabled.
	*
	* @param shoppingCategoryExt the shopping category ext
	*/
	public void cacheResult(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt);

	/**
	* Caches the shopping category exts in the entity cache if it is enabled.
	*
	* @param shoppingCategoryExts the shopping category exts
	*/
	public void cacheResult(
		java.util.List<com.slayer.model.ShoppingCategoryExt> shoppingCategoryExts);

	/**
	* Creates a new shopping category ext with the primary key. Does not add the shopping category ext to the database.
	*
	* @param categoryId the primary key for the new shopping category ext
	* @return the new shopping category ext
	*/
	public com.slayer.model.ShoppingCategoryExt create(long categoryId);

	/**
	* Removes the shopping category ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the shopping category ext
	* @return the shopping category ext that was removed
	* @throws com.slayer.NoSuchShoppingCategoryExtException if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCategoryExt remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchShoppingCategoryExtException;

	public com.slayer.model.ShoppingCategoryExt updateImpl(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping category ext with the primary key or throws a {@link com.slayer.NoSuchShoppingCategoryExtException} if it could not be found.
	*
	* @param categoryId the primary key of the shopping category ext
	* @return the shopping category ext
	* @throws com.slayer.NoSuchShoppingCategoryExtException if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCategoryExt findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchShoppingCategoryExtException;

	/**
	* Returns the shopping category ext with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the shopping category ext
	* @return the shopping category ext, or <code>null</code> if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCategoryExt fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shopping category exts.
	*
	* @return the shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.ShoppingCategoryExt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.slayer.model.ShoppingCategoryExt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.slayer.model.ShoppingCategoryExt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping category exts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping category exts.
	*
	* @return the number of shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
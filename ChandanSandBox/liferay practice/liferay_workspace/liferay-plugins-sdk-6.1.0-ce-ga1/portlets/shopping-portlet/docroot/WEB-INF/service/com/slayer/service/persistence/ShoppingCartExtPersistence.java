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

import com.slayer.model.ShoppingCartExt;

/**
 * The persistence interface for the shopping cart ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ahmedhasan
 * @see ShoppingCartExtPersistenceImpl
 * @see ShoppingCartExtUtil
 * @generated
 */
public interface ShoppingCartExtPersistence extends BasePersistence<ShoppingCartExt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoppingCartExtUtil} to access the shopping cart ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the shopping cart ext in the entity cache if it is enabled.
	*
	* @param shoppingCartExt the shopping cart ext
	*/
	public void cacheResult(com.slayer.model.ShoppingCartExt shoppingCartExt);

	/**
	* Caches the shopping cart exts in the entity cache if it is enabled.
	*
	* @param shoppingCartExts the shopping cart exts
	*/
	public void cacheResult(
		java.util.List<com.slayer.model.ShoppingCartExt> shoppingCartExts);

	/**
	* Creates a new shopping cart ext with the primary key. Does not add the shopping cart ext to the database.
	*
	* @param recId the primary key for the new shopping cart ext
	* @return the new shopping cart ext
	*/
	public com.slayer.model.ShoppingCartExt create(long recId);

	/**
	* Removes the shopping cart ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recId the primary key of the shopping cart ext
	* @return the shopping cart ext that was removed
	* @throws com.slayer.NoSuchShoppingCartExtException if a shopping cart ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCartExt remove(long recId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchShoppingCartExtException;

	public com.slayer.model.ShoppingCartExt updateImpl(
		com.slayer.model.ShoppingCartExt shoppingCartExt, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping cart ext with the primary key or throws a {@link com.slayer.NoSuchShoppingCartExtException} if it could not be found.
	*
	* @param recId the primary key of the shopping cart ext
	* @return the shopping cart ext
	* @throws com.slayer.NoSuchShoppingCartExtException if a shopping cart ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCartExt findByPrimaryKey(long recId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchShoppingCartExtException;

	/**
	* Returns the shopping cart ext with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recId the primary key of the shopping cart ext
	* @return the shopping cart ext, or <code>null</code> if a shopping cart ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCartExt fetchByPrimaryKey(long recId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shopping cart exts.
	*
	* @return the shopping cart exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.ShoppingCartExt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shopping cart exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping cart exts
	* @param end the upper bound of the range of shopping cart exts (not inclusive)
	* @return the range of shopping cart exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.ShoppingCartExt> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shopping cart exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping cart exts
	* @param end the upper bound of the range of shopping cart exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of shopping cart exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.ShoppingCartExt> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping cart exts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping cart exts.
	*
	* @return the number of shopping cart exts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
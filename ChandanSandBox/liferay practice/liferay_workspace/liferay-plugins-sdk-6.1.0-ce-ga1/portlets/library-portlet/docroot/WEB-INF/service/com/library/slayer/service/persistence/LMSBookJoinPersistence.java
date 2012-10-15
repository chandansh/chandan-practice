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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l m s book join service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmed Hasan
 * @see LMSBookJoinPersistenceImpl
 * @see LMSBookJoinUtil
 * @generated
 */
public interface LMSBookJoinPersistence extends BasePersistence<LMSBookJoin> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSBookJoinUtil} to access the l m s book join persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the l m s book join in the entity cache if it is enabled.
	*
	* @param lmsBookJoin the l m s book join
	*/
	public void cacheResult(com.library.slayer.model.LMSBookJoin lmsBookJoin);

	/**
	* Caches the l m s book joins in the entity cache if it is enabled.
	*
	* @param lmsBookJoins the l m s book joins
	*/
	public void cacheResult(
		java.util.List<com.library.slayer.model.LMSBookJoin> lmsBookJoins);

	/**
	* Creates a new l m s book join with the primary key. Does not add the l m s book join to the database.
	*
	* @param joinId the primary key for the new l m s book join
	* @return the new l m s book join
	*/
	public com.library.slayer.model.LMSBookJoin create(long joinId);

	/**
	* Removes the l m s book join with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param joinId the primary key of the l m s book join
	* @return the l m s book join that was removed
	* @throws com.library.slayer.NoSuchBookJoinException if a l m s book join with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBookJoin remove(long joinId)
		throws com.library.slayer.NoSuchBookJoinException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.library.slayer.model.LMSBookJoin updateImpl(
		com.library.slayer.model.LMSBookJoin lmsBookJoin, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book join with the primary key or throws a {@link com.library.slayer.NoSuchBookJoinException} if it could not be found.
	*
	* @param joinId the primary key of the l m s book join
	* @return the l m s book join
	* @throws com.library.slayer.NoSuchBookJoinException if a l m s book join with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBookJoin findByPrimaryKey(long joinId)
		throws com.library.slayer.NoSuchBookJoinException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book join with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param joinId the primary key of the l m s book join
	* @return the l m s book join, or <code>null</code> if a l m s book join with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBookJoin fetchByPrimaryKey(long joinId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s book joins.
	*
	* @return the l m s book joins
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.LMSBookJoin> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.library.slayer.model.LMSBookJoin> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.library.slayer.model.LMSBookJoin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s book joins from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s book joins.
	*
	* @return the number of l m s book joins
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

package com.edujini.incoleg.video.service.persistence;

import com.edujini.incoleg.video.model.VOMap;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the v o map service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link VOMapUtil} to access the v o map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Edujini
 * @see VOMapPersistenceImpl
 * @see VOMapUtil
 * @generated
 */
public interface VOMapPersistence extends BasePersistence<VOMap> {
	/**
	* Caches the v o map in the entity cache if it is enabled.
	*
	* @param voMap the v o map to cache
	*/
	public void cacheResult(com.edujini.incoleg.video.model.VOMap voMap);

	/**
	* Caches the v o maps in the entity cache if it is enabled.
	*
	* @param voMaps the v o maps to cache
	*/
	public void cacheResult(
		java.util.List<com.edujini.incoleg.video.model.VOMap> voMaps);

	/**
	* Creates a new v o map with the primary key. Does not add the v o map to the database.
	*
	* @param videoId the primary key for the new v o map
	* @return the new v o map
	*/
	public com.edujini.incoleg.video.model.VOMap create(
		java.lang.String videoId);

	/**
	* Removes the v o map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the v o map to remove
	* @return the v o map that was removed
	* @throws com.edujini.incoleg.video.NoSuchVOMapException if a v o map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VOMap remove(
		java.lang.String videoId)
		throws com.edujini.incoleg.video.NoSuchVOMapException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.edujini.incoleg.video.model.VOMap updateImpl(
		com.edujini.incoleg.video.model.VOMap voMap, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the v o map with the primary key or throws a {@link com.edujini.incoleg.video.NoSuchVOMapException} if it could not be found.
	*
	* @param videoId the primary key of the v o map to find
	* @return the v o map
	* @throws com.edujini.incoleg.video.NoSuchVOMapException if a v o map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VOMap findByPrimaryKey(
		java.lang.String videoId)
		throws com.edujini.incoleg.video.NoSuchVOMapException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the v o map with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoId the primary key of the v o map to find
	* @return the v o map, or <code>null</code> if a v o map with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VOMap fetchByPrimaryKey(
		java.lang.String videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the v o maps.
	*
	* @return the v o maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.edujini.incoleg.video.model.VOMap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the v o maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v o maps to return
	* @param end the upper bound of the range of v o maps to return (not inclusive)
	* @return the range of v o maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.edujini.incoleg.video.model.VOMap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the v o maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of v o maps to return
	* @param end the upper bound of the range of v o maps to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of v o maps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.edujini.incoleg.video.model.VOMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the v o maps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the v o maps.
	*
	* @return the number of v o maps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
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

import com.edujini.incoleg.video.model.StoreSettings;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the store settings service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link StoreSettingsUtil} to access the store settings persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Edujini
 * @see StoreSettingsPersistenceImpl
 * @see StoreSettingsUtil
 * @generated
 */
public interface StoreSettingsPersistence extends BasePersistence<StoreSettings> {
	/**
	* Caches the store settings in the entity cache if it is enabled.
	*
	* @param storeSettings the store settings to cache
	*/
	public void cacheResult(
		com.edujini.incoleg.video.model.StoreSettings storeSettings);

	/**
	* Caches the store settingses in the entity cache if it is enabled.
	*
	* @param storeSettingses the store settingses to cache
	*/
	public void cacheResult(
		java.util.List<com.edujini.incoleg.video.model.StoreSettings> storeSettingses);

	/**
	* Creates a new store settings with the primary key. Does not add the store settings to the database.
	*
	* @param storeId the primary key for the new store settings
	* @return the new store settings
	*/
	public com.edujini.incoleg.video.model.StoreSettings create(long storeId);

	/**
	* Removes the store settings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param storeId the primary key of the store settings to remove
	* @return the store settings that was removed
	* @throws com.edujini.incoleg.video.NoSuchStoreSettingsException if a store settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.StoreSettings remove(long storeId)
		throws com.edujini.incoleg.video.NoSuchStoreSettingsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.edujini.incoleg.video.model.StoreSettings updateImpl(
		com.edujini.incoleg.video.model.StoreSettings storeSettings,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the store settings with the primary key or throws a {@link com.edujini.incoleg.video.NoSuchStoreSettingsException} if it could not be found.
	*
	* @param storeId the primary key of the store settings to find
	* @return the store settings
	* @throws com.edujini.incoleg.video.NoSuchStoreSettingsException if a store settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.StoreSettings findByPrimaryKey(
		long storeId)
		throws com.edujini.incoleg.video.NoSuchStoreSettingsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the store settings with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param storeId the primary key of the store settings to find
	* @return the store settings, or <code>null</code> if a store settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.StoreSettings fetchByPrimaryKey(
		long storeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the store settingses.
	*
	* @return the store settingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.edujini.incoleg.video.model.StoreSettings> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the store settingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of store settingses to return
	* @param end the upper bound of the range of store settingses to return (not inclusive)
	* @return the range of store settingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.edujini.incoleg.video.model.StoreSettings> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the store settingses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of store settingses to return
	* @param end the upper bound of the range of store settingses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of store settingses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.edujini.incoleg.video.model.StoreSettings> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the store settingses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the store settingses.
	*
	* @return the number of store settingses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
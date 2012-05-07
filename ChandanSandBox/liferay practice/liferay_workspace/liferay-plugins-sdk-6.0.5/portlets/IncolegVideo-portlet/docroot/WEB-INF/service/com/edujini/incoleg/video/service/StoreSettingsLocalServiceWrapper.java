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

package com.edujini.incoleg.video.service;

/**
 * <p>
 * This class is a wrapper for {@link StoreSettingsLocalService}.
 * </p>
 *
 * @author    Edujini
 * @see       StoreSettingsLocalService
 * @generated
 */
public class StoreSettingsLocalServiceWrapper
	implements StoreSettingsLocalService {
	public StoreSettingsLocalServiceWrapper(
		StoreSettingsLocalService storeSettingsLocalService) {
		_storeSettingsLocalService = storeSettingsLocalService;
	}

	/**
	* Adds the store settings to the database. Also notifies the appropriate model listeners.
	*
	* @param storeSettings the store settings to add
	* @return the store settings that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.StoreSettings addStoreSettings(
		com.edujini.incoleg.video.model.StoreSettings storeSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.addStoreSettings(storeSettings);
	}

	/**
	* Creates a new store settings with the primary key. Does not add the store settings to the database.
	*
	* @param storeId the primary key for the new store settings
	* @return the new store settings
	*/
	public com.edujini.incoleg.video.model.StoreSettings createStoreSettings(
		long storeId) {
		return _storeSettingsLocalService.createStoreSettings(storeId);
	}

	/**
	* Deletes the store settings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param storeId the primary key of the store settings to delete
	* @throws PortalException if a store settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteStoreSettings(long storeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_storeSettingsLocalService.deleteStoreSettings(storeId);
	}

	/**
	* Deletes the store settings from the database. Also notifies the appropriate model listeners.
	*
	* @param storeSettings the store settings to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteStoreSettings(
		com.edujini.incoleg.video.model.StoreSettings storeSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		_storeSettingsLocalService.deleteStoreSettings(storeSettings);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the store settings with the primary key.
	*
	* @param storeId the primary key of the store settings to get
	* @return the store settings
	* @throws PortalException if a store settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.StoreSettings getStoreSettings(
		long storeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.getStoreSettings(storeId);
	}

	/**
	* Gets a range of all the store settingses.
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
	public java.util.List<com.edujini.incoleg.video.model.StoreSettings> getStoreSettingses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.getStoreSettingses(start, end);
	}

	/**
	* Gets the number of store settingses.
	*
	* @return the number of store settingses
	* @throws SystemException if a system exception occurred
	*/
	public int getStoreSettingsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.getStoreSettingsesCount();
	}

	/**
	* Updates the store settings in the database. Also notifies the appropriate model listeners.
	*
	* @param storeSettings the store settings to update
	* @return the store settings that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.StoreSettings updateStoreSettings(
		com.edujini.incoleg.video.model.StoreSettings storeSettings)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.updateStoreSettings(storeSettings);
	}

	/**
	* Updates the store settings in the database. Also notifies the appropriate model listeners.
	*
	* @param storeSettings the store settings to update
	* @param merge whether to merge the store settings with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the store settings that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.StoreSettings updateStoreSettings(
		com.edujini.incoleg.video.model.StoreSettings storeSettings,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _storeSettingsLocalService.updateStoreSettings(storeSettings,
			merge);
	}

	public StoreSettingsLocalService getWrappedStoreSettingsLocalService() {
		return _storeSettingsLocalService;
	}

	private StoreSettingsLocalService _storeSettingsLocalService;
}
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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the store settings service. This utility wraps {@link StoreSettingsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Edujini
 * @see StoreSettingsPersistence
 * @see StoreSettingsPersistenceImpl
 * @generated
 */
public class StoreSettingsUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(StoreSettings storeSettings) {
		getPersistence().clearCache(storeSettings);
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
	public static List<StoreSettings> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StoreSettings> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StoreSettings> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static StoreSettings remove(StoreSettings storeSettings)
		throws SystemException {
		return getPersistence().remove(storeSettings);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static StoreSettings update(StoreSettings storeSettings,
		boolean merge) throws SystemException {
		return getPersistence().update(storeSettings, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static StoreSettings update(StoreSettings storeSettings,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(storeSettings, merge, serviceContext);
	}

	/**
	* Caches the store settings in the entity cache if it is enabled.
	*
	* @param storeSettings the store settings to cache
	*/
	public static void cacheResult(
		com.edujini.incoleg.video.model.StoreSettings storeSettings) {
		getPersistence().cacheResult(storeSettings);
	}

	/**
	* Caches the store settingses in the entity cache if it is enabled.
	*
	* @param storeSettingses the store settingses to cache
	*/
	public static void cacheResult(
		java.util.List<com.edujini.incoleg.video.model.StoreSettings> storeSettingses) {
		getPersistence().cacheResult(storeSettingses);
	}

	/**
	* Creates a new store settings with the primary key. Does not add the store settings to the database.
	*
	* @param storeId the primary key for the new store settings
	* @return the new store settings
	*/
	public static com.edujini.incoleg.video.model.StoreSettings create(
		long storeId) {
		return getPersistence().create(storeId);
	}

	/**
	* Removes the store settings with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param storeId the primary key of the store settings to remove
	* @return the store settings that was removed
	* @throws com.edujini.incoleg.video.NoSuchStoreSettingsException if a store settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.edujini.incoleg.video.model.StoreSettings remove(
		long storeId)
		throws com.edujini.incoleg.video.NoSuchStoreSettingsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(storeId);
	}

	public static com.edujini.incoleg.video.model.StoreSettings updateImpl(
		com.edujini.incoleg.video.model.StoreSettings storeSettings,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(storeSettings, merge);
	}

	/**
	* Finds the store settings with the primary key or throws a {@link com.edujini.incoleg.video.NoSuchStoreSettingsException} if it could not be found.
	*
	* @param storeId the primary key of the store settings to find
	* @return the store settings
	* @throws com.edujini.incoleg.video.NoSuchStoreSettingsException if a store settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.edujini.incoleg.video.model.StoreSettings findByPrimaryKey(
		long storeId)
		throws com.edujini.incoleg.video.NoSuchStoreSettingsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(storeId);
	}

	/**
	* Finds the store settings with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param storeId the primary key of the store settings to find
	* @return the store settings, or <code>null</code> if a store settings with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.edujini.incoleg.video.model.StoreSettings fetchByPrimaryKey(
		long storeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(storeId);
	}

	/**
	* Finds all the store settingses.
	*
	* @return the store settingses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.edujini.incoleg.video.model.StoreSettings> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.edujini.incoleg.video.model.StoreSettings> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.edujini.incoleg.video.model.StoreSettings> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the store settingses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the store settingses.
	*
	* @return the number of store settingses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StoreSettingsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StoreSettingsPersistence)PortletBeanLocatorUtil.locate(com.edujini.incoleg.video.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					StoreSettingsPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(StoreSettingsPersistence persistence) {
		_persistence = persistence;
	}

	private static StoreSettingsPersistence _persistence;
}
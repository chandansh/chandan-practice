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

package com.edujini.incoleg.video.service.base;

import com.edujini.incoleg.video.service.StoreSettingsLocalService;
import com.edujini.incoleg.video.service.StoreSettingsService;
import com.edujini.incoleg.video.service.VOMapLocalService;
import com.edujini.incoleg.video.service.VOMapService;
import com.edujini.incoleg.video.service.VideoInfoLocalService;
import com.edujini.incoleg.video.service.VideoInfoService;
import com.edujini.incoleg.video.service.persistence.StoreSettingsPersistence;
import com.edujini.incoleg.video.service.persistence.VOMapPersistence;
import com.edujini.incoleg.video.service.persistence.VideoInfoPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the video info remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.edujini.incoleg.video.service.impl.VideoInfoServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.edujini.incoleg.video.service.VideoInfoServiceUtil} to access the video info remote service.
 * </p>
 *
 * @author Edujini
 * @see com.edujini.incoleg.video.service.impl.VideoInfoServiceImpl
 * @see com.edujini.incoleg.video.service.VideoInfoServiceUtil
 * @generated
 */
public abstract class VideoInfoServiceBaseImpl extends PrincipalBean
	implements VideoInfoService {
	/**
	 * Gets the video info local service.
	 *
	 * @return the video info local service
	 */
	public VideoInfoLocalService getVideoInfoLocalService() {
		return videoInfoLocalService;
	}

	/**
	 * Sets the video info local service.
	 *
	 * @param videoInfoLocalService the video info local service
	 */
	public void setVideoInfoLocalService(
		VideoInfoLocalService videoInfoLocalService) {
		this.videoInfoLocalService = videoInfoLocalService;
	}

	/**
	 * Gets the video info remote service.
	 *
	 * @return the video info remote service
	 */
	public VideoInfoService getVideoInfoService() {
		return videoInfoService;
	}

	/**
	 * Sets the video info remote service.
	 *
	 * @param videoInfoService the video info remote service
	 */
	public void setVideoInfoService(VideoInfoService videoInfoService) {
		this.videoInfoService = videoInfoService;
	}

	/**
	 * Gets the video info persistence.
	 *
	 * @return the video info persistence
	 */
	public VideoInfoPersistence getVideoInfoPersistence() {
		return videoInfoPersistence;
	}

	/**
	 * Sets the video info persistence.
	 *
	 * @param videoInfoPersistence the video info persistence
	 */
	public void setVideoInfoPersistence(
		VideoInfoPersistence videoInfoPersistence) {
		this.videoInfoPersistence = videoInfoPersistence;
	}

	/**
	 * Gets the store settings local service.
	 *
	 * @return the store settings local service
	 */
	public StoreSettingsLocalService getStoreSettingsLocalService() {
		return storeSettingsLocalService;
	}

	/**
	 * Sets the store settings local service.
	 *
	 * @param storeSettingsLocalService the store settings local service
	 */
	public void setStoreSettingsLocalService(
		StoreSettingsLocalService storeSettingsLocalService) {
		this.storeSettingsLocalService = storeSettingsLocalService;
	}

	/**
	 * Gets the store settings remote service.
	 *
	 * @return the store settings remote service
	 */
	public StoreSettingsService getStoreSettingsService() {
		return storeSettingsService;
	}

	/**
	 * Sets the store settings remote service.
	 *
	 * @param storeSettingsService the store settings remote service
	 */
	public void setStoreSettingsService(
		StoreSettingsService storeSettingsService) {
		this.storeSettingsService = storeSettingsService;
	}

	/**
	 * Gets the store settings persistence.
	 *
	 * @return the store settings persistence
	 */
	public StoreSettingsPersistence getStoreSettingsPersistence() {
		return storeSettingsPersistence;
	}

	/**
	 * Sets the store settings persistence.
	 *
	 * @param storeSettingsPersistence the store settings persistence
	 */
	public void setStoreSettingsPersistence(
		StoreSettingsPersistence storeSettingsPersistence) {
		this.storeSettingsPersistence = storeSettingsPersistence;
	}

	/**
	 * Gets the v o map local service.
	 *
	 * @return the v o map local service
	 */
	public VOMapLocalService getVOMapLocalService() {
		return voMapLocalService;
	}

	/**
	 * Sets the v o map local service.
	 *
	 * @param voMapLocalService the v o map local service
	 */
	public void setVOMapLocalService(VOMapLocalService voMapLocalService) {
		this.voMapLocalService = voMapLocalService;
	}

	/**
	 * Gets the v o map remote service.
	 *
	 * @return the v o map remote service
	 */
	public VOMapService getVOMapService() {
		return voMapService;
	}

	/**
	 * Sets the v o map remote service.
	 *
	 * @param voMapService the v o map remote service
	 */
	public void setVOMapService(VOMapService voMapService) {
		this.voMapService = voMapService;
	}

	/**
	 * Gets the v o map persistence.
	 *
	 * @return the v o map persistence
	 */
	public VOMapPersistence getVOMapPersistence() {
		return voMapPersistence;
	}

	/**
	 * Sets the v o map persistence.
	 *
	 * @param voMapPersistence the v o map persistence
	 */
	public void setVOMapPersistence(VOMapPersistence voMapPersistence) {
		this.voMapPersistence = voMapPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = videoInfoPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = VideoInfoLocalService.class)
	protected VideoInfoLocalService videoInfoLocalService;
	@BeanReference(type = VideoInfoService.class)
	protected VideoInfoService videoInfoService;
	@BeanReference(type = VideoInfoPersistence.class)
	protected VideoInfoPersistence videoInfoPersistence;
	@BeanReference(type = StoreSettingsLocalService.class)
	protected StoreSettingsLocalService storeSettingsLocalService;
	@BeanReference(type = StoreSettingsService.class)
	protected StoreSettingsService storeSettingsService;
	@BeanReference(type = StoreSettingsPersistence.class)
	protected StoreSettingsPersistence storeSettingsPersistence;
	@BeanReference(type = VOMapLocalService.class)
	protected VOMapLocalService voMapLocalService;
	@BeanReference(type = VOMapService.class)
	protected VOMapService voMapService;
	@BeanReference(type = VOMapPersistence.class)
	protected VOMapPersistence voMapPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}
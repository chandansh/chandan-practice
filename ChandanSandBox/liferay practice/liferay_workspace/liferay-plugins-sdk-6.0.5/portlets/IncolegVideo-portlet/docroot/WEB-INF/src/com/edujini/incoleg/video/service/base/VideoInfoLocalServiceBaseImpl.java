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

import com.edujini.incoleg.video.model.VideoInfo;
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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the video info local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.edujini.incoleg.video.service.impl.VideoInfoLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.edujini.incoleg.video.service.VideoInfoLocalServiceUtil} to access the video info local service.
 * </p>
 *
 * @author Edujini
 * @see com.edujini.incoleg.video.service.impl.VideoInfoLocalServiceImpl
 * @see com.edujini.incoleg.video.service.VideoInfoLocalServiceUtil
 * @generated
 */
public abstract class VideoInfoLocalServiceBaseImpl
	implements VideoInfoLocalService {
	/**
	 * Adds the video info to the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoInfo the video info to add
	 * @return the video info that was added
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo addVideoInfo(VideoInfo videoInfo)
		throws SystemException {
		videoInfo.setNew(true);

		return videoInfoPersistence.update(videoInfo, false);
	}

	/**
	 * Creates a new video info with the primary key. Does not add the video info to the database.
	 *
	 * @param videoId the primary key for the new video info
	 * @return the new video info
	 */
	public VideoInfo createVideoInfo(String videoId) {
		return videoInfoPersistence.create(videoId);
	}

	/**
	 * Deletes the video info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the video info to delete
	 * @throws PortalException if a video info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteVideoInfo(String videoId)
		throws PortalException, SystemException {
		videoInfoPersistence.remove(videoId);
	}

	/**
	 * Deletes the video info from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoInfo the video info to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteVideoInfo(VideoInfo videoInfo) throws SystemException {
		videoInfoPersistence.remove(videoInfo);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return videoInfoPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return videoInfoPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return videoInfoPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return videoInfoPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the video info with the primary key.
	 *
	 * @param videoId the primary key of the video info to get
	 * @return the video info
	 * @throws PortalException if a video info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo getVideoInfo(String videoId)
		throws PortalException, SystemException {
		return videoInfoPersistence.findByPrimaryKey(videoId);
	}

	/**
	 * Gets a range of all the video infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video infos to return
	 * @param end the upper bound of the range of video infos to return (not inclusive)
	 * @return the range of video infos
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoInfo> getVideoInfos(int start, int end)
		throws SystemException {
		return videoInfoPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of video infos.
	 *
	 * @return the number of video infos
	 * @throws SystemException if a system exception occurred
	 */
	public int getVideoInfosCount() throws SystemException {
		return videoInfoPersistence.countAll();
	}

	/**
	 * Updates the video info in the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoInfo the video info to update
	 * @return the video info that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo updateVideoInfo(VideoInfo videoInfo)
		throws SystemException {
		videoInfo.setNew(false);

		return videoInfoPersistence.update(videoInfo, true);
	}

	/**
	 * Updates the video info in the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoInfo the video info to update
	 * @param merge whether to merge the video info with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the video info that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public VideoInfo updateVideoInfo(VideoInfo videoInfo, boolean merge)
		throws SystemException {
		videoInfo.setNew(false);

		return videoInfoPersistence.update(videoInfo, merge);
	}

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
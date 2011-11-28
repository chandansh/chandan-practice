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

import com.edujini.incoleg.video.model.VideoInfo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the video info service. This utility wraps {@link VideoInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see VideoInfoPersistence
 * @see VideoInfoPersistenceImpl
 * @generated
 */
public class VideoInfoUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(VideoInfo videoInfo) {
		getPersistence().clearCache(videoInfo);
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
	public static List<VideoInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static VideoInfo remove(VideoInfo videoInfo)
		throws SystemException {
		return getPersistence().remove(videoInfo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VideoInfo update(VideoInfo videoInfo, boolean merge)
		throws SystemException {
		return getPersistence().update(videoInfo, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VideoInfo update(VideoInfo videoInfo, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videoInfo, merge, serviceContext);
	}

	/**
	* Caches the video info in the entity cache if it is enabled.
	*
	* @param videoInfo the video info to cache
	*/
	public static void cacheResult(
		com.edujini.incoleg.video.model.VideoInfo videoInfo) {
		getPersistence().cacheResult(videoInfo);
	}

	/**
	* Caches the video infos in the entity cache if it is enabled.
	*
	* @param videoInfos the video infos to cache
	*/
	public static void cacheResult(
		java.util.List<com.edujini.incoleg.video.model.VideoInfo> videoInfos) {
		getPersistence().cacheResult(videoInfos);
	}

	/**
	* Creates a new video info with the primary key. Does not add the video info to the database.
	*
	* @param videoId the primary key for the new video info
	* @return the new video info
	*/
	public static com.edujini.incoleg.video.model.VideoInfo create(
		java.lang.String videoId) {
		return getPersistence().create(videoId);
	}

	/**
	* Removes the video info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the video info to remove
	* @return the video info that was removed
	* @throws com.edujini.incoleg.video.NoSuchVideoInfoException if a video info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.edujini.incoleg.video.model.VideoInfo remove(
		java.lang.String videoId)
		throws com.edujini.incoleg.video.NoSuchVideoInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(videoId);
	}

	public static com.edujini.incoleg.video.model.VideoInfo updateImpl(
		com.edujini.incoleg.video.model.VideoInfo videoInfo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoInfo, merge);
	}

	/**
	* Finds the video info with the primary key or throws a {@link com.edujini.incoleg.video.NoSuchVideoInfoException} if it could not be found.
	*
	* @param videoId the primary key of the video info to find
	* @return the video info
	* @throws com.edujini.incoleg.video.NoSuchVideoInfoException if a video info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.edujini.incoleg.video.model.VideoInfo findByPrimaryKey(
		java.lang.String videoId)
		throws com.edujini.incoleg.video.NoSuchVideoInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(videoId);
	}

	/**
	* Finds the video info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoId the primary key of the video info to find
	* @return the video info, or <code>null</code> if a video info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.edujini.incoleg.video.model.VideoInfo fetchByPrimaryKey(
		java.lang.String videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoId);
	}

	/**
	* Finds the video info where mappedFileName = &#63; or throws a {@link com.edujini.incoleg.video.NoSuchVideoInfoException} if it could not be found.
	*
	* @param mappedFileName the mapped file name to search with
	* @return the matching video info
	* @throws com.edujini.incoleg.video.NoSuchVideoInfoException if a matching video info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.edujini.incoleg.video.model.VideoInfo findByFileName(
		java.lang.String mappedFileName)
		throws com.edujini.incoleg.video.NoSuchVideoInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileName(mappedFileName);
	}

	/**
	* Finds the video info where mappedFileName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mappedFileName the mapped file name to search with
	* @return the matching video info, or <code>null</code> if a matching video info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.edujini.incoleg.video.model.VideoInfo fetchByFileName(
		java.lang.String mappedFileName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFileName(mappedFileName);
	}

	/**
	* Finds the video info where mappedFileName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mappedFileName the mapped file name to search with
	* @return the matching video info, or <code>null</code> if a matching video info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.edujini.incoleg.video.model.VideoInfo fetchByFileName(
		java.lang.String mappedFileName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileName(mappedFileName, retrieveFromCache);
	}

	/**
	* Finds all the video infos.
	*
	* @return the video infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.edujini.incoleg.video.model.VideoInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the video infos.
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
	public static java.util.List<com.edujini.incoleg.video.model.VideoInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the video infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video infos to return
	* @param end the upper bound of the range of video infos to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of video infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.edujini.incoleg.video.model.VideoInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the video info where mappedFileName = &#63; from the database.
	*
	* @param mappedFileName the mapped file name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFileName(java.lang.String mappedFileName)
		throws com.edujini.incoleg.video.NoSuchVideoInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFileName(mappedFileName);
	}

	/**
	* Removes all the video infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the video infos where mappedFileName = &#63;.
	*
	* @param mappedFileName the mapped file name to search with
	* @return the number of matching video infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileName(java.lang.String mappedFileName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFileName(mappedFileName);
	}

	/**
	* Counts all the video infos.
	*
	* @return the number of video infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoInfoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoInfoPersistence)PortletBeanLocatorUtil.locate(com.edujini.incoleg.video.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					VideoInfoPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(VideoInfoPersistence persistence) {
		_persistence = persistence;
	}

	private static VideoInfoPersistence _persistence;
}
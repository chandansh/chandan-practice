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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the video info service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link VideoInfoUtil} to access the video info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Edujini
 * @see VideoInfoPersistenceImpl
 * @see VideoInfoUtil
 * @generated
 */
public interface VideoInfoPersistence extends BasePersistence<VideoInfo> {
	/**
	* Caches the video info in the entity cache if it is enabled.
	*
	* @param videoInfo the video info to cache
	*/
	public void cacheResult(com.edujini.incoleg.video.model.VideoInfo videoInfo);

	/**
	* Caches the video infos in the entity cache if it is enabled.
	*
	* @param videoInfos the video infos to cache
	*/
	public void cacheResult(
		java.util.List<com.edujini.incoleg.video.model.VideoInfo> videoInfos);

	/**
	* Creates a new video info with the primary key. Does not add the video info to the database.
	*
	* @param videoId the primary key for the new video info
	* @return the new video info
	*/
	public com.edujini.incoleg.video.model.VideoInfo create(
		java.lang.String videoId);

	/**
	* Removes the video info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the video info to remove
	* @return the video info that was removed
	* @throws com.edujini.incoleg.video.NoSuchVideoInfoException if a video info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VideoInfo remove(
		java.lang.String videoId)
		throws com.edujini.incoleg.video.NoSuchVideoInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.edujini.incoleg.video.model.VideoInfo updateImpl(
		com.edujini.incoleg.video.model.VideoInfo videoInfo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the video info with the primary key or throws a {@link com.edujini.incoleg.video.NoSuchVideoInfoException} if it could not be found.
	*
	* @param videoId the primary key of the video info to find
	* @return the video info
	* @throws com.edujini.incoleg.video.NoSuchVideoInfoException if a video info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VideoInfo findByPrimaryKey(
		java.lang.String videoId)
		throws com.edujini.incoleg.video.NoSuchVideoInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the video info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoId the primary key of the video info to find
	* @return the video info, or <code>null</code> if a video info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VideoInfo fetchByPrimaryKey(
		java.lang.String videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the video info where mappedFileName = &#63; or throws a {@link com.edujini.incoleg.video.NoSuchVideoInfoException} if it could not be found.
	*
	* @param mappedFileName the mapped file name to search with
	* @return the matching video info
	* @throws com.edujini.incoleg.video.NoSuchVideoInfoException if a matching video info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VideoInfo findByFileName(
		java.lang.String mappedFileName)
		throws com.edujini.incoleg.video.NoSuchVideoInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the video info where mappedFileName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mappedFileName the mapped file name to search with
	* @return the matching video info, or <code>null</code> if a matching video info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VideoInfo fetchByFileName(
		java.lang.String mappedFileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the video info where mappedFileName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mappedFileName the mapped file name to search with
	* @return the matching video info, or <code>null</code> if a matching video info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VideoInfo fetchByFileName(
		java.lang.String mappedFileName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the video infos.
	*
	* @return the video infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.edujini.incoleg.video.model.VideoInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.edujini.incoleg.video.model.VideoInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.edujini.incoleg.video.model.VideoInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the video info where mappedFileName = &#63; from the database.
	*
	* @param mappedFileName the mapped file name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFileName(java.lang.String mappedFileName)
		throws com.edujini.incoleg.video.NoSuchVideoInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the video infos where mappedFileName = &#63;.
	*
	* @param mappedFileName the mapped file name to search with
	* @return the number of matching video infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByFileName(java.lang.String mappedFileName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the video infos.
	*
	* @return the number of video infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
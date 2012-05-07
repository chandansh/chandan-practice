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

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the video info local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link VideoInfoLocalServiceUtil} to access the video info local service. Add custom service methods to {@link com.edujini.incoleg.video.service.impl.VideoInfoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Edujini
 * @see VideoInfoLocalServiceUtil
 * @see com.edujini.incoleg.video.service.base.VideoInfoLocalServiceBaseImpl
 * @see com.edujini.incoleg.video.service.impl.VideoInfoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VideoInfoLocalService {
	/**
	* Adds the video info to the database. Also notifies the appropriate model listeners.
	*
	* @param videoInfo the video info to add
	* @return the video info that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VideoInfo addVideoInfo(
		com.edujini.incoleg.video.model.VideoInfo videoInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new video info with the primary key. Does not add the video info to the database.
	*
	* @param videoId the primary key for the new video info
	* @return the new video info
	*/
	public com.edujini.incoleg.video.model.VideoInfo createVideoInfo(
		java.lang.String videoId);

	/**
	* Deletes the video info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the video info to delete
	* @throws PortalException if a video info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVideoInfo(java.lang.String videoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the video info from the database. Also notifies the appropriate model listeners.
	*
	* @param videoInfo the video info to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVideoInfo(
		com.edujini.incoleg.video.model.VideoInfo videoInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the video info with the primary key.
	*
	* @param videoId the primary key of the video info to get
	* @return the video info
	* @throws PortalException if a video info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.edujini.incoleg.video.model.VideoInfo getVideoInfo(
		java.lang.String videoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.edujini.incoleg.video.model.VideoInfo> getVideoInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of video infos.
	*
	* @return the number of video infos
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVideoInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the video info in the database. Also notifies the appropriate model listeners.
	*
	* @param videoInfo the video info to update
	* @return the video info that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VideoInfo updateVideoInfo(
		com.edujini.incoleg.video.model.VideoInfo videoInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the video info in the database. Also notifies the appropriate model listeners.
	*
	* @param videoInfo the video info to update
	* @param merge whether to merge the video info with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the video info that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.edujini.incoleg.video.model.VideoInfo updateVideoInfo(
		com.edujini.incoleg.video.model.VideoInfo videoInfo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;
}
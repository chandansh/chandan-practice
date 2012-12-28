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

package com.library.slayer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LMSBookJoinLocalService}.
 * </p>
 *
 * @author    Ahmed Hasan
 * @see       LMSBookJoinLocalService
 * @generated
 */
public class LMSBookJoinLocalServiceWrapper implements LMSBookJoinLocalService,
	ServiceWrapper<LMSBookJoinLocalService> {
	public LMSBookJoinLocalServiceWrapper(
		LMSBookJoinLocalService lmsBookJoinLocalService) {
		_lmsBookJoinLocalService = lmsBookJoinLocalService;
	}

	/**
	* Adds the l m s book join to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBookJoin the l m s book join
	* @return the l m s book join that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBookJoin addLMSBookJoin(
		com.library.slayer.model.LMSBookJoin lmsBookJoin)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.addLMSBookJoin(lmsBookJoin);
	}

	/**
	* Creates a new l m s book join with the primary key. Does not add the l m s book join to the database.
	*
	* @param joinId the primary key for the new l m s book join
	* @return the new l m s book join
	*/
	public com.library.slayer.model.LMSBookJoin createLMSBookJoin(long joinId) {
		return _lmsBookJoinLocalService.createLMSBookJoin(joinId);
	}

	/**
	* Deletes the l m s book join with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param joinId the primary key of the l m s book join
	* @throws PortalException if a l m s book join with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLMSBookJoin(long joinId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_lmsBookJoinLocalService.deleteLMSBookJoin(joinId);
	}

	/**
	* Deletes the l m s book join from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBookJoin the l m s book join
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLMSBookJoin(
		com.library.slayer.model.LMSBookJoin lmsBookJoin)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsBookJoinLocalService.deleteLMSBookJoin(lmsBookJoin);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.library.slayer.model.LMSBookJoin fetchLMSBookJoin(long joinId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.fetchLMSBookJoin(joinId);
	}

	/**
	* Returns the l m s book join with the primary key.
	*
	* @param joinId the primary key of the l m s book join
	* @return the l m s book join
	* @throws PortalException if a l m s book join with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBookJoin getLMSBookJoin(long joinId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.getLMSBookJoin(joinId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<com.library.slayer.model.LMSBookJoin> getLMSBookJoins(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.getLMSBookJoins(start, end);
	}

	/**
	* Returns the number of l m s book joins.
	*
	* @return the number of l m s book joins
	* @throws SystemException if a system exception occurred
	*/
	public int getLMSBookJoinsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.getLMSBookJoinsCount();
	}

	/**
	* Updates the l m s book join in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsBookJoin the l m s book join
	* @return the l m s book join that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBookJoin updateLMSBookJoin(
		com.library.slayer.model.LMSBookJoin lmsBookJoin)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.updateLMSBookJoin(lmsBookJoin);
	}

	/**
	* Updates the l m s book join in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsBookJoin the l m s book join
	* @param merge whether to merge the l m s book join with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the l m s book join that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBookJoin updateLMSBookJoin(
		com.library.slayer.model.LMSBookJoin lmsBookJoin, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoinLocalService.updateLMSBookJoin(lmsBookJoin, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lmsBookJoinLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lmsBookJoinLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LMSBookJoinLocalService getWrappedLMSBookJoinLocalService() {
		return _lmsBookJoinLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLMSBookJoinLocalService(
		LMSBookJoinLocalService lmsBookJoinLocalService) {
		_lmsBookJoinLocalService = lmsBookJoinLocalService;
	}

	public LMSBookJoinLocalService getWrappedService() {
		return _lmsBookJoinLocalService;
	}

	public void setWrappedService(
		LMSBookJoinLocalService lmsBookJoinLocalService) {
		_lmsBookJoinLocalService = lmsBookJoinLocalService;
	}

	private LMSBookJoinLocalService _lmsBookJoinLocalService;
}
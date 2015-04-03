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

package com.slayer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingCartExtLocalService}.
 * </p>
 *
 * @author    ahmedhasan
 * @see       ShoppingCartExtLocalService
 * @generated
 */
public class ShoppingCartExtLocalServiceWrapper
	implements ShoppingCartExtLocalService,
		ServiceWrapper<ShoppingCartExtLocalService> {
	public ShoppingCartExtLocalServiceWrapper(
		ShoppingCartExtLocalService shoppingCartExtLocalService) {
		_shoppingCartExtLocalService = shoppingCartExtLocalService;
	}

	/**
	* Adds the shopping cart ext to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCartExt the shopping cart ext
	* @return the shopping cart ext that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCartExt addShoppingCartExt(
		com.slayer.model.ShoppingCartExt shoppingCartExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCartExtLocalService.addShoppingCartExt(shoppingCartExt);
	}

	/**
	* Creates a new shopping cart ext with the primary key. Does not add the shopping cart ext to the database.
	*
	* @param recId the primary key for the new shopping cart ext
	* @return the new shopping cart ext
	*/
	public com.slayer.model.ShoppingCartExt createShoppingCartExt(long recId) {
		return _shoppingCartExtLocalService.createShoppingCartExt(recId);
	}

	/**
	* Deletes the shopping cart ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recId the primary key of the shopping cart ext
	* @throws PortalException if a shopping cart ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCartExt(long recId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCartExtLocalService.deleteShoppingCartExt(recId);
	}

	/**
	* Deletes the shopping cart ext from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCartExt the shopping cart ext
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCartExt(
		com.slayer.model.ShoppingCartExt shoppingCartExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCartExtLocalService.deleteShoppingCartExt(shoppingCartExt);
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
		return _shoppingCartExtLocalService.dynamicQuery(dynamicQuery);
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
		return _shoppingCartExtLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _shoppingCartExtLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _shoppingCartExtLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.slayer.model.ShoppingCartExt fetchShoppingCartExt(long recId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCartExtLocalService.fetchShoppingCartExt(recId);
	}

	/**
	* Returns the shopping cart ext with the primary key.
	*
	* @param recId the primary key of the shopping cart ext
	* @return the shopping cart ext
	* @throws PortalException if a shopping cart ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCartExt getShoppingCartExt(long recId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCartExtLocalService.getShoppingCartExt(recId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCartExtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the shopping cart exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping cart exts
	* @param end the upper bound of the range of shopping cart exts (not inclusive)
	* @return the range of shopping cart exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.ShoppingCartExt> getShoppingCartExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCartExtLocalService.getShoppingCartExts(start, end);
	}

	/**
	* Returns the number of shopping cart exts.
	*
	* @return the number of shopping cart exts
	* @throws SystemException if a system exception occurred
	*/
	public int getShoppingCartExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCartExtLocalService.getShoppingCartExtsCount();
	}

	/**
	* Updates the shopping cart ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingCartExt the shopping cart ext
	* @return the shopping cart ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCartExt updateShoppingCartExt(
		com.slayer.model.ShoppingCartExt shoppingCartExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCartExtLocalService.updateShoppingCartExt(shoppingCartExt);
	}

	/**
	* Updates the shopping cart ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingCartExt the shopping cart ext
	* @param merge whether to merge the shopping cart ext with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping cart ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCartExt updateShoppingCartExt(
		com.slayer.model.ShoppingCartExt shoppingCartExt, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCartExtLocalService.updateShoppingCartExt(shoppingCartExt,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _shoppingCartExtLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_shoppingCartExtLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ShoppingCartExtLocalService getWrappedShoppingCartExtLocalService() {
		return _shoppingCartExtLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedShoppingCartExtLocalService(
		ShoppingCartExtLocalService shoppingCartExtLocalService) {
		_shoppingCartExtLocalService = shoppingCartExtLocalService;
	}

	public ShoppingCartExtLocalService getWrappedService() {
		return _shoppingCartExtLocalService;
	}

	public void setWrappedService(
		ShoppingCartExtLocalService shoppingCartExtLocalService) {
		_shoppingCartExtLocalService = shoppingCartExtLocalService;
	}

	private ShoppingCartExtLocalService _shoppingCartExtLocalService;
}
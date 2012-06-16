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
 * This class is a wrapper for {@link ShoppingCategoryExtLocalService}.
 * </p>
 *
 * @author    ahmedhasan
 * @see       ShoppingCategoryExtLocalService
 * @generated
 */
public class ShoppingCategoryExtLocalServiceWrapper
	implements ShoppingCategoryExtLocalService,
		ServiceWrapper<ShoppingCategoryExtLocalService> {
	public ShoppingCategoryExtLocalServiceWrapper(
		ShoppingCategoryExtLocalService shoppingCategoryExtLocalService) {
		_shoppingCategoryExtLocalService = shoppingCategoryExtLocalService;
	}

	/**
	* Adds the shopping category ext to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryExt the shopping category ext
	* @return the shopping category ext that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCategoryExt addShoppingCategoryExt(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryExtLocalService.addShoppingCategoryExt(shoppingCategoryExt);
	}

	/**
	* Creates a new shopping category ext with the primary key. Does not add the shopping category ext to the database.
	*
	* @param categoryId the primary key for the new shopping category ext
	* @return the new shopping category ext
	*/
	public com.slayer.model.ShoppingCategoryExt createShoppingCategoryExt(
		long categoryId) {
		return _shoppingCategoryExtLocalService.createShoppingCategoryExt(categoryId);
	}

	/**
	* Deletes the shopping category ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the shopping category ext
	* @throws PortalException if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCategoryExt(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryExtLocalService.deleteShoppingCategoryExt(categoryId);
	}

	/**
	* Deletes the shopping category ext from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryExt the shopping category ext
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCategoryExt(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryExtLocalService.deleteShoppingCategoryExt(shoppingCategoryExt);
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
		return _shoppingCategoryExtLocalService.dynamicQuery(dynamicQuery);
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
		return _shoppingCategoryExtLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _shoppingCategoryExtLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _shoppingCategoryExtLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.slayer.model.ShoppingCategoryExt fetchShoppingCategoryExt(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryExtLocalService.fetchShoppingCategoryExt(categoryId);
	}

	/**
	* Returns the shopping category ext with the primary key.
	*
	* @param categoryId the primary key of the shopping category ext
	* @return the shopping category ext
	* @throws PortalException if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCategoryExt getShoppingCategoryExt(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryExtLocalService.getShoppingCategoryExt(categoryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryExtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the shopping category exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping category exts
	* @param end the upper bound of the range of shopping category exts (not inclusive)
	* @return the range of shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.ShoppingCategoryExt> getShoppingCategoryExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryExtLocalService.getShoppingCategoryExts(start,
			end);
	}

	/**
	* Returns the number of shopping category exts.
	*
	* @return the number of shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public int getShoppingCategoryExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryExtLocalService.getShoppingCategoryExtsCount();
	}

	/**
	* Updates the shopping category ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryExt the shopping category ext
	* @return the shopping category ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCategoryExt updateShoppingCategoryExt(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryExtLocalService.updateShoppingCategoryExt(shoppingCategoryExt);
	}

	/**
	* Updates the shopping category ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryExt the shopping category ext
	* @param merge whether to merge the shopping category ext with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping category ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.ShoppingCategoryExt updateShoppingCategoryExt(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryExtLocalService.updateShoppingCategoryExt(shoppingCategoryExt,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _shoppingCategoryExtLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_shoppingCategoryExtLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ShoppingCategoryExtLocalService getWrappedShoppingCategoryExtLocalService() {
		return _shoppingCategoryExtLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedShoppingCategoryExtLocalService(
		ShoppingCategoryExtLocalService shoppingCategoryExtLocalService) {
		_shoppingCategoryExtLocalService = shoppingCategoryExtLocalService;
	}

	public ShoppingCategoryExtLocalService getWrappedService() {
		return _shoppingCategoryExtLocalService;
	}

	public void setWrappedService(
		ShoppingCategoryExtLocalService shoppingCategoryExtLocalService) {
		_shoppingCategoryExtLocalService = shoppingCategoryExtLocalService;
	}

	private ShoppingCategoryExtLocalService _shoppingCategoryExtLocalService;
}
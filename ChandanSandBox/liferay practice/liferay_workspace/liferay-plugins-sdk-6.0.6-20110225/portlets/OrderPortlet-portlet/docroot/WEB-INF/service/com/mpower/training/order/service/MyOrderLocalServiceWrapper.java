/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.mpower.training.order.service;

/**
 * <p>
 * This class is a wrapper for {@link MyOrderLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MyOrderLocalService
 * @generated
 */
public class MyOrderLocalServiceWrapper implements MyOrderLocalService {
	public MyOrderLocalServiceWrapper(MyOrderLocalService myOrderLocalService) {
		_myOrderLocalService = myOrderLocalService;
	}

	/**
	* Adds the my order to the database. Also notifies the appropriate model listeners.
	*
	* @param myOrder the my order to add
	* @return the my order that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder addMyOrder(
		com.mpower.training.order.model.MyOrder myOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myOrderLocalService.addMyOrder(myOrder);
	}

	/**
	* Creates a new my order with the primary key. Does not add the my order to the database.
	*
	* @param id the primary key for the new my order
	* @return the new my order
	*/
	public com.mpower.training.order.model.MyOrder createMyOrder(long id) {
		return _myOrderLocalService.createMyOrder(id);
	}

	/**
	* Deletes the my order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the my order to delete
	* @throws PortalException if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMyOrder(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_myOrderLocalService.deleteMyOrder(id);
	}

	/**
	* Deletes the my order from the database. Also notifies the appropriate model listeners.
	*
	* @param myOrder the my order to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMyOrder(com.mpower.training.order.model.MyOrder myOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		_myOrderLocalService.deleteMyOrder(myOrder);
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
		return _myOrderLocalService.dynamicQuery(dynamicQuery);
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
		return _myOrderLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _myOrderLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _myOrderLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the my order with the primary key.
	*
	* @param id the primary key of the my order to get
	* @return the my order
	* @throws PortalException if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder getMyOrder(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myOrderLocalService.getMyOrder(id);
	}

	/**
	* Gets a range of all the my orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of my orders to return
	* @param end the upper bound of the range of my orders to return (not inclusive)
	* @return the range of my orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.training.order.model.MyOrder> getMyOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myOrderLocalService.getMyOrders(start, end);
	}

	/**
	* Gets the number of my orders.
	*
	* @return the number of my orders
	* @throws SystemException if a system exception occurred
	*/
	public int getMyOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myOrderLocalService.getMyOrdersCount();
	}

	/**
	* Updates the my order in the database. Also notifies the appropriate model listeners.
	*
	* @param myOrder the my order to update
	* @return the my order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder updateMyOrder(
		com.mpower.training.order.model.MyOrder myOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myOrderLocalService.updateMyOrder(myOrder);
	}

	/**
	* Updates the my order in the database. Also notifies the appropriate model listeners.
	*
	* @param myOrder the my order to update
	* @param merge whether to merge the my order with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the my order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder updateMyOrder(
		com.mpower.training.order.model.MyOrder myOrder, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myOrderLocalService.updateMyOrder(myOrder, merge);
	}

	public MyOrderLocalService getWrappedMyOrderLocalService() {
		return _myOrderLocalService;
	}

	private MyOrderLocalService _myOrderLocalService;
}
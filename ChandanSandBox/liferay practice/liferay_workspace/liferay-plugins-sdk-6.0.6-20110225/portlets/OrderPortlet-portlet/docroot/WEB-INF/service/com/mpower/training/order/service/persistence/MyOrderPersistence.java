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

package com.mpower.training.order.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.mpower.training.order.model.MyOrder;

/**
 * The persistence interface for the my order service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link MyOrderUtil} to access the my order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyOrderPersistenceImpl
 * @see MyOrderUtil
 * @generated
 */
public interface MyOrderPersistence extends BasePersistence<MyOrder> {
	/**
	* Caches the my order in the entity cache if it is enabled.
	*
	* @param myOrder the my order to cache
	*/
	public void cacheResult(com.mpower.training.order.model.MyOrder myOrder);

	/**
	* Caches the my orders in the entity cache if it is enabled.
	*
	* @param myOrders the my orders to cache
	*/
	public void cacheResult(
		java.util.List<com.mpower.training.order.model.MyOrder> myOrders);

	/**
	* Creates a new my order with the primary key. Does not add the my order to the database.
	*
	* @param id the primary key for the new my order
	* @return the new my order
	*/
	public com.mpower.training.order.model.MyOrder create(long id);

	/**
	* Removes the my order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the my order to remove
	* @return the my order that was removed
	* @throws com.mpower.training.order.NoSuchMyOrderException if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException;

	public com.mpower.training.order.model.MyOrder updateImpl(
		com.mpower.training.order.model.MyOrder myOrder, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my order with the primary key or throws a {@link com.mpower.training.order.NoSuchMyOrderException} if it could not be found.
	*
	* @param id the primary key of the my order to find
	* @return the my order
	* @throws com.mpower.training.order.NoSuchMyOrderException if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException;

	/**
	* Finds the my order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the my order to find
	* @return the my order, or <code>null</code> if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my order where name = &#63; or throws a {@link com.mpower.training.order.NoSuchMyOrderException} if it could not be found.
	*
	* @param name the name to search with
	* @return the matching my order
	* @throws com.mpower.training.order.NoSuchMyOrderException if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException;

	/**
	* Finds the my order where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @return the matching my order, or <code>null</code> if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my order where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @return the matching my order, or <code>null</code> if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my order where id = &#63; and name = &#63; or throws a {@link com.mpower.training.order.NoSuchMyOrderException} if it could not be found.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @return the matching my order
	* @throws com.mpower.training.order.NoSuchMyOrderException if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder findByIdAndName(long id,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException;

	/**
	* Finds the my order where id = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @return the matching my order, or <code>null</code> if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder fetchByIdAndName(long id,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my order where id = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @return the matching my order, or <code>null</code> if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.order.model.MyOrder fetchByIdAndName(long id,
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the my orders.
	*
	* @return the my orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.training.order.model.MyOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the my orders.
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
	public java.util.List<com.mpower.training.order.model.MyOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the my orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of my orders to return
	* @param end the upper bound of the range of my orders to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of my orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.training.order.model.MyOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the my order where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException;

	/**
	* Removes the my order where id = &#63; and name = &#63; from the database.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIdAndName(long id, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException;

	/**
	* Removes all the my orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the my orders where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching my orders
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the my orders where id = &#63; and name = &#63;.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @return the number of matching my orders
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdAndName(long id, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the my orders.
	*
	* @return the number of my orders
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
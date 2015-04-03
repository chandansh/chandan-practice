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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import com.mpower.training.order.model.MyOrder;

import java.util.List;

/**
 * The persistence utility for the my order service. This utility wraps {@link MyOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyOrderPersistence
 * @see MyOrderPersistenceImpl
 * @generated
 */
public class MyOrderUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(MyOrder myOrder) {
		getPersistence().clearCache(myOrder);
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
	public static List<MyOrder> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MyOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MyOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static MyOrder remove(MyOrder myOrder) throws SystemException {
		return getPersistence().remove(myOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static MyOrder update(MyOrder myOrder, boolean merge)
		throws SystemException {
		return getPersistence().update(myOrder, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static MyOrder update(MyOrder myOrder, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(myOrder, merge, serviceContext);
	}

	/**
	* Caches the my order in the entity cache if it is enabled.
	*
	* @param myOrder the my order to cache
	*/
	public static void cacheResult(
		com.mpower.training.order.model.MyOrder myOrder) {
		getPersistence().cacheResult(myOrder);
	}

	/**
	* Caches the my orders in the entity cache if it is enabled.
	*
	* @param myOrders the my orders to cache
	*/
	public static void cacheResult(
		java.util.List<com.mpower.training.order.model.MyOrder> myOrders) {
		getPersistence().cacheResult(myOrders);
	}

	/**
	* Creates a new my order with the primary key. Does not add the my order to the database.
	*
	* @param id the primary key for the new my order
	* @return the new my order
	*/
	public static com.mpower.training.order.model.MyOrder create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the my order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the my order to remove
	* @return the my order that was removed
	* @throws com.mpower.training.order.NoSuchMyOrderException if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException {
		return getPersistence().remove(id);
	}

	public static com.mpower.training.order.model.MyOrder updateImpl(
		com.mpower.training.order.model.MyOrder myOrder, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(myOrder, merge);
	}

	/**
	* Finds the my order with the primary key or throws a {@link com.mpower.training.order.NoSuchMyOrderException} if it could not be found.
	*
	* @param id the primary key of the my order to find
	* @return the my order
	* @throws com.mpower.training.order.NoSuchMyOrderException if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Finds the my order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the my order to find
	* @return the my order, or <code>null</code> if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Finds the my order where name = &#63; or throws a {@link com.mpower.training.order.NoSuchMyOrderException} if it could not be found.
	*
	* @param name the name to search with
	* @return the matching my order
	* @throws com.mpower.training.order.NoSuchMyOrderException if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException {
		return getPersistence().findByName(name);
	}

	/**
	* Finds the my order where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @return the matching my order, or <code>null</code> if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Finds the my order where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @return the matching my order, or <code>null</code> if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Finds the my order where id = &#63; and name = &#63; or throws a {@link com.mpower.training.order.NoSuchMyOrderException} if it could not be found.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @return the matching my order
	* @throws com.mpower.training.order.NoSuchMyOrderException if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder findByIdAndName(
		long id, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException {
		return getPersistence().findByIdAndName(id, name);
	}

	/**
	* Finds the my order where id = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @return the matching my order, or <code>null</code> if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder fetchByIdAndName(
		long id, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdAndName(id, name);
	}

	/**
	* Finds the my order where id = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @return the matching my order, or <code>null</code> if a matching my order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder fetchByIdAndName(
		long id, java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIdAndName(id, name, retrieveFromCache);
	}

	/**
	* Finds all the my orders.
	*
	* @return the my orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.training.order.model.MyOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.mpower.training.order.model.MyOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.mpower.training.order.model.MyOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the my order where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException {
		getPersistence().removeByName(name);
	}

	/**
	* Removes the my order where id = &#63; and name = &#63; from the database.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIdAndName(long id, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.order.NoSuchMyOrderException {
		getPersistence().removeByIdAndName(id, name);
	}

	/**
	* Removes all the my orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the my orders where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching my orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Counts all the my orders where id = &#63; and name = &#63;.
	*
	* @param id the id to search with
	* @param name the name to search with
	* @return the number of matching my orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIdAndName(long id, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIdAndName(id, name);
	}

	/**
	* Counts all the my orders.
	*
	* @return the number of my orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MyOrderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MyOrderPersistence)PortletBeanLocatorUtil.locate(com.mpower.training.order.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					MyOrderPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(MyOrderPersistence persistence) {
		_persistence = persistence;
	}

	private static MyOrderPersistence _persistence;
}
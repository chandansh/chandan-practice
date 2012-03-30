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

package com.mpower.training.customer.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import com.mpower.training.customer.model.MyCustomer;

import java.util.List;

/**
 * The persistence utility for the my customer service. This utility wraps {@link MyCustomerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see MyCustomerPersistence
 * @see MyCustomerPersistenceImpl
 * @generated
 */
public class MyCustomerUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(MyCustomer myCustomer) {
		getPersistence().clearCache(myCustomer);
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
	public static List<MyCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MyCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MyCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static MyCustomer remove(MyCustomer myCustomer)
		throws SystemException {
		return getPersistence().remove(myCustomer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static MyCustomer update(MyCustomer myCustomer, boolean merge)
		throws SystemException {
		return getPersistence().update(myCustomer, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static MyCustomer update(MyCustomer myCustomer, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(myCustomer, merge, serviceContext);
	}

	/**
	* Caches the my customer in the entity cache if it is enabled.
	*
	* @param myCustomer the my customer to cache
	*/
	public static void cacheResult(
		com.mpower.training.customer.model.MyCustomer myCustomer) {
		getPersistence().cacheResult(myCustomer);
	}

	/**
	* Caches the my customers in the entity cache if it is enabled.
	*
	* @param myCustomers the my customers to cache
	*/
	public static void cacheResult(
		java.util.List<com.mpower.training.customer.model.MyCustomer> myCustomers) {
		getPersistence().cacheResult(myCustomers);
	}

	/**
	* Creates a new my customer with the primary key. Does not add the my customer to the database.
	*
	* @param id the primary key for the new my customer
	* @return the new my customer
	*/
	public static com.mpower.training.customer.model.MyCustomer create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the my customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the my customer to remove
	* @return the my customer that was removed
	* @throws com.mpower.training.customer.NoSuchMyCustomerException if a my customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException {
		return getPersistence().remove(id);
	}

	public static com.mpower.training.customer.model.MyCustomer updateImpl(
		com.mpower.training.customer.model.MyCustomer myCustomer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(myCustomer, merge);
	}

	/**
	* Finds the my customer with the primary key or throws a {@link com.mpower.training.customer.NoSuchMyCustomerException} if it could not be found.
	*
	* @param id the primary key of the my customer to find
	* @return the my customer
	* @throws com.mpower.training.customer.NoSuchMyCustomerException if a my customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Finds the my customer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the my customer to find
	* @return the my customer, or <code>null</code> if a my customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Finds the my customer where name = &#63; or throws a {@link com.mpower.training.customer.NoSuchMyCustomerException} if it could not be found.
	*
	* @param name the name to search with
	* @return the matching my customer
	* @throws com.mpower.training.customer.NoSuchMyCustomerException if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException {
		return getPersistence().findByName(name);
	}

	/**
	* Finds the my customer where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Finds the my customer where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Finds the my customer where name = &#63; and address = &#63; or throws a {@link com.mpower.training.customer.NoSuchMyCustomerException} if it could not be found.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the matching my customer
	* @throws com.mpower.training.customer.NoSuchMyCustomerException if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer findByNameAndAddress(
		java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException {
		return getPersistence().findByNameAndAddress(name, address);
	}

	/**
	* Finds the my customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer fetchByNameAndAddress(
		java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameAndAddress(name, address);
	}

	/**
	* Finds the my customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer fetchByNameAndAddress(
		java.lang.String name, java.lang.String address,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndAddress(name, address, retrieveFromCache);
	}

	/**
	* Finds all the my customers.
	*
	* @return the my customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.training.customer.model.MyCustomer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the my customers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of my customers to return
	* @param end the upper bound of the range of my customers to return (not inclusive)
	* @return the range of my customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.training.customer.model.MyCustomer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the my customers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of my customers to return
	* @param end the upper bound of the range of my customers to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of my customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.mpower.training.customer.model.MyCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the my customer where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException {
		getPersistence().removeByName(name);
	}

	/**
	* Removes the my customer where name = &#63; and address = &#63; from the database.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNameAndAddress(java.lang.String name,
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException {
		getPersistence().removeByNameAndAddress(name, address);
	}

	/**
	* Removes all the my customers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the my customers where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching my customers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Counts all the my customers where name = &#63; and address = &#63;.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the number of matching my customers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndAddress(java.lang.String name,
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndAddress(name, address);
	}

	/**
	* Counts all the my customers.
	*
	* @return the number of my customers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MyCustomerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MyCustomerPersistence)PortletBeanLocatorUtil.locate(com.mpower.training.customer.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					MyCustomerPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(MyCustomerPersistence persistence) {
		_persistence = persistence;
	}

	private static MyCustomerPersistence _persistence;
}
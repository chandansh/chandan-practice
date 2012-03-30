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

import com.liferay.portal.service.persistence.BasePersistence;

import com.mpower.training.customer.model.MyCustomer;

/**
 * The persistence interface for the my customer service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link MyCustomerUtil} to access the my customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyCustomerPersistenceImpl
 * @see MyCustomerUtil
 * @generated
 */
public interface MyCustomerPersistence extends BasePersistence<MyCustomer> {
	/**
	* Caches the my customer in the entity cache if it is enabled.
	*
	* @param myCustomer the my customer to cache
	*/
	public void cacheResult(
		com.mpower.training.customer.model.MyCustomer myCustomer);

	/**
	* Caches the my customers in the entity cache if it is enabled.
	*
	* @param myCustomers the my customers to cache
	*/
	public void cacheResult(
		java.util.List<com.mpower.training.customer.model.MyCustomer> myCustomers);

	/**
	* Creates a new my customer with the primary key. Does not add the my customer to the database.
	*
	* @param id the primary key for the new my customer
	* @return the new my customer
	*/
	public com.mpower.training.customer.model.MyCustomer create(long id);

	/**
	* Removes the my customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the my customer to remove
	* @return the my customer that was removed
	* @throws com.mpower.training.customer.NoSuchMyCustomerException if a my customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.customer.model.MyCustomer remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException;

	public com.mpower.training.customer.model.MyCustomer updateImpl(
		com.mpower.training.customer.model.MyCustomer myCustomer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my customer with the primary key or throws a {@link com.mpower.training.customer.NoSuchMyCustomerException} if it could not be found.
	*
	* @param id the primary key of the my customer to find
	* @return the my customer
	* @throws com.mpower.training.customer.NoSuchMyCustomerException if a my customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.customer.model.MyCustomer findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException;

	/**
	* Finds the my customer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the my customer to find
	* @return the my customer, or <code>null</code> if a my customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.customer.model.MyCustomer fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my customer where name = &#63; or throws a {@link com.mpower.training.customer.NoSuchMyCustomerException} if it could not be found.
	*
	* @param name the name to search with
	* @return the matching my customer
	* @throws com.mpower.training.customer.NoSuchMyCustomerException if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.customer.model.MyCustomer findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException;

	/**
	* Finds the my customer where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.customer.model.MyCustomer fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my customer where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.customer.model.MyCustomer fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my customer where name = &#63; and address = &#63; or throws a {@link com.mpower.training.customer.NoSuchMyCustomerException} if it could not be found.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the matching my customer
	* @throws com.mpower.training.customer.NoSuchMyCustomerException if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.customer.model.MyCustomer findByNameAndAddress(
		java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException;

	/**
	* Finds the my customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.customer.model.MyCustomer fetchByNameAndAddress(
		java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the my customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the matching my customer, or <code>null</code> if a matching my customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.training.customer.model.MyCustomer fetchByNameAndAddress(
		java.lang.String name, java.lang.String address,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the my customers.
	*
	* @return the my customers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.training.customer.model.MyCustomer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.mpower.training.customer.model.MyCustomer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.mpower.training.customer.model.MyCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the my customer where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException;

	/**
	* Removes the my customer where name = &#63; and address = &#63; from the database.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNameAndAddress(java.lang.String name,
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.training.customer.NoSuchMyCustomerException;

	/**
	* Removes all the my customers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the my customers where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching my customers
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the my customers where name = &#63; and address = &#63;.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the number of matching my customers
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameAndAddress(java.lang.String name,
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the my customers.
	*
	* @return the number of my customers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
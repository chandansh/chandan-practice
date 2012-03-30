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

package com.mpoer.training.customer.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.mpoer.training.customer.model.Customer;

/**
 * The persistence interface for the customer service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link CustomerUtil} to access the customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerPersistenceImpl
 * @see CustomerUtil
 * @generated
 */
public interface CustomerPersistence extends BasePersistence<Customer> {
	/**
	* Caches the customer in the entity cache if it is enabled.
	*
	* @param customer the customer to cache
	*/
	public void cacheResult(com.mpoer.training.customer.model.Customer customer);

	/**
	* Caches the customers in the entity cache if it is enabled.
	*
	* @param customers the customers to cache
	*/
	public void cacheResult(
		java.util.List<com.mpoer.training.customer.model.Customer> customers);

	/**
	* Creates a new customer with the primary key. Does not add the customer to the database.
	*
	* @param id the primary key for the new customer
	* @return the new customer
	*/
	public com.mpoer.training.customer.model.Customer create(long id);

	/**
	* Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the customer to remove
	* @return the customer that was removed
	* @throws com.mpoer.training.customer.NoSuchCustomerException if a customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpoer.training.customer.NoSuchCustomerException;

	public com.mpoer.training.customer.model.Customer updateImpl(
		com.mpoer.training.customer.model.Customer customer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the customer with the primary key or throws a {@link com.mpoer.training.customer.NoSuchCustomerException} if it could not be found.
	*
	* @param id the primary key of the customer to find
	* @return the customer
	* @throws com.mpoer.training.customer.NoSuchCustomerException if a customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpoer.training.customer.NoSuchCustomerException;

	/**
	* Finds the customer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the customer to find
	* @return the customer, or <code>null</code> if a customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the customer where name = &#63; or throws a {@link com.mpoer.training.customer.NoSuchCustomerException} if it could not be found.
	*
	* @param name the name to search with
	* @return the matching customer
	* @throws com.mpoer.training.customer.NoSuchCustomerException if a matching customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpoer.training.customer.NoSuchCustomerException;

	/**
	* Finds the customer where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @return the matching customer, or <code>null</code> if a matching customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the customer where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @return the matching customer, or <code>null</code> if a matching customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the customer where name = &#63; and address = &#63; or throws a {@link com.mpoer.training.customer.NoSuchCustomerException} if it could not be found.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the matching customer
	* @throws com.mpoer.training.customer.NoSuchCustomerException if a matching customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer findByNameAndAddress(
		java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpoer.training.customer.NoSuchCustomerException;

	/**
	* Finds the customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the matching customer, or <code>null</code> if a matching customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer fetchByNameAndAddress(
		java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the customer where name = &#63; and address = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the matching customer, or <code>null</code> if a matching customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer fetchByNameAndAddress(
		java.lang.String name, java.lang.String address,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the customers.
	*
	* @return the customers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpoer.training.customer.model.Customer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the customers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of customers to return
	* @param end the upper bound of the range of customers to return (not inclusive)
	* @return the range of customers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpoer.training.customer.model.Customer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the customers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of customers to return
	* @param end the upper bound of the range of customers to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of customers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpoer.training.customer.model.Customer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the customer where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpoer.training.customer.NoSuchCustomerException;

	/**
	* Removes the customer where name = &#63; and address = &#63; from the database.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNameAndAddress(java.lang.String name,
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpoer.training.customer.NoSuchCustomerException;

	/**
	* Removes all the customers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the customers where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching customers
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the customers where name = &#63; and address = &#63;.
	*
	* @param name the name to search with
	* @param address the address to search with
	* @return the number of matching customers
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameAndAddress(java.lang.String name,
		java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the customers.
	*
	* @return the number of customers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
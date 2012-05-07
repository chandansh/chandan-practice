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

package com.coleg.service.persistence;

import com.coleg.model.Customer;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the customer service. This utility wraps {@link CustomerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author supriya
 * @see CustomerPersistence
 * @see CustomerPersistenceImpl
 * @generated
 */
public class CustomerUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Customer customer) {
		getPersistence().clearCache(customer);
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
	public static List<Customer> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Customer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Customer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Customer remove(Customer customer) throws SystemException {
		return getPersistence().remove(customer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Customer update(Customer customer, boolean merge)
		throws SystemException {
		return getPersistence().update(customer, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Customer update(Customer customer, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(customer, merge, serviceContext);
	}

	/**
	* Caches the customer in the entity cache if it is enabled.
	*
	* @param customer the customer to cache
	*/
	public static void cacheResult(com.coleg.model.Customer customer) {
		getPersistence().cacheResult(customer);
	}

	/**
	* Caches the customers in the entity cache if it is enabled.
	*
	* @param customers the customers to cache
	*/
	public static void cacheResult(
		java.util.List<com.coleg.model.Customer> customers) {
		getPersistence().cacheResult(customers);
	}

	/**
	* Creates a new customer with the primary key. Does not add the customer to the database.
	*
	* @param id the primary key for the new customer
	* @return the new customer
	*/
	public static com.coleg.model.Customer create(java.lang.String id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the customer to remove
	* @return the customer that was removed
	* @throws com.coleg.NoSuchCustomerException if a customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Customer remove(java.lang.String id)
		throws com.coleg.NoSuchCustomerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.coleg.model.Customer updateImpl(
		com.coleg.model.Customer customer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(customer, merge);
	}

	/**
	* Finds the customer with the primary key or throws a {@link com.coleg.NoSuchCustomerException} if it could not be found.
	*
	* @param id the primary key of the customer to find
	* @return the customer
	* @throws com.coleg.NoSuchCustomerException if a customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Customer findByPrimaryKey(java.lang.String id)
		throws com.coleg.NoSuchCustomerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Finds the customer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the customer to find
	* @return the customer, or <code>null</code> if a customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.coleg.model.Customer fetchByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Finds all the customers.
	*
	* @return the customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.coleg.model.Customer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.coleg.model.Customer> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.coleg.model.Customer> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the customers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the customers.
	*
	* @return the number of customers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CustomerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CustomerPersistence)PortletBeanLocatorUtil.locate(com.coleg.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					CustomerPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(CustomerPersistence persistence) {
		_persistence = persistence;
	}

	private static CustomerPersistence _persistence;
}
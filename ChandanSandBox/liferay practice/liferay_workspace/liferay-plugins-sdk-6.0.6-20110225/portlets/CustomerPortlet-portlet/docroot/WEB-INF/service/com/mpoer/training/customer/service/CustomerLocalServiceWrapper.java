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

package com.mpoer.training.customer.service;

/**
 * <p>
 * This class is a wrapper for {@link CustomerLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CustomerLocalService
 * @generated
 */
public class CustomerLocalServiceWrapper implements CustomerLocalService {
	public CustomerLocalServiceWrapper(
		CustomerLocalService customerLocalService) {
		_customerLocalService = customerLocalService;
	}

	/**
	* Adds the customer to the database. Also notifies the appropriate model listeners.
	*
	* @param customer the customer to add
	* @return the customer that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer addCustomer(
		com.mpoer.training.customer.model.Customer customer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerLocalService.addCustomer(customer);
	}

	/**
	* Creates a new customer with the primary key. Does not add the customer to the database.
	*
	* @param id the primary key for the new customer
	* @return the new customer
	*/
	public com.mpoer.training.customer.model.Customer createCustomer(long id) {
		return _customerLocalService.createCustomer(id);
	}

	/**
	* Deletes the customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the customer to delete
	* @throws PortalException if a customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCustomer(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_customerLocalService.deleteCustomer(id);
	}

	/**
	* Deletes the customer from the database. Also notifies the appropriate model listeners.
	*
	* @param customer the customer to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCustomer(
		com.mpoer.training.customer.model.Customer customer)
		throws com.liferay.portal.kernel.exception.SystemException {
		_customerLocalService.deleteCustomer(customer);
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
		return _customerLocalService.dynamicQuery(dynamicQuery);
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
		return _customerLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _customerLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _customerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the customer with the primary key.
	*
	* @param id the primary key of the customer to get
	* @return the customer
	* @throws PortalException if a customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer getCustomer(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _customerLocalService.getCustomer(id);
	}

	/**
	* Gets a range of all the customers.
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
	public java.util.List<com.mpoer.training.customer.model.Customer> getCustomers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerLocalService.getCustomers(start, end);
	}

	/**
	* Gets the number of customers.
	*
	* @return the number of customers
	* @throws SystemException if a system exception occurred
	*/
	public int getCustomersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerLocalService.getCustomersCount();
	}

	/**
	* Updates the customer in the database. Also notifies the appropriate model listeners.
	*
	* @param customer the customer to update
	* @return the customer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer updateCustomer(
		com.mpoer.training.customer.model.Customer customer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerLocalService.updateCustomer(customer);
	}

	/**
	* Updates the customer in the database. Also notifies the appropriate model listeners.
	*
	* @param customer the customer to update
	* @param merge whether to merge the customer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the customer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.mpoer.training.customer.model.Customer updateCustomer(
		com.mpoer.training.customer.model.Customer customer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerLocalService.updateCustomer(customer, merge);
	}

	public void deactivateCustomer(long id) {
		_customerLocalService.deactivateCustomer(id);
	}

	public com.mpoer.training.customer.model.Customer findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpoer.training.customer.NoSuchCustomerException {
		return _customerLocalService.findByName(name);
	}

	public com.mpoer.training.customer.model.Customer findByNameAndAddress(
		java.lang.String name, java.lang.String address)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _customerLocalService.findByNameAndAddress(name, address);
	}

	public CustomerLocalService getWrappedCustomerLocalService() {
		return _customerLocalService;
	}

	private CustomerLocalService _customerLocalService;
}
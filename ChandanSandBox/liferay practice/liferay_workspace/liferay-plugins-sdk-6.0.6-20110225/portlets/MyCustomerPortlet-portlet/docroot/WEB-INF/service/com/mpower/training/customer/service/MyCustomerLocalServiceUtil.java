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

package com.mpower.training.customer.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the my customer local service. This utility wraps {@link com.mpower.training.customer.service.impl.MyCustomerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.mpower.training.customer.service.impl.MyCustomerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyCustomerLocalService
 * @see com.mpower.training.customer.service.base.MyCustomerLocalServiceBaseImpl
 * @see com.mpower.training.customer.service.impl.MyCustomerLocalServiceImpl
 * @generated
 */
public class MyCustomerLocalServiceUtil {
	/**
	* Adds the my customer to the database. Also notifies the appropriate model listeners.
	*
	* @param myCustomer the my customer to add
	* @return the my customer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer addMyCustomer(
		com.mpower.training.customer.model.MyCustomer myCustomer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMyCustomer(myCustomer);
	}

	/**
	* Creates a new my customer with the primary key. Does not add the my customer to the database.
	*
	* @param id the primary key for the new my customer
	* @return the new my customer
	*/
	public static com.mpower.training.customer.model.MyCustomer createMyCustomer(
		long id) {
		return getService().createMyCustomer(id);
	}

	/**
	* Deletes the my customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the my customer to delete
	* @throws PortalException if a my customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMyCustomer(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMyCustomer(id);
	}

	/**
	* Deletes the my customer from the database. Also notifies the appropriate model listeners.
	*
	* @param myCustomer the my customer to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMyCustomer(
		com.mpower.training.customer.model.MyCustomer myCustomer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMyCustomer(myCustomer);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the my customer with the primary key.
	*
	* @param id the primary key of the my customer to get
	* @return the my customer
	* @throws PortalException if a my customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer getMyCustomer(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyCustomer(id);
	}

	/**
	* Gets a range of all the my customers.
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
	public static java.util.List<com.mpower.training.customer.model.MyCustomer> getMyCustomers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyCustomers(start, end);
	}

	/**
	* Gets the number of my customers.
	*
	* @return the number of my customers
	* @throws SystemException if a system exception occurred
	*/
	public static int getMyCustomersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyCustomersCount();
	}

	/**
	* Updates the my customer in the database. Also notifies the appropriate model listeners.
	*
	* @param myCustomer the my customer to update
	* @return the my customer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer updateMyCustomer(
		com.mpower.training.customer.model.MyCustomer myCustomer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMyCustomer(myCustomer);
	}

	/**
	* Updates the my customer in the database. Also notifies the appropriate model listeners.
	*
	* @param myCustomer the my customer to update
	* @param merge whether to merge the my customer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the my customer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.customer.model.MyCustomer updateMyCustomer(
		com.mpower.training.customer.model.MyCustomer myCustomer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMyCustomer(myCustomer, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static MyCustomerLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					MyCustomerLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new MyCustomerLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(MyCustomerLocalService service) {
		_service = service;
	}

	private static MyCustomerLocalService _service;
}
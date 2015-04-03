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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the my order local service. This utility wraps {@link com.mpower.training.order.service.impl.MyOrderLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.mpower.training.order.service.impl.MyOrderLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyOrderLocalService
 * @see com.mpower.training.order.service.base.MyOrderLocalServiceBaseImpl
 * @see com.mpower.training.order.service.impl.MyOrderLocalServiceImpl
 * @generated
 */
public class MyOrderLocalServiceUtil {
	/**
	* Adds the my order to the database. Also notifies the appropriate model listeners.
	*
	* @param myOrder the my order to add
	* @return the my order that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder addMyOrder(
		com.mpower.training.order.model.MyOrder myOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMyOrder(myOrder);
	}

	/**
	* Creates a new my order with the primary key. Does not add the my order to the database.
	*
	* @param id the primary key for the new my order
	* @return the new my order
	*/
	public static com.mpower.training.order.model.MyOrder createMyOrder(long id) {
		return getService().createMyOrder(id);
	}

	/**
	* Deletes the my order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the my order to delete
	* @throws PortalException if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMyOrder(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMyOrder(id);
	}

	/**
	* Deletes the my order from the database. Also notifies the appropriate model listeners.
	*
	* @param myOrder the my order to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteMyOrder(
		com.mpower.training.order.model.MyOrder myOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMyOrder(myOrder);
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
	* Gets the my order with the primary key.
	*
	* @param id the primary key of the my order to get
	* @return the my order
	* @throws PortalException if a my order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder getMyOrder(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyOrder(id);
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
	public static java.util.List<com.mpower.training.order.model.MyOrder> getMyOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyOrders(start, end);
	}

	/**
	* Gets the number of my orders.
	*
	* @return the number of my orders
	* @throws SystemException if a system exception occurred
	*/
	public static int getMyOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyOrdersCount();
	}

	/**
	* Updates the my order in the database. Also notifies the appropriate model listeners.
	*
	* @param myOrder the my order to update
	* @return the my order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder updateMyOrder(
		com.mpower.training.order.model.MyOrder myOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMyOrder(myOrder);
	}

	/**
	* Updates the my order in the database. Also notifies the appropriate model listeners.
	*
	* @param myOrder the my order to update
	* @param merge whether to merge the my order with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the my order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.mpower.training.order.model.MyOrder updateMyOrder(
		com.mpower.training.order.model.MyOrder myOrder, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMyOrder(myOrder, merge);
	}

	public static void clearService() {
		_service = null;
	}

	public static MyOrderLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					MyOrderLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new MyOrderLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(MyOrderLocalService service) {
		_service = service;
	}

	private static MyOrderLocalService _service;
}
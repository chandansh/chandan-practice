/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.slayer.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the shopping cart ext local service. This utility wraps {@link com.slayer.service.impl.ShoppingCartExtLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ahmedhasan
 * @see ShoppingCartExtLocalService
 * @see com.slayer.service.base.ShoppingCartExtLocalServiceBaseImpl
 * @see com.slayer.service.impl.ShoppingCartExtLocalServiceImpl
 * @generated
 */
public class ShoppingCartExtLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.slayer.service.impl.ShoppingCartExtLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the shopping cart ext to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCartExt the shopping cart ext
	* @return the shopping cart ext that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCartExt addShoppingCartExt(
		com.slayer.model.ShoppingCartExt shoppingCartExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addShoppingCartExt(shoppingCartExt);
	}

	/**
	* Creates a new shopping cart ext with the primary key. Does not add the shopping cart ext to the database.
	*
	* @param recId the primary key for the new shopping cart ext
	* @return the new shopping cart ext
	*/
	public static com.slayer.model.ShoppingCartExt createShoppingCartExt(
		long recId) {
		return getService().createShoppingCartExt(recId);
	}

	/**
	* Deletes the shopping cart ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recId the primary key of the shopping cart ext
	* @throws PortalException if a shopping cart ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingCartExt(long recId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingCartExt(recId);
	}

	/**
	* Deletes the shopping cart ext from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCartExt the shopping cart ext
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingCartExt(
		com.slayer.model.ShoppingCartExt shoppingCartExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingCartExt(shoppingCartExt);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
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
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
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
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
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
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.slayer.model.ShoppingCartExt fetchShoppingCartExt(
		long recId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchShoppingCartExt(recId);
	}

	/**
	* Returns the shopping cart ext with the primary key.
	*
	* @param recId the primary key of the shopping cart ext
	* @return the shopping cart ext
	* @throws PortalException if a shopping cart ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCartExt getShoppingCartExt(
		long recId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingCartExt(recId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the shopping cart exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping cart exts
	* @param end the upper bound of the range of shopping cart exts (not inclusive)
	* @return the range of shopping cart exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.slayer.model.ShoppingCartExt> getShoppingCartExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingCartExts(start, end);
	}

	/**
	* Returns the number of shopping cart exts.
	*
	* @return the number of shopping cart exts
	* @throws SystemException if a system exception occurred
	*/
	public static int getShoppingCartExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingCartExtsCount();
	}

	/**
	* Updates the shopping cart ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingCartExt the shopping cart ext
	* @return the shopping cart ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCartExt updateShoppingCartExt(
		com.slayer.model.ShoppingCartExt shoppingCartExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingCartExt(shoppingCartExt);
	}

	/**
	* Updates the shopping cart ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingCartExt the shopping cart ext
	* @param merge whether to merge the shopping cart ext with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping cart ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCartExt updateShoppingCartExt(
		com.slayer.model.ShoppingCartExt shoppingCartExt, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingCartExt(shoppingCartExt, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static void clearService() {
		_service = null;
	}

	public static ShoppingCartExtLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ShoppingCartExtLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ShoppingCartExtLocalService.class.getName(),
					portletClassLoader);

			_service = new ShoppingCartExtLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ShoppingCartExtLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ShoppingCartExtLocalService.class);
		}

		return _service;
	}

	public void setService(ShoppingCartExtLocalService service) {
		MethodCache.remove(ShoppingCartExtLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ShoppingCartExtLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ShoppingCartExtLocalService.class);
	}

	private static ShoppingCartExtLocalService _service;
}
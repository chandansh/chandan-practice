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
 * The utility for the shopping category ext local service. This utility wraps {@link com.slayer.service.impl.ShoppingCategoryExtLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ahmedhasan
 * @see ShoppingCategoryExtLocalService
 * @see com.slayer.service.base.ShoppingCategoryExtLocalServiceBaseImpl
 * @see com.slayer.service.impl.ShoppingCategoryExtLocalServiceImpl
 * @generated
 */
public class ShoppingCategoryExtLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.slayer.service.impl.ShoppingCategoryExtLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the shopping category ext to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryExt the shopping category ext
	* @return the shopping category ext that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCategoryExt addShoppingCategoryExt(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addShoppingCategoryExt(shoppingCategoryExt);
	}

	/**
	* Creates a new shopping category ext with the primary key. Does not add the shopping category ext to the database.
	*
	* @param categoryId the primary key for the new shopping category ext
	* @return the new shopping category ext
	*/
	public static com.slayer.model.ShoppingCategoryExt createShoppingCategoryExt(
		long categoryId) {
		return getService().createShoppingCategoryExt(categoryId);
	}

	/**
	* Deletes the shopping category ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the shopping category ext
	* @throws PortalException if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingCategoryExt(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingCategoryExt(categoryId);
	}

	/**
	* Deletes the shopping category ext from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryExt the shopping category ext
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingCategoryExt(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingCategoryExt(shoppingCategoryExt);
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

	public static com.slayer.model.ShoppingCategoryExt fetchShoppingCategoryExt(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchShoppingCategoryExt(categoryId);
	}

	/**
	* Returns the shopping category ext with the primary key.
	*
	* @param categoryId the primary key of the shopping category ext
	* @return the shopping category ext
	* @throws PortalException if a shopping category ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCategoryExt getShoppingCategoryExt(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingCategoryExt(categoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the shopping category exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping category exts
	* @param end the upper bound of the range of shopping category exts (not inclusive)
	* @return the range of shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.slayer.model.ShoppingCategoryExt> getShoppingCategoryExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingCategoryExts(start, end);
	}

	/**
	* Returns the number of shopping category exts.
	*
	* @return the number of shopping category exts
	* @throws SystemException if a system exception occurred
	*/
	public static int getShoppingCategoryExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingCategoryExtsCount();
	}

	/**
	* Updates the shopping category ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryExt the shopping category ext
	* @return the shopping category ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCategoryExt updateShoppingCategoryExt(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingCategoryExt(shoppingCategoryExt);
	}

	/**
	* Updates the shopping category ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategoryExt the shopping category ext
	* @param merge whether to merge the shopping category ext with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping category ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.ShoppingCategoryExt updateShoppingCategoryExt(
		com.slayer.model.ShoppingCategoryExt shoppingCategoryExt, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingCategoryExt(shoppingCategoryExt, merge);
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

	public static ShoppingCategoryExtLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ShoppingCategoryExtLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ShoppingCategoryExtLocalService.class.getName(),
					portletClassLoader);

			_service = new ShoppingCategoryExtLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ShoppingCategoryExtLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ShoppingCategoryExtLocalService.class);
		}

		return _service;
	}

	public void setService(ShoppingCategoryExtLocalService service) {
		MethodCache.remove(ShoppingCategoryExtLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ShoppingCategoryExtLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ShoppingCategoryExtLocalService.class);
	}

	private static ShoppingCategoryExtLocalService _service;
}
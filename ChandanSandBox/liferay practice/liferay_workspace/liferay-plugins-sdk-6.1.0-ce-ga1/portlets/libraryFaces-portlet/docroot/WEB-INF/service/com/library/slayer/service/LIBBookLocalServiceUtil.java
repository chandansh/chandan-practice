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

package com.library.slayer.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the l i b book local service. This utility wraps {@link com.library.slayer.service.impl.LIBBookLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author veena
 * @see LIBBookLocalService
 * @see com.library.slayer.service.base.LIBBookLocalServiceBaseImpl
 * @see com.library.slayer.service.impl.LIBBookLocalServiceImpl
 * @generated
 */
public class LIBBookLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.library.slayer.service.impl.LIBBookLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the l i b book to the database. Also notifies the appropriate model listeners.
	*
	* @param libBook the l i b book
	* @return the l i b book that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LIBBook addLIBBook(
		com.library.slayer.model.LIBBook libBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLIBBook(libBook);
	}

	/**
	* Creates a new l i b book with the primary key. Does not add the l i b book to the database.
	*
	* @param bookId the primary key for the new l i b book
	* @return the new l i b book
	*/
	public static com.library.slayer.model.LIBBook createLIBBook(long bookId) {
		return getService().createLIBBook(bookId);
	}

	/**
	* Deletes the l i b book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the l i b book
	* @throws PortalException if a l i b book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLIBBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLIBBook(bookId);
	}

	/**
	* Deletes the l i b book from the database. Also notifies the appropriate model listeners.
	*
	* @param libBook the l i b book
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLIBBook(com.library.slayer.model.LIBBook libBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLIBBook(libBook);
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

	public static com.library.slayer.model.LIBBook fetchLIBBook(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLIBBook(bookId);
	}

	/**
	* Returns the l i b book with the primary key.
	*
	* @param bookId the primary key of the l i b book
	* @return the l i b book
	* @throws PortalException if a l i b book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LIBBook getLIBBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLIBBook(bookId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l i b books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l i b books
	* @param end the upper bound of the range of l i b books (not inclusive)
	* @return the range of l i b books
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.library.slayer.model.LIBBook> getLIBBooks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLIBBooks(start, end);
	}

	/**
	* Returns the number of l i b books.
	*
	* @return the number of l i b books
	* @throws SystemException if a system exception occurred
	*/
	public static int getLIBBooksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLIBBooksCount();
	}

	/**
	* Updates the l i b book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param libBook the l i b book
	* @return the l i b book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LIBBook updateLIBBook(
		com.library.slayer.model.LIBBook libBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLIBBook(libBook);
	}

	/**
	* Updates the l i b book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param libBook the l i b book
	* @param merge whether to merge the l i b book with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the l i b book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LIBBook updateLIBBook(
		com.library.slayer.model.LIBBook libBook, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLIBBook(libBook, merge);
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

	public static LIBBookLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LIBBookLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LIBBookLocalService.class.getName(), portletClassLoader);

			_service = new LIBBookLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LIBBookLocalServiceUtil.class,
				"_service");
			MethodCache.remove(LIBBookLocalService.class);
		}

		return _service;
	}

	public void setService(LIBBookLocalService service) {
		MethodCache.remove(LIBBookLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(LIBBookLocalServiceUtil.class,
			"_service");
		MethodCache.remove(LIBBookLocalService.class);
	}

	private static LIBBookLocalService _service;
}
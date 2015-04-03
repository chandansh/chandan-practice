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
 * The utility for the l m s book local service. This utility wraps {@link com.library.slayer.service.impl.LMSBookLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ahmed Hasan
 * @see LMSBookLocalService
 * @see com.library.slayer.service.base.LMSBookLocalServiceBaseImpl
 * @see com.library.slayer.service.impl.LMSBookLocalServiceImpl
 * @generated
 */
public class LMSBookLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.library.slayer.service.impl.LMSBookLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the l m s book to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @return the l m s book that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LMSBook addLMSBook(
		com.library.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLMSBook(lmsBook);
	}

	/**
	* Creates a new l m s book with the primary key. Does not add the l m s book to the database.
	*
	* @param bookId the primary key for the new l m s book
	* @return the new l m s book
	*/
	public static com.library.slayer.model.LMSBook createLMSBook(long bookId) {
		return getService().createLMSBook(bookId);
	}

	/**
	* Deletes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the l m s book
	* @throws PortalException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLMSBook(bookId);
	}

	/**
	* Deletes the l m s book from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteLMSBook(com.library.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLMSBook(lmsBook);
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

	public static com.library.slayer.model.LMSBook fetchLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLMSBook(bookId);
	}

	/**
	* Returns the l m s book with the primary key.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book
	* @throws PortalException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LMSBook getLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSBook(bookId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the l m s book with the UUID in the group.
	*
	* @param uuid the UUID of l m s book
	* @param groupId the group id of the l m s book
	* @return the l m s book
	* @throws PortalException if a l m s book with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LMSBook getLMSBookByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSBookByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the l m s books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l m s books
	* @param end the upper bound of the range of l m s books (not inclusive)
	* @return the range of l m s books
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.library.slayer.model.LMSBook> getLMSBooks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSBooks(start, end);
	}

	/**
	* Returns the number of l m s books.
	*
	* @return the number of l m s books
	* @throws SystemException if a system exception occurred
	*/
	public static int getLMSBooksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLMSBooksCount();
	}

	/**
	* Updates the l m s book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @return the l m s book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LMSBook updateLMSBook(
		com.library.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLMSBook(lmsBook);
	}

	/**
	* Updates the l m s book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @param merge whether to merge the l m s book with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the l m s book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.library.slayer.model.LMSBook updateLMSBook(
		com.library.slayer.model.LMSBook lmsBook, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLMSBook(lmsBook, merge);
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

	public static java.util.List<com.library.slayer.model.LMSBook> AdvanceSearchAny(
		long companyId, long groupId, java.lang.String title,
		java.lang.String author, java.lang.String desc) {
		return getService()
				   .AdvanceSearchAny(companyId, groupId, title, author, desc);
	}

	public static java.util.List<com.library.slayer.model.LMSBook> advanceSearchAll(
		long companyId, long groupId, java.lang.String title,
		java.lang.String author, java.lang.String desc, java.lang.String type) {
		return getService()
				   .advanceSearchAll(companyId, groupId, title, author, desc,
			type);
	}

	public static java.util.List<com.library.slayer.model.LMSBook> searchBooks(
		long companyId, java.lang.String keywords) {
		return getService().searchBooks(companyId, keywords);
	}

	public static com.liferay.portal.kernel.search.Hits search(long companyId,
		java.lang.String keywords) {
		return getService().search(companyId, keywords);
	}

	public static com.library.slayer.model.LMSBook addBook(
		com.library.slayer.model.LMSBook lmsBook,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().addBook(lmsBook, serviceContext);
	}

	public static void updateAsset(long userId,
		com.library.slayer.model.LMSBook lmsBook, long[] assetCategoryIds,
		java.lang.String[] assetTagNames, long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, lmsBook, assetCategoryIds, assetTagNames,
			assetLinkEntryIds);
	}

	public static java.util.List<com.library.slayer.model.LMSBook> getAllBooksWithPermission()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService().getAllBooksWithPermission();
	}

	public static com.library.slayer.model.LMSBook getBookByName(
		java.lang.String bookTitle) {
		return getService().getBookByName(bookTitle);
	}

	public static void sendMessage(com.library.slayer.model.LMSBook lmsBook,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().sendMessage(lmsBook, serviceContext);
	}

	public static com.library.slayer.model.LMSBook addEntry(long userId,
		long groupId, long companyId, java.lang.String bookTitle,
		java.lang.String author, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEntry(userId, groupId, companyId, bookTitle, author,
			description, serviceContext);
	}

	public static void addEntryResources(
		com.library.slayer.model.LMSBook lmsBook, long userId, long groupId,
		long companyId, boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(lmsBook, userId, groupId, companyId,
			addGroupPermissions, addGuestPermissions);
	}

	public static void addEntryResources(
		com.library.slayer.model.LMSBook lmsBook, long userId, long groupId,
		long companyId, java.lang.String[] groupPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addEntryResources(lmsBook, userId, groupId, companyId,
			groupPermissions, guestPermissions);
	}

	public static void updateAsset(long userId, long groupId,
		com.library.slayer.model.LMSBook lmsBook, long[] assetCategoryIds,
		java.lang.String[] assetTagNames, long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateAsset(userId, groupId, lmsBook, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	public static java.util.List<com.library.slayer.model.LMSBookJoin> findBook(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findBook(bookTitle);
	}

	public static java.util.List<com.library.slayer.model.LMSBookAddressBean> findBooksByModel(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return getService().findBooksByModel(bookTitle);
	}

	public static com.library.slayer.model.LMSBook updateWFStatus(long userId,
		long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateWFStatus(userId, resourcePrimKey, status,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static LMSBookLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LMSBookLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					LMSBookLocalService.class.getName(), portletClassLoader);

			_service = new LMSBookLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(LMSBookLocalServiceUtil.class,
				"_service");
			MethodCache.remove(LMSBookLocalService.class);
		}

		return _service;
	}

	public void setService(LMSBookLocalService service) {
		MethodCache.remove(LMSBookLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(LMSBookLocalServiceUtil.class,
			"_service");
		MethodCache.remove(LMSBookLocalService.class);
	}

	private static LMSBookLocalService _service;
}
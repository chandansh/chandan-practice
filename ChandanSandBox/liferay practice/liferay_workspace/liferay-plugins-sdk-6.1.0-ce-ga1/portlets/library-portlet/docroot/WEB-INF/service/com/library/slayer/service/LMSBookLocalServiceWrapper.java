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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LMSBookLocalService}.
 * </p>
 *
 * @author    Ahmed Hasan
 * @see       LMSBookLocalService
 * @generated
 */
public class LMSBookLocalServiceWrapper implements LMSBookLocalService,
	ServiceWrapper<LMSBookLocalService> {
	public LMSBookLocalServiceWrapper(LMSBookLocalService lmsBookLocalService) {
		_lmsBookLocalService = lmsBookLocalService;
	}

	/**
	* Adds the l m s book to the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @return the l m s book that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook addLMSBook(
		com.library.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.addLMSBook(lmsBook);
	}

	/**
	* Creates a new l m s book with the primary key. Does not add the l m s book to the database.
	*
	* @param bookId the primary key for the new l m s book
	* @return the new l m s book
	*/
	public com.library.slayer.model.LMSBook createLMSBook(long bookId) {
		return _lmsBookLocalService.createLMSBook(bookId);
	}

	/**
	* Deletes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the l m s book
	* @throws PortalException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_lmsBookLocalService.deleteLMSBook(bookId);
	}

	/**
	* Deletes the l m s book from the database. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLMSBook(com.library.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsBookLocalService.deleteLMSBook(lmsBook);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.library.slayer.model.LMSBook fetchLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.fetchLMSBook(bookId);
	}

	/**
	* Returns the l m s book with the primary key.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book
	* @throws PortalException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook getLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.getLMSBook(bookId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.getPersistedModel(primaryKeyObj);
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
	public com.library.slayer.model.LMSBook getLMSBookByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.getLMSBookByUuidAndGroupId(uuid, groupId);
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
	public java.util.List<com.library.slayer.model.LMSBook> getLMSBooks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.getLMSBooks(start, end);
	}

	/**
	* Returns the number of l m s books.
	*
	* @return the number of l m s books
	* @throws SystemException if a system exception occurred
	*/
	public int getLMSBooksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.getLMSBooksCount();
	}

	/**
	* Updates the l m s book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @return the l m s book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook updateLMSBook(
		com.library.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.updateLMSBook(lmsBook);
	}

	/**
	* Updates the l m s book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lmsBook the l m s book
	* @param merge whether to merge the l m s book with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the l m s book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook updateLMSBook(
		com.library.slayer.model.LMSBook lmsBook, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.updateLMSBook(lmsBook, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _lmsBookLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_lmsBookLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<com.library.slayer.model.LMSBook> AdvanceSearchAny(
		long companyId, long groupId, java.lang.String title,
		java.lang.String author, java.lang.String desc) {
		return _lmsBookLocalService.AdvanceSearchAny(companyId, groupId, title,
			author, desc);
	}

	public java.util.List<com.library.slayer.model.LMSBook> advanceSearchAll(
		long companyId, long groupId, java.lang.String title,
		java.lang.String author, java.lang.String desc, java.lang.String type) {
		return _lmsBookLocalService.advanceSearchAll(companyId, groupId, title,
			author, desc, type);
	}

	public java.util.List<com.library.slayer.model.LMSBook> searchBooks(
		long companyId, java.lang.String keywords) {
		return _lmsBookLocalService.searchBooks(companyId, keywords);
	}

	public com.liferay.portal.kernel.search.Hits search(long companyId,
		java.lang.String keywords) {
		return _lmsBookLocalService.search(companyId, keywords);
	}

	public com.library.slayer.model.LMSBook addBook(
		com.library.slayer.model.LMSBook lmsBook,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _lmsBookLocalService.addBook(lmsBook, serviceContext);
	}

	public void updateAsset(long userId,
		com.library.slayer.model.LMSBook lmsBook, long[] assetCategoryIds,
		java.lang.String[] assetTagNames, long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_lmsBookLocalService.updateAsset(userId, lmsBook, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	public java.util.List<com.library.slayer.model.LMSBook> getAllBooksWithPermission()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _lmsBookLocalService.getAllBooksWithPermission();
	}

	public com.library.slayer.model.LMSBook getBookByName(
		java.lang.String bookTitle) {
		return _lmsBookLocalService.getBookByName(bookTitle);
	}

	public void sendMessage(com.library.slayer.model.LMSBook lmsBook,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsBookLocalService.sendMessage(lmsBook, serviceContext);
	}

	public com.library.slayer.model.LMSBook addEntry(long userId, long groupId,
		long companyId, java.lang.String bookTitle, java.lang.String author,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.addEntry(userId, groupId, companyId,
			bookTitle, author, description, serviceContext);
	}

	public void addEntryResources(com.library.slayer.model.LMSBook lmsBook,
		long userId, long groupId, long companyId, boolean addGroupPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_lmsBookLocalService.addEntryResources(lmsBook, userId, groupId,
			companyId, addGroupPermissions, addGuestPermissions);
	}

	public void addEntryResources(com.library.slayer.model.LMSBook lmsBook,
		long userId, long groupId, long companyId,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_lmsBookLocalService.addEntryResources(lmsBook, userId, groupId,
			companyId, groupPermissions, guestPermissions);
	}

	public void updateAsset(long userId, long groupId,
		com.library.slayer.model.LMSBook lmsBook, long[] assetCategoryIds,
		java.lang.String[] assetTagNames, long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_lmsBookLocalService.updateAsset(userId, groupId, lmsBook,
			assetCategoryIds, assetTagNames, assetLinkEntryIds);
	}

	public java.util.List<com.library.slayer.model.LMSBookJoin> findBook(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _lmsBookLocalService.findBook(bookTitle);
	}

	public java.util.List<com.library.slayer.model.LMSBookAddressBean> findBooksByModel(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		return _lmsBookLocalService.findBooksByModel(bookTitle);
	}

	public com.library.slayer.model.LMSBook updateWFStatus(long userId,
		long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookLocalService.updateWFStatus(userId, resourcePrimKey,
			status, serviceContext);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LMSBookLocalService getWrappedLMSBookLocalService() {
		return _lmsBookLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLMSBookLocalService(
		LMSBookLocalService lmsBookLocalService) {
		_lmsBookLocalService = lmsBookLocalService;
	}

	public LMSBookLocalService getWrappedService() {
		return _lmsBookLocalService;
	}

	public void setWrappedService(LMSBookLocalService lmsBookLocalService) {
		_lmsBookLocalService = lmsBookLocalService;
	}

	private LMSBookLocalService _lmsBookLocalService;
}
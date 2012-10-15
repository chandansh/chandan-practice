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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Ahmed Hasan
 */
public class LMSBookLocalServiceClp implements LMSBookLocalService {
	public LMSBookLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addLMSBookMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLMSBook", com.library.slayer.model.LMSBook.class);

		_createLMSBookMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createLMSBook", long.class);

		_deleteLMSBookMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteLMSBook", long.class);

		_deleteLMSBookMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteLMSBook", com.library.slayer.model.LMSBook.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_fetchLMSBookMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchLMSBook", long.class);

		_getLMSBookMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLMSBook", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getLMSBookByUuidAndGroupIdMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLMSBookByUuidAndGroupId", java.lang.String.class, long.class);

		_getLMSBooksMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLMSBooks", int.class, int.class);

		_getLMSBooksCountMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLMSBooksCount");

		_updateLMSBookMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLMSBook", com.library.slayer.model.LMSBook.class);

		_updateLMSBookMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLMSBook", com.library.slayer.model.LMSBook.class,
				boolean.class);

		_getBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_AdvanceSearchAnyMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"AdvanceSearchAny", long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_advanceSearchAllMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"advanceSearchAll", long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class);

		_searchBooksMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchBooks", long.class, java.lang.String.class);

		_searchMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"search", long.class, java.lang.String.class);

		_addBookMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"addBook", com.library.slayer.model.LMSBook.class,
				com.liferay.portal.service.ServiceContext.class);

		_updateAssetMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateAsset", long.class,
				com.library.slayer.model.LMSBook.class, long[].class,
				java.lang.String[].class, long[].class);

		_getAllBooksWithPermissionMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllBooksWithPermission");

		_getBookByNameMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBookByName", java.lang.String.class);

		_sendMessageMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"sendMessage", com.library.slayer.model.LMSBook.class,
				com.liferay.portal.service.ServiceContext.class);

		_addEntryMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntry", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class,
				com.liferay.portal.service.ServiceContext.class);

		_addEntryResourcesMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources", com.library.slayer.model.LMSBook.class,
				long.class, long.class, long.class, boolean.class, boolean.class);

		_addEntryResourcesMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"addEntryResources", com.library.slayer.model.LMSBook.class,
				long.class, long.class, long.class, java.lang.String[].class,
				java.lang.String[].class);

		_updateAssetMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateAsset", long.class, long.class,
				com.library.slayer.model.LMSBook.class, long[].class,
				java.lang.String[].class, long[].class);

		_findBookMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"findBook", java.lang.String.class);

		_findBooksByModelMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"findBooksByModel", java.lang.String.class);

		_updateWFStatusMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateWFStatus", long.class, long.class, int.class,
				com.liferay.portal.service.ServiceContext.class);
	}

	public com.library.slayer.model.LMSBook addLMSBook(
		com.library.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLMSBookMethodKey0,
				ClpSerializer.translateInput(lmsBook));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public com.library.slayer.model.LMSBook createLMSBook(long bookId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createLMSBookMethodKey1,
				bookId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteLMSBookMethodKey2,
				bookId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteLMSBook(com.library.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteLMSBookMethodKey3,
				ClpSerializer.translateInput(lmsBook));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.library.slayer.model.LMSBook fetchLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchLMSBookMethodKey8,
				bookId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public com.library.slayer.model.LMSBook getLMSBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLMSBookMethodKey9,
				bookId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public com.library.slayer.model.LMSBook getLMSBookByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLMSBookByUuidAndGroupIdMethodKey11,
				ClpSerializer.translateInput(uuid), groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.library.slayer.model.LMSBook> getLMSBooks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLMSBooksMethodKey12,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.library.slayer.model.LMSBook>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLMSBooksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLMSBooksCountMethodKey13);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.library.slayer.model.LMSBook updateLMSBook(
		com.library.slayer.model.LMSBook lmsBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLMSBookMethodKey14,
				ClpSerializer.translateInput(lmsBook));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public com.library.slayer.model.LMSBook updateLMSBook(
		com.library.slayer.model.LMSBook lmsBook, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLMSBookMethodKey15,
				ClpSerializer.translateInput(lmsBook), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey16);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey17,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<com.library.slayer.model.LMSBook> AdvanceSearchAny(
		long companyId, long groupId, java.lang.String title,
		java.lang.String author, java.lang.String desc) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_AdvanceSearchAnyMethodKey18,
				companyId, groupId, ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(author),
				ClpSerializer.translateInput(desc));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.library.slayer.model.LMSBook>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.library.slayer.model.LMSBook> advanceSearchAll(
		long companyId, long groupId, java.lang.String title,
		java.lang.String author, java.lang.String desc, java.lang.String type) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_advanceSearchAllMethodKey19,
				companyId, groupId, ClpSerializer.translateInput(title),
				ClpSerializer.translateInput(author),
				ClpSerializer.translateInput(desc),
				ClpSerializer.translateInput(type));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.library.slayer.model.LMSBook>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.library.slayer.model.LMSBook> searchBooks(
		long companyId, java.lang.String keywords) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchBooksMethodKey20,
				companyId, ClpSerializer.translateInput(keywords));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.library.slayer.model.LMSBook>)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.kernel.search.Hits search(long companyId,
		java.lang.String keywords) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchMethodKey21,
				companyId, ClpSerializer.translateInput(keywords));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.search.Hits)ClpSerializer.translateOutput(returnObj);
	}

	public com.library.slayer.model.LMSBook addBook(
		com.library.slayer.model.LMSBook lmsBook,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addBookMethodKey22,
				ClpSerializer.translateInput(lmsBook),
				ClpSerializer.translateInput(serviceContext));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public void updateAsset(long userId,
		com.library.slayer.model.LMSBook lmsBook, long[] assetCategoryIds,
		java.lang.String[] assetTagNames, long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_updateAssetMethodKey23,
				userId, ClpSerializer.translateInput(lmsBook),
				ClpSerializer.translateInput(assetCategoryIds),
				ClpSerializer.translateInput(assetTagNames),
				ClpSerializer.translateInput(assetLinkEntryIds));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<com.library.slayer.model.LMSBook> getAllBooksWithPermission()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllBooksWithPermissionMethodKey24);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
				throw (com.liferay.portal.security.auth.PrincipalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.library.slayer.model.LMSBook>)ClpSerializer.translateOutput(returnObj);
	}

	public com.library.slayer.model.LMSBook getBookByName(
		java.lang.String bookTitle) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBookByNameMethodKey25,
				ClpSerializer.translateInput(bookTitle));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public void sendMessage(com.library.slayer.model.LMSBook lmsBook,
		com.liferay.portal.service.ServiceContext serviceContext) {
		MethodHandler methodHandler = new MethodHandler(_sendMessageMethodKey26,
				ClpSerializer.translateInput(lmsBook),
				ClpSerializer.translateInput(serviceContext));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.library.slayer.model.LMSBook addEntry(long userId, long groupId,
		long companyId, java.lang.String bookTitle, java.lang.String author,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addEntryMethodKey27,
				userId, groupId, companyId,
				ClpSerializer.translateInput(bookTitle),
				ClpSerializer.translateInput(author),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(serviceContext));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public void addEntryResources(com.library.slayer.model.LMSBook lmsBook,
		long userId, long groupId, long companyId, boolean addGroupPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey28,
				ClpSerializer.translateInput(lmsBook), userId, groupId,
				companyId, addGroupPermissions, addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addEntryResources(com.library.slayer.model.LMSBook lmsBook,
		long userId, long groupId, long companyId,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addEntryResourcesMethodKey29,
				ClpSerializer.translateInput(lmsBook), userId, groupId,
				companyId, ClpSerializer.translateInput(groupPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void updateAsset(long userId, long groupId,
		com.library.slayer.model.LMSBook lmsBook, long[] assetCategoryIds,
		java.lang.String[] assetTagNames, long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_updateAssetMethodKey30,
				userId, groupId, ClpSerializer.translateInput(lmsBook),
				ClpSerializer.translateInput(assetCategoryIds),
				ClpSerializer.translateInput(assetTagNames),
				ClpSerializer.translateInput(assetLinkEntryIds));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<com.library.slayer.model.LMSBookJoin> findBook(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findBookMethodKey31,
				ClpSerializer.translateInput(bookTitle));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.library.slayer.model.LMSBookJoin>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.library.slayer.model.LMSBookAddressBean> findBooksByModel(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.rmi.RemoteException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findBooksByModelMethodKey32,
				ClpSerializer.translateInput(bookTitle));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.library.slayer.model.LMSBookAddressBean>)ClpSerializer.translateOutput(returnObj);
	}

	public com.library.slayer.model.LMSBook updateWFStatus(long userId,
		long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateWFStatusMethodKey33,
				userId, resourcePrimKey, status,
				ClpSerializer.translateInput(serviceContext));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.library.slayer.model.LMSBook)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addLMSBookMethodKey0;
	private MethodKey _createLMSBookMethodKey1;
	private MethodKey _deleteLMSBookMethodKey2;
	private MethodKey _deleteLMSBookMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchLMSBookMethodKey8;
	private MethodKey _getLMSBookMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getLMSBookByUuidAndGroupIdMethodKey11;
	private MethodKey _getLMSBooksMethodKey12;
	private MethodKey _getLMSBooksCountMethodKey13;
	private MethodKey _updateLMSBookMethodKey14;
	private MethodKey _updateLMSBookMethodKey15;
	private MethodKey _getBeanIdentifierMethodKey16;
	private MethodKey _setBeanIdentifierMethodKey17;
	private MethodKey _AdvanceSearchAnyMethodKey18;
	private MethodKey _advanceSearchAllMethodKey19;
	private MethodKey _searchBooksMethodKey20;
	private MethodKey _searchMethodKey21;
	private MethodKey _addBookMethodKey22;
	private MethodKey _updateAssetMethodKey23;
	private MethodKey _getAllBooksWithPermissionMethodKey24;
	private MethodKey _getBookByNameMethodKey25;
	private MethodKey _sendMessageMethodKey26;
	private MethodKey _addEntryMethodKey27;
	private MethodKey _addEntryResourcesMethodKey28;
	private MethodKey _addEntryResourcesMethodKey29;
	private MethodKey _updateAssetMethodKey30;
	private MethodKey _findBookMethodKey31;
	private MethodKey _findBooksByModelMethodKey32;
	private MethodKey _updateWFStatusMethodKey33;
}
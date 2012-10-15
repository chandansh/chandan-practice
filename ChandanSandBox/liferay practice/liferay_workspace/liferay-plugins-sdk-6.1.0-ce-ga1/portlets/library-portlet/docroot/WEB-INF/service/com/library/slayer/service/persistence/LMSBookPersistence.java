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

package com.library.slayer.service.persistence;

import com.library.slayer.model.LMSBook;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l m s book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ahmed Hasan
 * @see LMSBookPersistenceImpl
 * @see LMSBookUtil
 * @generated
 */
public interface LMSBookPersistence extends BasePersistence<LMSBook> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LMSBookUtil} to access the l m s book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the l m s book in the entity cache if it is enabled.
	*
	* @param lmsBook the l m s book
	*/
	public void cacheResult(com.library.slayer.model.LMSBook lmsBook);

	/**
	* Caches the l m s books in the entity cache if it is enabled.
	*
	* @param lmsBooks the l m s books
	*/
	public void cacheResult(
		java.util.List<com.library.slayer.model.LMSBook> lmsBooks);

	/**
	* Creates a new l m s book with the primary key. Does not add the l m s book to the database.
	*
	* @param bookId the primary key for the new l m s book
	* @return the new l m s book
	*/
	public com.library.slayer.model.LMSBook create(long bookId);

	/**
	* Removes the l m s book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book that was removed
	* @throws com.library.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook remove(long bookId)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.library.slayer.model.LMSBook updateImpl(
		com.library.slayer.model.LMSBook lmsBook, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book with the primary key or throws a {@link com.library.slayer.NoSuchBookException} if it could not be found.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book
	* @throws com.library.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook findByPrimaryKey(long bookId)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the l m s book
	* @return the l m s book, or <code>null</code> if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook fetchByPrimaryKey(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s books where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching l m s books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.LMSBook> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l m s books where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of l m s books
	* @param end the upper bound of the range of l m s books (not inclusive)
	* @return the range of matching l m s books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.LMSBook> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s books where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of l m s books
	* @param end the upper bound of the range of l m s books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l m s books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.LMSBook> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l m s book in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l m s book
	* @throws com.library.slayer.NoSuchBookException if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l m s book in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l m s book
	* @throws com.library.slayer.NoSuchBookException if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s books before and after the current l m s book in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookId the primary key of the current l m s book
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l m s book
	* @throws com.library.slayer.NoSuchBookException if a l m s book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook[] findByUuid_PrevAndNext(
		long bookId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book where uuid = &#63; and groupId = &#63; or throws a {@link com.library.slayer.NoSuchBookException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching l m s book
	* @throws com.library.slayer.NoSuchBookException if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book where bookTitle = &#63; or throws a {@link com.library.slayer.NoSuchBookException} if it could not be found.
	*
	* @param bookTitle the book title
	* @return the matching l m s book
	* @throws com.library.slayer.NoSuchBookException if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook findByBook(
		java.lang.String bookTitle)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book where bookTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bookTitle the book title
	* @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook fetchByBook(
		java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l m s book where bookTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bookTitle the book title
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l m s book, or <code>null</code> if a matching l m s book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LMSBook fetchByBook(
		java.lang.String bookTitle, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l m s books.
	*
	* @return the l m s books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.LMSBook> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.library.slayer.model.LMSBook> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l m s books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l m s books
	* @param end the upper bound of the range of l m s books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l m s books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.LMSBook> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s books where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s book where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l m s book where bookTitle = &#63; from the database.
	*
	* @param bookTitle the book title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBook(java.lang.String bookTitle)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l m s books from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s books where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching l m s books
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s books where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching l m s books
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s books where bookTitle = &#63;.
	*
	* @param bookTitle the book title
	* @return the number of matching l m s books
	* @throws SystemException if a system exception occurred
	*/
	public int countByBook(java.lang.String bookTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l m s books.
	*
	* @return the number of l m s books
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
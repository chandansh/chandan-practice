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

import com.library.slayer.model.LIBBook;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l i b book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author veena
 * @see LIBBookPersistenceImpl
 * @see LIBBookUtil
 * @generated
 */
public interface LIBBookPersistence extends BasePersistence<LIBBook> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LIBBookUtil} to access the l i b book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the l i b book in the entity cache if it is enabled.
	*
	* @param libBook the l i b book
	*/
	public void cacheResult(com.library.slayer.model.LIBBook libBook);

	/**
	* Caches the l i b books in the entity cache if it is enabled.
	*
	* @param libBooks the l i b books
	*/
	public void cacheResult(
		java.util.List<com.library.slayer.model.LIBBook> libBooks);

	/**
	* Creates a new l i b book with the primary key. Does not add the l i b book to the database.
	*
	* @param bookId the primary key for the new l i b book
	* @return the new l i b book
	*/
	public com.library.slayer.model.LIBBook create(long bookId);

	/**
	* Removes the l i b book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the l i b book
	* @return the l i b book that was removed
	* @throws com.library.slayer.NoSuchBookException if a l i b book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LIBBook remove(long bookId)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.library.slayer.model.LIBBook updateImpl(
		com.library.slayer.model.LIBBook libBook, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l i b book with the primary key or throws a {@link com.library.slayer.NoSuchBookException} if it could not be found.
	*
	* @param bookId the primary key of the l i b book
	* @return the l i b book
	* @throws com.library.slayer.NoSuchBookException if a l i b book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LIBBook findByPrimaryKey(long bookId)
		throws com.library.slayer.NoSuchBookException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l i b book with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the l i b book
	* @return the l i b book, or <code>null</code> if a l i b book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.library.slayer.model.LIBBook fetchByPrimaryKey(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l i b books.
	*
	* @return the l i b books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.LIBBook> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.library.slayer.model.LIBBook> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l i b books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l i b books
	* @param end the upper bound of the range of l i b books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l i b books
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.library.slayer.model.LIBBook> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l i b books from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l i b books.
	*
	* @return the number of l i b books
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
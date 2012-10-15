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

package com.slayer.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.slayer.model.AuthorPost;

/**
 * The persistence interface for the author post service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chandan
 * @see AuthorPostPersistenceImpl
 * @see AuthorPostUtil
 * @generated
 */
public interface AuthorPostPersistence extends BasePersistence<AuthorPost> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthorPostUtil} to access the author post persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the author post in the entity cache if it is enabled.
	*
	* @param authorPost the author post
	*/
	public void cacheResult(com.slayer.model.AuthorPost authorPost);

	/**
	* Caches the author posts in the entity cache if it is enabled.
	*
	* @param authorPosts the author posts
	*/
	public void cacheResult(
		java.util.List<com.slayer.model.AuthorPost> authorPosts);

	/**
	* Creates a new author post with the primary key. Does not add the author post to the database.
	*
	* @param authorPostId the primary key for the new author post
	* @return the new author post
	*/
	public com.slayer.model.AuthorPost create(long authorPostId);

	/**
	* Removes the author post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorPostId the primary key of the author post
	* @return the author post that was removed
	* @throws com.slayer.NoSuchAuthorPostException if a author post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.AuthorPost remove(long authorPostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchAuthorPostException;

	public com.slayer.model.AuthorPost updateImpl(
		com.slayer.model.AuthorPost authorPost, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the author post with the primary key or throws a {@link com.slayer.NoSuchAuthorPostException} if it could not be found.
	*
	* @param authorPostId the primary key of the author post
	* @return the author post
	* @throws com.slayer.NoSuchAuthorPostException if a author post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.AuthorPost findByPrimaryKey(long authorPostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchAuthorPostException;

	/**
	* Returns the author post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorPostId the primary key of the author post
	* @return the author post, or <code>null</code> if a author post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.slayer.model.AuthorPost fetchByPrimaryKey(long authorPostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the author posts.
	*
	* @return the author posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.AuthorPost> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the author posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of author posts
	* @param end the upper bound of the range of author posts (not inclusive)
	* @return the range of author posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.AuthorPost> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the author posts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of author posts
	* @param end the upper bound of the range of author posts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of author posts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.slayer.model.AuthorPost> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the author posts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of author posts.
	*
	* @return the number of author posts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
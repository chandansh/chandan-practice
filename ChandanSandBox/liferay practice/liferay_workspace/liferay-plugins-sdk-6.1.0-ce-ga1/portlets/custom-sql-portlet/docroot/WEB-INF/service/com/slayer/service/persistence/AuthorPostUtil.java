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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.slayer.model.AuthorPost;

import java.util.List;

/**
 * The persistence utility for the author post service. This utility wraps {@link AuthorPostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chandan
 * @see AuthorPostPersistence
 * @see AuthorPostPersistenceImpl
 * @generated
 */
public class AuthorPostUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AuthorPost authorPost) {
		getPersistence().clearCache(authorPost);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AuthorPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuthorPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuthorPost> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AuthorPost update(AuthorPost authorPost, boolean merge)
		throws SystemException {
		return getPersistence().update(authorPost, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AuthorPost update(AuthorPost authorPost, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(authorPost, merge, serviceContext);
	}

	/**
	* Caches the author post in the entity cache if it is enabled.
	*
	* @param authorPost the author post
	*/
	public static void cacheResult(com.slayer.model.AuthorPost authorPost) {
		getPersistence().cacheResult(authorPost);
	}

	/**
	* Caches the author posts in the entity cache if it is enabled.
	*
	* @param authorPosts the author posts
	*/
	public static void cacheResult(
		java.util.List<com.slayer.model.AuthorPost> authorPosts) {
		getPersistence().cacheResult(authorPosts);
	}

	/**
	* Creates a new author post with the primary key. Does not add the author post to the database.
	*
	* @param authorPostId the primary key for the new author post
	* @return the new author post
	*/
	public static com.slayer.model.AuthorPost create(long authorPostId) {
		return getPersistence().create(authorPostId);
	}

	/**
	* Removes the author post with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param authorPostId the primary key of the author post
	* @return the author post that was removed
	* @throws com.slayer.NoSuchAuthorPostException if a author post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.AuthorPost remove(long authorPostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchAuthorPostException {
		return getPersistence().remove(authorPostId);
	}

	public static com.slayer.model.AuthorPost updateImpl(
		com.slayer.model.AuthorPost authorPost, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(authorPost, merge);
	}

	/**
	* Returns the author post with the primary key or throws a {@link com.slayer.NoSuchAuthorPostException} if it could not be found.
	*
	* @param authorPostId the primary key of the author post
	* @return the author post
	* @throws com.slayer.NoSuchAuthorPostException if a author post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.AuthorPost findByPrimaryKey(
		long authorPostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.slayer.NoSuchAuthorPostException {
		return getPersistence().findByPrimaryKey(authorPostId);
	}

	/**
	* Returns the author post with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param authorPostId the primary key of the author post
	* @return the author post, or <code>null</code> if a author post with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.slayer.model.AuthorPost fetchByPrimaryKey(
		long authorPostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(authorPostId);
	}

	/**
	* Returns all the author posts.
	*
	* @return the author posts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.slayer.model.AuthorPost> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.slayer.model.AuthorPost> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.slayer.model.AuthorPost> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the author posts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of author posts.
	*
	* @return the number of author posts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AuthorPostPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AuthorPostPersistence)PortletBeanLocatorUtil.locate(com.slayer.service.ClpSerializer.getServletContextName(),
					AuthorPostPersistence.class.getName());

			ReferenceRegistry.registerReference(AuthorPostUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(AuthorPostPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(AuthorPostUtil.class, "_persistence");
	}

	private static AuthorPostPersistence _persistence;
}
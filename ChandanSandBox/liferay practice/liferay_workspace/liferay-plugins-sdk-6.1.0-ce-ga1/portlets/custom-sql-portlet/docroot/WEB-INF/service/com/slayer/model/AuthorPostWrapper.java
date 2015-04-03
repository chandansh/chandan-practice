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

package com.slayer.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AuthorPost}.
 * </p>
 *
 * @author    Chandan
 * @see       AuthorPost
 * @generated
 */
public class AuthorPostWrapper implements AuthorPost, ModelWrapper<AuthorPost> {
	public AuthorPostWrapper(AuthorPost authorPost) {
		_authorPost = authorPost;
	}

	public Class<?> getModelClass() {
		return AuthorPost.class;
	}

	public String getModelClassName() {
		return AuthorPost.class.getName();
	}

	/**
	* Returns the primary key of this author post.
	*
	* @return the primary key of this author post
	*/
	public long getPrimaryKey() {
		return _authorPost.getPrimaryKey();
	}

	/**
	* Sets the primary key of this author post.
	*
	* @param primaryKey the primary key of this author post
	*/
	public void setPrimaryKey(long primaryKey) {
		_authorPost.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the author post ID of this author post.
	*
	* @return the author post ID of this author post
	*/
	public long getAuthorPostId() {
		return _authorPost.getAuthorPostId();
	}

	/**
	* Sets the author post ID of this author post.
	*
	* @param authorPostId the author post ID of this author post
	*/
	public void setAuthorPostId(long authorPostId) {
		_authorPost.setAuthorPostId(authorPostId);
	}

	/**
	* Returns the post ID of this author post.
	*
	* @return the post ID of this author post
	*/
	public long getPostId() {
		return _authorPost.getPostId();
	}

	/**
	* Sets the post ID of this author post.
	*
	* @param postId the post ID of this author post
	*/
	public void setPostId(long postId) {
		_authorPost.setPostId(postId);
	}

	/**
	* Returns the title of this author post.
	*
	* @return the title of this author post
	*/
	public java.lang.String getTitle() {
		return _authorPost.getTitle();
	}

	/**
	* Sets the title of this author post.
	*
	* @param title the title of this author post
	*/
	public void setTitle(java.lang.String title) {
		_authorPost.setTitle(title);
	}

	/**
	* Returns the content of this author post.
	*
	* @return the content of this author post
	*/
	public java.lang.String getContent() {
		return _authorPost.getContent();
	}

	/**
	* Sets the content of this author post.
	*
	* @param content the content of this author post
	*/
	public void setContent(java.lang.String content) {
		_authorPost.setContent(content);
	}

	/**
	* Returns the author ID of this author post.
	*
	* @return the author ID of this author post
	*/
	public long getAuthorId() {
		return _authorPost.getAuthorId();
	}

	/**
	* Sets the author ID of this author post.
	*
	* @param authorId the author ID of this author post
	*/
	public void setAuthorId(long authorId) {
		_authorPost.setAuthorId(authorId);
	}

	/**
	* Returns the name of this author post.
	*
	* @return the name of this author post
	*/
	public java.lang.String getName() {
		return _authorPost.getName();
	}

	/**
	* Sets the name of this author post.
	*
	* @param name the name of this author post
	*/
	public void setName(java.lang.String name) {
		_authorPost.setName(name);
	}

	/**
	* Returns the specialization of this author post.
	*
	* @return the specialization of this author post
	*/
	public java.lang.String getSpecialization() {
		return _authorPost.getSpecialization();
	}

	/**
	* Sets the specialization of this author post.
	*
	* @param specialization the specialization of this author post
	*/
	public void setSpecialization(java.lang.String specialization) {
		_authorPost.setSpecialization(specialization);
	}

	public boolean isNew() {
		return _authorPost.isNew();
	}

	public void setNew(boolean n) {
		_authorPost.setNew(n);
	}

	public boolean isCachedModel() {
		return _authorPost.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_authorPost.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _authorPost.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _authorPost.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_authorPost.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _authorPost.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_authorPost.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuthorPostWrapper((AuthorPost)_authorPost.clone());
	}

	public int compareTo(com.slayer.model.AuthorPost authorPost) {
		return _authorPost.compareTo(authorPost);
	}

	@Override
	public int hashCode() {
		return _authorPost.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.slayer.model.AuthorPost> toCacheModel() {
		return _authorPost.toCacheModel();
	}

	public com.slayer.model.AuthorPost toEscapedModel() {
		return new AuthorPostWrapper(_authorPost.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _authorPost.toString();
	}

	public java.lang.String toXmlString() {
		return _authorPost.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AuthorPost getWrappedAuthorPost() {
		return _authorPost;
	}

	public AuthorPost getWrappedModel() {
		return _authorPost;
	}

	public void resetOriginalValues() {
		_authorPost.resetOriginalValues();
	}

	private AuthorPost _authorPost;
}
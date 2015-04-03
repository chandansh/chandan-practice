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
 * This class is a wrapper for {@link Post}.
 * </p>
 *
 * @author    Chandan
 * @see       Post
 * @generated
 */
public class PostWrapper implements Post, ModelWrapper<Post> {
	public PostWrapper(Post post) {
		_post = post;
	}

	public Class<?> getModelClass() {
		return Post.class;
	}

	public String getModelClassName() {
		return Post.class.getName();
	}

	/**
	* Returns the primary key of this post.
	*
	* @return the primary key of this post
	*/
	public long getPrimaryKey() {
		return _post.getPrimaryKey();
	}

	/**
	* Sets the primary key of this post.
	*
	* @param primaryKey the primary key of this post
	*/
	public void setPrimaryKey(long primaryKey) {
		_post.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the post ID of this post.
	*
	* @return the post ID of this post
	*/
	public long getPostId() {
		return _post.getPostId();
	}

	/**
	* Sets the post ID of this post.
	*
	* @param postId the post ID of this post
	*/
	public void setPostId(long postId) {
		_post.setPostId(postId);
	}

	/**
	* Returns the title of this post.
	*
	* @return the title of this post
	*/
	public java.lang.String getTitle() {
		return _post.getTitle();
	}

	/**
	* Sets the title of this post.
	*
	* @param title the title of this post
	*/
	public void setTitle(java.lang.String title) {
		_post.setTitle(title);
	}

	/**
	* Returns the content of this post.
	*
	* @return the content of this post
	*/
	public java.lang.String getContent() {
		return _post.getContent();
	}

	/**
	* Sets the content of this post.
	*
	* @param content the content of this post
	*/
	public void setContent(java.lang.String content) {
		_post.setContent(content);
	}

	/**
	* Returns the author ID of this post.
	*
	* @return the author ID of this post
	*/
	public long getAuthorId() {
		return _post.getAuthorId();
	}

	/**
	* Sets the author ID of this post.
	*
	* @param authorId the author ID of this post
	*/
	public void setAuthorId(long authorId) {
		_post.setAuthorId(authorId);
	}

	public boolean isNew() {
		return _post.isNew();
	}

	public void setNew(boolean n) {
		_post.setNew(n);
	}

	public boolean isCachedModel() {
		return _post.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_post.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _post.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _post.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_post.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _post.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_post.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PostWrapper((Post)_post.clone());
	}

	public int compareTo(com.slayer.model.Post post) {
		return _post.compareTo(post);
	}

	@Override
	public int hashCode() {
		return _post.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.slayer.model.Post> toCacheModel() {
		return _post.toCacheModel();
	}

	public com.slayer.model.Post toEscapedModel() {
		return new PostWrapper(_post.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _post.toString();
	}

	public java.lang.String toXmlString() {
		return _post.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_post.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Post getWrappedPost() {
		return _post;
	}

	public Post getWrappedModel() {
		return _post;
	}

	public void resetOriginalValues() {
		_post.resetOriginalValues();
	}

	private Post _post;
}
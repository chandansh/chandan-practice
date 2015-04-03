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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the AuthorPost service. Represents a row in the &quot;me_AuthorPost&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.slayer.model.impl.AuthorPostModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.slayer.model.impl.AuthorPostImpl}.
 * </p>
 *
 * @author Chandan
 * @see AuthorPost
 * @see com.slayer.model.impl.AuthorPostImpl
 * @see com.slayer.model.impl.AuthorPostModelImpl
 * @generated
 */
public interface AuthorPostModel extends BaseModel<AuthorPost> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a author post model instance should use the {@link AuthorPost} interface instead.
	 */

	/**
	 * Returns the primary key of this author post.
	 *
	 * @return the primary key of this author post
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this author post.
	 *
	 * @param primaryKey the primary key of this author post
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the author post ID of this author post.
	 *
	 * @return the author post ID of this author post
	 */
	public long getAuthorPostId();

	/**
	 * Sets the author post ID of this author post.
	 *
	 * @param authorPostId the author post ID of this author post
	 */
	public void setAuthorPostId(long authorPostId);

	/**
	 * Returns the post ID of this author post.
	 *
	 * @return the post ID of this author post
	 */
	public long getPostId();

	/**
	 * Sets the post ID of this author post.
	 *
	 * @param postId the post ID of this author post
	 */
	public void setPostId(long postId);

	/**
	 * Returns the title of this author post.
	 *
	 * @return the title of this author post
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this author post.
	 *
	 * @param title the title of this author post
	 */
	public void setTitle(String title);

	/**
	 * Returns the content of this author post.
	 *
	 * @return the content of this author post
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this author post.
	 *
	 * @param content the content of this author post
	 */
	public void setContent(String content);

	/**
	 * Returns the author ID of this author post.
	 *
	 * @return the author ID of this author post
	 */
	public long getAuthorId();

	/**
	 * Sets the author ID of this author post.
	 *
	 * @param authorId the author ID of this author post
	 */
	public void setAuthorId(long authorId);

	/**
	 * Returns the name of this author post.
	 *
	 * @return the name of this author post
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this author post.
	 *
	 * @param name the name of this author post
	 */
	public void setName(String name);

	/**
	 * Returns the specialization of this author post.
	 *
	 * @return the specialization of this author post
	 */
	@AutoEscape
	public String getSpecialization();

	/**
	 * Sets the specialization of this author post.
	 *
	 * @param specialization the specialization of this author post
	 */
	public void setSpecialization(String specialization);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(AuthorPost authorPost);

	public int hashCode();

	public CacheModel<AuthorPost> toCacheModel();

	public AuthorPost toEscapedModel();

	public String toString();

	public String toXmlString();
}
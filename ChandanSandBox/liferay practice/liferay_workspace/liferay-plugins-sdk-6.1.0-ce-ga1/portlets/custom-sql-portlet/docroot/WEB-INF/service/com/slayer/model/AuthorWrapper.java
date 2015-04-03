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
 * This class is a wrapper for {@link Author}.
 * </p>
 *
 * @author    Chandan
 * @see       Author
 * @generated
 */
public class AuthorWrapper implements Author, ModelWrapper<Author> {
	public AuthorWrapper(Author author) {
		_author = author;
	}

	public Class<?> getModelClass() {
		return Author.class;
	}

	public String getModelClassName() {
		return Author.class.getName();
	}

	/**
	* Returns the primary key of this author.
	*
	* @return the primary key of this author
	*/
	public long getPrimaryKey() {
		return _author.getPrimaryKey();
	}

	/**
	* Sets the primary key of this author.
	*
	* @param primaryKey the primary key of this author
	*/
	public void setPrimaryKey(long primaryKey) {
		_author.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the author ID of this author.
	*
	* @return the author ID of this author
	*/
	public long getAuthorId() {
		return _author.getAuthorId();
	}

	/**
	* Sets the author ID of this author.
	*
	* @param authorId the author ID of this author
	*/
	public void setAuthorId(long authorId) {
		_author.setAuthorId(authorId);
	}

	/**
	* Returns the name of this author.
	*
	* @return the name of this author
	*/
	public java.lang.String getName() {
		return _author.getName();
	}

	/**
	* Sets the name of this author.
	*
	* @param name the name of this author
	*/
	public void setName(java.lang.String name) {
		_author.setName(name);
	}

	/**
	* Returns the specialization of this author.
	*
	* @return the specialization of this author
	*/
	public java.lang.String getSpecialization() {
		return _author.getSpecialization();
	}

	/**
	* Sets the specialization of this author.
	*
	* @param specialization the specialization of this author
	*/
	public void setSpecialization(java.lang.String specialization) {
		_author.setSpecialization(specialization);
	}

	public boolean isNew() {
		return _author.isNew();
	}

	public void setNew(boolean n) {
		_author.setNew(n);
	}

	public boolean isCachedModel() {
		return _author.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_author.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _author.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _author.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_author.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _author.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_author.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuthorWrapper((Author)_author.clone());
	}

	public int compareTo(com.slayer.model.Author author) {
		return _author.compareTo(author);
	}

	@Override
	public int hashCode() {
		return _author.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.slayer.model.Author> toCacheModel() {
		return _author.toCacheModel();
	}

	public com.slayer.model.Author toEscapedModel() {
		return new AuthorWrapper(_author.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _author.toString();
	}

	public java.lang.String toXmlString() {
		return _author.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_author.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Author getWrappedAuthor() {
		return _author;
	}

	public Author getWrappedModel() {
		return _author;
	}

	public void resetOriginalValues() {
		_author.resetOriginalValues();
	}

	private Author _author;
}
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

package com.library.slayer.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LIBBook}.
 * </p>
 *
 * @author    veena
 * @see       LIBBook
 * @generated
 */
public class LIBBookWrapper implements LIBBook, ModelWrapper<LIBBook> {
	public LIBBookWrapper(LIBBook libBook) {
		_libBook = libBook;
	}

	public Class<?> getModelClass() {
		return LIBBook.class;
	}

	public String getModelClassName() {
		return LIBBook.class.getName();
	}

	/**
	* Returns the primary key of this l i b book.
	*
	* @return the primary key of this l i b book
	*/
	public long getPrimaryKey() {
		return _libBook.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l i b book.
	*
	* @param primaryKey the primary key of this l i b book
	*/
	public void setPrimaryKey(long primaryKey) {
		_libBook.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the book ID of this l i b book.
	*
	* @return the book ID of this l i b book
	*/
	public long getBookId() {
		return _libBook.getBookId();
	}

	/**
	* Sets the book ID of this l i b book.
	*
	* @param bookId the book ID of this l i b book
	*/
	public void setBookId(long bookId) {
		_libBook.setBookId(bookId);
	}

	/**
	* Returns the book title of this l i b book.
	*
	* @return the book title of this l i b book
	*/
	public java.lang.String getBookTitle() {
		return _libBook.getBookTitle();
	}

	/**
	* Sets the book title of this l i b book.
	*
	* @param bookTitle the book title of this l i b book
	*/
	public void setBookTitle(java.lang.String bookTitle) {
		_libBook.setBookTitle(bookTitle);
	}

	/**
	* Returns the author of this l i b book.
	*
	* @return the author of this l i b book
	*/
	public java.lang.String getAuthor() {
		return _libBook.getAuthor();
	}

	/**
	* Sets the author of this l i b book.
	*
	* @param author the author of this l i b book
	*/
	public void setAuthor(java.lang.String author) {
		_libBook.setAuthor(author);
	}

	public boolean isNew() {
		return _libBook.isNew();
	}

	public void setNew(boolean n) {
		_libBook.setNew(n);
	}

	public boolean isCachedModel() {
		return _libBook.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_libBook.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _libBook.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _libBook.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_libBook.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _libBook.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_libBook.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LIBBookWrapper((LIBBook)_libBook.clone());
	}

	public int compareTo(com.library.slayer.model.LIBBook libBook) {
		return _libBook.compareTo(libBook);
	}

	@Override
	public int hashCode() {
		return _libBook.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.library.slayer.model.LIBBook> toCacheModel() {
		return _libBook.toCacheModel();
	}

	public com.library.slayer.model.LIBBook toEscapedModel() {
		return new LIBBookWrapper(_libBook.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _libBook.toString();
	}

	public java.lang.String toXmlString() {
		return _libBook.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_libBook.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LIBBook getWrappedLIBBook() {
		return _libBook;
	}

	public LIBBook getWrappedModel() {
		return _libBook;
	}

	public void resetOriginalValues() {
		_libBook.resetOriginalValues();
	}

	private LIBBook _libBook;
}
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

package com.mpower.services.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author    Meenu
 * @see       Book
 * @generated
 */
public class BookWrapper implements Book, ModelWrapper<Book> {
	public BookWrapper(Book book) {
		_book = book;
	}

	public Class<?> getModelClass() {
		return Book.class;
	}

	public String getModelClassName() {
		return Book.class.getName();
	}

	/**
	* Returns the primary key of this book.
	*
	* @return the primary key of this book
	*/
	public long getPrimaryKey() {
		return _book.getPrimaryKey();
	}

	/**
	* Sets the primary key of this book.
	*
	* @param primaryKey the primary key of this book
	*/
	public void setPrimaryKey(long primaryKey) {
		_book.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the book ID of this book.
	*
	* @return the book ID of this book
	*/
	public long getBookId() {
		return _book.getBookId();
	}

	/**
	* Sets the book ID of this book.
	*
	* @param bookId the book ID of this book
	*/
	public void setBookId(long bookId) {
		_book.setBookId(bookId);
	}

	/**
	* Returns the book number of this book.
	*
	* @return the book number of this book
	*/
	public long getBookNumber() {
		return _book.getBookNumber();
	}

	/**
	* Sets the book number of this book.
	*
	* @param bookNumber the book number of this book
	*/
	public void setBookNumber(long bookNumber) {
		_book.setBookNumber(bookNumber);
	}

	/**
	* Returns the writer name of this book.
	*
	* @return the writer name of this book
	*/
	public java.lang.String getWriterName() {
		return _book.getWriterName();
	}

	/**
	* Sets the writer name of this book.
	*
	* @param writerName the writer name of this book
	*/
	public void setWriterName(java.lang.String writerName) {
		_book.setWriterName(writerName);
	}

	/**
	* Returns the create date of this book.
	*
	* @return the create date of this book
	*/
	public java.util.Date getCreateDate() {
		return _book.getCreateDate();
	}

	/**
	* Sets the create date of this book.
	*
	* @param createDate the create date of this book
	*/
	public void setCreateDate(java.util.Date createDate) {
		_book.setCreateDate(createDate);
	}

	/**
	* Returns the first name of this book.
	*
	* @return the first name of this book
	*/
	public java.lang.String getFirstName() {
		return _book.getFirstName();
	}

	/**
	* Sets the first name of this book.
	*
	* @param firstName the first name of this book
	*/
	public void setFirstName(java.lang.String firstName) {
		_book.setFirstName(firstName);
	}

	/**
	* Returns the last name of this book.
	*
	* @return the last name of this book
	*/
	public java.lang.String getLastName() {
		return _book.getLastName();
	}

	/**
	* Sets the last name of this book.
	*
	* @param lastName the last name of this book
	*/
	public void setLastName(java.lang.String lastName) {
		_book.setLastName(lastName);
	}

	/**
	* Returns the quantity of this book.
	*
	* @return the quantity of this book
	*/
	public int getQuantity() {
		return _book.getQuantity();
	}

	/**
	* Sets the quantity of this book.
	*
	* @param quantity the quantity of this book
	*/
	public void setQuantity(int quantity) {
		_book.setQuantity(quantity);
	}

	/**
	* Returns the total cost of this book.
	*
	* @return the total cost of this book
	*/
	public double getTotalCost() {
		return _book.getTotalCost();
	}

	/**
	* Sets the total cost of this book.
	*
	* @param totalCost the total cost of this book
	*/
	public void setTotalCost(double totalCost) {
		_book.setTotalCost(totalCost);
	}

	/**
	* Returns the status of this book.
	*
	* @return the status of this book
	*/
	public java.lang.String getStatus() {
		return _book.getStatus();
	}

	/**
	* Sets the status of this book.
	*
	* @param status the status of this book
	*/
	public void setStatus(java.lang.String status) {
		_book.setStatus(status);
	}

	public boolean isNew() {
		return _book.isNew();
	}

	public void setNew(boolean n) {
		_book.setNew(n);
	}

	public boolean isCachedModel() {
		return _book.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_book.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _book.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _book.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_book.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _book.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_book.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BookWrapper((Book)_book.clone());
	}

	public int compareTo(com.mpower.services.model.Book book) {
		return _book.compareTo(book);
	}

	@Override
	public int hashCode() {
		return _book.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.mpower.services.model.Book> toCacheModel() {
		return _book.toCacheModel();
	}

	public com.mpower.services.model.Book toEscapedModel() {
		return new BookWrapper(_book.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _book.toString();
	}

	public java.lang.String toXmlString() {
		return _book.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_book.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Book getWrappedBook() {
		return _book;
	}

	public Book getWrappedModel() {
		return _book;
	}

	public void resetOriginalValues() {
		_book.resetOriginalValues();
	}

	private Book _book;
}
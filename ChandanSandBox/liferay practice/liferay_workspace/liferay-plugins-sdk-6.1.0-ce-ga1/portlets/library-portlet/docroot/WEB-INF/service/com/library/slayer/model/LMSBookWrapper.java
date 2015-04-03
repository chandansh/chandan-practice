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
 * This class is a wrapper for {@link LMSBook}.
 * </p>
 *
 * @author    Ahmed Hasan
 * @see       LMSBook
 * @generated
 */
public class LMSBookWrapper implements LMSBook, ModelWrapper<LMSBook> {
	public LMSBookWrapper(LMSBook lmsBook) {
		_lmsBook = lmsBook;
	}

	public Class<?> getModelClass() {
		return LMSBook.class;
	}

	public String getModelClassName() {
		return LMSBook.class.getName();
	}

	/**
	* Returns the primary key of this l m s book.
	*
	* @return the primary key of this l m s book
	*/
	public long getPrimaryKey() {
		return _lmsBook.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s book.
	*
	* @param primaryKey the primary key of this l m s book
	*/
	public void setPrimaryKey(long primaryKey) {
		_lmsBook.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this l m s book.
	*
	* @return the uuid of this l m s book
	*/
	public java.lang.String getUuid() {
		return _lmsBook.getUuid();
	}

	/**
	* Sets the uuid of this l m s book.
	*
	* @param uuid the uuid of this l m s book
	*/
	public void setUuid(java.lang.String uuid) {
		_lmsBook.setUuid(uuid);
	}

	/**
	* Returns the book ID of this l m s book.
	*
	* @return the book ID of this l m s book
	*/
	public long getBookId() {
		return _lmsBook.getBookId();
	}

	/**
	* Sets the book ID of this l m s book.
	*
	* @param bookId the book ID of this l m s book
	*/
	public void setBookId(long bookId) {
		_lmsBook.setBookId(bookId);
	}

	/**
	* Returns the book title of this l m s book.
	*
	* @return the book title of this l m s book
	*/
	public java.lang.String getBookTitle() {
		return _lmsBook.getBookTitle();
	}

	/**
	* Sets the book title of this l m s book.
	*
	* @param bookTitle the book title of this l m s book
	*/
	public void setBookTitle(java.lang.String bookTitle) {
		_lmsBook.setBookTitle(bookTitle);
	}

	/**
	* Returns the author of this l m s book.
	*
	* @return the author of this l m s book
	*/
	public java.lang.String getAuthor() {
		return _lmsBook.getAuthor();
	}

	/**
	* Sets the author of this l m s book.
	*
	* @param author the author of this l m s book
	*/
	public void setAuthor(java.lang.String author) {
		_lmsBook.setAuthor(author);
	}

	/**
	* Returns the description of this l m s book.
	*
	* @return the description of this l m s book
	*/
	public java.lang.String getDescription() {
		return _lmsBook.getDescription();
	}

	/**
	* Sets the description of this l m s book.
	*
	* @param description the description of this l m s book
	*/
	public void setDescription(java.lang.String description) {
		_lmsBook.setDescription(description);
	}

	/**
	* Returns the file name of this l m s book.
	*
	* @return the file name of this l m s book
	*/
	public java.lang.String getFileName() {
		return _lmsBook.getFileName();
	}

	/**
	* Sets the file name of this l m s book.
	*
	* @param fileName the file name of this l m s book
	*/
	public void setFileName(java.lang.String fileName) {
		_lmsBook.setFileName(fileName);
	}

	/**
	* Returns the downloaded of this l m s book.
	*
	* @return the downloaded of this l m s book
	*/
	public int getDownloaded() {
		return _lmsBook.getDownloaded();
	}

	/**
	* Sets the downloaded of this l m s book.
	*
	* @param downloaded the downloaded of this l m s book
	*/
	public void setDownloaded(int downloaded) {
		_lmsBook.setDownloaded(downloaded);
	}

	/**
	* Returns the status of this l m s book.
	*
	* @return the status of this l m s book
	*/
	public int getStatus() {
		return _lmsBook.getStatus();
	}

	/**
	* Sets the status of this l m s book.
	*
	* @param status the status of this l m s book
	*/
	public void setStatus(int status) {
		_lmsBook.setStatus(status);
	}

	/**
	* Returns the company ID of this l m s book.
	*
	* @return the company ID of this l m s book
	*/
	public long getCompanyId() {
		return _lmsBook.getCompanyId();
	}

	/**
	* Sets the company ID of this l m s book.
	*
	* @param companyId the company ID of this l m s book
	*/
	public void setCompanyId(long companyId) {
		_lmsBook.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this l m s book.
	*
	* @return the group ID of this l m s book
	*/
	public long getGroupId() {
		return _lmsBook.getGroupId();
	}

	/**
	* Sets the group ID of this l m s book.
	*
	* @param groupId the group ID of this l m s book
	*/
	public void setGroupId(long groupId) {
		_lmsBook.setGroupId(groupId);
	}

	/**
	* Returns the create date of this l m s book.
	*
	* @return the create date of this l m s book
	*/
	public java.util.Date getCreateDate() {
		return _lmsBook.getCreateDate();
	}

	/**
	* Sets the create date of this l m s book.
	*
	* @param createDate the create date of this l m s book
	*/
	public void setCreateDate(java.util.Date createDate) {
		_lmsBook.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this l m s book.
	*
	* @return the modified date of this l m s book
	*/
	public java.util.Date getModifiedDate() {
		return _lmsBook.getModifiedDate();
	}

	/**
	* Sets the modified date of this l m s book.
	*
	* @param modifiedDate the modified date of this l m s book
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_lmsBook.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this l m s book.
	*
	* @return the user ID of this l m s book
	*/
	public long getUserId() {
		return _lmsBook.getUserId();
	}

	/**
	* Sets the user ID of this l m s book.
	*
	* @param userId the user ID of this l m s book
	*/
	public void setUserId(long userId) {
		_lmsBook.setUserId(userId);
	}

	/**
	* Returns the user uuid of this l m s book.
	*
	* @return the user uuid of this l m s book
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBook.getUserUuid();
	}

	/**
	* Sets the user uuid of this l m s book.
	*
	* @param userUuid the user uuid of this l m s book
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_lmsBook.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this l m s book.
	*
	* @return the user name of this l m s book
	*/
	public java.lang.String getUserName() {
		return _lmsBook.getUserName();
	}

	/**
	* Sets the user name of this l m s book.
	*
	* @param userName the user name of this l m s book
	*/
	public void setUserName(java.lang.String userName) {
		_lmsBook.setUserName(userName);
	}

	public boolean isNew() {
		return _lmsBook.isNew();
	}

	public void setNew(boolean n) {
		_lmsBook.setNew(n);
	}

	public boolean isCachedModel() {
		return _lmsBook.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_lmsBook.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _lmsBook.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsBook.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsBook.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsBook.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsBook.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSBookWrapper((LMSBook)_lmsBook.clone());
	}

	public int compareTo(com.library.slayer.model.LMSBook lmsBook) {
		return _lmsBook.compareTo(lmsBook);
	}

	@Override
	public int hashCode() {
		return _lmsBook.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.library.slayer.model.LMSBook> toCacheModel() {
		return _lmsBook.toCacheModel();
	}

	public com.library.slayer.model.LMSBook toEscapedModel() {
		return new LMSBookWrapper(_lmsBook.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsBook.toString();
	}

	public java.lang.String toXmlString() {
		return _lmsBook.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsBook.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LMSBook getWrappedLMSBook() {
		return _lmsBook;
	}

	public LMSBook getWrappedModel() {
		return _lmsBook;
	}

	public void resetOriginalValues() {
		_lmsBook.resetOriginalValues();
	}

	private LMSBook _lmsBook;
}
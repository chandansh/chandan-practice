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
 * This class is a wrapper for {@link LMSBookJoin}.
 * </p>
 *
 * @author    Ahmed Hasan
 * @see       LMSBookJoin
 * @generated
 */
public class LMSBookJoinWrapper implements LMSBookJoin,
	ModelWrapper<LMSBookJoin> {
	public LMSBookJoinWrapper(LMSBookJoin lmsBookJoin) {
		_lmsBookJoin = lmsBookJoin;
	}

	public Class<?> getModelClass() {
		return LMSBookJoin.class;
	}

	public String getModelClassName() {
		return LMSBookJoin.class.getName();
	}

	/**
	* Returns the primary key of this l m s book join.
	*
	* @return the primary key of this l m s book join
	*/
	public long getPrimaryKey() {
		return _lmsBookJoin.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l m s book join.
	*
	* @param primaryKey the primary key of this l m s book join
	*/
	public void setPrimaryKey(long primaryKey) {
		_lmsBookJoin.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the join ID of this l m s book join.
	*
	* @return the join ID of this l m s book join
	*/
	public long getJoinId() {
		return _lmsBookJoin.getJoinId();
	}

	/**
	* Sets the join ID of this l m s book join.
	*
	* @param joinId the join ID of this l m s book join
	*/
	public void setJoinId(long joinId) {
		_lmsBookJoin.setJoinId(joinId);
	}

	/**
	* Returns the book ID of this l m s book join.
	*
	* @return the book ID of this l m s book join
	*/
	public long getBookId() {
		return _lmsBookJoin.getBookId();
	}

	/**
	* Sets the book ID of this l m s book join.
	*
	* @param bookId the book ID of this l m s book join
	*/
	public void setBookId(long bookId) {
		_lmsBookJoin.setBookId(bookId);
	}

	/**
	* Returns the user ID of this l m s book join.
	*
	* @return the user ID of this l m s book join
	*/
	public long getUserId() {
		return _lmsBookJoin.getUserId();
	}

	/**
	* Sets the user ID of this l m s book join.
	*
	* @param userId the user ID of this l m s book join
	*/
	public void setUserId(long userId) {
		_lmsBookJoin.setUserId(userId);
	}

	/**
	* Returns the user uuid of this l m s book join.
	*
	* @return the user uuid of this l m s book join
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lmsBookJoin.getUserUuid();
	}

	/**
	* Sets the user uuid of this l m s book join.
	*
	* @param userUuid the user uuid of this l m s book join
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_lmsBookJoin.setUserUuid(userUuid);
	}

	/**
	* Returns the book title of this l m s book join.
	*
	* @return the book title of this l m s book join
	*/
	public java.lang.String getBookTitle() {
		return _lmsBookJoin.getBookTitle();
	}

	/**
	* Sets the book title of this l m s book join.
	*
	* @param bookTitle the book title of this l m s book join
	*/
	public void setBookTitle(java.lang.String bookTitle) {
		_lmsBookJoin.setBookTitle(bookTitle);
	}

	/**
	* Returns the author of this l m s book join.
	*
	* @return the author of this l m s book join
	*/
	public java.lang.String getAuthor() {
		return _lmsBookJoin.getAuthor();
	}

	/**
	* Sets the author of this l m s book join.
	*
	* @param author the author of this l m s book join
	*/
	public void setAuthor(java.lang.String author) {
		_lmsBookJoin.setAuthor(author);
	}

	/**
	* Returns the first name of this l m s book join.
	*
	* @return the first name of this l m s book join
	*/
	public java.lang.String getFirstName() {
		return _lmsBookJoin.getFirstName();
	}

	/**
	* Sets the first name of this l m s book join.
	*
	* @param firstName the first name of this l m s book join
	*/
	public void setFirstName(java.lang.String firstName) {
		_lmsBookJoin.setFirstName(firstName);
	}

	/**
	* Returns the last name of this l m s book join.
	*
	* @return the last name of this l m s book join
	*/
	public java.lang.String getLastName() {
		return _lmsBookJoin.getLastName();
	}

	/**
	* Sets the last name of this l m s book join.
	*
	* @param lastName the last name of this l m s book join
	*/
	public void setLastName(java.lang.String lastName) {
		_lmsBookJoin.setLastName(lastName);
	}

	/**
	* Returns the city of this l m s book join.
	*
	* @return the city of this l m s book join
	*/
	public java.lang.String getCity() {
		return _lmsBookJoin.getCity();
	}

	/**
	* Sets the city of this l m s book join.
	*
	* @param city the city of this l m s book join
	*/
	public void setCity(java.lang.String city) {
		_lmsBookJoin.setCity(city);
	}

	/**
	* Returns the zip of this l m s book join.
	*
	* @return the zip of this l m s book join
	*/
	public java.lang.String getZip() {
		return _lmsBookJoin.getZip();
	}

	/**
	* Sets the zip of this l m s book join.
	*
	* @param zip the zip of this l m s book join
	*/
	public void setZip(java.lang.String zip) {
		_lmsBookJoin.setZip(zip);
	}

	/**
	* Returns the email address of this l m s book join.
	*
	* @return the email address of this l m s book join
	*/
	public java.lang.String getEmailAddress() {
		return _lmsBookJoin.getEmailAddress();
	}

	/**
	* Sets the email address of this l m s book join.
	*
	* @param emailAddress the email address of this l m s book join
	*/
	public void setEmailAddress(java.lang.String emailAddress) {
		_lmsBookJoin.setEmailAddress(emailAddress);
	}

	public boolean isNew() {
		return _lmsBookJoin.isNew();
	}

	public void setNew(boolean n) {
		_lmsBookJoin.setNew(n);
	}

	public boolean isCachedModel() {
		return _lmsBookJoin.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_lmsBookJoin.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _lmsBookJoin.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _lmsBookJoin.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_lmsBookJoin.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _lmsBookJoin.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_lmsBookJoin.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LMSBookJoinWrapper((LMSBookJoin)_lmsBookJoin.clone());
	}

	public int compareTo(com.library.slayer.model.LMSBookJoin lmsBookJoin) {
		return _lmsBookJoin.compareTo(lmsBookJoin);
	}

	@Override
	public int hashCode() {
		return _lmsBookJoin.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.library.slayer.model.LMSBookJoin> toCacheModel() {
		return _lmsBookJoin.toCacheModel();
	}

	public com.library.slayer.model.LMSBookJoin toEscapedModel() {
		return new LMSBookJoinWrapper(_lmsBookJoin.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _lmsBookJoin.toString();
	}

	public java.lang.String toXmlString() {
		return _lmsBookJoin.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_lmsBookJoin.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LMSBookJoin getWrappedLMSBookJoin() {
		return _lmsBookJoin;
	}

	public LMSBookJoin getWrappedModel() {
		return _lmsBookJoin;
	}

	public void resetOriginalValues() {
		_lmsBookJoin.resetOriginalValues();
	}

	private LMSBookJoin _lmsBookJoin;
}
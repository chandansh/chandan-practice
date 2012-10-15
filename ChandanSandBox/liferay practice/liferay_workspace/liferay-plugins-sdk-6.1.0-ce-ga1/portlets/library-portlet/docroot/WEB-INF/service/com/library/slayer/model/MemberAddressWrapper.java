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
 * This class is a wrapper for {@link MemberAddress}.
 * </p>
 *
 * @author    Ahmed Hasan
 * @see       MemberAddress
 * @generated
 */
public class MemberAddressWrapper implements MemberAddress,
	ModelWrapper<MemberAddress> {
	public MemberAddressWrapper(MemberAddress memberAddress) {
		_memberAddress = memberAddress;
	}

	public Class<?> getModelClass() {
		return MemberAddress.class;
	}

	public String getModelClassName() {
		return MemberAddress.class.getName();
	}

	/**
	* Returns the primary key of this member address.
	*
	* @return the primary key of this member address
	*/
	public long getPrimaryKey() {
		return _memberAddress.getPrimaryKey();
	}

	/**
	* Sets the primary key of this member address.
	*
	* @param primaryKey the primary key of this member address
	*/
	public void setPrimaryKey(long primaryKey) {
		_memberAddress.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this member address.
	*
	* @return the user ID of this member address
	*/
	public long getUserId() {
		return _memberAddress.getUserId();
	}

	/**
	* Sets the user ID of this member address.
	*
	* @param userId the user ID of this member address
	*/
	public void setUserId(long userId) {
		_memberAddress.setUserId(userId);
	}

	/**
	* Returns the user uuid of this member address.
	*
	* @return the user uuid of this member address
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _memberAddress.getUserUuid();
	}

	/**
	* Sets the user uuid of this member address.
	*
	* @param userUuid the user uuid of this member address
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_memberAddress.setUserUuid(userUuid);
	}

	/**
	* Returns the first name of this member address.
	*
	* @return the first name of this member address
	*/
	public java.lang.String getFirstName() {
		return _memberAddress.getFirstName();
	}

	/**
	* Sets the first name of this member address.
	*
	* @param firstName the first name of this member address
	*/
	public void setFirstName(java.lang.String firstName) {
		_memberAddress.setFirstName(firstName);
	}

	/**
	* Returns the last name of this member address.
	*
	* @return the last name of this member address
	*/
	public java.lang.String getLastName() {
		return _memberAddress.getLastName();
	}

	/**
	* Sets the last name of this member address.
	*
	* @param lastName the last name of this member address
	*/
	public void setLastName(java.lang.String lastName) {
		_memberAddress.setLastName(lastName);
	}

	/**
	* Returns the street address1 of this member address.
	*
	* @return the street address1 of this member address
	*/
	public java.lang.String getStreetAddress1() {
		return _memberAddress.getStreetAddress1();
	}

	/**
	* Sets the street address1 of this member address.
	*
	* @param streetAddress1 the street address1 of this member address
	*/
	public void setStreetAddress1(java.lang.String streetAddress1) {
		_memberAddress.setStreetAddress1(streetAddress1);
	}

	/**
	* Returns the street address2 of this member address.
	*
	* @return the street address2 of this member address
	*/
	public java.lang.String getStreetAddress2() {
		return _memberAddress.getStreetAddress2();
	}

	/**
	* Sets the street address2 of this member address.
	*
	* @param streetAddress2 the street address2 of this member address
	*/
	public void setStreetAddress2(java.lang.String streetAddress2) {
		_memberAddress.setStreetAddress2(streetAddress2);
	}

	/**
	* Returns the city of this member address.
	*
	* @return the city of this member address
	*/
	public java.lang.String getCity() {
		return _memberAddress.getCity();
	}

	/**
	* Sets the city of this member address.
	*
	* @param city the city of this member address
	*/
	public void setCity(java.lang.String city) {
		_memberAddress.setCity(city);
	}

	/**
	* Returns the zip of this member address.
	*
	* @return the zip of this member address
	*/
	public java.lang.String getZip() {
		return _memberAddress.getZip();
	}

	/**
	* Sets the zip of this member address.
	*
	* @param zip the zip of this member address
	*/
	public void setZip(java.lang.String zip) {
		_memberAddress.setZip(zip);
	}

	/**
	* Returns the email address of this member address.
	*
	* @return the email address of this member address
	*/
	public java.lang.String getEmailAddress() {
		return _memberAddress.getEmailAddress();
	}

	/**
	* Sets the email address of this member address.
	*
	* @param emailAddress the email address of this member address
	*/
	public void setEmailAddress(java.lang.String emailAddress) {
		_memberAddress.setEmailAddress(emailAddress);
	}

	/**
	* Returns the phone number of this member address.
	*
	* @return the phone number of this member address
	*/
	public java.lang.String getPhoneNumber() {
		return _memberAddress.getPhoneNumber();
	}

	/**
	* Sets the phone number of this member address.
	*
	* @param phoneNumber the phone number of this member address
	*/
	public void setPhoneNumber(java.lang.String phoneNumber) {
		_memberAddress.setPhoneNumber(phoneNumber);
	}

	/**
	* Returns the mobile number of this member address.
	*
	* @return the mobile number of this member address
	*/
	public java.lang.String getMobileNumber() {
		return _memberAddress.getMobileNumber();
	}

	/**
	* Sets the mobile number of this member address.
	*
	* @param mobileNumber the mobile number of this member address
	*/
	public void setMobileNumber(java.lang.String mobileNumber) {
		_memberAddress.setMobileNumber(mobileNumber);
	}

	/**
	* Returns the date added of this member address.
	*
	* @return the date added of this member address
	*/
	public java.util.Date getDateAdded() {
		return _memberAddress.getDateAdded();
	}

	/**
	* Sets the date added of this member address.
	*
	* @param dateAdded the date added of this member address
	*/
	public void setDateAdded(java.util.Date dateAdded) {
		_memberAddress.setDateAdded(dateAdded);
	}

	public boolean isNew() {
		return _memberAddress.isNew();
	}

	public void setNew(boolean n) {
		_memberAddress.setNew(n);
	}

	public boolean isCachedModel() {
		return _memberAddress.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_memberAddress.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _memberAddress.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _memberAddress.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_memberAddress.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _memberAddress.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_memberAddress.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MemberAddressWrapper((MemberAddress)_memberAddress.clone());
	}

	public int compareTo(com.library.slayer.model.MemberAddress memberAddress) {
		return _memberAddress.compareTo(memberAddress);
	}

	@Override
	public int hashCode() {
		return _memberAddress.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.library.slayer.model.MemberAddress> toCacheModel() {
		return _memberAddress.toCacheModel();
	}

	public com.library.slayer.model.MemberAddress toEscapedModel() {
		return new MemberAddressWrapper(_memberAddress.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _memberAddress.toString();
	}

	public java.lang.String toXmlString() {
		return _memberAddress.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_memberAddress.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public MemberAddress getWrappedMemberAddress() {
		return _memberAddress;
	}

	public MemberAddress getWrappedModel() {
		return _memberAddress;
	}

	public void resetOriginalValues() {
		_memberAddress.resetOriginalValues();
	}

	private MemberAddress _memberAddress;
}
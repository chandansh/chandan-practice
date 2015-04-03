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

package com.test.slayer.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author    Chandan
 * @see       Address
 * @generated
 */
public class AddressWrapper implements Address, ModelWrapper<Address> {
	public AddressWrapper(Address address) {
		_address = address;
	}

	public Class<?> getModelClass() {
		return Address.class;
	}

	public String getModelClassName() {
		return Address.class.getName();
	}

	/**
	* Returns the primary key of this address.
	*
	* @return the primary key of this address
	*/
	public long getPrimaryKey() {
		return _address.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address.
	*
	* @param primaryKey the primary key of this address
	*/
	public void setPrimaryKey(long primaryKey) {
		_address.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the add ID of this address.
	*
	* @return the add ID of this address
	*/
	public long getAddId() {
		return _address.getAddId();
	}

	/**
	* Sets the add ID of this address.
	*
	* @param addId the add ID of this address
	*/
	public void setAddId(long addId) {
		_address.setAddId(addId);
	}

	/**
	* Returns the company ID of this address.
	*
	* @return the company ID of this address
	*/
	public long getCompanyId() {
		return _address.getCompanyId();
	}

	/**
	* Sets the company ID of this address.
	*
	* @param companyId the company ID of this address
	*/
	public void setCompanyId(long companyId) {
		_address.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this address.
	*
	* @return the user ID of this address
	*/
	public long getUserId() {
		return _address.getUserId();
	}

	/**
	* Sets the user ID of this address.
	*
	* @param userId the user ID of this address
	*/
	public void setUserId(long userId) {
		_address.setUserId(userId);
	}

	/**
	* Returns the user uuid of this address.
	*
	* @return the user uuid of this address
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _address.getUserUuid();
	}

	/**
	* Sets the user uuid of this address.
	*
	* @param userUuid the user uuid of this address
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_address.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this address.
	*
	* @return the user name of this address
	*/
	public java.lang.String getUserName() {
		return _address.getUserName();
	}

	/**
	* Sets the user name of this address.
	*
	* @param userName the user name of this address
	*/
	public void setUserName(java.lang.String userName) {
		_address.setUserName(userName);
	}

	/**
	* Returns the create date of this address.
	*
	* @return the create date of this address
	*/
	public java.util.Date getCreateDate() {
		return _address.getCreateDate();
	}

	/**
	* Sets the create date of this address.
	*
	* @param createDate the create date of this address
	*/
	public void setCreateDate(java.util.Date createDate) {
		_address.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this address.
	*
	* @return the modified date of this address
	*/
	public java.util.Date getModifiedDate() {
		return _address.getModifiedDate();
	}

	/**
	* Sets the modified date of this address.
	*
	* @param modifiedDate the modified date of this address
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_address.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the address of this address.
	*
	* @return the address of this address
	*/
	public java.lang.String getAddress() {
		return _address.getAddress();
	}

	/**
	* Sets the address of this address.
	*
	* @param address the address of this address
	*/
	public void setAddress(java.lang.String address) {
		_address.setAddress(address);
	}

	/**
	* Returns the city of this address.
	*
	* @return the city of this address
	*/
	public java.lang.String getCity() {
		return _address.getCity();
	}

	/**
	* Sets the city of this address.
	*
	* @param city the city of this address
	*/
	public void setCity(java.lang.String city) {
		_address.setCity(city);
	}

	/**
	* Returns the state of this address.
	*
	* @return the state of this address
	*/
	public java.lang.String getState() {
		return _address.getState();
	}

	/**
	* Sets the state of this address.
	*
	* @param state the state of this address
	*/
	public void setState(java.lang.String state) {
		_address.setState(state);
	}

	/**
	* Returns the pin of this address.
	*
	* @return the pin of this address
	*/
	public java.lang.String getPin() {
		return _address.getPin();
	}

	/**
	* Sets the pin of this address.
	*
	* @param pin the pin of this address
	*/
	public void setPin(java.lang.String pin) {
		_address.setPin(pin);
	}

	public boolean isNew() {
		return _address.isNew();
	}

	public void setNew(boolean n) {
		_address.setNew(n);
	}

	public boolean isCachedModel() {
		return _address.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_address.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _address.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _address.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_address.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _address.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_address.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressWrapper((Address)_address.clone());
	}

	public int compareTo(Address address) {
		return _address.compareTo(address);
	}

	@Override
	public int hashCode() {
		return _address.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Address> toCacheModel() {
		return _address.toCacheModel();
	}

	public Address toEscapedModel() {
		return new AddressWrapper(_address.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _address.toString();
	}

	public java.lang.String toXmlString() {
		return _address.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_address.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Address getWrappedAddress() {
		return _address;
	}

	public Address getWrappedModel() {
		return _address;
	}

	public void resetOriginalValues() {
		_address.resetOriginalValues();
	}

	private Address _address;
}
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.mpower.training.customer.model;

/**
 * <p>
 * This class is a wrapper for {@link MyCustomer}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MyCustomer
 * @generated
 */
public class MyCustomerWrapper implements MyCustomer {
	public MyCustomerWrapper(MyCustomer myCustomer) {
		_myCustomer = myCustomer;
	}

	public long getPrimaryKey() {
		return _myCustomer.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_myCustomer.setPrimaryKey(pk);
	}

	public long getId() {
		return _myCustomer.getId();
	}

	public void setId(long id) {
		_myCustomer.setId(id);
	}

	public java.lang.String getName() {
		return _myCustomer.getName();
	}

	public void setName(java.lang.String name) {
		_myCustomer.setName(name);
	}

	public java.lang.String getAddress() {
		return _myCustomer.getAddress();
	}

	public void setAddress(java.lang.String address) {
		_myCustomer.setAddress(address);
	}

	public MyCustomer toEscapedModel() {
		return _myCustomer.toEscapedModel();
	}

	public boolean isNew() {
		return _myCustomer.isNew();
	}

	public void setNew(boolean n) {
		_myCustomer.setNew(n);
	}

	public boolean isCachedModel() {
		return _myCustomer.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_myCustomer.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _myCustomer.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_myCustomer.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _myCustomer.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _myCustomer.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_myCustomer.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _myCustomer.clone();
	}

	public int compareTo(MyCustomer myCustomer) {
		return _myCustomer.compareTo(myCustomer);
	}

	public int hashCode() {
		return _myCustomer.hashCode();
	}

	public java.lang.String toString() {
		return _myCustomer.toString();
	}

	public java.lang.String toXmlString() {
		return _myCustomer.toXmlString();
	}

	public MyCustomer getWrappedMyCustomer() {
		return _myCustomer;
	}

	private MyCustomer _myCustomer;
}
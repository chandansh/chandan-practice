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

package com.mpoer.training.customer.model;

/**
 * <p>
 * This class is a wrapper for {@link Customer}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Customer
 * @generated
 */
public class CustomerWrapper implements Customer {
	public CustomerWrapper(Customer customer) {
		_customer = customer;
	}

	public long getPrimaryKey() {
		return _customer.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_customer.setPrimaryKey(pk);
	}

	public long getId() {
		return _customer.getId();
	}

	public void setId(long id) {
		_customer.setId(id);
	}

	public java.lang.String getName() {
		return _customer.getName();
	}

	public void setName(java.lang.String name) {
		_customer.setName(name);
	}

	public java.lang.String getAddress() {
		return _customer.getAddress();
	}

	public void setAddress(java.lang.String address) {
		_customer.setAddress(address);
	}

	public java.util.Date getInductionDate() {
		return _customer.getInductionDate();
	}

	public void setInductionDate(java.util.Date inductionDate) {
		_customer.setInductionDate(inductionDate);
	}

	public com.mpoer.training.customer.model.Customer toEscapedModel() {
		return _customer.toEscapedModel();
	}

	public boolean isNew() {
		return _customer.isNew();
	}

	public void setNew(boolean n) {
		_customer.setNew(n);
	}

	public boolean isCachedModel() {
		return _customer.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_customer.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _customer.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_customer.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _customer.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _customer.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_customer.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _customer.clone();
	}

	public int compareTo(com.mpoer.training.customer.model.Customer customer) {
		return _customer.compareTo(customer);
	}

	public int hashCode() {
		return _customer.hashCode();
	}

	public java.lang.String toString() {
		return _customer.toString();
	}

	public java.lang.String toXmlString() {
		return _customer.toXmlString();
	}

	public java.lang.String getDetails() {
		return _customer.getDetails();
	}

	public Customer getWrappedCustomer() {
		return _customer;
	}

	private Customer _customer;
}
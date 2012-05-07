/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.coleg.model;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author    chandan
 * @see       Employee
 * @generated
 */
public class EmployeeWrapper implements Employee {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
	}

	public java.lang.String getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	public void setPrimaryKey(java.lang.String pk) {
		_employee.setPrimaryKey(pk);
	}

	public java.lang.String getId() {
		return _employee.getId();
	}

	public void setId(java.lang.String id) {
		_employee.setId(id);
	}

	public java.lang.String getName() {
		return _employee.getName();
	}

	public void setName(java.lang.String name) {
		_employee.setName(name);
	}

	public java.lang.String getAddress() {
		return _employee.getAddress();
	}

	public void setAddress(java.lang.String address) {
		_employee.setAddress(address);
	}

	public com.coleg.model.Employee toEscapedModel() {
		return _employee.toEscapedModel();
	}

	public boolean isNew() {
		return _employee.isNew();
	}

	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_employee.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _employee.clone();
	}

	public int compareTo(com.coleg.model.Employee employee) {
		return _employee.compareTo(employee);
	}

	public int hashCode() {
		return _employee.hashCode();
	}

	public java.lang.String toString() {
		return _employee.toString();
	}

	public java.lang.String toXmlString() {
		return _employee.toXmlString();
	}

	public Employee getWrappedEmployee() {
		return _employee;
	}

	private Employee _employee;
}
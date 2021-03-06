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
 * This class is a wrapper for {@link Emp}.
 * </p>
 *
 * @author    chandan
 * @see       Emp
 * @generated
 */
public class EmpWrapper implements Emp {
	public EmpWrapper(Emp emp) {
		_emp = emp;
	}

	public java.lang.String getPrimaryKey() {
		return _emp.getPrimaryKey();
	}

	public void setPrimaryKey(java.lang.String pk) {
		_emp.setPrimaryKey(pk);
	}

	public java.lang.String getEmpId() {
		return _emp.getEmpId();
	}

	public void setEmpId(java.lang.String empId) {
		_emp.setEmpId(empId);
	}

	public java.lang.String getUname() {
		return _emp.getUname();
	}

	public void setUname(java.lang.String uname) {
		_emp.setUname(uname);
	}

	public java.lang.String getAddress() {
		return _emp.getAddress();
	}

	public void setAddress(java.lang.String address) {
		_emp.setAddress(address);
	}

	public Emp toEscapedModel() {
		return _emp.toEscapedModel();
	}

	public boolean isNew() {
		return _emp.isNew();
	}

	public void setNew(boolean n) {
		_emp.setNew(n);
	}

	public boolean isCachedModel() {
		return _emp.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_emp.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _emp.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_emp.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _emp.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _emp.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_emp.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _emp.clone();
	}

	public int compareTo(Emp emp) {
		return _emp.compareTo(emp);
	}

	public int hashCode() {
		return _emp.hashCode();
	}

	public java.lang.String toString() {
		return _emp.toString();
	}

	public java.lang.String toXmlString() {
		return _emp.toXmlString();
	}

	public Emp getWrappedEmp() {
		return _emp;
	}

	private Emp _emp;
}
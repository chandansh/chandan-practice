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

package com.mpower.training.order.model;

/**
 * <p>
 * This class is a wrapper for {@link MyOrder}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MyOrder
 * @generated
 */
public class MyOrderWrapper implements MyOrder {
	public MyOrderWrapper(MyOrder myOrder) {
		_myOrder = myOrder;
	}

	public long getPrimaryKey() {
		return _myOrder.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_myOrder.setPrimaryKey(pk);
	}

	public long getId() {
		return _myOrder.getId();
	}

	public void setId(long id) {
		_myOrder.setId(id);
	}

	public java.lang.String getName() {
		return _myOrder.getName();
	}

	public void setName(java.lang.String name) {
		_myOrder.setName(name);
	}

	public java.lang.String getDescription() {
		return _myOrder.getDescription();
	}

	public void setDescription(java.lang.String description) {
		_myOrder.setDescription(description);
	}

	public com.mpower.training.order.model.MyOrder toEscapedModel() {
		return _myOrder.toEscapedModel();
	}

	public boolean isNew() {
		return _myOrder.isNew();
	}

	public void setNew(boolean n) {
		_myOrder.setNew(n);
	}

	public boolean isCachedModel() {
		return _myOrder.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_myOrder.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _myOrder.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_myOrder.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _myOrder.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _myOrder.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_myOrder.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _myOrder.clone();
	}

	public int compareTo(com.mpower.training.order.model.MyOrder myOrder) {
		return _myOrder.compareTo(myOrder);
	}

	public int hashCode() {
		return _myOrder.hashCode();
	}

	public java.lang.String toString() {
		return _myOrder.toString();
	}

	public java.lang.String toXmlString() {
		return _myOrder.toXmlString();
	}

	public MyOrder getWrappedMyOrder() {
		return _myOrder;
	}

	private MyOrder _myOrder;
}
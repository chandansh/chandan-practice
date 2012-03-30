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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the MyCustomer service. Represents a row in the &quot;myCust_training_MyCustomer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.mpower.training.customer.model.impl.MyCustomerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.mpower.training.customer.model.impl.MyCustomerImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a my customer model instance should use the {@link MyCustomer} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyCustomer
 * @see com.mpower.training.customer.model.impl.MyCustomerImpl
 * @see com.mpower.training.customer.model.impl.MyCustomerModelImpl
 * @generated
 */
public interface MyCustomerModel extends BaseModel<MyCustomer> {
	/**
	 * Gets the primary key of this my customer.
	 *
	 * @return the primary key of this my customer
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this my customer
	 *
	 * @param pk the primary key of this my customer
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the id of this my customer.
	 *
	 * @return the id of this my customer
	 */
	public long getId();

	/**
	 * Sets the id of this my customer.
	 *
	 * @param id the id of this my customer
	 */
	public void setId(long id);

	/**
	 * Gets the name of this my customer.
	 *
	 * @return the name of this my customer
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this my customer.
	 *
	 * @param name the name of this my customer
	 */
	public void setName(String name);

	/**
	 * Gets the address of this my customer.
	 *
	 * @return the address of this my customer
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this my customer.
	 *
	 * @param address the address of this my customer
	 */
	public void setAddress(String address);

	/**
	 * Gets a copy of this my customer as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public MyCustomer toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(MyCustomer myCustomer);

	public int hashCode();

	public String toString();

	public String toXmlString();
}
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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Customer service. Represents a row in the &quot;myportlet_coleg_Customer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.coleg.model.impl.CustomerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.coleg.model.impl.CustomerImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a customer model instance should use the {@link Customer} interface instead.
 * </p>
 *
 * @author supriya
 * @see Customer
 * @see com.coleg.model.impl.CustomerImpl
 * @see com.coleg.model.impl.CustomerModelImpl
 * @generated
 */
public interface CustomerModel extends BaseModel<Customer> {
	/**
	 * Gets the primary key of this customer.
	 *
	 * @return the primary key of this customer
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this customer
	 *
	 * @param pk the primary key of this customer
	 */
	public void setPrimaryKey(String pk);

	/**
	 * Gets the id of this customer.
	 *
	 * @return the id of this customer
	 */
	@AutoEscape
	public String getId();

	/**
	 * Sets the id of this customer.
	 *
	 * @param id the id of this customer
	 */
	public void setId(String id);

	/**
	 * Gets the name of this customer.
	 *
	 * @return the name of this customer
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this customer.
	 *
	 * @param name the name of this customer
	 */
	public void setName(String name);

	/**
	 * Gets the company of this customer.
	 *
	 * @return the company of this customer
	 */
	@AutoEscape
	public String getCompany();

	/**
	 * Sets the company of this customer.
	 *
	 * @param company the company of this customer
	 */
	public void setCompany(String company);

	/**
	 * Gets the address of this customer.
	 *
	 * @return the address of this customer
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this customer.
	 *
	 * @param address the address of this customer
	 */
	public void setAddress(String address);

	/**
	 * Gets a copy of this customer as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Customer toEscapedModel();

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

	public int compareTo(Customer customer);

	public int hashCode();

	public String toString();

	public String toXmlString();
}
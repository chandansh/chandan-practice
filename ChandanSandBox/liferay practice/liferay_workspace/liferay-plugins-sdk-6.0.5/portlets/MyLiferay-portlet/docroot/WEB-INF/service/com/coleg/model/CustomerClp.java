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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author supriya
 */
public class CustomerClp extends BaseModelImpl<Customer> implements Customer {
	public CustomerClp() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public Customer toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Customer)Proxy.newProxyInstance(Customer.class.getClassLoader(),
				new Class[] { Customer.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		CustomerClp clone = new CustomerClp();

		clone.setId(getId());
		clone.setName(getName());
		clone.setCompany(getCompany());
		clone.setAddress(getAddress());

		return clone;
	}

	public int compareTo(Customer customer) {
		String pk = customer.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CustomerClp customer = null;

		try {
			customer = (CustomerClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = customer.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.coleg.model.Customer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private String _name;
	private String _company;
	private String _address;
}
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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.coleg.service.http.CustomerServiceSoap}.
 * </p>
 *
 * @author    supriya
 * @see       com.coleg.service.http.CustomerServiceSoap
 * @generated
 */
public class CustomerSoap implements Serializable {
	public static CustomerSoap toSoapModel(Customer model) {
		CustomerSoap soapModel = new CustomerSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setCompany(model.getCompany());
		soapModel.setAddress(model.getAddress());

		return soapModel;
	}

	public static CustomerSoap[] toSoapModels(Customer[] models) {
		CustomerSoap[] soapModels = new CustomerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[][] toSoapModels(Customer[][] models) {
		CustomerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomerSoap[] toSoapModels(List<Customer> models) {
		List<CustomerSoap> soapModels = new ArrayList<CustomerSoap>(models.size());

		for (Customer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomerSoap[soapModels.size()]);
	}

	public CustomerSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
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

	private String _id;
	private String _name;
	private String _company;
	private String _address;
}
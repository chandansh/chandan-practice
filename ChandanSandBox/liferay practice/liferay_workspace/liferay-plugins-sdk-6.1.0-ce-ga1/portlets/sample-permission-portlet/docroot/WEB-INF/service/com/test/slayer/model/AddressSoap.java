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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Chandan
 * @generated
 */
public class AddressSoap implements Serializable {
	public static AddressSoap toSoapModel(Address model) {
		AddressSoap soapModel = new AddressSoap();

		soapModel.setAddId(model.getAddId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAddress(model.getAddress());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setPin(model.getPin());

		return soapModel;
	}

	public static AddressSoap[] toSoapModels(Address[] models) {
		AddressSoap[] soapModels = new AddressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressSoap[][] toSoapModels(Address[][] models) {
		AddressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressSoap[] toSoapModels(List<Address> models) {
		List<AddressSoap> soapModels = new ArrayList<AddressSoap>(models.size());

		for (Address model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressSoap[soapModels.size()]);
	}

	public AddressSoap() {
	}

	public long getPrimaryKey() {
		return _addId;
	}

	public void setPrimaryKey(long pk) {
		setAddId(pk);
	}

	public long getAddId() {
		return _addId;
	}

	public void setAddId(long addId) {
		_addId = addId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getPin() {
		return _pin;
	}

	public void setPin(String pin) {
		_pin = pin;
	}

	private long _addId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _address;
	private String _city;
	private String _state;
	private String _pin;
}
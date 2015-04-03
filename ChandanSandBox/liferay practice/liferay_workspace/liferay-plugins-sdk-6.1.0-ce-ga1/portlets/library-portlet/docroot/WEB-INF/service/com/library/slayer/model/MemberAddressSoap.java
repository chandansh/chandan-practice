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

package com.library.slayer.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Ahmed Hasan
 * @generated
 */
public class MemberAddressSoap implements Serializable {
	public static MemberAddressSoap toSoapModel(MemberAddress model) {
		MemberAddressSoap soapModel = new MemberAddressSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setStreetAddress1(model.getStreetAddress1());
		soapModel.setStreetAddress2(model.getStreetAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setZip(model.getZip());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setMobileNumber(model.getMobileNumber());
		soapModel.setDateAdded(model.getDateAdded());

		return soapModel;
	}

	public static MemberAddressSoap[] toSoapModels(MemberAddress[] models) {
		MemberAddressSoap[] soapModels = new MemberAddressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MemberAddressSoap[][] toSoapModels(MemberAddress[][] models) {
		MemberAddressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MemberAddressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MemberAddressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MemberAddressSoap[] toSoapModels(List<MemberAddress> models) {
		List<MemberAddressSoap> soapModels = new ArrayList<MemberAddressSoap>(models.size());

		for (MemberAddress model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MemberAddressSoap[soapModels.size()]);
	}

	public MemberAddressSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getStreetAddress1() {
		return _streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		_streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return _streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		_streetAddress2 = streetAddress2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return _mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		_mobileNumber = mobileNumber;
	}

	public Date getDateAdded() {
		return _dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		_dateAdded = dateAdded;
	}

	private long _userId;
	private String _firstName;
	private String _lastName;
	private String _streetAddress1;
	private String _streetAddress2;
	private String _city;
	private String _zip;
	private String _emailAddress;
	private String _phoneNumber;
	private String _mobileNumber;
	private Date _dateAdded;
}
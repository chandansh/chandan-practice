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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Ahmed Hasan
 * @generated
 */
public class LMSBookJoinSoap implements Serializable {
	public static LMSBookJoinSoap toSoapModel(LMSBookJoin model) {
		LMSBookJoinSoap soapModel = new LMSBookJoinSoap();

		soapModel.setJoinId(model.getJoinId());
		soapModel.setBookId(model.getBookId());
		soapModel.setUserId(model.getUserId());
		soapModel.setBookTitle(model.getBookTitle());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setCity(model.getCity());
		soapModel.setZip(model.getZip());
		soapModel.setEmailAddress(model.getEmailAddress());

		return soapModel;
	}

	public static LMSBookJoinSoap[] toSoapModels(LMSBookJoin[] models) {
		LMSBookJoinSoap[] soapModels = new LMSBookJoinSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSBookJoinSoap[][] toSoapModels(LMSBookJoin[][] models) {
		LMSBookJoinSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSBookJoinSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSBookJoinSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSBookJoinSoap[] toSoapModels(List<LMSBookJoin> models) {
		List<LMSBookJoinSoap> soapModels = new ArrayList<LMSBookJoinSoap>(models.size());

		for (LMSBookJoin model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSBookJoinSoap[soapModels.size()]);
	}

	public LMSBookJoinSoap() {
	}

	public long getPrimaryKey() {
		return _joinId;
	}

	public void setPrimaryKey(long pk) {
		setJoinId(pk);
	}

	public long getJoinId() {
		return _joinId;
	}

	public void setJoinId(long joinId) {
		_joinId = joinId;
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getBookTitle() {
		return _bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		_bookTitle = bookTitle;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
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

	private long _joinId;
	private long _bookId;
	private long _userId;
	private String _bookTitle;
	private String _author;
	private String _firstName;
	private String _lastName;
	private String _city;
	private String _zip;
	private String _emailAddress;
}
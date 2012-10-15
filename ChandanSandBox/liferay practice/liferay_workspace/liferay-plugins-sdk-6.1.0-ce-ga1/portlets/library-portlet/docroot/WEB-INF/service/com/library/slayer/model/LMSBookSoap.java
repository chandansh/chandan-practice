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
 * This class is used by SOAP remote services, specifically {@link com.library.slayer.service.http.LMSBookServiceSoap}.
 *
 * @author    Ahmed Hasan
 * @see       com.library.slayer.service.http.LMSBookServiceSoap
 * @generated
 */
public class LMSBookSoap implements Serializable {
	public static LMSBookSoap toSoapModel(LMSBook model) {
		LMSBookSoap soapModel = new LMSBookSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBookId(model.getBookId());
		soapModel.setBookTitle(model.getBookTitle());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setDescription(model.getDescription());
		soapModel.setFileName(model.getFileName());
		soapModel.setDownloaded(model.getDownloaded());
		soapModel.setStatus(model.getStatus());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());

		return soapModel;
	}

	public static LMSBookSoap[] toSoapModels(LMSBook[] models) {
		LMSBookSoap[] soapModels = new LMSBookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LMSBookSoap[][] toSoapModels(LMSBook[][] models) {
		LMSBookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LMSBookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LMSBookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LMSBookSoap[] toSoapModels(List<LMSBook> models) {
		List<LMSBookSoap> soapModels = new ArrayList<LMSBookSoap>(models.size());

		for (LMSBook model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LMSBookSoap[soapModels.size()]);
	}

	public LMSBookSoap() {
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long pk) {
		setBookId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public int getDownloaded() {
		return _downloaded;
	}

	public void setDownloaded(int downloaded) {
		_downloaded = downloaded;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	private String _uuid;
	private long _bookId;
	private String _bookTitle;
	private String _author;
	private String _description;
	private String _fileName;
	private int _downloaded;
	private int _status;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userName;
}
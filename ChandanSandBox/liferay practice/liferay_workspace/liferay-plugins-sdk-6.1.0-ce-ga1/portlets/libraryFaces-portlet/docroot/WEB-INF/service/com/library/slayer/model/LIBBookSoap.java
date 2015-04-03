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
 * @author    veena
 * @generated
 */
public class LIBBookSoap implements Serializable {
	public static LIBBookSoap toSoapModel(LIBBook model) {
		LIBBookSoap soapModel = new LIBBookSoap();

		soapModel.setBookId(model.getBookId());
		soapModel.setBookTitle(model.getBookTitle());
		soapModel.setAuthor(model.getAuthor());

		return soapModel;
	}

	public static LIBBookSoap[] toSoapModels(LIBBook[] models) {
		LIBBookSoap[] soapModels = new LIBBookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LIBBookSoap[][] toSoapModels(LIBBook[][] models) {
		LIBBookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LIBBookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LIBBookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LIBBookSoap[] toSoapModels(List<LIBBook> models) {
		List<LIBBookSoap> soapModels = new ArrayList<LIBBookSoap>(models.size());

		for (LIBBook model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LIBBookSoap[soapModels.size()]);
	}

	public LIBBookSoap() {
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long pk) {
		setBookId(pk);
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

	private long _bookId;
	private String _bookTitle;
	private String _author;
}
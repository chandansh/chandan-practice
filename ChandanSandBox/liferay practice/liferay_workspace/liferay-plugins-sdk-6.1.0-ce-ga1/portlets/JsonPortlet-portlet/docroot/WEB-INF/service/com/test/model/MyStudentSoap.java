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

package com.test.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.test.service.http.MyStudentServiceSoap}.
 *
 * @author    Chandan
 * @see       com.test.service.http.MyStudentServiceSoap
 * @generated
 */
public class MyStudentSoap implements Serializable {
	public static MyStudentSoap toSoapModel(MyStudent model) {
		MyStudentSoap soapModel = new MyStudentSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static MyStudentSoap[] toSoapModels(MyStudent[] models) {
		MyStudentSoap[] soapModels = new MyStudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MyStudentSoap[][] toSoapModels(MyStudent[][] models) {
		MyStudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MyStudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MyStudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MyStudentSoap[] toSoapModels(List<MyStudent> models) {
		List<MyStudentSoap> soapModels = new ArrayList<MyStudentSoap>(models.size());

		for (MyStudent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MyStudentSoap[soapModels.size()]);
	}

	public MyStudentSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _id;
	private String _name;
}
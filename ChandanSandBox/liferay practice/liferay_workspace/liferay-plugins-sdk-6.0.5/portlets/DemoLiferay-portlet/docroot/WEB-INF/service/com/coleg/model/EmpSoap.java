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
 * {@link com.coleg.service.http.EmpServiceSoap}.
 * </p>
 *
 * @author    chandan
 * @see       com.coleg.service.http.EmpServiceSoap
 * @generated
 */
public class EmpSoap implements Serializable {
	public static EmpSoap toSoapModel(Emp model) {
		EmpSoap soapModel = new EmpSoap();

		soapModel.setEmpId(model.getEmpId());
		soapModel.setUname(model.getUname());
		soapModel.setAddress(model.getAddress());

		return soapModel;
	}

	public static EmpSoap[] toSoapModels(Emp[] models) {
		EmpSoap[] soapModels = new EmpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpSoap[][] toSoapModels(Emp[][] models) {
		EmpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpSoap[] toSoapModels(List<Emp> models) {
		List<EmpSoap> soapModels = new ArrayList<EmpSoap>(models.size());

		for (Emp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpSoap[soapModels.size()]);
	}

	public EmpSoap() {
	}

	public String getPrimaryKey() {
		return _empId;
	}

	public void setPrimaryKey(String pk) {
		setEmpId(pk);
	}

	public String getEmpId() {
		return _empId;
	}

	public void setEmpId(String empId) {
		_empId = empId;
	}

	public String getUname() {
		return _uname;
	}

	public void setUname(String uname) {
		_uname = uname;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	private String _empId;
	private String _uname;
	private String _address;
}